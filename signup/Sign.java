package signup;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import login.Login_Page;
import login.Login_Page;
public class Sign {
		public String Name;
		public String Aadhar;
		public String Age;
		String Pass;
		String repass;
		int count;
		boolean Aadhar_Checking = false;
		boolean Age_Checking = false;
		String ex = "no";
		Connection con = null;
		PreparedStatement pst;
		ResultSet rs;
		public Sign(){
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
	public void sig() {
		final JFrame frame = new JFrame(" Details ");
		
		//SignUp Logo
		ImageIcon im = new ImageIcon("C:\\Users\\mahes\\eclipse-workspace\\BusPass\\src\\signup\\Photos\\SignUp_Logo.png");
		JLabel lo = new JLabel(im);
		lo.setBounds(650,2,225,225);
		frame.add(lo);
		
		//Bus Logo
		ImageIcon imj = new ImageIcon("C:\\Users\\mahes\\eclipse-workspace\\BusPass\\src\\signup\\Photos\\Bus_Logo.png");
		JLabel lo1 = new JLabel(imj);
		lo1.setBounds(130,100,225,225);
		frame.add(lo1);
		
		//Slogan
		JLabel so = new JLabel("We give you good services");
		so.setBounds(80,280,400,35);
		so.setFont(new Font("Palatino Linotype",Font.BOLD,29));
		so.setForeground(Color.black);
		frame.add(so);
		
		//Logo
		ImageIcon imj1 = new ImageIcon("C:\\Users\\mahes\\eclipse-workspace\\BusPass\\src\\signup\\Photos\\Register_Logo.png");
		JLabel lo2 = new JLabel(imj1);
		lo2.setBounds(80,300,300,150);
		frame.add(lo2);
		
		//Name
		JLabel la = new JLabel("Name");
		la.setBounds(600,200,80,23);
		la.setFont(new Font("Times New Roman",Font.BOLD,23));
		la.setForeground(Color.WHITE);
		frame.add(la);
		final JTextField tc = new JTextField();
		tc.setBounds(720,205,120,20);
		frame.add(tc);
		
		//Aadher
		JLabel la1 = new JLabel("Aadhaar No ");
		la1.setBounds(548,250,135,23);
		la1.setFont(new Font("Times New Roman",Font.BOLD,23));
		la1.setForeground(Color.WHITE);
		frame.add(la1);
		final JTextField tc1 = new JTextField();
		tc1.setBounds(720,255,120,20);
		frame.add(tc1);
		
		//Age
		JLabel la2 = new JLabel("Age ");
		la2.setBounds(600,300,120,23);
		la2.setFont(new Font("Times New Roman",Font.BOLD,23));
		la2.setForeground(Color.WHITE);
		frame.add(la2);
		final JTextField tc2 = new JTextField();
		tc2.setBounds(720,305,120,20);
		frame.add(tc2);
		
		//password
		JLabel la3 = new JLabel("Password ");
		la3.setBounds(555,350,120,23);
		la3.setFont(new Font("Times New Roman",Font.BOLD,23));
		la3.setForeground(Color.WHITE);
		frame.add(la3);
		final JPasswordField tc3 = new JPasswordField();
		tc3.setBounds(720,355,120,20);
		frame.add(tc3);
		
		//ReEnter Password 
		JLabel la4 = new JLabel("ReEnter Password ");
		la4.setBounds(520,400,200,23);
		la4.setFont(new Font("Times New Roman",Font.BOLD,23));
		la4.setForeground(Color.WHITE);
		frame.add(la4);
		final JPasswordField tc4 = new JPasswordField();
		tc4.setBounds(720,405,120,20);
		frame.add(tc4);
		
		//Back button
		JButton bu1 = new JButton("Back");
		bu1.setBounds(900,20,83,23);
		bu1.setBackground(Color.decode("#e51a59"));
		bu1.setForeground(Color.BLACK);
		bu1.setFont(new Font("Times New Roman",Font.BOLD,20));
        bu1.setBorder(BorderFactory.createEmptyBorder());
        bu1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Login_Page lg = new Login_Page();
				lg.Login_Main();
			}
		});
		frame.add(bu1);
		
		
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
		
		
		//Submit Button
		JButton bu = new JButton("Submit");
		bu.setFont(new Font("Times New Roman",Font.BOLD,18));
		bu.setBackground(Color.black);
		bu.setForeground(Color.white);
		bu.setBounds(735,470,90,25);
		bu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Name=tc.getText();
				Aadhar = tc1.getText();
				Age = tc2.getText();
				Pass = tc3.getText();
				repass = tc4.getText();
				
				//chacking
				try {
					
					pst = con.prepareStatement("select * from signup");
					rs = pst.executeQuery();
					
					while(rs.next()) {
							if(Aadhar.equals(rs.getString(2))) {
									ex = "yes";
									break;
						}
		
					}
					Aadhar_Checking=Aadhar.length()==12;
					Age_Checking = Age.length()<=3;
					if(Aadhar_Checking ) {
						if(Pass.equals(repass)) {
							if(Age_Checking) {
								if(ex=="no") {
									try {
										pst=con.prepareStatement("insert into signup values(?,?,?,?)");
										pst.setString(1, Name);
										pst.setString(2, Aadhar);
										pst.setString(3, Age);
										pst.setString(4, Pass);
										count = pst.executeUpdate();
										if(count>0) {
											JOptionPane.showMessageDialog(frame,"Data Send Sucessfully 😃");
											Login_Page lp1 = new Login_Page();
											lp1.Login_Main();
										}
										
									}catch(Exception e1){
										e1.printStackTrace();
									}
								}
								else {
				                	JOptionPane.showMessageDialog(frame," Data Already Recorded");
								}
							}
							else {
								JOptionPane.showMessageDialog(frame,"Invalid Age");
							}
						}else {
							JOptionPane.showMessageDialog(frame,"Password Not Matching");
						}
						
					}else {
						JOptionPane.showMessageDialog(frame,"Incorrect Aadhar Format 🙄","Error",JOptionPane.ERROR_MESSAGE);
					}
					
				}catch(Exception e1) {
					System.out.println(e1);
				}	
				ex="no";
				
			}
		});;
		frame.add(bu);
		
		
		
		ImageIcon ic = new ImageIcon("C:\\Users\\mahes\\eclipse-workspace\\BusPass\\src\\login\\Photos\\back.jpg");
		JLabel back = new JLabel(ic);
		back.setSize(1024,600);
		frame.add(back);
		frame.setSize(1024,600);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
	}
	public static void main(String[] args) {
		
		Sign su = new Sign();
		String SetName = su.Name;
		String SetAadhar = su.Aadhar;
		String setAge = su.Age;
		System.out.println(SetName);
		su.sig();
	}
}
