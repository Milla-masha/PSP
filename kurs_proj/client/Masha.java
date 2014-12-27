package by.bsuir.kyrsProjekt.client;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.Font;
public class Masha {
public static	Masha window = new Masha();
	private JFrame frame;
	public static void viewMasha(){
		window.frame.setVisible(true);
	}

	public static void closeWindow(){
		window.frame.setVisible(false);
	};
	
	
	public static void closing() throws IOException{
		window.frame.dispose();
		Client.disconect();
	}
	
	public static void begin() throws IOException {
		Client.conect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	window.frame.checkImage(ImageIO.read(this.getClass().getResourceAsStream("m.jpg")), 100, 100, this);
					window.frame.setIconImage(ImageIO.read(this.getClass().getResourceAsStream("m.jpg")));
					window.frame.setVisible(true);
			//		JDBC.JDBCget();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Masha() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1366, 730);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JButton button = new JButton("");
		button.setBounds(438, 94, 293, 301);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setIcon(new ImageIcon(Masha.class.getResource("/by/bsuir/kyrsProjekt/client/klassifikacia.jpg")));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 Classification.mainCl();
				 closeWindow();
			}
		});
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(Masha.class.getResource("/by/bsuir/kyrsProjekt/client/infa.png")));
		button_1.setBounds(114, 310, 266, 301);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Nature.viewNature();
				closeWindow();
			}
		});
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(Masha.class.getResource("/by/bsuir/kyrsProjekt/client/vitruvian_man.jpg")));
		button_2.setBounds(789, 310, 266, 301);
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Person.viewPerson();
				closeWindow();
				
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(button_1);
		frame.getContentPane().add(button);
		frame.getContentPane().add(button_2);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {//нажать на выход
				
				try {
					Client.closes();
					closing();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(Masha.class.getResource("/by/bsuir/kyrsProjekt/client/exit.png")));
		btnNewButton.setBounds(1179, 510, 161, 137);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(Masha.class.getResource("/by/bsuir/kyrsProjekt/client/krasnb.jpg")));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				stateOrganizm.viewstateOrganizm();
				 closeWindow();
				
			}
		});
		btnNewButton_2.setBounds(499, 466, 180, 145);
		frame.getContentPane().add(btnNewButton_2);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setFont(new Font("Tahoma", Font.ITALIC, 14));
		textPane.setText("  \u0417\u0430\u0434\u0430\u0447\u0430 \u0441\u0438\u0441\u0442\u0435\u043C\u0430\u0442\u0438\u043A\u0438 \u0441\u043E\u0441\u0442\u043E\u0438\u0442 \u0432 \u0442\u043E\u043C, \u0447\u0442\u043E\u0431\u044B \u0434\u043E\u043F\u043E\u043B\u043D\u0438\u0442\u044C \u0441\u043E\u0432\u0440\u0435\u043C\u0435\u043D\u043D\u044B\u0435 \u043A\u043B\u0430\u0441\u0441\u0438\u0444\u0438\u043A\u0430\u0446\u0438\u0438, \u0432 \u0431\u043E\u043B\u044C\u0448\u0438\u043D\u0441\u0442\u0432\u0435 \u0441\u0432\u043E\u0435\u043C \u0441\u043E\u0437\u0434\u0430\u043D\u043D\u044B\u0435 \u043D\u0430 \u043E\u0441\u043D\u043E\u0432\u0435 \u043A\u043B\u0430\u0434\u0438\u0441\u0442\u0438\u0447\u0435\u0441\u043A\u043E\u0433\u043E \u043C\u0435\u0442\u043E\u0434\u0430, \u0438\u043B\u0438 \u043A\u043B\u0430\u0434\u0438\u0441\u0442\u0438\u043A\u0438 (\u043E\u0442 \u0433\u0440\u0435\u0447. klados - \u0432\u0435\u0442\u0432\u044C) - \u0432\u0430\u0440\u0438\u0430\u043D\u0442\u0430 \u043F\u043E\u0441\u0442\u0440\u043E\u0435\u043D\u0438\u044F \u0440\u043E\u0434\u043E\u0441\u043B\u043E\u0432\u043D\u043E\u0433\u043E \u0434\u0440\u0435\u0432\u0430 \u043E\u0440\u0433\u0430\u043D\u0438\u0447\u0435\u0441\u043A\u043E\u0433\u043E \u043C\u0438\u0440\u0430, \u0431\u0430\u0437\u0438\u0440\u0443\u0435\u043C\u043E\u0433\u043E \u043D\u0430 \u0441\u0442\u0435\u043F\u0435\u043D\u0438 \u0440\u043E\u0434\u0441\u0442\u0432\u0430, \u043D\u043E \u0431\u0435\u0437 \u0443\u0447\u0435\u0442\u0430 \u0433\u0435\u043E\u0445\u0440\u043E\u043D\u043E\u043B\u043E\u0433\u0438\u0447\u0435\u0441\u043A\u043E\u0439 \u043F\u043E\u0441\u043B\u0435\u0434\u043E\u0432\u0430\u0442\u0435\u043B\u044C\u043D\u043E\u0441\u0442\u0438, \u0432\u043E\u0441\u0441\u0442\u0430\u043D\u043E\u0432\u0438\u0442\u044C \u043D\u0435\u0434\u043E\u0441\u0442\u0430\u044E\u0449\u0438\u0435 \u0432\u0435\u0442\u0432\u0438 \u0438 \u043F\u043E\u043C\u0435\u0441\u0442\u0438\u0442\u044C \u043A\u0430\u0436\u0434\u044B\u0439 \u043F\u043E\u0431\u0435\u0433 \u043D\u0430 \u0441\u043E\u043E\u0442\u0432\u0435\u0442\u0441\u0442\u0432\u0443\u044E\u0449\u0443\u044E \u0432\u0435\u0442\u0432\u044C. ");
		textPane.setBackground(new Color(204, 255, 102));
		textPane.setBounds(1179, 11, 161, 486);
		frame.getContentPane().add(textPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(1, 0, 1349, 692);
		lblNewLabel.setIcon(new ImageIcon(Masha.class.getResource("/by/bsuir/kyrsProjekt/client/phone.jpg")));
		frame.getContentPane().add(lblNewLabel);

	}
}

