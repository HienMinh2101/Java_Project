package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField amount ;
    JButton deposit, back;  
    String pinnumber;
    
    Deposit(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/v1030-076.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Nhập số tiền cần nạp: ");
        text.setForeground(Color.BLACK);
        text.setFont(new Font("System", Font.BOLD, 24));
        text.setBounds(60, 20, 400, 30);
        image.add(text);
        
        amount = new JTextField();
        amount.setBounds(20, 60, 350, 30);
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        image.add(amount);
        
        deposit = new JButton("Nạp tiền");
        deposit.setBounds(20, 100, 350, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back = new JButton("Quay lại");
        back.setBounds(20, 140, 350, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(400, 220);
        setLocation(300, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == deposit){
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            } else {
                try{
                Conn conn = new Conn();
                String query = "insert into bank values ('"+pinnumber+"', '"+date+"', 'Deposit' , '"+number+"')";
                conn.s.executeUpdate(query);
                setVisible(false);
                new VerifyCodeDeposit().setVisible(true);
                }catch (Exception e){
                    System.out.println(e);
                }
                
            }
        } else if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Deposit("");
    }
}
