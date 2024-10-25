package login;

import java.awt.Color;
import pass.Buspass;

import student.Student_Page;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.plaf.ColorUIResource;
import signup.Sign;
import Employee.Employee_Page;
import Alien.Alien_Pass;
import normal.Normal_Pass;
public class Login_Page {
String Password;
String UserId;
public String Aadhar;
public String Age;
public String Name;
public String name="User";
int r;

public void Login_Main() {
	String StName = name;
	final  JFrame frame = new JFrame("Login");
	
	//head Title
	JLabel lr = new JLabel("MKRTC");
	lr.setBounds(550,40,400,61);
	lr.setFont(new Font("Times New Roman",Font.BOLD,60));
	lr.setForeground(Color.black);
	frame.add(lr);
	
	
	//note
	JLabel lp = new JLabel("Enter Aadhar");
	lp.setBounds(880,206,120,14);
	lp.setFont(new Font("Times New Roman",Font.ITALIC,12));
	lp.setForeground(Color.red);
	frame.add(lp);
	
	//User Box
	 JLabel Id = new JLabel("User Id ");
     Id.setBounds(630,200,70,20);
     Id.setForeground(Color.black);
     Id.setFont(new Font("Times New Roman",Font.BOLD,20));
     frame.add(Id);
   final JTextField tf = new JTextField();
   
    tf.setBounds(750,200,120,24);
    frame.add(tf);
    
    //Password Box
    JLabel Pass = new JLabel("Password");
    Pass.setBounds(630,250,100,20);
    Pass.setFont(new Font("Times New Roman",Font.BOLD,20));
    Pass.setForeground(Color.black);
    frame.add(Pass);
  final JPasswordField tf1 = new JPasswordField();
   tf1.setBounds(750,250,120,24);
   
   frame.add(tf1);
   
   //Login Button
   
   JButton bu = new JButton("Login");
   bu.setForeground(Color.BLACK);
   bu.setFont(new Font("Times New Roman",Font.BOLD,23));
   bu.setBounds(760,310,100,25);
   bu.setBackground(Color.decode("#facf32"));
   bu.setBorder(BorderFactory.createEmptyBorder());
   bu.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
		UserId=tf.getText();
		Password = tf1.getText();
		
		//Validation
		try {
			boolean found = false;
			Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/buspass", "root", "//JOKER//");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM signup");
            while (rs.next()) {
                if (UserId.equals(rs.getString("Aadhar")) && Password.equals(rs.getString("Pass")) ) { 
                	name=rs.getString("name");
                	Name = rs.getString("name");
                	Aadhar = rs.getString("Aadhar");
                	Age = rs.getString("Age");
                	
                    System.out.println("Login Successful");
                    Home(0);
                    found = true;
                    break;
                    
                }
            }
               if(found==false) {
                	JFrame frame = new JFrame("Error");
                	JOptionPane.showMessageDialog(frame,"Details Not Found ! ","Error",JOptionPane.ERROR_MESSAGE);
                }
            con.close();
			
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	       
});
   frame.add(bu);
   
   
   //signup Label
   JLabel la = new JLabel("Don't Have Account?");
	la.setBounds(750,350,140,20);
	la.setFont(new Font("Corbel Light",Font.PLAIN,14));
	frame.add(la);
	JButton bu1 = new JButton("Create Account ->");
	   bu1.setForeground(Color.BLACK);
	   bu1.setFont(new Font("Times New Roman",Font.PLAIN,15));
	   bu1.setBounds(745,370,135,25);
	   bu1.setBackground(Color.decode("#facf32"));
	   bu1.setBorder(BorderFactory.createEmptyBorder());
	   //signup button listener
	   bu1.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			Sign su = new Sign();
			su.sig();
		}
	});
	   frame.add(bu1);
	   
	   //Background Image
	   ImageIcon img = new ImageIcon("C:\\Users\\mahes\\eclipse-workspace\\BusPass\\src\\login\\Photos\\logo.png");
	   JLabel lu = new JLabel(img);
	   lu.setBounds(20,30,150,150);
	   frame.add(lu);
	   
	   //Background Image
	   
	   ImageIcon img2 = new ImageIcon("C:\\Users\\mahes\\eclipse-workspace\\BusPass\\src\\login\\Photos\\bus.png");
	   JLabel ls = new JLabel(img2);
	   ls.setBounds(50,100,500,381);
	   frame.add(ls);
	   
   ImageIcon lbg = new ImageIcon("C:\\Users\\mahes\\eclipse-workspace\\BusPass\\src\\login\\Photos\\Login_Background.jpg");
	JLabel Login_Background = new JLabel(lbg);
	Login_Background.setSize(1024,600);
	frame.add(Login_Background);
	frame.setSize(1024,600);
	frame.setLayout(null);
	frame.setVisible(true);
	frame.setResizable(false);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}
