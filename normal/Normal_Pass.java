package normal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import login.Login_Page;
import signup.Sign;

public class Normal_Pass {
	
	String Name;
	String Age;
	String Gender;
	String Aadhar_no;
	String Address;
	String Country;
	String Pan_Id;
	String Occupation;
	String From;
	String To;
	String Time;
	String StartDate;
	String EndDate;
	String Aproved1="Yes";
	int Money;
	String de;
	int count;
	Connection con = null;
	PreparedStatement pst;
	ResultSet rs;
	String Result="No";
	String Aproved="Start";

	LocalTime CuTime = LocalTime.now();
	LocalDate CuDate = LocalDate.now();
	
	public Normal_Pass() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/buspass","root","//JOKER//");
			
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
			catch(SQLException e1){
				e1.printStackTrace();
			}
	}
public void Normal_Page() {
	StartDate =CuDate.toString();
	Time = CuTime.toString();
	Sign si = new Sign();
	Name =si.Name;
	Aadhar_no = si.Aadhar;
	Age = si.Age;
	final JFrame frame = new JFrame("Day Pass");
	
	
	
	
	//Label Student 
	JLabel la1 = new JLabel("Day Pass Details ");
	la1.setBounds(420,30,250,30);
	la1.setFont(new Font("Times New Roman",Font.BOLD,30));
	la1.setForeground(Color.decode("#bb1ee3"));
	frame.add(la1);
	
	//Name
	JLabel la = new JLabel("Name");
	la.setBounds(50,150,90,24);
	la.setFont(new Font("Times New Roman",Font.BOLD,24));
	la.setForeground(Color.black);
	frame.add(la);
	final JTextField tx = new JTextField(Name);
	tx.setBounds(170,153,140,24);
	tx.setFont(new Font("Times New Roman ",Font.BOLD,14));
	tx.setForeground(Color.black);
	frame.add(tx);
	
	//Age
	JLabel la2 = new JLabel("Age");
	la2.setBounds(50,200,90,24);
	la2.setFont(new Font("Times New Roman",Font.BOLD,24));
	la2.setForeground(Color.black);
	frame.add(la2);
	final JTextField tx1 = new JTextField(Age);
	tx1.setBounds(170,203,140,24);
	tx1.setFont(new Font("Times New Roman ",Font.BOLD,18));
	tx1.setForeground(Color.black);
	frame.add(tx1);
	
	//Gender
	 JLabel gender = new JLabel("Gender ");
		gender.setBounds(50,253,90,24);
	   gender.setFont(new Font("Times New Roman",Font.BOLD,24));
		final JRadioButton rt = new JRadioButton("Male");
		final JRadioButton rt1 = new JRadioButton("Female");
		final JRadioButton rt2 = new JRadioButton("Others");
		final JRadioButton rt3 = new JRadioButton("Alien");
		
		ButtonGroup btgroup = new ButtonGroup();
		btgroup.add(rt);
		btgroup.add(rt1);
		btgroup.add(rt2);
		btgroup.add(rt3);
		
		rt.setBounds(170,253, 70, 30);
		rt1.setBounds(240,253, 70, 30);
		rt2.setBounds(310,253,70,30);
		rt3.setBounds(380,253,70,30);

		frame.add(rt);
		frame.add(rt1);
		frame.add(rt2);
		frame.add(rt3);
	   frame.add(gender);	
	
	//Aadhar No
	JLabel la4 = new JLabel("Aadhar");
	la4.setBounds(50,300,90,24);
	la4.setFont(new Font("Times New Roman",Font.BOLD,24));
	la4.setForeground(Color.black);
	frame.add(la4);
	final JTextField tx3 = new JTextField(Aadhar_no);
	tx3.setBounds(170,303,140,24);
	tx3.setFont(new Font("Times New Roman ",Font.BOLD,18));
	tx3.setForeground(Color.black);
	frame.add(tx3);
	
	//Address
	JLabel la5 = new JLabel("Address");
	la5.setBounds(50,350,90,24);
	la5.setFont(new Font("Times New Roman",Font.BOLD,24));
	la5.setForeground(Color.black);
	frame.add(la5);
	final JTextField tx4 = new JTextField();
	tx4.setBounds(170,353,140,24);
	tx4.setFont(new Font("Times New Roman ",Font.BOLD,18));
	tx4.setForeground(Color.black);
	frame.add(tx4);
	
	//Country
	JLabel la6 = new JLabel("Country");
	la6.setBounds(50,400,90,24);
	la6.setFont(new Font("Times New Roman",Font.BOLD,24));
	la6.setForeground(Color.black);
	frame.add(la6);
	final JTextField tx5 = new JTextField();
	tx5.setBounds(170,403,140,24);
	tx5.setFont(new Font("Times New Roman ",Font.BOLD,18));
	tx5.setForeground(Color.black);
	frame.add(tx5);
	
	//Collage Id
	JLabel la7 = new JLabel("Pan Card Id");
	la7.setBounds(30,450,150,24);
	la7.setFont(new Font("Times New Roman",Font.BOLD,24));
	la7.setForeground(Color.black);
	frame.add(la7);
	final JTextField tx6 = new JTextField();
	tx6.setBounds(170,453,140,24);
	tx6.setFont(new Font("Times New Roman ",Font.BOLD,18));
	tx6.setForeground(Color.black);
	frame.add(tx6);
	
	//Collage Name
	JLabel la8 = new JLabel("Occupation");
	la8.setBounds(550,150,190,25);
	la8.setFont(new Font("Times New Roman",Font.BOLD,24));
	la8.setForeground(Color.black);
	frame.add(la8);
	final JTextField tx7 = new JTextField();
	tx7.setBounds(750,150,140,24);
	tx7.setFont(new Font("Times New Roman ",Font.BOLD,18));
	tx7.setForeground(Color.black);
	frame.add(tx7);
	
	//From 
	JLabel la9 = new JLabel("From");
	la9.setBounds(550,200,190,25);
	la9.setFont(new Font("Times New Roman",Font.BOLD,24));
	la9.setForeground(Color.black);
	frame.add(la9);
	final JTextField tx8 = new JTextField();
	tx8.setBounds(750,200,140,24);
	tx8.setFont(new Font("Times New Roman ",Font.BOLD,18));
	tx8.setForeground(Color.black);
	frame.add(tx8);
	
	//To
	JLabel la10 = new JLabel("To");
	la10.setBounds(550,250,190,25);
	la10.setFont(new Font("Times New Roman",Font.BOLD,24));
	la10.setForeground(Color.black);
	frame.add(la10);
	final JTextField tx9 = new JTextField();
	tx9.setBounds(750,250,140,24);
	tx9.setFont(new Font("Times New Roman ",Font.BOLD,18));
	tx9.setForeground(Color.black);
	frame.add(tx9);
	
	//StartDate
	JLabel la11 = new JLabel("Start Date ");
	la11.setBounds(550,300,190,25);
	la11.setFont(new Font("Times New Roman",Font.BOLD,24));
	la11.setForeground(Color.black);
	frame.add(la11);
	final JTextField tx10 = new JTextField(StartDate);
	tx10.setBounds(750,300,140,24);
	tx10.setFont(new Font("Times New Roman ",Font.BOLD,18));
	tx10.disable();
	tx10.setForeground(Color.black);
	frame.add(tx10);
	
	//End Date 
	JLabel la12 = new JLabel("End Date ");
	la12.setBounds(550,350,190,25);
	la12.setFont(new Font("Times New Roman",Font.BOLD,24));
	la12.setForeground(Color.black);
	frame.add(la12);
	final JTextField tx11 = new JTextField(StartDate);
	tx11.setBounds(750,350,140,24);
	tx11.setFont(new Font("Times New Roman ",Font.BOLD,18));
	tx11.setForeground(Color.black);
	tx11.disable();
	frame.add(tx11);
	
	
	
	//Home Button
		JButton bu2 = new JButton("Home");
		bu2.setBounds(50,30,83,23);
		bu2.setBackground(Color.decode("#e51a59"));
		bu2.setForeground(Color.BLACK);
		bu2.setFont(new Font("Times New Roman",Font.BOLD,20));
	    bu2.setBorder(BorderFactory.createEmptyBorder());
	    bu2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Login_Page lp = new Login_Page();
				lp.Login_Main();
			
			}
		});
	    frame.add(bu2);
	
	//Back Button
	JButton bu1 = new JButton("Back");
	bu1.setBounds(900,30,83,23);
	bu1.setBackground(Color.decode("#e51a59"));
	bu1.setForeground(Color.BLACK);
	bu1.setFont(new Font("Times New Roman",Font.BOLD,20));
    bu1.setBorder(BorderFactory.createEmptyBorder());
    bu1.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			Login_Page lp = new Login_Page();
			lp.Home(0);
		}
	});
    frame.add(bu1);
	
	//submit Button
			JButton bu = new JButton("Submit");
			bu.setBounds(680,450,120,23);
			bu.setForeground(Color.white);
			bu.setBackground(Color.black);
			bu.setFont(new Font("Times New Roman",Font.BOLD,23));
			bu.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					Name = tx.getText();
					Age = tx1.getText();
					if(rt.isSelected()) {
						Gender="Male";
					}
					else if(rt1.isSelected()) {
						Gender="Female";
					}
					else if(rt2.isSelected()) {
						Gender="Others";
					}
					else if(rt3.isSelected()) {
						Gender="Alien";
					}
					Aadhar_no = tx3.getText();
					Address = tx4.getText();
					Country = tx5.getText();
					Pan_Id = tx6.getText();
					Occupation = tx7.getText();
					From = tx8.getText();
					To = tx9.getText();
					StartDate = tx10.getText();
					EndDate = tx11.getText();
					if(Name.length()>0) {
						if(Age.length()>0 && Age.length()<=2) {
							if(Aadhar_no.length()==12) {
								if(Address.length()>0) {
									if(Country.length()>0) {
										if(Pan_Id.length()>0) {
											if(Occupation.length()>0) {
												if(From.length()>0) {
													if(To.length()>0) {
														pay();
													}else {
														JOptionPane.showMessageDialog(frame, "Fill The To Field ! ");
													}
												}else {
													JOptionPane.showMessageDialog(frame, "Fill The From Field ! ");
												}
											}else {
												JOptionPane.showMessageDialog(frame, "Fill The Occupation Field ! ");
											}
										}else {
											JOptionPane.showMessageDialog(frame, "Fill The PanId Field ! ");
										}
									}else {
										JOptionPane.showMessageDialog(frame, "Fill The Country Field ! ");
									}
								}else {
									JOptionPane.showMessageDialog(frame, "Fill The Address Field ! ");
								}
							}else {
								JOptionPane.showMessageDialog(frame, "Invalid Aadher Number !");
							}
						}else {
							JOptionPane.showMessageDialog(frame, "Invalid Age");
						}
						
					}else {
						JOptionPane.showMessageDialog(frame, "Fill The Name Field !");
					}
				
				}
			});
			frame.add(bu);
	
			//Background Image 
			ImageIcon imj = new ImageIcon("C:\\Users\\mahes\\eclipse-workspace\\BusPass\\src\\student\\Background.jpg");
			JLabel lo = new JLabel(imj);
			lo.setSize(1024, 600);
			frame.add(lo);
	frame.setSize(1024,600);
	frame.setLayout(null);
	frame.setVisible(true);
	frame.setResizable(false);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}



