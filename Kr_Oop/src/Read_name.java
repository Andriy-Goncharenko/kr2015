
import java.io.FileReader;
import java.io.IOException;

public class Read_name {
	static String Name;

	public static String Read() {

		try (FileReader reader = new FileReader("name.txt")) {
			char[] buffer = new char[100];
			reader.read(buffer);
			Name = new String(buffer);
		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		}
		return Name;
	}

}
