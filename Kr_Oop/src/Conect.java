import java.io.*;
import java.net.*;

public class Conect {
	static String modifiedSentence;
	static Receive receive;

	/**
	 * public static void name(String name, String IP) throws IOException {
	 * DatagramSocket Socket = new DatagramSocket(); InetAddress IPAddress =
	 * InetAddress.getByName(IP); byte[] send_name = new byte[name.length()];
	 * send_name = name.getBytes(); DatagramPacket sendPacket = new
	 * DatagramPacket(send_name, send_name.length, IPAddress, 5555);
	 * Socket.send(sendPacket); System.out.println("Send"); Socket.close(); }
	 */

	public static void sms(String sms, String IP) throws IOException {
		DatagramSocket Socket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName(IP);
		byte[] send_name = new byte[sms.length()];
		send_name = sms.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(send_name, send_name.length, IPAddress, 3333);
		Socket.send(sendPacket);
		System.out.println("Отпарвило");
		Socket.close();
	}

	public static void you_name() throws IOException {
		receive = new Receive();
		Thread thread2d = new Thread(receive);
		thread2d.start();
	}
}
