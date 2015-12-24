import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Receive implements Runnable {
	static FrameChatApp frameChatApp;
	static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	static String IP;
	static DatagramSocket serverSocket;
	static byte[] receiveData = new byte[256];

	@Override
	public void run() {
		try {
			Send_Messd();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static void Send_Messd() throws Exception {
		serverSocket = new DatagramSocket(3333);
		InetAddress IPAddress = InetAddress.getByName(IP);
		while (true) {
			DatagramPacket receivePacket = new DatagramPacket(receiveData, 256);
			serverSocket.receive(receivePacket);
			Date currentDate = new Date();
			String sentence = new String(receivePacket.getData());
			IP = receivePacket.getAddress().toString();
			FrameChatApp.textArea.append(" \n");
			if (receivePacket.getAddress() == IPAddress) {
			} else {
				FrameChatApp.textArea.append(sentence + sdf.format(currentDate) + "\n");
			}

			receiveData = new byte[256];
		}
	}

}