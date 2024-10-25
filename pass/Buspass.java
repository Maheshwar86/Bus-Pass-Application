package pass;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import login.Login_Page;

public class Buspass {
	String Name;
	String Gender;
	String Aadhar;
	String From;
	String To;
	String StartDate;
	String EndDate;
	String Result="Yes";
	String Id;
	String Allow = "No";
	public void display() {
		final JFrame frame = new JFrame("Display");
		
		
		//note
		JLabel lp = new JLabel("Enter Aadhar");
		lp.setBounds(890,326,120,14);
		lp.setFont(new Font("Times New Roman",Font.ITALIC,12));
		lp.setForeground(Color.red);
		frame.add(lp);
		
		//JButton Student
		JButton bu = new JButton("Student");
		bu.setBounds(750,350,130,23);
		bu.setForeground(Color.white);
		bu.setBackground(Color.black);
		bu.setFont(new Font("Times New Roman",Font.BOLD,22));
		
		final JTextField tx = new JTextField();
		tx.setBounds(890,350,100,23);
		tx.setFont(new Font("Times New Roman",Font.BOLD,15));
		Id=tx.getText();
		frame.add(tx);
		bu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Id = tx.getText();
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/buspass", "root", "//JOKER//");
		            Statement stmt = con.createStatement();
		            ResultSet rs = stmt.executeQuery("SELECT * FROM stupass");
		            while(rs.next()) {
		            	
		            	if(Id.equals(rs.getString(4))) {
		            		Name = rs.getString(1);
		            		Gender = rs.getString(3);
		            		Aadhar = rs.getString(4);
		            		From = rs.getString(9);
		            		To = rs.getString(10);
		            		StartDate = rs.getString(11);
		            		EndDate = rs.getString(12);
		            		if(Result.equals(rs.getString(13))) {
		            			Allow = "Yes";
		            			break;
		            		}
		            	}
		            }
		            
		            if(Allow=="Yes") {
		            	StuDisplay();
		            }
		            else {
		            	JOptionPane.showMessageDialog(frame, "Bus Pass Application Not Found");
		            }
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		frame.add(bu);
		//JButton Employee
				JButton bu1 = new JButton("Employee");
				bu1.setBounds(750,400,130,23);
				bu1.setForeground(Color.white);
				bu1.setBackground(Color.black);
				bu1.setFont(new Font("Times New Roman",Font.BOLD,22));
				final JTextField tx1 = new JTextField();
				tx1.setBounds(890,400,100,23);
				tx1.setFont(new Font("Times New Roman",Font.BOLD,15));
				bu1.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
						Id = tx1.getText();
						try {
							Class.forName("com.mysql.jdbc.Driver");
				            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/buspass", "root", "//JOKER//");
				            Statement stmt = con.createStatement();
				            ResultSet rs = stmt.executeQuery("SELECT * FROM emppass");
				            while(rs.next()) {
				            	
				            	if(Id.equals(rs.getString(4))) {
				            		Name = rs.getString(1);
				            		Gender = rs.getString(3);
				            		Aadhar = rs.getString(4);
				            		From = rs.getString(9);
				            		To = rs.getString(10);
				            		StartDate = rs.getString(11);
				            		EndDate = rs.getString(12);
				            		if(Result.equals(rs.getString(13))) {
				            			Allow = "Yes";
				            			break;
				            		}
				            	}
				            }
				            
				            if(Allow=="Yes") {
				            	StuDisplay();
				            }
				            else {
				            	JOptionPane.showMessageDialog(frame, "Bus Pass Application Not Found");
				            }
						}catch(Exception e1) {
							e1.printStackTrace();
						}
						
						
					}
				});
				
				
				frame.add(bu1);
				frame.add(tx1);
				
				
				//Home Button
				JButton bu4 = new JButton("Home");
				bu4.setBounds(50,30,83,23);
				bu4.setBackground(Color.decode("#e51a59"));
				bu4.setForeground(Color.BLACK);
				bu4.setFont(new Font("Times New Roman",Font.BOLD,20));
			    bu4.setBorder(BorderFactory.createEmptyBorder());
			    bu4.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						Login_Page lp = new Login_Page();
						lp.Login_Main();
					
					}
				});
			    frame.add(bu4);
				
				
				//Back Button
				JButton bo = new JButton("Back");
				bo.setBounds(900,30,83,23);
				bo.setBackground(Color.decode("#e51a59"));
				bo.setForeground(Color.BLACK);
				bo.setFont(new Font("Times New Roman",Font.BOLD,20));
			    bo.setBorder(BorderFactory.createEmptyBorder());
			    bo.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						Login_Page lp = new Login_Page();
						lp.Home(0);
					}
				});
			    frame.add(bo);
				
				
				
				//JButton Normal
				JButton bu2 = new JButton("Normal");
				bu2.setBounds(750,450,130,23);
				bu2.setForeground(Color.white);
				bu2.setBackground(Color.black);
				bu2.setFont(new Font("Times New Roman",Font.BOLD,22));
				final JTextField tx2 = new JTextField();
				tx2.setBounds(890,450,100,23);
				tx2.setFont(new Font("Times New Roman",Font.BOLD,15));
				
				bu2.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {

						Id = tx2.getText();
						try {
							Class.forName("com.mysql.jdbc.Driver");
				            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/buspass", "root", "//JOKER//");
				            Statement stmt = con.createStatement();
				            ResultSet rs = stmt.executeQuery("SELECT * FROM normalpass");
				            while(rs.next()) {
				            	
				            	if(Id.equals(rs.getString(4))) {
				            		Name = rs.getString(1);
				            		Gender = rs.getString(3);
				            		Aadhar = rs.getString(4);
				            		From = rs.getString(9);
				            		To = rs.getString(10);
				            		StartDate = rs.getString(11);
				            		EndDate = rs.getString(12);
				            		if(Result.equals(rs.getString(13))) {
				            			Allow = "Yes";
				            			break;
				            		}
				            	}
				            }
				            
				            if(Allow=="Yes") {
				            	StuDisplay();
				            }
				            else {
				            	JOptionPane.showMessageDialog(frame, "Bus Pass Application Not Found");
				            }
						}catch(Exception e1) {
							e1.printStackTrace();
						}
						
							
					}
				});
				
				frame.add(bu2);
				frame.add(tx2);
				
				//JButton Alien
				JButton bu3 = new JButton("Alien");
				bu3.setBounds(750,500,130,23);
				bu3.setForeground(Color.white);
				bu3.setBackground(Color.black);
				bu3.setFont(new Font("Times New Roman",Font.BOLD,22));
				final JTextField tx3 = new JTextField();
				tx3.setBounds(890,500,100,23);
				tx3.setFont(new Font("Times New Roman",Font.BOLD,15));
				
				
				bu3.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						Id = tx3.getText();
						try {
							Class.forName("com.mysql.jdbc.Driver");
				            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/buspass", "root", "//JOKER//");
				            Statement stmt = con.createStatement();
				            ResultSet rs = stmt.executeQuery("SELECT * FROM alienpass");
				            while(rs.next()) {
				            	
				            	if(Id.equals(rs.getString(4))) {
				            		Name = rs.getString(1);
				            		Gender = rs.getString(3);
				            		Aadhar = rs.getString(4);
				            		From = rs.getString(9);
				            		To = rs.getString(10);
				            		StartDate = rs.getString(11);
				            		EndDate = rs.getString(12);
				            		if(Result.equals(rs.getString(13))) {
				            			Allow = "Yes";
				            			break;
				            		}
				            	}
				            }
				            
				            if(Allow=="Yes") {
				            	StuDisplay();
				            }
				            else {
				            	JOptionPane.showMessageDialog(frame, "Bus Pass Application Not Found");
				            }
						}catch(Exception e1) {
							e1.printStackTrace();
						}
						
						
					}
				});

				
				frame.add(bu3);
				frame.add(tx3);
				
				
				//Logo
				JLabel la1 = new JLabel("Verification");
				la1.setBounds(800,120,300,35);
				la1.setFont(new Font("Times New Roman",Font.BOLD,35));
				la1.setForeground(Color.black);
				frame.add(la1);
				
		//Background Image 
		ImageIcon imj = new ImageIcon("C:\\Users\\mahes\\eclipse-workspace\\BusPass\\src\\pass\\Photos\\Bus_Background.jpg");
		JLabel lo = new JLabel(imj);
		lo.setSize(1024, 600);
		frame.add(lo);
		frame.setSize(1024,600);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void StuDisplay() {
		ImageIcon imj = new ImageIcon("C:\\Users\\mahes\\eclipse-workspace\\BusPass\\src\\pass\\Photos\\Student_Back.jpg");
		JFrame frame = new JFrame();
		
		
		//Mahesh Logo
		
		ImageIcon img = new ImageIcon("C:\\Users\\mahes\\eclipse-workspace\\BusPass\\src\\pass\\Photos\\Mahi_Logo.png");
		JLabel lu = new JLabel(img);
		lu.setBounds(40,20,120,120);
		frame.add(lu);
		
		//Nhce Logo
		ImageIcon img1 = new ImageIcon("C:\\Users\\mahes\\eclipse-workspace\\BusPass\\src\\pass\\Photos\\nhce_logo.png");
		JLabel lu1 = new JLabel(img1);
		lu1.setBounds(340,20,120,120);
		frame.add(lu1);
		
		//Kruthika Logo
		ImageIcon img2 = new ImageIcon("C:\\Users\\mahes\\eclipse-workspace\\BusPass\\src\\pass\\Photos\\kruthika.jpg");
		JLabel lu2 = new JLabel(img2);
		lu2.setBounds(620,20,120,120);
		frame.add(lu2);
		
		
		//Aproved Logo
		ImageIcon apr = new ImageIcon("C:\\Users\\mahes\\eclipse-workspace\\BusPass\\src\\pass\\Photos\\verify_logo.png");
		JLabel li = new JLabel(apr);
		li.setBounds(340,300,120,120);
		frame.add(li);
		
		//Name 
		JLabel lu3 = new JLabel("KM");
		lu3.setBounds(210,20,120,120);
		lu3.setFont(new Font("Times New Roman",Font.BOLD,50));
		lu3.setForeground(Color.black);
		frame.add(lu3);
		
		//Name2
		JLabel lu4 = new JLabel("RTC");
		lu4.setBounds(490,20,120,120);
		lu4.setFont(new Font("Times New Roman",Font.BOLD,50));
		lu4.setForeground(Color.RED);
		frame.add(lu4);
		
		
		//All Details 
		//Name
		JLabel lu5 = new JLabel("Name");
		lu5.setBounds(40,150,120,120);
		lu5.setFont(new Font("Times New Roman",Font.BOLD,18));
		lu5.setForeground(Color.black);
		frame.add(lu5);
		
		//GetName
		JLabel lu10 = new JLabel(Name);
		lu10.setBounds(190,200,170,20);
		lu10.setFont(new Font("Times New Roman",Font.BOLD,18));
		lu10.setForeground(Color.black);
		frame.add(lu10);
		
		//Gender
		JLabel lu6 = new JLabel("Gender");
		lu6.setBounds(40,200,120,120);
		lu6.setFont(new Font("Times New Roman",Font.BOLD,18));
		lu6.setForeground(Color.black);
		frame.add(lu6);
		
		//GetGender
		JLabel lu11 = new JLabel(Gender);
		lu11.setBounds(190,250,170,20);
		lu11.setFont(new Font("Times New Roman",Font.BOLD,18));
		lu11.setForeground(Color.black);
		frame.add(lu11);
		
		//Aadhar
		JLabel lu7 = new JLabel("Aadhar");
		lu7.setBounds(40,250,120,120);
		lu7.setFont(new Font("Times New Roman",Font.BOLD,18));
		lu7.setForeground(Color.black);
		frame.add(lu7);
		
		//GetAadhar
		JLabel lu12 = new JLabel(Aadhar);
		lu12.setBounds(190,300,170,20);
		lu12.setFont(new Font("Times New Roman",Font.BOLD,18));
		lu12.setForeground(Color.black);
		frame.add(lu12);
		
		//From
		JLabel lu8 = new JLabel("From");
		lu8.setBounds(40,300,120,120);
		lu8.setFont(new Font("Times New Roman",Font.BOLD,18));
		lu8.setForeground(Color.black);
		frame.add(lu8);
		
		//GetFrom
		JLabel lu13 = new JLabel(From);
		lu13.setBounds(190,350,170,20);
		lu13.setFont(new Font("Times New Roman",Font.BOLD,18));
		lu13.setForeground(Color.black);
		frame.add(lu13);
		
		//GetTo
		JLabel lu14 = new JLabel(To);
		lu14.setBounds(190,400,170,20);
		lu14.setFont(new Font("Times New Roman",Font.BOLD,18));
		lu14.setForeground(Color.black);
		frame.add(lu14);
		
		//To
		JLabel lu9 = new JLabel("To");
		lu9.setBounds(40,350,120,120);
		lu9.setFont(new Font("Times New Roman",Font.BOLD,18));
		lu9.setForeground(Color.black);
		frame.add(lu9);
		
		//Start Date
				JLabel da = new JLabel("Start");
				da.setBounds(440,150,120,120);
				da.setFont(new Font("Times New Roman",Font.BOLD,18));
				da.setForeground(Color.black);
				frame.add(da);
				
				//GetDate
				JLabel LK = new JLabel(StartDate);
				LK.setBounds(500,200,170,20);
				LK.setFont(new Font("Times New Roman",Font.BOLD,18));
				LK.setForeground(Color.black);
				frame.add(LK);
				
				
				//Start Date
				JLabel da1 = new JLabel("End");
				da1.setBounds(440,200,120,120);
				da1.setFont(new Font("Times New Roman",Font.BOLD,18));
				da1.setForeground(Color.black);
				frame.add(da1);
				
				//GetDate
				JLabel LK1 = new JLabel(EndDate);
				LK1.setBounds(500,250,170,20);
				LK1.setFont(new Font("Times New Roman",Font.BOLD,18));
				LK1.setForeground(Color.black);
				frame.add(LK1);
		
		//Person Photo
		ImageIcon img3 = new ImageIcon("C:\\Users\\mahes\\eclipse-workspace\\BusPass\\src\\pass\\Photos\\Student_Logo.png");
		JLabel lo = new JLabel(img3);
		lo.setBounds(620,170,120,120);
		frame.add(lo);
		
		//Qr Photo
				ImageIcon img4 = new ImageIcon("C:\\Users\\mahes\\eclipse-workspace\\BusPass\\src\\pass\\Photos\\Qr code.png");
				JLabel lo1 = new JLabel(img4);
				lo1.setBounds(620,320,120,120);
				frame.add(lo1);
		
		JLabel la = new JLabel(imj);
		la.setSize(800,500);
		frame.add(la);
		frame.setSize(800,500);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		Buspass bp = new Buspass();
		bp.display();
	}
}
