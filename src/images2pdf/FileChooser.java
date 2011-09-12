package images2pdf;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class FileChooser extends JFileChooser {
	private static final long serialVersionUID = 1L;
	
	public FileChooser() {
		super();
		setDialogTitle("Wskaż gdzie zapisać plik PDF");
		setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return "Pliki PDF";
			}
			
			@Override
			public boolean accept(File f) {
				if ((f.getName().toLowerCase().endsWith(".pdf")) || f.isDirectory())
					return true;
				return false;
			}
		});
	}
	
	public File getFile() {
		File f = getSelectedFile();
		if (!f.getName().endsWith(".pdf")){
			return new File(f.getAbsoluteFile() + ".pdf");
		}
		return f;
	}
}
