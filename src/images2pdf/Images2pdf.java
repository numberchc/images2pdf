package images2pdf;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.DocumentException;

public class Images2pdf {
	public static void main(String[] args) {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		if (directoryChooser.showOpenDialog(null) == DirectoryChooser.APPROVE_OPTION){
			File searchDir = directoryChooser.getSelectedFile();
			if (searchDir.exists()){
				FileChooser fileChooser = new FileChooser();
				if (fileChooser.showSaveDialog(null) == FileChooser.APPROVE_OPTION){
					File pdfFilePath = fileChooser.getFile();
					try {
						final PdfImageFile pdfImageFile = new PdfImageFile(pdfFilePath);
						final ProgressDialog progressDialog = new ProgressDialog(null);
						progressDialog.setVisible(true);
						FileWalker fileWalker = new FileWalker(){
							@Override
							public void onFileFound(File file) {
								if (!progressDialog.isCancelled()){
									progressDialog.stepForward(file.getName());
									try {
										pdfImageFile.addImage(file);
									} catch (MalformedURLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (DocumentException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
						};
						fileWalker.startWalking(searchDir);
						pdfImageFile.close();
						progressDialog.dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
