import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileManager {

	public static byte[] readFile(String fullFileName) throws IOException {
		File file = new File(fullFileName);
		FileInputStream fileInputStream = null;
		byte[] bFile = new byte[(int) file.length()];

		fileInputStream = new FileInputStream(file);
		fileInputStream.read(bFile);
		fileInputStream.close();

		return bFile;
	}

	public static void saveInFile(String fullFileName, byte[] content) throws IOException {
		OutputStream outputStream = new FileOutputStream(fullFileName);
		outputStream.write(content);
		outputStream.close();
	}

}
