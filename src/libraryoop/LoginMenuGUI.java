/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryoop;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Platform.exit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author youse
 */
public class LoginMenuGUI extends JFrame implements ActionListener {

    static void LoginMenuGUI() throws IOException {
        LoginMenuGUI x = new LoginMenuGUI();

    }
    /*
    
    
               JFrame frame_A = new JFrame("Sign in as Admin");
                JPanel panel_A = new JPanel();
                JButton Button_A = new JButton("Sign in");
                JLabel passlabel_A = new JLabel("Password ");
                JLabel ID_A = new JLabel("Admin's ID ");
                JTextField id = new JTextField();
                JPasswordField password = new JPasswordField("");


static ArrayList<User.userInfo> usersarr=new ArrayList();
    public LoginMenu() {
        
                frame_A.setSize(500,500);
                frame_A.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame_A.setLayout(null);
                frame_A.setLocationRelativeTo(null);
                frame_A.add(panel_A);
                frame_A.setVisible(true);
                passlabel_A.setBounds(120,205, 90, 30);
                Button_A.setBounds(180, 250, 110, 23);
                id.setBounds(180,180,110,23);
                password.setBounds(180,210,110,23);
                ID_A.setBounds(118,180,110,23);
                frame_A.add(Button_A);
                frame_A.add(id);
                frame_A.add(password);
                frame_A.add(passlabel_A);
                frame_A.add(ID_A);
            Button_A.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID=id.getText();   
             String Pass =password.getText();
            boolean found=false;
         for(int i=0;i<usersarr.size();i++){
             if(usersarr.get(i).getID().equals(ID)&&usersarr.get(i).getPassword().equals(Pass)&&usersarr.get(i).getIsadmin()==true){  
            JOptionPane.showMessageDialog(null,"Login successfully");
                             frame_A.setVisible(false);
                            // AdminGUI a = new AdminGUI();
             found=true;
             break;
             }
                 
         } 
         if (!found)
                JOptionPane.showMessageDialog(null,"Try again","",JOptionPane.WARNING_MESSAGE);
                        

            }
        });
                frame_A.setVisible(true);
            
    }
   
}
 class UserLogin {
     static ArrayList<User.userInfo> usersarr=new ArrayList();
    JFrame frame_A = new JFrame("Sign in as User");
                JPanel panel_A = new JPanel();
                JButton Button_A = new JButton("Sign in");
                JLabel passlabel_A = new JLabel("Password ");
                JLabel ID_A = new JLabel("User's ID ");
                JTextField id = new JTextField();
                JPasswordField password = new JPasswordField("");



    public UserLogin() {
                frame_A.setSize(500,500);
                frame_A.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame_A.setLayout(null);
                frame_A.setLocationRelativeTo(null);
                frame_A.add(panel_A);
                frame_A.setVisible(true);
                passlabel_A.setBounds(120,205, 90, 30);
                Button_A.setBounds(180, 250, 110, 23);
                id.setBounds(180,180,110,23);
                password.setBounds(180,210,110,23);
                ID_A.setBounds(118,180,110,23);
                frame_A.add(Button_A);
                frame_A.add(id);
                frame_A.add(password);
                frame_A.add(passlabel_A);
                frame_A.add(ID_A);
            Button_A.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID=id.getText();   
             String Pass =password.getText();
                       boolean found=false;
         for(int i=0;i<usersarr.size();i++){
             if(usersarr.get(i).getID().equals(ID)&&usersarr.get(i).getPassword().equals(Pass)&&usersarr.get(i).getIsadmin()==false){  
            JOptionPane.showMessageDialog(null,"Login successfully");
                             frame_A.setVisible(false);
                //             UserGUI ug = new UserGUI();
                             
             found=true;
             break;
             }
                 
         } 
         if (!found)
                JOptionPane.showMessageDialog(null,"Try again","",JOptionPane.WARNING_MESSAGE);
                        

            }
        });
                frame_A.setVisible(true);    
    }*/

    JLabel l1, l2, l3, l4;
    JTextField id;
    JPasswordField password;
    JButton b1, b2, b3;
    JPanel p1, p2, p3, p4;
    Choice c1;

