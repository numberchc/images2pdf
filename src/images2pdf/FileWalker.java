package images2pdf;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.io.DirectoryWalker;

public abstract class FileWalker extends DirectoryWalker<File> {
	private static String[] imageExtensions = {".jpg", ".jpeg", ".bmp", ".png", ".tiff", ".gif"};
	
	public FileWalker() {
		super();
	}
	
	@Override
	protected void handleFile(File file, int depth, Collection<File> results)
			throws IOException {
		for (String ext : imageExtensions) {
			String fileName = file.getName();
			if (fileName.toLowerCase().endsWith(ext)){
				onFileFound(file);
				break;
			}
		}
	}
	
	public abstract void onFileFound(File file);
	
	public void startWalking(File rootDir) throws IOException {
		walk(rootDir, null);
	}
}
