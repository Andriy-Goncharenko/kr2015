import javax.swing.JOptionPane;

public class start implements Runnable {
	public void run() {
	String string=	JOptionPane.showInputDialog("Введите Имя");
	JOptionPane.showMessageDialog(null, string, null, 0, null);
	}
}
