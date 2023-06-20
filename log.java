
package thislogin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class log extends JFrame{
   
    private JPanel panel;
    private JLabel lbl1;
    private JLabel lbl2;
    private JLabel lbl3;
    private JTextField txt1;
    private JPasswordField pass;
    private JButton btn1;
    private JButton btn2;
    
    
    public log(){
        super("Dentist Appointment");
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        add(panel);
        
        lbl1 = new JLabel("LOGIN HERE");
        lbl1.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 14));
        lbl1.setBounds(100,10,250,25);
        panel.add(lbl1);
        
        lbl2 = new JLabel("User");
        lbl2.setBounds(20,70,80,25);
        panel.add(lbl2);
       
        txt1 = new JTextField();
        txt1.setBounds(100,70,165,25);
        panel.add(txt1);
        
        lbl3 = new JLabel("Password");
        lbl3.setBounds(20,130,165,25);
        panel.add(lbl3);
        
        pass = new JPasswordField();
        pass.setBounds(100,130,165,25);
        panel.add(pass);
        
        btn1 = new JButton("Login");
        btn1.setBounds(50, 200, 90, 25);
        panel.add(btn1);
        
        btn2 = new JButton("Sign up");
        btn2.setBounds(160, 200, 90, 25);
        panel.add(btn2);
    }
}
