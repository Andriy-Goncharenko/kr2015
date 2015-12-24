import javax.swing.JOptionPane;

public class IP_Control {
	static String IP;
	static FrameChatApp frameChatApp;

	public static void IP(String IP) {
		if (IP == null) {
			JOptionPane.showMessageDialog(null, "Вы не выбрали собиседника");

		}
	}
}
