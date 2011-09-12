package images2pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.OutputStream;

public class PdfImageFile {
	private Document document;
	private PdfWriter pdfWriter;
	private FileOutputStream outputStream;
	
	public PdfImageFile(File path) throws DocumentException, FileNotFoundException {
		document = new Document(PageSize.A4);
		outputStream = new FileOutputStream(path);
		pdfWriter = PdfWriter.getInstance(document, outputStream);
		document.open();
	}
	
	public void addImage(File imageFile) throws DocumentException, MalformedURLException, IOException {
		Image image = Image.getInstance(imageFile.getAbsolutePath());
		image.setAlignment(Image.ALIGN_CENTER);
		Rectangle pgSize = document.getPageSize();
		image.setAbsolutePosition(pgSize.getWidth()/2 - image.getWidth()/2, pgSize.getHeight()/2 - image.getHeight()/2);
		document.add(image);
		Paragraph paragraph = new Paragraph(imageFile.getName());
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph);
		document.newPage();
		pdfWriter.flush();
	}
	
	public void close() throws IOException {
		document.close();
		outputStream.close();
	}
}
