/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryoop;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import static libraryoop.LoginMenuGUI.LoginMenuGUI;

/**
 *
 * @author youse
 */
public class Signup extends JFrame implements ActionListener {

    JPanel p1;
    JTextField tUserName, tFname, tLname, tAdminUsername, tAddress, tCellPhone, tEmail;
    JPasswordField tPassword, tAdminPassword;
    Choice c1;
    JButton b1, b2;

    Signup() {
        setBounds(600, 250, 700, 550);

        p1 = new JPanel();
        p1.setBounds(30, 30, 650, 700);
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);
        p1.setForeground(new Color(34, 139, 34));
        p1.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(173, 216, 230)));
        add(p1);

        JLabel lUsername = new JLabel("Username");
        lUsername.setForeground(Color.DARK_GRAY);
        lUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lUsername.setBounds(100, 50, 100, 20);
        p1.add(lUsername);

        tUserName = new JTextField();
        tUserName.setBounds(260, 50, 150, 20);
        p1.add(tUserName);

        JLabel lfname = new JLabel("First Name");
        lfname.setForeground(Color.DARK_GRAY);
        lfname.setFont(new Font("Tahoma", Font.BOLD, 14));
        lfname.setBounds(100, 90, 100, 20);
        p1.add(lfname);

        tFname = new JTextField();
        tFname.setBounds(260, 90, 150, 20);
        p1.add(tFname);

        JLabel llname = new JLabel("Last Name");
        llname.setForeground(Color.DARK_GRAY);
        llname.setFont(new Font("Tahoma", Font.BOLD, 14));
        llname.setBounds(100, 130, 100, 20);
        p1.add(llname);

        tLname = new JTextField();
        tLname.setBounds(260, 130, 150, 20);
        p1.add(tLname);

        JLabel lpassword = new JLabel("Password");
        lpassword.setForeground(Color.DARK_GRAY);
        lpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lpassword.setBounds(100, 170, 100, 20);
        p1.add(lpassword);

        tPassword = new JPasswordField();
        tPassword.setBounds(260, 170, 150, 20);
        p1.add(tPassword);

        JLabel lEmail = new JLabel("Email");
        lEmail.setForeground(Color.DARK_GRAY);
        lEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
        lEmail.setBounds(100, 210, 100, 20);
        p1.add(lEmail);

        tEmail = new JTextField();
        tEmail.setBounds(260, 210, 150, 20);
        p1.add(tEmail);

        JLabel lCellPhone = new JLabel("Cell Phone");
        lCellPhone.setForeground(Color.DARK_GRAY);
        lCellPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
        lCellPhone.setBounds(100, 250, 100, 20);
        p1.add(lCellPhone);

        tCellPhone = new JTextField();
        tCellPhone.setBounds(260, 250, 150, 20);
        p1.add(tCellPhone);

        JLabel lAddress = new JLabel("Address");
        lAddress.setForeground(Color.DARK_GRAY);
        lAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
        lAddress.setBounds(100, 290, 100, 20);
        p1.add(lAddress);

        tAddress = new JTextField();
        tAddress.setBounds(260, 290, 150, 20);
        p1.add(tAddress);

        JLabel l4 = new JLabel("Create Account As");
        l4.setForeground(Color.DARK_GRAY);
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(100, 330, 140, 20);
        p1.add(l4);

        JLabel lAdmin = new JLabel("Admin Username");
        lAdmin.setForeground(Color.DARK_GRAY);
        lAdmin.setFont(new Font("Tahoma", Font.BOLD, 14));
        lAdmin.setBounds(100, 370, 140, 20);
        lAdmin.setVisible(false);
        p1.add(lAdmin);

        tAdminUsername = new JTextField();
        tAdminUsername.setBounds(260, 370, 150, 20);
        tAdminUsername.setVisible(false);
        p1.add(tAdminUsername);

        JLabel lPassAdmin = new JLabel("Admin Password");
        lPassAdmin.setForeground(Color.DARK_GRAY);
        lPassAdmin.setFont(new Font("Tahoma", Font.BOLD, 14));
        lPassAdmin.setBounds(100, 410, 140, 20);
        lPassAdmin.setVisible(false);
        p1.add(lPassAdmin);

        tAdminPassword = new JPasswordField();
        tAdminPassword.setBounds(260, 410, 150, 20);
        tAdminPassword.setVisible(false);
        p1.add(tAdminPassword);

        c1 = new Choice();
        c1.add("Customer");
        c1.add("Admin");
        c1.setBounds(260, 330, 150, 20);
        p1.add(c1);

        c1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ae) {
                String user = c1.getSelectedItem();
                if (user.equals("Admin")) {
                    lAdmin.setVisible(true);
                    tAdminPassword.setVisible(true);
                    tAdminUsername.setVisible(true);
                    lPassAdmin.setVisible(true);

                } else {
                    lAdmin.setVisible(false);
                    tAdminPassword.setVisible(false);
                    tAdminUsername.setVisible(false);
                    lPassAdmin.setVisible(false);
                }
            }
        });

        b1 = new JButton("Create");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(140, 450, 120, 30);
        b1.addActionListener(this);
        p1.add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(300, 450, 120, 30);
        b2.addActionListener(this);
        p1.add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(450, 30, 250, 250);
        p1.add(l6);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String username = tUserName.getText();
            String fname = tFname.getText();
            String lname = tLname.getText();
            String address = tAddress.getText();
            String cellphone = tCellPhone.getText();
            String email = tEmail.getText();
            String password = tPassword.getText();
            String user = c1.getSelectedItem();
            String adminpass = tAdminPassword.getText();
            String adminuser = tAdminUsername.getText();
            try {

                if (user.equals("Customer")) {
                    ArrayList userInfo = new ArrayList<>();
                    User u = new User();
                    u.ReadUsers(userInfo);
                    User.userInfo obj = new User.userInfo();
                    //, , , tAdminUsername, , , tEmail;
                    obj.setFirstName(fname);
                    obj.setLastName(lname);
                    obj.setID(username);
                    obj.setAddress(address);
                    obj.setCellPhone(cellphone);
                    obj.setEmail(email);
                    obj.setPassword(password);
                    obj.setIsadmin(false);
                    obj.setIsBlocked(false);
                    if (username.equals("") || fname.equals("") || lname.equals("") || address.equals("") || cellphone.equals("") || email.equals("") || password.equals("")) {
                        JOptionPane.showMessageDialog(null, "Don't leave any field empty!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Account Created Successfully");
                        userInfo.add(obj); /// adding every user at the array list;
                        u.UpdateUsers(userInfo);
                        this.setVisible(false);
                        ArrayList<Loggedin.Status> statsarr = new ArrayList();
                        Loggedin.ReadStatus(statsarr);
                        Loggedin ln = new Loggedin();
                        String IDsession = ln.IDSession;
                        if (IDsession.equals("")) {
                            LoginMenuGUI();
                        } else { //USER GUI TO BE ADDED HERE
                            JOptionPane.showMessageDialog(null, "USER GUI TO BE ADDED HERE");
                        }
                    }
                } else if (user.equals("Admin")) {
                    ArrayList<User.userInfo> userlist = new ArrayList();

                    User.ReadUsers(userlist);

                    boolean found = false;
                    for (int i = 0; i < userlist.size(); i++) {
                        if (userlist.get(i).getID().equals(adminuser) && userlist.get(i).getPassword().equals(adminpass) && userlist.get(i).getIsadmin() == true) {

                            found = true;

                            break;
                        }
                    }
                    if (found == true) {
                        ArrayList userInfo = new ArrayList<>();
                        User u = new User();
                        u.ReadUsers(userInfo);
                        User.userInfo obj = new User.userInfo();
                        //, , , tAdminUsername, , , tEmail;
                        obj.setFirstName(fname);
                        obj.setLastName(lname);
                        obj.setID(username);
                        obj.setAddress(address);
                        obj.setCellPhone(cellphone);
                        obj.setEmail(email);
                        obj.setPassword(password);
                        obj.setIsadmin(true);
                        obj.setIsBlocked(false);
                        if (username.equals("") || fname.equals("") || lname.equals("") || address.equals("") || cellphone.equals("") || email.equals("") || password.equals("")) {
                            JOptionPane.showMessageDialog(null, "Don't leave any field empty!");

                        } else {

                            JOptionPane.showMessageDialog(null, "Account Created Successfully");
                            userInfo.add(obj); /// adding every user at the array list;
                            u.UpdateUsers(userInfo);
                            this.setVisible(false);
                            ArrayList<Loggedin.Status> statsarr = new ArrayList();
                            Loggedin.ReadStatus(statsarr);
                            Loggedin ln = new Loggedin();
                            String IDsession = ln.IDSession;
                            if (IDsession.equals("")) {
                                LoginMenuGUI();
                            } else { //USER GUI TO BE ADDED HERE
                                JOptionPane.showMessageDialog(null, "USER GUI TO BE ADDED HERE");
                            }
                            // LoginMenuGUI();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Check Admin Password and username");
                    }

                    // JOptionPane.showMessageDialog(null, "Account Created Successfully");
                    // this.setVisible(false);
                    //          LoginMenuGUI();
                    ArrayList<User.userInfo> usersarr = new ArrayList();
                    ArrayList<Books.BookInfo> bookarr = new ArrayList();
                    User.ReadUsers(usersarr);
                    Books.readBooks(bookarr);
                    //HENA
                }
            } catch (Exception e) {

            }
        } else if (ae.getSource() == b2) {
            this.setVisible(false);
               ArrayList<Loggedin.Status> statsarr = new ArrayList();
            try {
                Loggedin.ReadStatus(statsarr);
            } catch (IOException ex) {
                Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
            }
                            Loggedin ln = new Loggedin();
                            String IDsession = ln.IDSession;
                            System.out.println(IDsession);
                            if (IDsession.equals("")) {
                try {
                    LoginMenuGUI();
                } catch (IOException ex) {
                    Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
                }
                            } else { //USER GUI TO BE ADDED HERE
                                 new ReadersGUI().setVisible(true);
                            }
//            try {
//                LoginMenuGUI();
//            } catch (IOException ex) {
//                Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            ArrayList<User.userInfo> usersarr = new ArrayList();
//            ArrayList<Books.BookInfo> bookarr = new ArrayList();
//            try {
//                User.ReadUsers(usersarr);
//            } catch (IOException ex) {
//                Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            try {
//                Books.readBooks(bookarr);
//            } catch (IOException ex) {
//                Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }
}
