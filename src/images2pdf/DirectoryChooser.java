package images2pdf;

import javax.swing.JFileChooser;

public class DirectoryChooser extends JFileChooser {
	private static final long serialVersionUID = -2310427781668030721L;

	public DirectoryChooser() {
		super();
		setDialogTitle("Wybierz katalog zawierajacy pliki.");
		setFileSelectionMode(DIRECTORIES_ONLY);
	}
}
