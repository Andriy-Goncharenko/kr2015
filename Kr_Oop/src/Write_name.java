import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Write_name {
 	static String fileName ="name.txt";
	public static void write(String text) {
		File file = new File(fileName);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			PrintWriter out = new PrintWriter(file.getAbsoluteFile());

			try {
				out.print(text);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
