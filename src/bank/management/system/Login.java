package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login, register;
    JTextField cardTextField;
    JPasswordField pinTextField;
    JLabel pin, cardno, label1, label2, label3, phone, mail;
    ImageIcon i1, i3, i4, i6, i7, i9;
    Image i2, i5, i8;
    
    Login() {
        
        setTitle("Automatioc Teller Machine");
        
        setLayout(null);
        
        i1 = new ImageIcon (ClassLoader.getSystemResource("icons/logo.jpg"));
        i2 = i1.getImage().getScaledInstance(400, 100, Image.SCALE_REPLICATE);
        i3 = new ImageIcon(i2);
        label1 = new JLabel(i3);
        label1.setBounds(100, 10, 400, 100);
        label1.setBackground(new Color(153, 204, 255));
        add(label1);
        
        cardno = new JLabel("Tài khoản:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 20));
        cardno.setBounds(50, 130, 375, 30);
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(180,133,350,30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        pin = new JLabel("Mật Khẩu:");
        pin.setFont(new Font("Osward", Font.BOLD, 20));
        pin.setBounds(50, 180, 375, 30);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(180,183,350,30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        login = new JButton("Đăng nhập");
        login.setBounds(50,240,500,30);
        login.setBackground(Color.BLUE);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        register = new JButton("Đăng kí");
        register.setBounds(50,280,500,30);
        register.setBackground(Color.BLUE);
        register.setForeground(Color.WHITE);
        register.addActionListener(this);
        add(register);
        
        phone = new JLabel("1900558868");
        phone.setFont(new Font("Raleway", Font.BOLD, 14));
        phone.setBounds(270, 315, 375, 30);
        phone.setForeground(Color.BLUE);
        add(phone);
        
        i4 = new ImageIcon (ClassLoader.getSystemResource("icons/telephone-call.png"));
        i5 = i4.getImage().getScaledInstance(30, 20, Image.SCALE_DEFAULT);
        i6 = new ImageIcon(i5);
        label2 = new JLabel(i6);
        label2.setBounds(105, 317, 300, 30);
        add(label2);
        
        mail = new JLabel("contact@gmail.com.vn");
        mail.setFont(new Font("Raleway", Font.BOLD, 14));
        mail.setBounds(225, 340, 375, 30);
        mail.setForeground(Color.BLUE);
        add(mail);
        
        i7 = new ImageIcon (ClassLoader.getSystemResource("icons/email.png"));
        i8 = i7.getImage().getScaledInstance(30, 20, Image.SCALE_DEFAULT);
        i9 = new ImageIcon(i8);
        label3 = new JLabel(i9);
        label3.setBounds(50, 342, 300, 30);
        add(label3);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(600, 420);
        setVisible(true);
        setLocation(350,200);
        
    }
    
    public void actionPerformed(ActionEvent ae){
             if(ae.getSource() == login){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber =  '"+cardnumber+"' and pin =  '"+pinnumber+"'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu, vui lòng nhập lại");
                }
            } catch (Exception e){
                System.out.println(e);
            }
        } else if(ae.getSource() == register){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    
    public static void main(String args[])
    {
        new Login();
    }
    
}