public void Home(int i) {
	if(i==0) {
		
		JFrame frame = new JFrame("Home");
		//Logo
		ImageIcon img1 = new ImageIcon("C:\\Users\\mahes\\eclipse-workspace\\BusPass\\src\\home\\photos\\Bus_Logo.png");
		JLabel la1 = new JLabel(img1);
		la1.setBounds(750,80,225,225);
		frame.add(la1);
		
		//Slogan
		JLabel so = new JLabel("We give you good services");
		so.setBounds(700,250,400,35);
		so.setFont(new Font("Palatino Linotype",Font.BOLD,24));
		so.setForeground(Color.WHITE);
		frame.add(so);
		
		//Services
		JLabel la2 = new JLabel("Services");
		la2.setFont(new Font("Times New Roman",Font.BOLD,30));
		la2.setForeground(Color.BLACK);
		la2.setBounds(160,150,110,30);
		frame.add(la2);
		
		//wellcome
		JLabel la3 = new JLabel("Wellcome "+name);
		la3.setFont(new Font("Times New Roman",Font.BOLD,30));
		la3.setForeground(Color.BLACK);
		la3.setBounds(10,40,400,30);
		frame.add(la3);
		
		//Button Student Bus Pass
		JButton bu = new JButton("Student Bus Pass");
		bu.setBounds(125,250,200,32);
		bu.setFont(new Font("Times New Roman",Font.BOLD,20));
		bu.setForeground(Color.white);
		bu.setBackground(Color.black);
		
		bu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Student_Page sp = new Student_Page();
				sp.stu();
				
			}
		});
		
		frame.add(bu);
		
		//Button Employee Bus Pass
		JButton bu1 = new JButton("Employee Bus Pass");
		bu1.setBounds(125,300,200,32);
		bu1.setFont(new Font("Times New Roman",Font.BOLD,20));
		bu1.setForeground(Color.white);
		bu1.setBackground(Color.black);
		bu1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Employee_Page ep = new Employee_Page();
				ep.Employee_details();
			}
		});
		frame.add(bu1);
		
		//Button Normal Bus Pass
		JButton bu2 = new JButton("Normal Bus Pass");
		bu2.setBounds(125,350,200,32);
		bu2.setFont(new Font("Times New Roman",Font.BOLD,20));
		bu2.setForeground(Color.white);
		bu2.setBackground(Color.black);
		bu2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Normal_Pass np = new Normal_Pass();
				np.Normal_Page();
			}
		});
		frame.add(bu2);
		
		
		//Home Button
				JButton bu5 = new JButton("Home");
				bu5.setBounds(900,30,83,23);
				bu5.setBackground(Color.white);
				bu5.setForeground(Color.BLACK);
				bu5.setFont(new Font("Times New Roman",Font.BOLD,20));
			    bu5.setBorder(BorderFactory.createEmptyBorder());
			    bu5.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						Login_Page lp = new Login_Page();
						lp.Login_Main();
					
					}
				});
			    frame.add(bu5);
		
		
		//view buspasses
		
		JButton bo = new JButton("View Passes");
		bo.setBounds(450,40,170,23);
		bo.setBackground(Color.GRAY);
		bo.setFont(new Font("Times New Roman",Font.BOLD,23));
		bo.setForeground(Color.white);
		bo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Buspass bp = new Buspass();
				bp.display();
			}
		});
		frame.add(bo);
		
		
		//Label Alien Bus Pass
		JLabel la4 = new JLabel("Alien Bus Pass ->");
		la4.setBounds(140,400,270,32);
		la4.setFont(new Font("Times New Roman",Font.BOLD,20));
		la4.setForeground(Color.black);
		la4.setBackground(new Color(255, 200, 3));
		frame.add(la4);
		
		//alien Photo
		ImageIcon im = new ImageIcon("C:\\Users\\mahes\\eclipse-workspace\\BusPass\\src\\home\\photos\\Alien.png");
		JButton bu3 = new JButton(im);
		bu3.setBounds(400,370,100,100);
		bu3.setBackground(Color.decode("#e6d2de"));
		bu3.setBorderPainted(false);
		bu3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Alien_Pass ap = new Alien_Pass();
				ap.Alien_Page();
				
			}
		});
		frame.add(bu3);
		
		ImageIcon img = new ImageIcon("C:\\Users\\mahes\\eclipse-workspace\\BusPass\\src\\home\\photos\\background.jpg");
		JLabel la = new JLabel(img);
		la.setSize(1024,600);
		frame.add(la);
		frame.setSize(1024,600);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	else {
		System.out.println("Sorry Babu");
	}
	

}
public static void main(String[] args) {
	Login_Page lg = new Login_Page();
	lg.Login_Main();
	
}
}
