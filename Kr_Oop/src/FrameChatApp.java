import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


class FrameChatApp {
	static String Title = "ChatApp";
	static String name;
	static String sms;
	static String IP;
	static String You_mass;
	static JFrame frame = new JFrame();
	static JMenuBar menuBar = new JMenuBar();
	static JMenu m1 = new JMenu("Опций");
	static JButton Sent = new JButton("Отправить");
	static JMenuItem M_name = new JMenuItem("Введите свое имя");
	static JMenuItem M_Conect = new JMenuItem("Подключения");
	static JMenuItem M_Disconect = new JMenuItem("Отключения");
	static JMenuItem M_Exit = new JMenuItem("Выход из программы");
	static JMenuItem My_name = new JMenuItem("Вы:");
	static JMenuItem you_name = new JMenuItem("Собеседник:");
	static String nik;
	static JTextField text = new JTextField();
	static byte[] sendData = new byte[256];
	static byte[] receiveData = new byte[256];
	static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	static JTextArea textPane = new JTextArea();
	static JTextArea textArea = new JTextArea();
	 static final JMenu menu = new JMenu("Дурья");
	 static final JMenuItem menuItem = new JMenuItem("Добавить друга");

	
	static void frame() throws Exception {
		name=Read_name.Read();
		My_name.setText("Вы: " + Read_name.Read());
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPane.setBounds(0, 0, 242, 506);
		text.setSelectionColor(Color.DARK_GRAY);
		text.setBounds(0, 517, 394, 32);
		text.setBackground(Color.WHITE);
		text.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				sms = text.getText();
				switch (arg0.getKeyCode()) {
				case KeyEvent.VK_ENTER:
					sms = name + ":" + text.getText();
					Date currentDate = new Date();
					text.setText("");
					textPane.append(sms + sdf.format(currentDate) + "\n");
					textPane.append(" \n");
					try {
						Conect.sms(sms, IP);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		frame.getContentPane().setLayout(null);
		text.setEnabled(false);
		frame.getContentPane().add(text);
		text.setColumns(10);
		Sent.setBounds(391, 517, 123, 32);
		Sent.setBackground(Color.WHITE);

		Sent.setEnabled(false);
		frame.getContentPane().add(Sent);

		textPane.setEditable(false);
		textPane.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(textPane);
		textArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textArea.setEditable(false);
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(242, 0, 262, 506);
		frame.getContentPane().add(textArea);
		frame.setMaximumSize(new Dimension(500, 2147483647));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.jpg"));
		frame.setTitle(Title);
		frame.setSize(520, 602);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuBar.setForeground(Color.BLACK);
		menuBar.setBackground(Color.WHITE);
		frame.setJMenuBar(menuBar);
		m1.setBackground(Color.WHITE);
		menuBar.add(m1);

		Sent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == Sent) {
					sms = name + ":" + text.getText();
					Date currentDate = new Date();
					text.setText("");
					textPane.append(sms + sdf.format(currentDate) + "\n");
					textPane.append(" \n");
					try {
						Conect.sms(sms, IP);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		M_name.setBackground(Color.WHITE);
		M_name.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == M_name) {
					name = JOptionPane.showInputDialog("icon.jpg","Введите свое имя");
					Write_name.write(name);
					My_name.setText("Вы: " + name);

				}
			}
		});
		M_Exit.setBackground(Color.WHITE);
		M_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == M_Exit) {
					System.exit(0);
				}
			}
		});
		M_Conect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == M_Conect) {
					Name.Nik(name);
					IP_Control.IP(IP);
					try {
						Conect.Receive();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Sent.setEnabled(true);
					text.setEnabled(true);

				}
			}
		});
		M_Disconect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == M_Disconect) {
					try {
						Conect.Receive_Diconect();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Sent.setEnabled(false);
					text.setEnabled(false);
				}
			}
		});
		m1.add(M_name);
		M_Conect.setBackground(Color.GREEN);
		m1.add(M_Conect);
		M_Disconect.setBackground(Color.RED);
		m1.add(M_Disconect);
		m1.add(M_Exit);
		menu.setBackground(Color.WHITE);

		menuBar.add(menu);
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == menuItem) {
					My_friends.add_friends();
				}
			}
		});
		menuItem.setBackground(Color.WHITE);

		menu.add(menuItem);
		My_name.setBackground(Color.WHITE);
		menuBar.add(My_name);
		you_name.setBackground(Color.WHITE);

		menuBar.add(you_name);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}