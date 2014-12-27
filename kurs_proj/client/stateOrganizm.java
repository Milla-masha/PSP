package by.bsuir.kyrsProjekt.client;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;

import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;




@SuppressWarnings("serial")
public class stateOrganizm extends JFrame {
	@SuppressWarnings({ "rawtypes", "unused" })
	private JList list1;
	@SuppressWarnings({ "rawtypes", "unused" })
	private JList list2;	
	@SuppressWarnings("unused")
	private static JLabel lbanimals_1;
	public  ArrayList<String> listArray1;
	public  ArrayList<String> listArray2;
	public  ArrayList<String> listAR1;
	public  ArrayList<String> listAR2;
    public static stateOrganizm frame = new stateOrganizm();
	private JPanel contentPane;
	@SuppressWarnings("rawtypes")
	private  DefaultListModel model_vid;
	public static JTextPane textPane;
	public  ArrayList<String> listArraylist;
    public static void closestateOrganizm(){
    	frame.setVisible(false);
    }
     
	/**
	 * Launch the application.
	 */
	public static void viewstateOrganizm() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setIconImage(ImageIO.read(this.getClass().getResourceAsStream("m.jpg")));
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	@SuppressWarnings({  "rawtypes", "unchecked" })
	public stateOrganizm() {
		
		listArraylist=new ArrayList<String>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton button = new JButton("\u0413\u043B\u0430\u0432\u043D\u043E\u0435 \u043C\u0435\u043D\u044E");
		button.setIcon(new ImageIcon(Person.class.getResource("/by/bsuir/kyrsProjekt/client/back.jpg")));
		button.setBounds(1037, 547, 270, 85);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				closestateOrganizm();
				Masha.viewMasha();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(button);
		
		 model_vid = new DefaultListModel();
		 
		 try {
			listArraylist=Client.vidGetAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 for ( String element :listArraylist) {
	            model_vid.addElement(element);
	        }
	   
		 
			 textPane = new JTextPane();
			 textPane.setForeground(Color.BLACK);
			 textPane.setBackground(Color.WHITE);
			textPane.setBounds(828, 235, 191, 107);
			textPane.setBorder(new LineBorder(Color.BLACK, 2, true));
			contentPane.add(textPane);
			
		JList list = new JList(model_vid);
		list.setBackground(Color.WHITE);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {//нжать на список
				String state;
				try {
					state=Client.statusGet(listArraylist.get(list.getSelectedIndex()));
					textPane.setText(state);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		});
		list.setBorder(new LineBorder(Color.BLACK, 2, true));
		list.setBounds(432, 133, 213, 434);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setIcon(new ImageIcon(stateOrganizm.class.getResource("/by/bsuir/kyrsProjekt/client/obn.jpg")));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {//нажать на обновить статус
				try {
					Client.statusSet(listArraylist.get(list.getSelectedIndex()), textPane.getText());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		textPane_1.setEditable(false);
		textPane_1.setText("\u041A\u0440\u0430\u0301\u0441\u043D\u0430\u044F \u043A\u043D\u0438\u0301\u0433\u0430 \u2014 \u0430\u043D\u043D\u043E\u0442\u0438\u0440\u043E\u0432\u0430\u043D\u043D\u044B\u0439 \u0441\u043F\u0438\u0441\u043E\u043A \u0440\u0435\u0434\u043A\u0438\u0445 \u0438 \u043D\u0430\u0445\u043E\u0434\u044F\u0449\u0438\u0445\u0441\u044F \u043F\u043E\u0434 \u0443\u0433\u0440\u043E\u0437\u043E\u0439 \u0438\u0441\u0447\u0435\u0437\u043D\u043E\u0432\u0435\u043D\u0438\u044F \u0436\u0438\u0432\u043E\u0442\u043D\u044B\u0445, \u0440\u0430\u0441\u0442\u0435\u043D\u0438\u0439 \u0438 \u0433\u0440\u0438\u0431\u043E\u0432. \u042D\u0442\u043E \u043D\u0430\u0438\u0431\u043E\u043B\u0435\u0435 \u0448\u0438\u0440\u043E\u043A\u043E \u0438\u0441\u043F\u043E\u043B\u044C\u0437\u0443\u0435\u043C\u044B\u0439 \u0432 \u0441\u0444\u0435\u0440\u0435 \u043E\u0445\u0440\u0430\u043D\u044B \u043F\u0440\u0438\u0440\u043E\u0434\u044B \u0432\u0441\u0435\u0445 \u0441\u0442\u0440\u0430\u043D \u043C\u0438\u0440\u0430 \u0434\u043E\u043A\u0443\u043C\u0435\u043D\u0442, \u043F\u0440\u0435\u0434\u043D\u0430\u0437\u043D\u0430\u0447\u0435\u043D\u043D\u044B\u0439 \u0434\u043B\u044F \u0441\u043E\u0441\u0440\u0435\u0434\u043E\u0442\u043E\u0447\u0435\u043D\u0438\u044F \u0432\u043D\u0438\u043C\u0430\u043D\u0438\u044F \u043D\u0430 \u0432\u0438\u0434\u0430\u0445, \u0438\u043C\u0435\u044E\u0449\u0438\u0445 \u0432\u044B\u0441\u043E\u043A\u0443\u044E \u043F\u0440\u0438\u0440\u043E\u0434\u043E\u043E\u0445\u0440\u0430\u043D\u043D\u0443\u044E \u0437\u043D\u0430\u0447\u0438\u043C\u043E\u0441\u0442\u044C.");
		textPane_1.setBackground(new Color(204, 255, 102));
		textPane_1.setBounds(1177, 10, 163, 332);
		contentPane.add(textPane_1);
		btnNewButton.setBounds(828, 353, 191, 65);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u0412\u0441\u0435 \u0432\u0438\u0434\u044B");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {//нажать на все виды
				try {
					listArraylist=Client.vidGetAll();
					model_vid=new DefaultListModel();
					 for ( String element :listArraylist) {
				            model_vid.addElement(element);
				        }
					 list.setModel(model_vid);
					 list.setBackground(Color.WHITE);
					 textPane.setText("");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnNewButton_1.setBounds(49, 139, 177, 65);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u0412\u044B\u043C\u0435\u0440\u0448\u0438\u0435");
		btnNewButton_2.setBackground(new Color(102, 153, 204));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//нажать на вымершие  виды
				try {
					String vibor="¬ымершие";
					listArraylist=Client.vidGetVibor(vibor);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				model_vid=new DefaultListModel();
				 for ( String element :listArraylist) {
			            model_vid.addElement(element);
			        }
				 list.setModel(model_vid);
				 list.setBackground(new Color(102, 153, 204));
				 textPane.setText("");
			}
		});
		btnNewButton_2.setBounds(49, 256, 177, 65);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u041F\u043E\u0434 \u0443\u0433\u0440\u043E\u0437\u043E\u0439 \u0432\u044B\u043C\u0438\u0440\u0430\u043D\u0438\u044F");
		btnNewButton_3.setBackground(new Color(255, 0, 0));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//под угрозой вымирани€
				try {
					String vibor="ѕод угрозой вымирани€";
					listArraylist=Client.vidGetVibor(vibor);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				model_vid=new DefaultListModel();
				 for ( String element :listArraylist) {
			            model_vid.addElement(element);
			        }
				 list.setModel(model_vid);
				 list.setBackground(new Color(255, 0, 0));
				 textPane.setText("");
			}
		});
		btnNewButton_3.setBounds(49, 377, 177, 65);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u0420\u0438\u0441\u043A \u043C\u0430\u043B");
		btnNewButton_4.setBackground(Color.YELLOW);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//риск мал
				try {
					String vibor="–иск мал";
					listArraylist=Client.vidGetVibor(vibor);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				model_vid=new DefaultListModel();
				 for ( String element :listArraylist) {
			            model_vid.addElement(element);
			        }
				 list.setModel(model_vid);
				 list.setBackground(Color.YELLOW);
				 textPane.setText("");
			}
		});
		btnNewButton_4.setBounds(49, 502, 177, 65);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_2 = new JLabel("\u041E\u0445\u0440\u0430\u043D\u043D\u044B\u0439 \u0441\u0442\u0430\u0442\u0443\u0441:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_2.setBounds(828, 187, 185, 37);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("\u041A\u0440\u0430\u0441\u043D\u0430\u044F \u043A\u043D\u0438\u0433\u0430");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 72));
		lblNewLabel_1.setBackground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(312, 11, 573, 125);
		contentPane.add(lblNewLabel_1);
		
	

		
	
	
	
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(Person.class.getResource("/by/bsuir/kyrsProjekt/client/phone.jpg")));
		lblNewLabel.setBounds(0, 0, 1350, 692);
		contentPane.add(lblNewLabel);
		

	
	}
}