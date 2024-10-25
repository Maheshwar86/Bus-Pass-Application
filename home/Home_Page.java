package home;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import login.Login_Page;

public class Home_Page {
	void home_page(){
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
	la2.setBounds(160,200,110,30);
	frame.add(la2);
	
	//wellcome
	Login_Page lg = new Login_Page();
	lg.Login_Main();
	
	JLabel la3 = new JLabel("Wellcome ");
	la3.setFont(new Font("Times New Roman",Font.BOLD,30));
	la3.setForeground(Color.BLACK);
	la3.setBounds(160,200,110,30);
	frame.add(la3);
	
	ImageIcon img = new ImageIcon("C:\\Users\\imsin\\eclipse-workspace\\BusPass\\src\\home\\photos\\background.jpg");
	JLabel la = new JLabel(img);
	la.setSize(1024,600);
	frame.add(la);
	frame.setSize(1024,600);
	frame.setLayout(null);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
	public static void main(String[] args) {
		Home_Page hp = new Home_Page();
		hp.home_page();
	}
}
