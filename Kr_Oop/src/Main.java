
public class Main {

	static start Main_Thraed;

	public static void main(String[] args) {
		Main_Thraed = new start();
		Thread mThread =new Thread(Main_Thraed);
		mThread.start();
		System.out.println("Good start");
	}
}
