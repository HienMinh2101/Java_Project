package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Tranfer extends JFrame implements ActionListener{
    
    JTextField amount, person, note;
    JButton withdrawl, back;
    String pinnumber;
    Tranfer(String pinnumber){
       this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/v1030-076.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Nhập số tiền cần chuyển: ");
        text.setForeground(Color.BLACK);
        text.setFont(new Font("System", Font.BOLD, 24));
        text.setBounds(50, 20, 400, 30);
        image.add(text);
        
        amount = new JTextField();
        amount.setBounds(20, 60, 350, 30);
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        image.add(amount);
        
        JLabel text2 = new JLabel("Nhập số thẻ cần chuyển đến: ");
        text2.setForeground(Color.BLACK);
        text2.setFont(new Font("System", Font.BOLD, 24));
        text2.setBounds(30, 100, 400, 30);
        image.add(text2);
        
        person = new JTextField();
        person.setBounds(20, 140, 350, 30);
        person.setFont(new Font("Raleway", Font.BOLD, 22));
        image.add(person);
        
        JLabel text3 = new JLabel("Nhập tin nhắn cần gửi: ");
        text3.setForeground(Color.BLACK);
        text3.setFont(new Font("System", Font.BOLD, 24));
        text3.setBounds(60, 180, 400, 30);
        image.add(text3);
        
        note = new JTextField();
        note.setBounds(20, 220, 350, 30);
        note.setFont(new Font("Raleway", Font.BOLD, 22));
        image.add(note);
        
        withdrawl = new JButton("Chuyển tiền");
        withdrawl.setBounds(20, 260, 350, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        back = new JButton("Quay lại");
        back.setBounds(20, 300, 350, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(400, 400);
        setLocation(300, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
            if (ae.getSource() == withdrawl){
            String number = amount.getText();
            String persons = person.getText();
            String notes = note.getText();
            Date date = new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null, "Nhập số tiền cần chuyển");
            } 
            else if (persons.equals("")){
                JOptionPane.showMessageDialog(null, "Nhập mã thẻ cần chuyển");
            } 
            else if (notes.equals("")){
                JOptionPane.showMessageDialog(null, "Nhập tin nhắn cần gửi");
            } 
            else {
                try{
                Conn conn = new Conn();
                String query = "insert into transfer values ('"+pinnumber+"', '"+date+"', 'Transfer' , '"+number+"', '"+persons+"', '"+notes+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, " "+number+" VND Transfer Successfully ");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
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
        new Tranfer("");
    }
}
