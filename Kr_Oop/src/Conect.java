import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Conect {
	static String modifiedSentence;
	static Receive receive = new Receive();
	static Thread thread2d = new Thread(receive);

	public static void sms(String sms, String IP) throws IOException {
		DatagramSocket Socket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName(IP);
		byte[] send_name = new byte[sms.length()];
		send_name = sms.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(send_name, send_name.length, IPAddress, 3333);
		Socket.send(sendPacket);
		Socket.close();
	}

	public static void Receive() throws IOException {
		thread2d.start();
	}

	public static void Receive_Diconect() throws IOException, InterruptedException {
	}
}
