package by.bsuir.kyrsProjekt.client;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Classification extends JFrame {

	@SuppressWarnings("rawtypes")
	final DefaultListModel model;
	public  ArrayList<String> listArraylist;
	public  ArrayList<String> listArraylist_tip;
	public  ArrayList<String> listArraylist_klass;
	public  ArrayList<String> listArraylist_otriad;
	public  ArrayList<String> listArraylist_rod;
	public  ArrayList<String> listArraylist_vid;
    public static Classification frameClassification = new Classification();
	private JPanel contentPane;
	private JTextField vvodJText;
	private JTextField VvodTip;
	@SuppressWarnings("rawtypes")
	private  DefaultListModel model_tip;
	@SuppressWarnings("rawtypes")
	private  DefaultListModel model_otriad;
	@SuppressWarnings("rawtypes")
	private  DefaultListModel model_klass;
	@SuppressWarnings("rawtypes")
	private  DefaultListModel model_rod;
	@SuppressWarnings({ "rawtypes" })
	private  DefaultListModel model_vid;
	@SuppressWarnings("rawtypes")
	private JList list_tip;
	@SuppressWarnings("rawtypes")
	private JList list_klass;
	@SuppressWarnings("rawtypes")
	private JList list_otriad;
	@SuppressWarnings({ "rawtypes", "unused" })
	private JList list_rod;
	@SuppressWarnings("rawtypes")
	private JList list_vid;
	private JTextField VvodKlass;
	private JTextField VvodOtriad;
	private JTextField VvodRod;
	private JTextField VvodVid;

	public static void closeClassification(){
		frameClassification.setVisible(false);	
	}

	/**
	 * Launch the application.
	 */
	public static void mainCl() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameClassification.setIconImage(ImageIO.read(this.getClass().getResourceAsStream("m.jpg")));
					frameClassification.setVisible(true);
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
	public Classification() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setBackground(RGB(10,3,150));
		setContentPane(contentPane);
		
		JButton button = new JButton("\u0413\u043B\u0430\u0432\u043D\u043E\u0435 \u043C\u0435\u043D\u044E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		button.setIcon(new ImageIcon(Classification.class.getResource("/by/bsuir/kyrsProjekt/client/back.jpg")));
		button.setSelectedIcon(null);
		button.setBounds(1037, 547, 270, 85);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				closeClassification();
				Masha.viewMasha();
			}
		});
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(153, 255, 255));
		textPane.setBounds(922, 63, 344, 275);
		contentPane.add(textPane);
		
		 
			JButton SetOrg = new JButton("");
			SetOrg.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			SetOrg.setToolTipText("\u041E\u0431\u043D\u043E\u0432\u0438\u0442\u044C \u043E\u043F\u0438\u0441\u0430\u043D\u0438\u0435");
			SetOrg.setIcon(new ImageIcon(Classification.class.getResource("/by/bsuir/kyrsProjekt/client/obn.jpg")));
			SetOrg.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {// нажать на обновить описание
					try {
						Client.organizmSet(listArraylist_vid.get(list_vid.getSelectedIndex()), textPane.getText());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			SetOrg.setBounds(1017, 349, 160, 62);
			contentPane.add(SetOrg);

		
		final JList list_rod = new JList();
		 model_vid = new DefaultListModel();
		 list_vid = new JList(model_vid);
		 list_vid.addMouseListener(new MouseAdapter() {
			 
			 
			 @Override
		 	public void mouseClicked(MouseEvent arg0) {// нажать на таблицу 6
				 
				 String str;
				 try {
					str=Client.organizmGet(listArraylist_vid.get(list_vid.getSelectedIndex()));
					textPane.setText(str);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 	
		 	}
		 });
		list_rod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//нажать на таблицу 5
				listArraylist_vid = new ArrayList<String>();
			     try {
			    	 listArraylist_vid=Client.vidGet(listArraylist_rod.get(list_rod.getSelectedIndex()));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			 	DefaultListModel model_vid = new DefaultListModel();
			     for ( String element :listArraylist_vid) {
			            model_vid.addElement(element);
			        }
			     list_vid.setModel(model_vid);
			     textPane.setText("");
				
			}
		});
		 model_otriad = new DefaultListModel();
		 list_otriad = new JList(model_otriad);
		list_otriad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//нажать на таблицу 4
				listArraylist_rod = new ArrayList<String>();
			     try {
			    	 listArraylist_rod=Client.rodGet(listArraylist_otriad.get(list_otriad.getSelectedIndex()));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			 	DefaultListModel model_rod = new DefaultListModel();
			     for ( String element :listArraylist_rod) {
			            model_rod.addElement(element);
			        }
			     list_rod.setModel(model_rod);
			     
			     DefaultListModel model_vid = new DefaultListModel();
			     list_vid.setModel(model_vid);
			     textPane.setText("");
			}
		});
		
			
		
		//JList list_vid = new JList();
		list_vid.setBackground(new Color(204, 255, 255));
		list_vid.setBounds(756, 63, 124, 198);
		contentPane.add(list_vid);
		
		JScrollPane scrollPane_vid = new JScrollPane(list_vid);
		scrollPane_vid.setBounds(756, 63, 124, 198);
		contentPane.add(scrollPane_vid);
		
		VvodVid = new JTextField();
		VvodVid.setToolTipText("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0432\u0438\u0434");
		VvodVid.setBounds(755, 275, 125, 29);
		contentPane.add(VvodVid);
		VvodVid.setColumns(10);
		
		JButton DobavitVid = new JButton("");
		DobavitVid.setToolTipText("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
		DobavitVid.setIcon(new ImageIcon(Classification.class.getResource("/by/bsuir/kyrsProjekt/client/dob.jpg")));
		DobavitVid.setFont(new Font("Tahoma", Font.PLAIN, 10));
		DobavitVid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//нажать на добавить вид
				
				listArraylist_vid.add(VvodVid.getText());
				
				 model_vid = new DefaultListModel();
			     for ( String element :listArraylist_vid) {
			            model_vid.addElement(element);
			        }
				list_vid.setModel(model_vid);
			
				try {
					//System.out.println("!!!");
					//System.out.println(list_klass);
					//System.out.println(VvodOtriad.getText());
					Client.vidSet(listArraylist_rod.get(list_rod.getSelectedIndex()),VvodVid.getText()); 
					VvodVid.setText("");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
				
			
		});
		DobavitVid.setBounds(753, 316, 127, 42);
		contentPane.add(DobavitVid);
		
		JButton YdalitVid = new JButton("");
		YdalitVid.setToolTipText("\u0423\u0434\u0430\u043B\u0438\u0442\u044C");
		YdalitVid.setIcon(new ImageIcon(Classification.class.getResource("/by/bsuir/kyrsProjekt/client/del.jpg")));
		YdalitVid.setFont(new Font("Tahoma", Font.PLAIN, 10));
		YdalitVid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//нажать на удалить вид

				try {
					Client.vidDelete(listArraylist_vid.get(list_vid.getSelectedIndex()));
					listArraylist_vid.remove(list_vid.getSelectedIndex());
				} catch (Exception e1) {
					
				}
				 model_vid = new DefaultListModel();
			     for ( String element :listArraylist_vid) {
			            model_vid.addElement(element);
			        }
				list_vid.setModel(model_vid);
			}
		});
		YdalitVid.setBounds(753, 369, 127, 42);
		contentPane.add(YdalitVid);
		
		JLabel lblNewLabel_5 = new JLabel("\u0412\u0438\u0434:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setToolTipText("");
		lblNewLabel_5.setBounds(753, 18, 127, 42);
		contentPane.add(lblNewLabel_5);
		
		//JList list_rod = new JList();
		list_rod.setBackground(new Color(204, 255, 204));
		list_rod.setBounds(606, 62, 137, 201);
		contentPane.add(list_rod);
		
		JScrollPane scrollPane_rod = new JScrollPane(list_rod);
		scrollPane_rod.setBounds(606, 62, 137, 201);
		contentPane.add(scrollPane_rod);
		
		VvodRod = new JTextField();
		VvodRod.setToolTipText("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0440\u043E\u0434");
		VvodRod.setBounds(606, 276, 137, 29);
		contentPane.add(VvodRod);
		VvodRod.setColumns(10);
		
		JButton DobavitRod = new JButton("");
		DobavitRod.setToolTipText("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
		DobavitRod.setFont(new Font("Tahoma", Font.PLAIN, 10));
		DobavitRod.setIcon(new ImageIcon(Classification.class.getResource("/by/bsuir/kyrsProjekt/client/dob.jpg")));
		DobavitRod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//нажать на добавить род
				listArraylist_rod.add(VvodRod.getText());
				
				 model_rod = new DefaultListModel();
			     for ( String element :listArraylist_rod) {
			            model_rod.addElement(element);
			        }
				list_rod.setModel(model_rod);
			
				try {

					Client.rodSet(listArraylist_otriad.get(list_otriad.getSelectedIndex()),VvodRod.getText()); 
					VvodRod.setText("");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
				
			}
		);
		DobavitRod.setBounds(606, 316, 137, 42);
		contentPane.add(DobavitRod);
		
		JButton YdalitRod = new JButton("");
		YdalitRod.setToolTipText("\u0423\u0434\u0430\u043B\u0438\u0442\u044C");
		YdalitRod.setIcon(new ImageIcon(Classification.class.getResource("/by/bsuir/kyrsProjekt/client/del.jpg")));
		YdalitRod.setFont(new Font("Tahoma", Font.PLAIN, 10));
		YdalitRod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//нажать на удалить род

				try {
					Client.rodDelete(listArraylist_rod.get(list_rod.getSelectedIndex()));
					listArraylist_rod.remove(list_rod.getSelectedIndex());
				} catch (Exception e1) {
					
				}
				 model_rod = new DefaultListModel();
			     for ( String element :listArraylist_rod) {
			            model_rod.addElement(element);
			        }
				list_rod.setModel(model_rod);
				  

			     DefaultListModel model_vid = new DefaultListModel();
			     list_vid.setModel(model_vid);
			     }

		});
		YdalitRod.setBounds(606, 369, 137, 42);
		contentPane.add(YdalitRod);
		
		JLabel label = new JLabel("\u0420\u043E\u0434:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		label.setBounds(606, 18, 137, 42);
		contentPane.add(label);
		
		
		list_otriad.setBackground(new Color(204, 255, 153));
		list_otriad.setBounds(457, 61, 139, 202);
		contentPane.add(list_otriad);
		
		JScrollPane scrollPane_otriad = new JScrollPane(list_otriad);
		scrollPane_otriad.setBounds(457, 61, 139, 202);
		contentPane.add(scrollPane_otriad);
		
		VvodOtriad = new JTextField();
		VvodOtriad.setToolTipText("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u043E\u0442\u0440\u044F\u0434");
		VvodOtriad.setBounds(457, 276, 139, 29);
		contentPane.add(VvodOtriad);
		VvodOtriad.setColumns(10);

		JButton DobavitOtriad = new JButton("");
		DobavitOtriad.setToolTipText("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
		DobavitOtriad.setFont(new Font("Tahoma", Font.PLAIN, 10));
		DobavitOtriad.setIcon(new ImageIcon(Classification.class.getResource("/by/bsuir/kyrsProjekt/client/dob.jpg")));
		DobavitOtriad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {// нажать на добавить отряд
				listArraylist_otriad.add(VvodOtriad.getText());
				
				 model_otriad = new DefaultListModel();
			     for ( String element :listArraylist_otriad) {
			            model_otriad.addElement(element);
			        }
				list_otriad.setModel(model_otriad);
			
				try {
					Client.otriadSet(listArraylist_klass.get(list_klass.getSelectedIndex()),VvodOtriad.getText()); 
					VvodOtriad.setText("");
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				
			}
		});
		DobavitOtriad.setBounds(457, 316, 139, 42);
		contentPane.add(DobavitOtriad);
		
		JButton YdalitOtriad = new JButton("");
		YdalitOtriad.setToolTipText("\u0423\u0434\u0430\u043B\u0438\u0442\u044C");
		YdalitOtriad.setIcon(new ImageIcon(Classification.class.getResource("/by/bsuir/kyrsProjekt/client/del.jpg")));
		YdalitOtriad.setFont(new Font("Tahoma", Font.PLAIN, 10));
		YdalitOtriad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//нажать на удалить отряд
				
				try {
					Client.otriadDelete(listArraylist_otriad.get(list_otriad.getSelectedIndex()));
					listArraylist_otriad.remove(list_otriad.getSelectedIndex());
				} catch (Exception e1) {
					
				}
				 model_otriad = new DefaultListModel();
			     for ( String element :listArraylist_otriad) {
			            model_otriad.addElement(element);
			        }
				list_otriad.setModel(model_otriad);
				  

			     DefaultListModel model_vid = new DefaultListModel();
			     list_vid.setModel(model_vid);
			     DefaultListModel model_rod = new DefaultListModel();
			     list_rod.setModel(model_rod);
				
			}
		});
		YdalitOtriad.setBounds(457, 369, 139, 42);
		contentPane.add(YdalitOtriad);
		
		JLabel lblNewLabel_4 = new JLabel("\u041E\u0442\u0440\u044F\u0434:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel_4.setBounds(457, 18, 139, 42);
		contentPane.add(lblNewLabel_4);
		
		
		
		
		
		//final JList list_klass = new JList();
		 model_klass = new DefaultListModel();
		 list_klass = new JList(model_klass);
		list_klass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {// нажать на таблицу 3
				listArraylist_otriad = new ArrayList<String>();
			     try {
					listArraylist_otriad=Client.otriadGet(listArraylist_klass.get(list_klass.getSelectedIndex()));
				//	System.out.println(listArraylist_tip);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			 	DefaultListModel model_otriad = new DefaultListModel();
			     for ( String element :listArraylist_otriad) {
			            model_otriad.addElement(element);
			        }
			     list_otriad.setModel(model_otriad);
		 		
			     DefaultListModel model_vid = new DefaultListModel();
			     list_vid.setModel(model_vid);
			     DefaultListModel model_rod = new DefaultListModel();
			     list_rod.setModel(model_rod);
			     textPane.setText("");
				
			}
		});
		
		
		list_klass.setBackground(new Color(204, 255, 102));
		list_klass.setSelectionForeground(new Color(255, 255, 255));
		list_klass.setBounds(306, 60, 141, 203);
		contentPane.add(list_klass);
		
		JScrollPane scrollPane_klass = new JScrollPane(list_klass);
		scrollPane_klass.setBounds(306, 60, 141, 203);
		contentPane.add(scrollPane_klass);
		
		
		VvodKlass = new JTextField();
		VvodKlass.setToolTipText("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u043A\u043B\u0430\u0441\u0441");
		VvodKlass.setBounds(306, 276, 141, 29);
		contentPane.add(VvodKlass);
		VvodKlass.setColumns(10);
		
		JButton DobavitKlass = new JButton("");
		DobavitKlass.setToolTipText("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
		DobavitKlass.setIcon(new ImageIcon(Classification.class.getResource("/by/bsuir/kyrsProjekt/client/dob.jpg")));
		DobavitKlass.setFont(new Font("Tahoma", Font.PLAIN, 10));
		

		DobavitKlass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {// нажать на добавить класс
				listArraylist_klass.add(VvodKlass.getText());
				
				 model_klass = new DefaultListModel();
			     for ( String element :listArraylist_klass) {
			            model_klass.addElement(element);
			        }
				
				
				list_klass.setModel(model_klass);
				try {
					Client.klassSet(listArraylist_tip.get(list_tip.getSelectedIndex()),VvodKlass.getText()); 
					VvodKlass.setText("");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
				
			}
		);
		DobavitKlass.setBounds(306, 316, 141, 42);
		contentPane.add(DobavitKlass);
		
		JButton YdalitKlass = new JButton("");
		YdalitKlass.setToolTipText("\u0423\u0434\u0430\u043B\u0438\u0442\u044C");
		YdalitKlass.setIcon(new ImageIcon(Classification.class.getResource("/by/bsuir/kyrsProjekt/client/del.jpg")));
		YdalitKlass.setFont(new Font("Tahoma", Font.PLAIN, 10));
		YdalitKlass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {// ажать на удалить класс
				try {
					Client.klassDelete(listArraylist_klass.get(list_klass.getSelectedIndex()));
					listArraylist_klass.remove(list_klass.getSelectedIndex());
				} catch (Exception e1) {
					
				}
				 model_klass = new DefaultListModel();
			     for ( String element :listArraylist_klass) {
			            model_klass.addElement(element);
			        }
				list_klass.setModel(model_klass);
				
			     DefaultListModel model_vid = new DefaultListModel();
			     list_vid.setModel(model_vid);
			     DefaultListModel model_rod = new DefaultListModel();
			     list_rod.setModel(model_rod);
			     DefaultListModel model_otriad = new DefaultListModel();
			     list_otriad.setModel(model_otriad);
			
		}
				
			}
		);
		YdalitKlass.setBounds(306, 369, 141, 42);
		contentPane.add(YdalitKlass);
		
	
		
		
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("\u041A\u043B\u0430\u0441\u0441:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel_3.setBounds(306, 18, 139, 42);
		contentPane.add(lblNewLabel_3);
		contentPane.add(button);
	     listArraylist = new ArrayList<String>();
	     try {
	    	 //Carstvo.CarstvoSet();
			listArraylist=Client.CarstvoGet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 model = new DefaultListModel();
	     //model.addElement(listArraylist);
	     for ( String element :listArraylist) {
	            model.addElement(element);
	        }
		
		
		
		
		JButton addButton = new JButton("");
		addButton.setToolTipText("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		addButton.setIcon(new ImageIcon(Classification.class.getResource("/by/bsuir/kyrsProjekt/client/dob.jpg")));
		addButton.setBounds(10, 316, 141, 42);
		contentPane.add(addButton);
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(vvodJText.getText());
				listArraylist.add(vvodJText.getText());
				model.addElement(vvodJText.getText());
				try {
					Client.CarstvoSet(vvodJText.getText());
					vvodJText.setText("");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		vvodJText = new JTextField();
		vvodJText.setToolTipText("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0446\u0430\u0440\u0441\u0442\u0432\u043E");
		vvodJText.setBounds(10, 276, 141, 29);
		contentPane.add(vvodJText);
		vvodJText.setColumns(10);
		
		JButton deleteButton = new JButton("");
		deleteButton.setToolTipText("\u0423\u0434\u0430\u043B\u0438\u0442\u044C");
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		deleteButton.setIcon(new ImageIcon(Classification.class.getResource("/by/bsuir/kyrsProjekt/client/del.jpg")));
		deleteButton.setBounds(10, 369, 141, 42);
		contentPane.add(deleteButton);
		
		JLabel lblNewLabel_1 = new JLabel("\u0426\u0430\u0440\u0441\u0442\u0432\u043E:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel_1.setBounds(10, 18, 141, 42);
		contentPane.add(lblNewLabel_1);
		
		 model_tip = new DefaultListModel();
		 list_tip = new JList(model_tip);
		 list_tip.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent arg0) {//нажатие на таблицу 2
		 		listArraylist_klass = new ArrayList<String>();
			     try {
					listArraylist_klass=Client.klassGet(listArraylist_tip.get(list_tip.getSelectedIndex()));
				//	System.out.println(listArraylist_tip);
				} catch (Exception e) {
					e.printStackTrace();
				}
			 	DefaultListModel model_klass = new DefaultListModel();
			     for ( String element :listArraylist_klass) {
			            model_klass.addElement(element);
			        }
			     list_klass.setModel(model_klass);
		 		
			     DefaultListModel model_vid = new DefaultListModel();
			     list_vid.setModel(model_vid);
			     DefaultListModel model_rod = new DefaultListModel();
			     list_rod.setModel(model_rod);
			     DefaultListModel model_otriad = new DefaultListModel();
			     list_otriad.setModel(model_otriad);
			     textPane.setText("");
		 	}
		 });
	
				final JList list = new JList();
				list.addMouseListener(new MouseAdapter() {// нажатие на таблицу 1
					@Override
					public void mouseClicked(MouseEvent arg0) {
						 listArraylist_tip = new ArrayList<String>();
					     try {
					    	 System.out.println("!!!");
							listArraylist_tip=Client.tipGet(list.getSelectedIndex());
							System.out.println("!!!");
						} catch (Exception e) {
							e.printStackTrace();
						}
					 	DefaultListModel model_tip = new DefaultListModel();
					     for ( String element :listArraylist_tip) {
					            model_tip.addElement(element);
					        }
					     list_tip.setModel(model_tip);
					     
					     DefaultListModel model_klass = new DefaultListModel();
					     list_klass.setModel(model_klass);
					     DefaultListModel model_vid = new DefaultListModel();
					     list_vid.setModel(model_vid);
					     DefaultListModel model_rod = new DefaultListModel();
					     list_rod.setModel(model_rod);
					     DefaultListModel model_otriad = new DefaultListModel();
					     list_otriad.setModel(model_otriad);
					     textPane.setText("");
					     
					}
				})
				;
				list.setBackground(new Color(204, 255, 0));
				list.setFont(new Font("Tahoma", Font.PLAIN, 12));
				list.setForeground(new Color(0, 0, 0));
				list.setBounds(10, 60, 141, 205);
				contentPane.add(list);
				list.setModel(model);
				
				JScrollPane scrollPane = new JScrollPane(list);
				scrollPane.setBounds(10, 60, 141, 205);
				contentPane.add(scrollPane);
		
		JLabel lblNewLabel_2 = new JLabel("\u0422\u0438\u043F:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setLabelFor(this);
		lblNewLabel_2.setToolTipText("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel_2.setBounds(161, 26, 108, 27);
		contentPane.add(lblNewLabel_2);
		
	

		deleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {// надо добавить удаление из колекции!
				//model.remove(list.getSelectedIndex());
				try {
					Client.CarstvoDelete(list.getSelectedIndex());
					model.remove(list.getSelectedIndex());
					
					  
				     DefaultListModel model_klass = new DefaultListModel();
				     list_klass.setModel(model_klass);
				     DefaultListModel model_vid = new DefaultListModel();
				     list_vid.setModel(model_vid);
				     DefaultListModel model_rod = new DefaultListModel();
				     list_rod.setModel(model_rod);
				     DefaultListModel model_otriad = new DefaultListModel();
				     list_otriad.setModel(model_otriad);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		

	
		
		  list_tip.setBackground(new Color(204, 255, 51));
			JScrollPane scrollPane_tip = new JScrollPane(list_tip);	
			scrollPane_tip.setBounds(155, 60, 141, 205);
			contentPane.add(scrollPane_tip);
			
		

		VvodTip = new JTextField();
		VvodTip.setToolTipText("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0442\u0438\u043F");
		VvodTip.setBounds(161, 276, 135, 29);
		contentPane.add(VvodTip);
		VvodTip.setColumns(10);
		
		JButton DobavitTip = new JButton("");
		DobavitTip.setToolTipText("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
		DobavitTip.setFont(new Font("Tahoma", Font.PLAIN, 10));
		DobavitTip.setIcon(new ImageIcon(Classification.class.getResource("/by/bsuir/kyrsProjekt/client/dob.jpg")));
		DobavitTip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {// нажать на кнопку добавить тип
				
				listArraylist_tip.add(VvodTip.getText());
				
				 model_tip = new DefaultListModel();
			     for ( String element :listArraylist_tip) {
			            model_tip.addElement(element);
			        }
				
				
				list_tip.setModel(model_tip);
				try {
					Client.tipSet(list.getSelectedIndex(),VvodTip.getText());
					VvodTip.setText("");

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		DobavitTip.setBounds(161, 316, 135, 42);
		contentPane.add(DobavitTip);
		
		
		JButton YdalitTip = new JButton("");
		YdalitTip.setToolTipText("\u0423\u0434\u0430\u043B\u0438\u0442\u044C");
		YdalitTip.setIcon(new ImageIcon(Classification.class.getResource("/by/bsuir/kyrsProjekt/client/del.jpg")));
		YdalitTip.setFont(new Font("Tahoma", Font.PLAIN, 10));
		YdalitTip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//ажать на удалить тип
					try {
						Client.tipDelete(listArraylist_tip.get(list_tip.getSelectedIndex()));
						listArraylist_tip.remove(list_tip.getSelectedIndex());
					    } catch (Exception e1) {
						
					}
					 list_tip.setModel(model_tip);
					 model_tip = new DefaultListModel();
				     for ( String element :listArraylist_tip) {
				            model_tip.addElement(element);
				        }
					list_tip.setModel(model_tip);
			}
		});
		
		
		YdalitTip.setBounds(161, 369, 135, 42);
		contentPane.add(YdalitTip);
		
		JLabel lblNewLabel_6 = new JLabel("\u041E\u043F\u0438\u0441\u0430\u043D\u0438\u0435 \u0432\u0438\u0434\u0430:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(921, 18, 345, 42);
		contentPane.add(lblNewLabel_6);




		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(UIManager.getFont("Button.font"));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setIcon(new ImageIcon("D:\\\u0423\u0447\u0435\u0431\u0430\\\u041A\u0443\u0440\u0441\u0430\u0447\\PapkaNew\\Kyrs\\src\\by\\Belarusian\\phone.jpg"));
		lblNewLabel.setBounds(0, 0, 1340, 681);
		contentPane.add(lblNewLabel);
		
	
	}
}