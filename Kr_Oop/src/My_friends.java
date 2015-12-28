import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class My_friends {
	static String fileName = "friends.txt";

	public static void Append_Friends(String text ,String IP) {
		File file = new File(fileName);
		FileWriter fr = null;
		try {
			fr = new FileWriter(file, true);
			fr.write(text+"\n");
			fr.write(IP+"\n");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void add_friends(){
	
			String frinds = JOptionPane.showInputDialog("Ввыдите имя");
			String frinds_ip = JOptionPane.showInputDialog("Ввыдите ip ");
			My_friends.Append_Friends(frinds, frinds_ip);
			JMenuItem menuItem = new JMenuItem(frinds);
			menuItem.setBackground(Color.WHITE);
			FrameChatApp.menu.add(menuItem);
			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == menuItem) {

						FrameChatApp.you_name.setText("Собеседник:" + frinds);
						FrameChatApp.IP = frinds_ip;
					}
				}
			});
	}

}
