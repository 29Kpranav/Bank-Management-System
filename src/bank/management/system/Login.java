package bank.management.system;

import javax.swing.*;    
import java.awt.*;       // to import image class
import java.awt.event.*; // for ActionListener // java swing -- jframe
import java.sql.*;

// ATM simulator system
public class Login extends JFrame implements ActionListener{  
    
    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){    
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null); 
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);  
        ImageIcon i3 = new ImageIcon(i2); 
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100); 
        add(label);  
        
        JLabel text = new JLabel("Welcoome to ATM"); 
        text.setFont(new Font("Oswad", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);        
        add(text);
        
        JLabel cardno = new JLabel("Card No. :");  
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 230, 30);        
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
                
        JLabel pin = new JLabel("PIN :");  
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 40); 
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this); 
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this); 
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);  
        add(signup);
        
        getContentPane().setBackground(Color.WHITE); 
        
        setSize(800, 480);  
        setVisible(true);   
        setLocation(350, 200); 
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == clear){
            cardTextField.setText(""); 
            pinTextField.setText("");
        } else if(ae.getSource() == login){
            conn x = new conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "Select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"' ";
            try{
               ResultSet rs =  x.s.executeQuery(query);
               if(rs.next()){
                   setVisible(false);
                   new Transactions(pinnumber).setVisible(true);
               }else {
                   JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
               }
            } catch(Exception e){
                System.out.println(e);
            }   
        } else if(ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
        
        
    }
    
    public static void main(String[] args) {
        new Login(); 
        
    }
}










//extends all propertise of JFrame and implement interface for action
//make object of image class to get scaled image..
//to create custom layout we need to null java's layout and use setBound
//create object of image icon and pass class loader with static method to pick image
//we can't pass i2 in jlabel directly so convert it
//to place any component on our frame pass the object of that component
//position of icon - dist. from left, upper, frame length & breadth
//frame color
//create label
//to catch event of button
//length of frame
//frame will be visible from now
//location of frame 350 from left and 200 from upper
//to implement all methods from interface  
//we need to override it so use this..
//after clicking button textfield will empty
//if else to understand which button apply and perform action furthur
//write code in constructor and call to open frame immeadiatly