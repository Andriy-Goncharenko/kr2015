import java.awt.Color;
import java.awt.Component;
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

import org.eclipse.wb.swing.FocusTraversalOnArray;

class FrameChatApp {
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 900;
	static String Title = "ChatApp";
	static String name;
	static String sms;
	static String IP;
	static String You_mass;
	static JFrame frame = new JFrame();
	static JMenuBar menuBar = new JMenuBar();
	static JMenu m1 = new JMenu("Свойства");
	static JButton Sent = new JButton("Отправить");
	static JMenuItem M_name = new JMenuItem("Введите свое Имя");
	static JMenuItem M_Conect = new JMenuItem("Присоединеться");
	static JMenuItem M_Disconect = new JMenuItem("Отсоединиться");
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
	private static final JMenu menu = new JMenu("Друзья");
	private static final JMenuItem menuItem = new JMenuItem("Добавить друга");

	/**
	 * @wbp.parser.entryPoint
	 */
	static void frame() throws Exception {
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPane.setBounds(0, 0, 242, 506);
		textPane.setText(name);
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
		frame.setIconImage(
				Toolkit.getDefaultToolkit().getImage("C:\\Users\\\u0414\u0438\u043C\u0430\\workspace\\Kr_Oop\\src\\icon.jpg"));
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
				}
			}
		});
		M_name.setBackground(Color.WHITE);
		M_name.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == M_name) {
					name = JOptionPane.showInputDialog("Введите ваше имя");
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
					String frinds = JOptionPane.showInputDialog("Введите имя друга");
					String frinds_ip = JOptionPane.showInputDialog("Введите ip друга");
					JMenuItem menuItem = new JMenuItem(frinds);
					menuItem.setBackground(Color.WHITE);
					menu.add(menuItem);
					menuItem.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (e.getSource() == menuItem) {

								you_name.setText("Собеседник:" + frinds);
								IP = frinds_ip;
							}
						}
					});
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
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { menuBar, m1, M_name, M_Conect,
				M_Disconect, M_Exit, menu, menuItem, My_name, you_name }));
		frame.setVisible(true);
	}
}