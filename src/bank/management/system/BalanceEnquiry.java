package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton back;
    String pinnumber;
    
    BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/v1030-076.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 320, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image1 = new JLabel(i6);
        image1.setBounds(0, 0, 400 , 320);
        add(image1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm-card.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150, 20, 100 , 100);
        image1.add(image);
        
        JLabel card = new JLabel("");
        card.setBounds(40, 150, 400, 20);
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        image1.add(card);
        
        back = new JButton("Back");
        back.setBounds(20, 250, 350, 30);
        back.addActionListener(this);
        image1.add(back);
        
        Conn c = new Conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select  * from bank where pin = '"+pinnumber+"'");
                while (rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"' ");
            while (rs.next()){
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0,12));
            }
        } catch (Exception e){
            System.out.println(e);
        }
        
        JLabel text = new JLabel("Số tiền hiện tại: " + balance + " VND");
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Raleway", Font.BOLD, 22));
        text.setBounds(20, 200, 400, 30);
        image1.add(text);
        
        setSize(400, 330);
        setLocation(300, 0);
        setVisible(true);
        setUndecorated(true);
        getContentPane().setBackground(Color.WHITE);
    }
    
    public void actionPerformed (ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
