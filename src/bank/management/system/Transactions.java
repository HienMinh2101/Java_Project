package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit, withdrawl, tranfer, history, pinchange, balanceenquiry, user, exit;
    String pinnumber;
    JLabel depositLabel, withdrawLabel, tranferLabel, historyLabel, pinchangeLabel, balanceenquiryLabel, userLabel, backgroundLabel;
    ImageIcon depositIcon, depositIcon1, withdrawalIcon, withdrawalIcon1, tranferIcon, tranferIcon1, historyIcon, historyIcon1
            , pinchangeIcon, pinchangeIcon1 , balanceenquiryIcon, balanceenquiryIcon1, userIcon, userIcon1, backgroundIcon, backgroundIcon1;
    Image depositImage, withdrawalImage, tranferImage, historyImage, pinchanImage, balanceenquiryImage, userImage, backgroundImage;
    
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("icons/detail-shot-skyscrapers.jpg"));
        backgroundImage = backgroundIcon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        backgroundIcon1 = new ImageIcon(backgroundImage);
        backgroundLabel = new JLabel(backgroundIcon1);
        backgroundLabel.setBounds(0, 0, 400, 800);
        add(backgroundLabel);
        
        JLabel text = new JLabel("Chọn chức năng cần sử dụng");
        text.setBounds(20, 10, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,24));
        backgroundLabel.add(text);
        
        depositIcon = new ImageIcon (ClassLoader.getSystemResource("icons/deposit.png"));
        depositImage = depositIcon.getImage().getScaledInstance(100, 100, Image.SCALE_REPLICATE);
        depositIcon1 = new ImageIcon(depositImage);
        depositLabel = new JLabel(depositIcon1);
        depositLabel.setBounds(50, 60, 100, 100);
        depositLabel.setBackground(new Color(153, 204, 255));
        depositLabel.setCursor(Cursor.getDefaultCursor());
        backgroundLabel.add(depositLabel);
        
        deposit = new JButton("Nạp tiền");
        deposit.setBounds(20, 170, 150, 30);
        deposit.addActionListener(this);
        backgroundLabel.add(deposit);
        
        withdrawalIcon = new ImageIcon (ClassLoader.getSystemResource("icons/money-withdrawal.png"));
        withdrawalImage = withdrawalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_REPLICATE);
        withdrawalIcon1 = new ImageIcon(withdrawalImage);
        withdrawLabel = new JLabel(withdrawalIcon1);
        withdrawLabel.setBounds(250, 60, 100, 100);
        withdrawLabel.setBackground(new Color(153, 204, 255));
        withdrawLabel.setCursor(Cursor.getDefaultCursor());
        backgroundLabel.add(withdrawLabel);
        
        withdrawl = new JButton("Rút tiền");
        withdrawl.setBounds(220, 170, 150, 30);
        withdrawl.addActionListener(this);
        backgroundLabel.add(withdrawl);
        
        tranferIcon = new ImageIcon (ClassLoader.getSystemResource("icons/money-transfer.png"));
        tranferImage = tranferIcon.getImage().getScaledInstance(100, 100, Image.SCALE_REPLICATE);
        tranferIcon1 = new ImageIcon(tranferImage);
        tranferLabel = new JLabel(tranferIcon1);
        tranferLabel.setBounds(50, 220, 100, 100);
        tranferLabel.setBackground(new Color(153, 204, 255));
        tranferLabel.setCursor(Cursor.getDefaultCursor());
        backgroundLabel.add(tranferLabel);
        
        tranfer = new JButton("Chuyển tiền");
        tranfer.setBounds(20, 330, 150, 30);
        tranfer.addActionListener(this);
        backgroundLabel.add(tranfer);
        
        historyIcon = new ImageIcon (ClassLoader.getSystemResource("icons/cheque.png"));
        historyImage = historyIcon.getImage().getScaledInstance(100, 100, Image.SCALE_REPLICATE);
        historyIcon1 = new ImageIcon(historyImage);
        historyLabel = new JLabel(historyIcon1);
        historyLabel.setBounds(250, 220, 100, 100);
        historyLabel.setBackground(new Color(153, 204, 255));
        historyLabel.setCursor(Cursor.getDefaultCursor());
        backgroundLabel.add(historyLabel);
        
        history = new JButton("Lịch sử");
        history.setBounds(220, 330, 150, 30);
        history.addActionListener(this);
        backgroundLabel.add(history);
        
        pinchangeIcon = new ImageIcon (ClassLoader.getSystemResource("icons/rotation-locks.png"));
        pinchanImage = pinchangeIcon.getImage().getScaledInstance(100, 100, Image.SCALE_REPLICATE);
        pinchangeIcon1 = new ImageIcon(pinchanImage);
        pinchangeLabel = new JLabel(pinchangeIcon1);
        pinchangeLabel.setBounds(50, 380, 100, 100);
        pinchangeLabel.setBackground(new Color(153, 204, 255));
        pinchangeLabel.setCursor(Cursor.getDefaultCursor());
        backgroundLabel.add(pinchangeLabel);
        
        pinchange = new JButton("Đổi mã");
        pinchange.setBounds(20, 490, 150, 30);
        pinchange.addActionListener(this);
        backgroundLabel.add(pinchange);
        
        balanceenquiryIcon = new ImageIcon (ClassLoader.getSystemResource("icons/atm-card.png"));
        balanceenquiryImage = balanceenquiryIcon.getImage().getScaledInstance(100, 100, Image.SCALE_REPLICATE);
        balanceenquiryIcon1 = new ImageIcon(balanceenquiryImage);
        balanceenquiryLabel = new JLabel(balanceenquiryIcon1);
        balanceenquiryLabel.setBounds(250, 380, 100, 100);
        balanceenquiryLabel.setBackground(new Color(153, 204, 255));
        balanceenquiryLabel.setCursor(Cursor.getDefaultCursor());
        backgroundLabel.add(balanceenquiryLabel);
        
        balanceenquiry = new JButton("Thẻ ATM");
        balanceenquiry.setBounds(220, 490, 150, 30);
        balanceenquiry.addActionListener(this);
        backgroundLabel.add(balanceenquiry);
        
        exit = new JButton("Đăng xuất");
        exit.setBounds(20, 560, 345, 30);
        exit.addActionListener(this);
        backgroundLabel.add(exit);
        
        setSize(400, 650);
        setLocation(300, 0);
        setVisible(true);
        setUndecorated(true);
        getContentPane().setBackground(Color.WHITE);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit) {
            setVisible(false);
            new Login().setVisible(true);
        } else if (ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if (ae.getSource() == tranfer){
            setVisible(false);
            new Tranfer(pinnumber).setVisible(true);
        } else if (ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (ae.getSource() == balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if (ae.getSource() == history){
            new History(pinnumber).setVisible(true);
        } 
    }
    
    public static void main(String[] args) {
        new Transactions("");
    }
}
