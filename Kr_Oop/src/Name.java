import javax.swing.JOptionPane;

public class Name {
	static String name;
	static FrameChatApp frameChatApp;

	public static void Nik(String name) {
		if (name == null) {
			name = JOptionPane.showInputDialog("Введите ваше имя");
			FrameChatApp.name = name;
			FrameChatApp.My_name.setText("Ваше имя: " + name);

		}
	}
}
