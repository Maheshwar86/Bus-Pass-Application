package normal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import login.Login_Page;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Normal_Pass_Payment {
	int Money;
	String de;
public void pay() {
	
	
	JFrame frame = new JFrame();
	
	//head
	JLabel la1 = new JLabel("Day Bus Pass");
	la1.setBounds(400,30,700,50);
	la1.setForeground(Color.white);
	la1.setFont(new Font("Times New Roman",Font.BOLD,48));
	frame.add(la1);
	
	//head
		JLabel lu = new JLabel("Pay : 3000");
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
						if(Money!=70) {
							JOptionPane.showMessageDialog(frame,"Enter Correct Amount");
						
						}
						else {
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
				frame.add(lu1);
				
				//button
				JButton bu = new JButton("Done");
				bu.setBounds(250,250,80,22);
				bu.setForeground(Color.black);
				bu.setBackground(Color.white);
				bu.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(frame,"Payment Done");
						Login_Page lp = new Login_Page();
						lp.Home(0);
					}
				});
				frame.add(bu);
				frame.add(lu1);
				ImageIcon imj = new ImageIcon("C:\\Users\\mahes\\eclipse-workspace\\BusPass\\src\\normal\\photos\\background.jpg");
				JLabel la3 = new JLabel(imj);
				la3.setSize(600,400);
				frame.add(la3);
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
	Normal_Pass_Payment npp = new Normal_Pass_Payment();
	npp.pay();
}
}