//Payment 
public void pay() {
	
	
	JFrame frame = new JFrame();
	
	//head
	JLabel la1 = new JLabel("Day Pass Payment Page");
	la1.setBounds(400,30,700,50);
	la1.setForeground(Color.white);
	la1.setFont(new Font("Times New Roman",Font.BOLD,48));
	frame.add(la1);
	
	//head
		JLabel lu = new JLabel("Pay : 70");
		lu.setBounds(600,250,700,22);
		lu.setForeground(Color.white);
		lu.setFont(new Font("Times New Roman",Font.BOLD,20));
		frame.add(lu);
	
	
	//pay method
	JLabel la2 = new JLabel("Pay method");
	la2.setBounds(550,200,300,36);
	la2.setForeground(Color.white);
	la2.setFont(new Font("Times New Roman",Font.BOLD,35));
	frame.add(la2);
	
	//upi button
	JButton bu = new JButton("UPI");
	bu.setBounds(580,300,100,25);
	bu.setFont(new Font("Times New Roman",Font.BOLD,24));
	bu.setForeground(Color.yellow);
	bu.setBackground(Color.red);
	bu.setBorderPainted(false);
	bu.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			
			final JFrame frame = new JFrame();
			JLabel la = new JLabel("Enter Upi Id");
			la.setBounds(200,100,120,22);
			la.setForeground(Color.white);
			la.setFont(new Font("Times New Roman",Font.BOLD,21));
			frame.add(la);
			final JTextField tx  =new JTextField();
			tx.setBounds(360,100,100,22);
			tx.setForeground(Color.black);
			tx.setFont(new Font("Times New Roman",Font.BOLD,21));
			frame.add(tx);
			
			//Money
			JLabel la2 = new JLabel("Enter Money");
			la2.setBounds(200,150,120,22);
			la2.setForeground(Color.white);
			la2.setFont(new Font("Times New Roman",Font.BOLD,21));
			frame.add(la2);
			final JTextField tx1  =new JTextField();
			tx1.setBounds(360,150,100,22);
			tx1.setForeground(Color.black);
			tx1.setFont(new Font("Times New Roman",Font.BOLD,21));
			frame.add(tx1);
			
			//button
			JButton bu = new JButton("Pay");
			bu.setBounds(250,250,80,22);
			bu.setForeground(Color.black);
			bu.setBackground(Color.white);
			bu.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					String Upi;
					Upi = tx1.getText();
					de = tx.getText();
					 
					try {
						Money = Integer.parseInt(Upi);
					}catch(Exception e1){
						e1.printStackTrace();
					}
					if(de==null) {
						JOptionPane.showMessageDialog(frame,"Please Enter Upi Id ");
					}else {
						if(Money!=3000) {
							JOptionPane.showMessageDialog(frame,"Enter Correct Amount");
						
						}
						else {
							try {
								pst = con.prepareStatement("select * from Normalpass");
								rs = pst.executeQuery();
								while(rs.next()) {
									if(Aadhar_no.equals(rs.getString(4))) {
										Result = "Yes";
										break;
									}
								}
								
								if(Result=="No") {
									pst=con.prepareStatement("insert into Normalpass values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
									pst.setString(1,Name);
									pst.setString(2, Age);
									pst.setString(3, Gender);
									pst.setString(4, Aadhar_no);
									pst.setString(5, Address);
									pst.setString(6, Country);
									pst.setString(7, Pan_Id);
									pst.setString(8, Occupation);
									pst.setString(9, From);
									pst.setString(10, To);
									pst.setString(11, StartDate);
									pst.setString(12, EndDate);
									pst.setString(13, Aproved1);
									count = pst.executeUpdate();
									if(count>0) {
										JOptionPane.showMessageDialog(frame,"Data Send Sucessfully");
									}
								}
								else {
									JOptionPane.showMessageDialog(frame,"This Id Already Recorded");
								}
							}catch(Exception e3){
								e3.printStackTrace();
							}
							Result="No";
							JOptionPane.showMessageDialog(frame,"Payment Done");
							Login_Page lp = new Login_Page();
							lp.Home(0);
						}
					}
					
					
				}
			});
			frame.add(bu);
			ImageIcon imj = new ImageIcon("C:\\Users\\mahes\\eclipse-workspace\\BusPass\\src\\normal\\photos\\background.jpg");
			JLabel la3 = new JLabel(imj);
			la3.setSize(600,400);
			frame.add(la3);
			frame.setSize(600,400);
			frame.setLayout(null);
			frame.setVisible(true);
			
			
		}
	});
	frame.add(bu);
	
	
	//card
	JButton bu1 = new JButton("Card");
	bu1.setBounds(580,350,100,25);
	bu1.setFont(new Font("Times New Roman",Font.BOLD,24));
	bu1.setForeground(Color.black);
	bu1.setBackground(Color.green);
	bu1.setBorderPainted(false);
	bu1.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			final JFrame frame = new JFrame();
			
			//card Number
			JLabel la = new JLabel("Enter Card Nuber");
			la.setBounds(100,100,200,22);
			la.setForeground(Color.white);
			la.setFont(new Font("Times New Roman",Font.BOLD,21));
			frame.add(la);
			final JTextField tx  =new JTextField();
			tx.setBounds(300,100,150,22);
			tx.setForeground(Color.black);
			tx.setFont(new Font("Times New Roman",Font.BOLD,21));
			frame.add(tx);
			
			
			//Exp
			JLabel la1 = new JLabel("Enter Exp");
			la1.setBounds(150,150,120,22);
			la1.setForeground(Color.white);
			la1.setFont(new Font("Times New Roman",Font.BOLD,21));
			frame.add(la1);
			final JTextField tx1  =new JTextField();
			tx1.setBounds(300,150,60,22);
			tx1.setForeground(Color.black);
			tx1.setFont(new Font("Times New Roman",Font.BOLD,21));
			frame.add(tx1);
			
			//Cvv
			JLabel la2 = new JLabel("Enter Cvv");
			la2.setBounds(150,200,120,22);
			la2.setForeground(Color.white);
			la2.setFont(new Font("Times New Roman",Font.BOLD,21));
			frame.add(la2);
			final JPasswordField tx2  =new JPasswordField();
			tx2.setBounds(300,200,60,22);
			tx2.setForeground(Color.black);
			tx2.setFont(new Font("Times New Roman",Font.BOLD,21));
			frame.add(tx2);
			
			JButton bu = new JButton("Pay");
			bu.setBounds(250,250,80,22);
			bu.setForeground(Color.black);
			bu.setBackground(Color.white);
			bu.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					String ac;
					String ex;
					String cv;
					ac=tx.getText();
					ex = tx1.getText();
					cv = tx2.getText();
					
					if(ac==null && ex==null) {
						JOptionPane.showMessageDialog(frame,"Please Enter All Fileds");
					}
					else {
						try {
							pst = con.prepareStatement("select * from Normalpass");
							rs = pst.executeQuery();
							while(rs.next()) {
								if(Aadhar_no.equals(rs.getString(4))) {
									Result = "Yes";
									break;
								}
							}
							
							if(Result=="No") {
								pst=con.prepareStatement("insert into Normalpass values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
								pst.setString(1,Name);
								pst.setString(2, Age);
								pst.setString(3, Gender);
								pst.setString(4, Aadhar_no);
								pst.setString(5, Address);
								pst.setString(6, Country);
								pst.setString(7, Pan_Id);
								pst.setString(8, Occupation);
								pst.setString(9, From);
								pst.setString(10, To);
								pst.setString(11, StartDate);
								pst.setString(12, EndDate);
								pst.setString(13, Aproved1);
								count = pst.executeUpdate();
								if(count>0) {
									JOptionPane.showMessageDialog(frame,"Data Send Sucessfully");
								}
							}
							else {
								JOptionPane.showMessageDialog(frame,"This Id Already Recorded");
							}
						}catch(Exception e3){
							e3.printStackTrace();
						}
						Result="No";
						JOptionPane.showMessageDialog(frame,"Payment Done");
						Login_Page lp = new Login_Page();
						lp.Home(0);
					}
					
				}
			});
			frame.add(bu);
			ImageIcon imj = new ImageIcon("C:\\Users\\mahes\\eclipse-workspace\\BusPass\\src\\normal\\photos\\background.jpg");
			JLabel la3 = new JLabel(imj);
			la3.setSize(600,400);
			frame.add(la3);
			frame.setSize(600,400);
			frame.setLayout(null);
			frame.setVisible(true);
			
			
		}
	});
	
	frame.add(bu1);
	
	//QrCode
		JButton bu2 = new JButton("QrCode");
		bu2.setBounds(565,400,130,25);
		bu2.setFont(new Font("Times New Roman",Font.BOLD,24));
		bu2.setForeground(Color.ORANGE);
		bu2.setBackground(Color.black);
		bu2.setBorderPainted(false);
		bu2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				final JFrame frame = new JFrame();
				//logo
				ImageIcon im = new ImageIcon("C:\\Users\\mahes\\eclipse-workspace\\BusPass\\src\\normal\\photos\\qrcode.jpg");
				JLabel lu1 = new JLabel(im);
				lu1.setBounds(200,30,200,200);
				
				//button
				JButton bu = new JButton("Done");
				bu.setBounds(250,250,80,22);
				bu.setForeground(Color.black);
				bu.setBackground(Color.white);
				bu.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						try {
							pst = con.prepareStatement("select * from Normalpass");
							rs = pst.executeQuery();
							while(rs.next()) {
								if(Aadhar_no.equals(rs.getString(4))) {
									Result = "Yes";
									break;
								}
							}
							
							if(Result=="No") {
								pst=con.prepareStatement("insert into Normalpass values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
								pst.setString(1,Name);
								pst.setString(2, Age);
								pst.setString(3, Gender);
								pst.setString(4, Aadhar_no);
								pst.setString(5, Address);
								pst.setString(6, Country);
								pst.setString(7, Pan_Id);
								pst.setString(8, Occupation);
								pst.setString(9, From);
								pst.setString(10, To);
								pst.setString(11, StartDate);
								pst.setString(12, EndDate);
								pst.setString(13, Aproved1);
								count = pst.executeUpdate();
								if(count>0) {
									JOptionPane.showMessageDialog(frame,"Data Send Sucessfully");
								}
							}
							else {
								JOptionPane.showMessageDialog(frame,"This Id Already Recorded");
							}
						}catch(Exception e3){
							e3.printStackTrace();
						}
						Result="No";
						
						//Background Image 
						ImageIcon imj = new ImageIcon("C:\\Users\\mahes\\eclipse-workspace\\BusPass\\src\\student\\Background.jpg");
						JLabel lo = new JLabel(imj);
						lo.setSize(1024, 600);
						frame.add(lo);
						JOptionPane.showMessageDialog(frame,"Payment Done");
						Login_Page lp = new Login_Page();
						lp.Home(0);
					}
				});
				frame.add(bu);
				
				frame.add(lu1);
				frame.setSize(600,400);
				frame.setLayout(null);
				frame.setVisible(true);
				
			}
		});
		frame.add(bu2);
	
	
	
	ImageIcon imj = new ImageIcon("C:\\Users\\mahes\\eclipse-workspace\\BusPass\\src\\normal\\photos\\background.jpg");
	JLabel la = new JLabel(imj);
	la.setSize(1024,600);
	frame.add(la);
	frame.setSize(1024,600);
	frame.setLayout(null);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public static void main(String[] args) {
	Normal_Pass np = new Normal_Pass();
	np.Normal_Page();
}
}