    LoginMenuGUI() throws IOException {

        setTitle("Login Menu");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        l1 = new JLabel("Username");
        l1.setBounds(300, 20, 100, 20);
        add(l1);
        l2 = new JLabel("Password");
        l2.setBounds(300, 60, 100, 20);
        add(l2);

        id = new JTextField(15);
        id.setBounds(400, 20, 150, 20);
        add(id);
        password = new JPasswordField(15);
        password.setBounds(400, 60, 150, 20);
        add(password);

        l4 = new JLabel("Logging in as");
        l4.setBounds(300, 100, 100, 20);
        add(l4);

        c1 = new Choice();
        c1.add("Admin");
        c1.add("User");
        c1.setBounds(400, 100, 150, 20);
        add(c1);

        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i1 = ic1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        b1 = new JButton("Login", new ImageIcon(i1));
        b1.setBounds(330, 160, 100, 20);
        add(b1);

        ImageIcon ic2 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i2 = ic2.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        b2 = new JButton("Cancel", new ImageIcon(i2));
        b2.setBounds(450, 160, 100, 20);
        add(b2);

        ImageIcon ic4 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i4 = ic4.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        b3 = new JButton("Signup", new ImageIcon(i4));
        b3.setBounds(380, 200, 130, 20);
        add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        ImageIcon ic3 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i3 = ic3.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        l3 = new JLabel(icc3);
        l3.setBounds(0, 0, 250, 250);
        add(l3);

        setLayout(new BorderLayout());

        setSize(640, 300);
        setLocation(600, 300);
        setVisible(true);
        addWindowListener(new User.WindowEventHandler());

    }

    public void actionPerformed(ActionEvent ae) {
        ArrayList<User.userInfo> userlist = new ArrayList();
        try {
            User.ReadUsers(userlist);
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (ae.getSource() == b1) {
            if (c1.getSelectedItem().equals("Admin")) {
                String ID = id.getText();
                String Pass = password.getText();
                boolean found = false;
                for (int i = 0; i < userlist.size(); i++) {
                    if (userlist.get(i).getID().equals(ID) && userlist.get(i).getPassword().equals(Pass) && userlist.get(i).getIsadmin() == true) {
                        JOptionPane.showMessageDialog(null, "Login successfully");
                        setVisible(false);
                          try {
                            Loggedin.ADDSTATS(Pass, ID, true);
                            System.out.println(Pass+" "+ID);
                        } catch (IOException ex) {
                            Logger.getLogger(LoginMenu.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                                                 Loggedin.LoggedinInfo();
                        } catch (IOException ex) {
                            Logger.getLogger(LoginMenuGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
   new ReadersGUI().setVisible(true);
                        // AdminGUI a = new AdminGUI();
                        User x = new User();
                        found = true;
                        break;
                    }

                }
                if (!found) {
                    JOptionPane.showMessageDialog(null, "Try again", "", JOptionPane.WARNING_MESSAGE);
                }

            } else if (c1.getSelectedItem().equals("User")) {
                String ID = id.getText();
                String Pass = password.getText();
                boolean found = false;
                for (int i = 0; i < userlist.size(); i++) {
                    if (userlist.get(i).getID().equals(ID) && userlist.get(i).getPassword().equals(Pass) && userlist.get(i).getIsadmin() == false) {
                        JOptionPane.showMessageDialog(null, "Login successfully");
                        try {
                            Loggedin.ADDSTATS(Pass, ID, true);
                            System.out.println(Pass+" "+ID);
                        } catch (IOException ex) {
                            Logger.getLogger(LoginMenu.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                                               Loggedin.LoggedinInfo();
                        } catch (IOException ex) {
                            Logger.getLogger(LoginMenuGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
     
                        setVisible(false);
                     //   User x = new User();
                     new UsersGUI().setVisible(true);
                     
//                        try {
//                            x.run();
//                            //       User.UserGUI ug =  x.new.UserGUI();
//                        } catch (IOException ex) {
//                            Logger.getLogger(LoginMenu.class.getName()).log(Level.SEVERE, null, ex);
//                        }

                        found = true;
                        break;
                    }

                }
                if (!found) {
                    JOptionPane.showMessageDialog(null, "Try again", "", JOptionPane.WARNING_MESSAGE);
                }

            }
        } else if (ae.getSource() == b2) {
            this.setVisible(false);
            System.exit(0);
        } else if (ae.getSource() == b3) {
            this.setVisible(false);
            new Signup().setVisible(true);

        }
    }
}
