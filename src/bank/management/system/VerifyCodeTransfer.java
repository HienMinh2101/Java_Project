package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class VerifyCodeTransfer extends JFrame implements ActionListener{
    
    JLabel enterpin;
    JPasswordField enterpinTextField;
    JButton summit, cancel;
    String formno;
    
    public VerifyCodeTransfer() {
        this.formno = formno;
        setLayout(null);
        
        enterpin = new JLabel("Nhập mã pin");
        enterpin.setFont(new Font("Raleway", Font.BOLD, 24));
        enterpin.setBounds(100, 20, 150, 30);
        add(enterpin);
        
        enterpinTextField = new JPasswordField();
        enterpinTextField.setBounds(20,60,300,30);
        enterpinTextField.setFont(new Font("Arial", Font.BOLD, 20));
        add(enterpinTextField);
        
        summit = new JButton("Xác nhận");
        summit.setBounds(30,100,120,30);
        summit.setBackground(Color.BLUE);
        summit.setForeground(Color.WHITE);
        summit.addActionListener(this);
        add(summit);
        
        cancel = new JButton("Quay lại");
        cancel.setBounds(180,100,120,30);
        cancel.setBackground(Color.BLUE);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(350, 200);
        setVisible(true);
        setLocation(350,200);
        getContentPane().setBackground(Color.WHITE);
    }

    
    public void actionPerformed(ActionEvent ae){
             if(ae.getSource() == summit){
            Conn conn = new Conn();
            String pinnumber = enterpinTextField.getText();
            String query = "select * from login where pin =  '"+pinnumber+"'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Chuyển tiền thành công");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Sai mã pin, vui lòng nhập lại");
                }
            } catch (Exception e){
                System.out.println(e);
            }
        } else if(ae.getSource() == cancel){
            setVisible(false);
            new Tranfer(formno).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new VerifyCodeTransfer();
    }

}
