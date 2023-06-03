package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JLabel additionalDetails, religion, category, income, education, occupation, pan, senior, exit;
    JTextField panTextField;
    JRadioButton syes, sno, eyes, eno;
    JButton next;
    ButtonGroup sengroup, exitgroup;
    JComboBox reli, cate, inco, educa, occupa;
    String formno;
    
    SignupTwo(String formno){
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        additionalDetails = new JLabel("Page 2: Chi tiết bổ sung");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        religion = new JLabel("Tôn Giáo:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 100, 30);
        add(religion);
        
        String valReli[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        reli = new JComboBox(valReli);
        reli.setBounds(300, 140, 400, 30);
        reli.setBackground(Color.WHITE);
        add(reli);
        
        category = new JLabel("Loại thẻ:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);
        
        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        cate = new JComboBox(valCategory);
        cate.setBounds(300, 190, 400, 30);
        cate.setBackground(Color.WHITE);
        add(cate);
        
        income = new JLabel("Thu Nhập Cá Nhân:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);
        
        String incomeCategory[] = {"Null", "< 10,000,000", "< 20,000,000", "< 50,000,000", "Upto 100,000,000"};
        inco = new JComboBox(incomeCategory);
        inco.setBounds(300, 240, 400, 30);
        inco.setBackground(Color.WHITE);
        add(inco);
        
        education = new JLabel("Trình Độ Học Vấn:");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(100, 290, 200, 30);
        add(education);
        
        String valEducation[] = {"Tốt Nghiệp Cấp 1", "Tốt Nghiệp Cấp 2", "Tốt Nghiệp Cấp 3", "Tốt Nghiệp Đại Học", "Tốt Nghiệp Cao Đẳng"};
        educa = new JComboBox(valEducation);
        educa.setBounds(300, 290, 400, 30);
        educa.setBackground(Color.WHITE);
        add(educa);
        
        occupation = new JLabel("Nghề Nghiệp:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 340, 200, 30);
        add(occupation);
        
        String valOccupation[] = {"Doanh Nhân", "Công Nhân", "Sinh Viên", "Học Sinh", "IT", "Nhân Viên Văn Phòng", "Thợ Máy", "Thợ Gỗ"};
        occupa = new JComboBox(valOccupation);
        occupa.setBounds(300, 340, 400, 30);
        occupa.setBackground(Color.WHITE);
        add(occupa);
        
        pan = new JLabel("Số Điện Thoại:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 390, 200, 30);
        add(pan);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 390, 400, 30);
        add(panTextField);
        
        senior = new JLabel("Người Cao Tuổi:");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(100, 440, 200, 30);
        add(senior);
        
        syes = new JRadioButton("Có");
        syes.setBounds(300, 440, 120, 30);
        syes.setBackground(new Color(153, 204, 255));
        add(syes);
        
        sno = new JRadioButton("Không");
        sno.setBounds(450, 440, 120 , 30);
        sno.setBackground(new Color(153, 204, 255));
        add(sno);
        
        sengroup = new ButtonGroup();
        sengroup.add(syes);
        sengroup.add(sno);
        
        exit = new JLabel("Đã Có Tài Khoản:");
        exit.setFont(new Font("Raleway", Font.BOLD, 20));
        exit.setBounds(100, 490, 200, 30);
        add(exit);
        
        eyes = new JRadioButton("Có");
        eyes.setBounds(300, 490, 120, 30);
        eyes.setBackground(new Color(153, 204, 255));
        add(eyes);
        
        eno = new JRadioButton("Không");
        eno.setBounds(450, 490, 120 , 30);
        eno.setBackground(new Color(153, 204, 255));
        add(eno);
        
        exitgroup = new ButtonGroup();
        exitgroup.add(eyes);
        exitgroup.add(eno);
        
        next = new JButton("Tiếp Tục");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 540, 150, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(new Color(153, 204, 255));
        
        setSize(850,650);
        setLocation(350, 10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String sreligion = (String) reli.getSelectedItem();
        String scategory = (String) cate.getSelectedItem();
        String sincome = (String) inco.getSelectedItem();
        String seduction = (String) educa.getSelectedItem();
        String soccupation = (String) occupa.getSelectedItem();
        String seniorcitizen = null;
        if (syes.isSelected()){
            seniorcitizen = "Yes";
        }else if (sno.isSelected()){
            seniorcitizen = "No";
        }
        
        String exisitingaccount = null;
        if (eyes.isSelected()){
            exisitingaccount = "Yes";
        } else if (eno.isSelected()){
            exisitingaccount = "No";
        }
        
        String span = panTextField.getText();
        try {
                Conn c = new Conn();
                String query = "insert into signuptwo values ('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seduction+"', '"+soccupation+"', '"+span+"', '"+seniorcitizen+"', '"+exisitingaccount+"') ";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void main (String arg[]){
        new SignupTwo("");
    }
}
