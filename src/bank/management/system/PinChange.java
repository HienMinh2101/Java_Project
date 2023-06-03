package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;
    
    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/v1030-076.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900 , 900);
        add(image);
        
        JLabel pintext = new JLabel("Mật khẩu mới");
        pintext.setForeground(Color.BLACK);
        pintext.setFont(new Font("System", Font.BOLD, 24));
        pintext.setBounds(120, 20, 350, 30);
        image.add(pintext);
                
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(20, 60, 350, 30);
        image.add(pin);
        
        JLabel repintext = new JLabel("Nhập lại mật khẩu mới");
        repintext.setForeground(Color.BLACK);
        repintext.setFont(new Font("System", Font.BOLD, 24));
        repintext.setBounds(60, 100, 350, 30);
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(20, 140, 350, 30);
        image.add(repin);
        
        change = new JButton("Thay đổi");
        change.setBounds(20, 180, 350, 30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("Quay lại");
        back.setBounds(20, 220, 350, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(400, 300);
        setLocation(300, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == change){
            try {
                String npin = pin.getText();
                String rpin = repin.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                } 
                
                if (npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }
                
                if (rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }
                
                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin='"+pinnumber+"'";
                String query2 = "update login set pin = '"+rpin+"' where pin='"+pinnumber+"'";
                String query3 = "update signupthree set pin = '"+rpin+"' where pin='"+pinnumber+"'";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                
                setVisible(false);
                new Transactions(rpin).setVisible(true);
                
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
