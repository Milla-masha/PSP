package by.bsuir.kyrsProjekt.client;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;

import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Person extends JFrame {
	@SuppressWarnings({ "rawtypes", "unused" })
	private JList list1;
	@SuppressWarnings({ "rawtypes", "unused" })
	private JList list2;	
	@SuppressWarnings("unused")
	private static JLabel lbanimals_1;
	private static int if1=0, if2=0;
	public  ArrayList<String> listArray1;
	public  ArrayList<String> listArray2;
	public  ArrayList<String> listAR1;
	public  ArrayList<String> listAR2;
	@SuppressWarnings("rawtypes")
	private  DefaultListModel model_1;
	@SuppressWarnings("rawtypes")
	private  DefaultListModel model_2;
    public static Person frame = new Person();
	private JPanel contentPane;
    public static void closePerson(){
    	frame.setVisible(false);
    }
     
	/**
	 * Launch the application.
	 */
	public static void viewPerson() {
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
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Person() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

	final	JLabel lbanimals_1 = new JLabel("");
		lbanimals_1.setBackground(new Color(240, 240, 240));
		lbanimals_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbanimals_1.setBounds(347, 182, 437, 388);
		contentPane.add(lbanimals_1);
		lbanimals_1.setIcon(new ImageIcon(Person.class.getResource("/by/bsuir/kyrsProjekt/client/not.jpg")));
		
		JButton button = new JButton("\u0413\u043B\u0430\u0432\u043D\u043E\u0435 \u043C\u0435\u043D\u044E");
		button.setIcon(new ImageIcon(Person.class.getResource("/by/bsuir/kyrsProjekt/client/back.jpg")));
		button.setBounds(1037, 547, 270, 85);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				closePerson();
				Masha.viewMasha();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(button);
		
		JList list1 = new JList();
		JList list2 = new JList();
		list1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {//tbl1
				lbanimals_1.setIcon(new ImageIcon(Person.class.getResource("/by/bsuir/kyrsProjekt/client/not.jpg")));
				if1=1;
				if(if2==1)
				{
					String name;
					name=("/by/bsuir/kyrsProjekt/client/");
					name=name+listAR1.get(list1.getSelectedIndex());
					name=name+listAR2.get(list2.getSelectedIndex());
					name=name+(".jpg");
					System.out.println(name);
					lbanimals_1.setIcon(new ImageIcon(Person.class.getResource(name)));
				}
			}
		});
		list1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		list1.setBackground(new Color(102, 204, 153));
		list1.setFont(new Font("Calibri", Font.BOLD, 15));
		list1.setBounds(153, 261, 172, 251);
		contentPane.add(list1);
		
		listAR1=new ArrayList();
		listAR1.add("sobaka");
		listAR1.add("krolic");
		listAR1.add("lev");
		listAR1.add("koza");
		listAR1.add("ylitka");
listArray1=new ArrayList();
		listArray1.add("собака");
		listArray1.add("кролик");
		listArray1.add("лев");
		listArray1.add("коза");
		listArray1.add("улитка");
		
		model_1= new DefaultListModel();
		 for ( String element :listArray1) {
	            model_1.addElement(element);
	        }
	     list1.setModel(model_1);
	     
	    

		list2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if2=1;
				lbanimals_1.setIcon(new ImageIcon(Person.class.getResource("/by/bsuir/kyrsProjekt/client/not.jpg")));
				
				if(if1==1)
				{
					String name;
					name=("/by/bsuir/kyrsProjekt/client/");
					name=name+listAR1.get(list1.getSelectedIndex());
					name=name+listAR2.get(list2.getSelectedIndex());
					name=name+(".jpg");
					System.out.println(name);
					lbanimals_1.setIcon(new ImageIcon(Person.class.getResource(name)));
				}
			}
		});
		list2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		list2.setFont(new Font("Calibri", Font.BOLD, 15));
		list2.setBackground(new Color(102, 204, 153));
		list2.setEnabled(true);
		list2.setBounds(813, 261, 202, 251);
		contentPane.add(list2);
		
		listAR2=new ArrayList();
		listAR2.add("tigr");
		listAR2.add("kot");
		listAR2.add("olen");
		listAR2.add("payk");
		listAR2.add("ptica");
		
		listArray2=new ArrayList();
		listArray2.add("тигр");
		listArray2.add("кот");
		listArray2.add("олень");
		listArray2.add("паук");
		listArray2.add("птица");
		
		 model_2 = new DefaultListModel();
		 for ( String element :listArray2) {
	            model_2.addElement(element);
	        }
	     list2.setModel(model_2);
;		
		

		JLabel lblNewLabel_1 = new JLabel("\u0412 \u0434\u0430\u043B\u0435\u043A\u043E\u043C-\u0434\u0430\u043B\u0435\u043A\u043E\u043C \u0431\u0443\u0434\u0443\u0449\u0435\u043C...");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 24));
		lblNewLabel_1.setBounds(338, 22, 463, 46);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u0410 \u043C\u043E\u0436\u0435\u0442 \u0438 \u043D\u0435 \u0434\u0430\u043B\u0435\u043A\u043E\u043C...");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 19));
		lblNewLabel_2.setBounds(347, 43, 437, 46);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u0421\u041A\u0420\u0415\u0429\u0418\u0412\u0410\u041D\u0418\u0415");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 39));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(348, 79, 436, 102);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u0410 \u043C\u043E\u0436\u0435\u0442 \u0438 \u043D\u0435 \u0431\u0443\u0434\u0443\u0449\u0435\u043C...");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 17));
		lblNewLabel_4.setBackground(new Color(240, 240, 240));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(348, 79, 436, 40);
		contentPane.add(lblNewLabel_4);
		
		
	
	
	
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Person.class.getResource("/by/bsuir/kyrsProjekt/client/phone.jpg")));
		lblNewLabel.setBounds(0, 0, 1350, 692);
		contentPane.add(lblNewLabel);
		

	
	}
}