import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DiskManager {

	public void save(String objectName, Object content) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objectName));
		oos.writeObject(content);
		oos.flush();
		oos.close();
	}
	
	public Object getContent(String objectName) throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objectName));
		Object content = ois.readObject();
		ois.close();
		return content;
	}
	
}
