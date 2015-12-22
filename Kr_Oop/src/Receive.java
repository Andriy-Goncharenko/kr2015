import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Receive implements Runnable {
	static FrameChatApp frameChatApp;
	static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
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
		DatagramSocket serverSocket;
		byte[] receiveData = new byte[256];
		serverSocket = new DatagramSocket(3333);
		while (true) {
			DatagramPacket receivePacket = new DatagramPacket(receiveData, 256);
			serverSocket.receive(receivePacket);
			Date currentDate = new Date();
			String sentence = new String(receivePacket.getData());
			frameChatApp.textPane.append(receivePacket.getAddress()+":" + sentence+"("+sdf.format(currentDate)+")"+"\n");
			
		}
	}

}