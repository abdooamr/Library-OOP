/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryoop;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import static java.nio.file.Files.list;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author youse
 */
public class UserSettingsGUI extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField tTitle, tISBN, tAuthor, tPrice, tNumOfCopies, tGenre, tLocation;
    private JButton b1, b2;
    JComboBox comboBox;
    String ufname, ulname, ucellphone, uaddress, email, uuID;
    Choice c1;

    public UserSettingsGUI() throws IOException {
        Loggedin l = new Loggedin();
        String UserFname = l.fnameSession;
        String UserLname = l.lnameSession;
        String IDuser = l.IDSession;
        System.out.println(IDuser + "HAAAHH");
        ArrayList<User.userInfo> usersarr = new ArrayList();
        //  ArrayList<Books.BookInfo> bookarr=new ArrayList();
        User.ReadUsers(usersarr);
        for (int i = 0; i < usersarr.size(); ++i) {

            User.userInfo user = usersarr.get(i);

            if ((user.getID()).equals(IDuser)) {
                usersarr.get(i);
                System.out.println("ID:" + user.getID() + " First name:" + user.getFirstName() + " Last name:" + user.getLasttName()
                        + " Address:" + user.getAdress() + " Phone:" + user.getCellPhone() + " Email:" + user.getEmail() + " Blocked:" + user.getIsBlocked());
                ufname = user.getFirstName();
                ulname = user.getLasttName();
                ucellphone = user.getCellPhone();
                uaddress = user.getAdress();
                email = user.getEmail();
                uuID = user.getID();

            }

        }
        setBounds(600, 200, 540, 470);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lISBN = new JLabel("First Name");
        lISBN.setForeground(new Color(47, 79, 79));
        lISBN.setFont(new Font("Tahoma", Font.BOLD, 14));
        lISBN.setBounds(40, 51, 140, 22);
        contentPane.add(lISBN);

        JLabel lTitle = new JLabel("Last Name");
        lTitle.setForeground(new Color(47, 79, 79));
        lTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
        lTitle.setBounds(40, 84, 140, 22);
        contentPane.add(lTitle);

        JLabel lGenre = new JLabel("UserID");
        lGenre.setForeground(new Color(47, 79, 79));
        lGenre.setFont(new Font("Tahoma", Font.BOLD, 14));
        lGenre.setBounds(40, 117, 140, 22);
        contentPane.add(lGenre);

        JLabel lAuthor = new JLabel("Address");
        lAuthor.setForeground(new Color(47, 79, 79));
        lAuthor.setFont(new Font("Tahoma", Font.BOLD, 14));
        lAuthor.setBounds(40, 150, 140, 22);
        contentPane.add(lAuthor);

        JLabel lLocation = new JLabel("CellPhone");
        lLocation.setForeground(new Color(47, 79, 79));
        lLocation.setFont(new Font("Tahoma", Font.BOLD, 14));
        lLocation.setBounds(40, 183, 140, 22);
        contentPane.add(lLocation);

        JLabel lPrice = new JLabel("Email");
        lPrice.setForeground(new Color(47, 79, 79));
        lPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
        lPrice.setBounds(40, 216, 140, 22);
        contentPane.add(lPrice);

        JLabel lNumberOfCopies = new JLabel("Update");
        lNumberOfCopies.setForeground(new Color(47, 79, 79));
        lNumberOfCopies.setFont(new Font("Tahoma", Font.BOLD, 14));
        lNumberOfCopies.setBounds(40, 249, 140, 22);
        contentPane.add(lNumberOfCopies);

//	tISBN = new JTextField();
//	tISBN.setForeground(new Color(47, 79, 79));
//	tISBN.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
//	tISBN.setBounds(169, 54, 198, 20);
//	contentPane.add(tISBN);
//	tISBN.setColumns(10);
        JLabel lfname = new JLabel(ufname);
        lfname.setForeground(new Color(47, 79, 79));
        lfname.setFont(new Font("Tahoma", Font.BOLD, 14));
        lfname.setBounds(169, 54, 198, 20);
        contentPane.add(lfname);

        JLabel llname = new JLabel(ulname);
        llname.setForeground(new Color(47, 79, 79));
        llname.setFont(new Font("Tahoma", Font.BOLD, 14));
        llname.setBounds(169, 87, 198, 20);
        contentPane.add(llname);

        JLabel llcellphone = new JLabel(ucellphone);
        llcellphone.setForeground(new Color(47, 79, 79));
        llcellphone.setFont(new Font("Tahoma", Font.BOLD, 14));
        llcellphone.setBounds(169, 186, 194, 20);
        contentPane.add(llcellphone);

        JLabel luserID = new JLabel(uuID);
        luserID.setForeground(new Color(47, 79, 79));
        luserID.setFont(new Font("Tahoma", Font.BOLD, 14));
        luserID.setBounds(169, 120, 198, 20);
        contentPane.add(luserID);

        JLabel laddress = new JLabel(uaddress);
        laddress.setForeground(new Color(47, 79, 79));
        laddress.setFont(new Font("Tahoma", Font.BOLD, 14));
        laddress.setBounds(169, 150, 140, 22);
        contentPane.add(laddress);

        JLabel lemail = new JLabel(email);
        lemail.setForeground(new Color(47, 79, 79));
        lemail.setFont(new Font("Tahoma", Font.BOLD, 14));
        lemail.setBounds(169, 219, 140, 22);
        contentPane.add(lemail);

        tNumOfCopies = new JTextField();
        tNumOfCopies.setForeground(new Color(47, 79, 79));
        tNumOfCopies.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        tNumOfCopies.setColumns(10);
        tNumOfCopies.setBounds(169, 252, 120, 20);
        contentPane.add(tNumOfCopies);

        c1 = new Choice();
        c1.add("FirstName");
        c1.add("LastName");
        c1.add("Email");
        c1.add("CellPhone");
        c1.add("Address");
        

        c1.setBounds(320, 252, 120, 20);
        contentPane.add(c1);

//	tAuthor = new JTextField();
//	tAuthor.setForeground(new Color(47, 79, 79));
//	tAuthor.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
//	tAuthor.setColumns(10);
//	tAuthor.setBounds(169, 153, 198, 20);
//	contentPane.add(tAuthor);
//
//        tPrice = new JTextField();
//	tPrice.setForeground(new Color(47, 79, 79));
//	tPrice.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
//	tPrice.setColumns(10);
        //	tPrice.setBounds(169, 219, 198, 20);
//	contentPane.add(tPrice);
        b1 = new JButton("Update");
        b1.addActionListener(this);
        b1.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b1.setBounds(102, 300, 100, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b2.setBounds(212, 300, 108, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        contentPane.add(b2);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(138, 43, 226), 2), "Add Books", TitledBorder.LEADING,
                TitledBorder.TOP, null, new Color(0, 0, 255)));
        panel.setBounds(10, 29, 450, 350);
        contentPane.add(panel);

        panel.setBackground(Color.WHITE);
        contentPane.setBackground(Color.WHITE);
        addWindowListener(new User.WindowEventHandler());

    }

    public void actionPerformed(ActionEvent ae) {
        //,,,,,,;

        if (ae.getSource() == b1) {
                ArrayList<User.userInfo> usersarr = new ArrayList();
            try {
                //  ArrayList<Books.BookInfo> bookarr=new ArrayList();
                User.ReadUsers(usersarr);
            } catch (IOException ex) {
                Logger.getLogger(UserSettingsGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
             UserSettings us = new UserSettings();
            String searchmeth = c1.getSelectedItem();
            String data =tNumOfCopies.getText();

        
            if(searchmeth.equals("FirstName")){
               us.EditUserFirstName(uuID, usersarr, data);
                    try {
                        User.UpdateUsers(usersarr);
                    } catch (IOException ex) {
                        Logger.getLogger(UserSettingsGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            else            if(searchmeth.equals("LastName")){
               us.EditUserLastName(uuID, usersarr, data);
                          try {
                        User.UpdateUsers(usersarr);
                    } catch (IOException ex) {
                        Logger.getLogger(UserSettingsGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            else            if(searchmeth.equals("CellPhone")){
               us.EditUserCellPhone(uuID, usersarr, data);
                          try {
                        User.UpdateUsers(usersarr);
                    } catch (IOException ex) {
                        Logger.getLogger(UserSettingsGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            else            if(searchmeth.equals("Address")){
               us.EditUserAddress(uuID, usersarr, data);
                          try {
                        User.UpdateUsers(usersarr);
                    } catch (IOException ex) {
                        Logger.getLogger(UserSettingsGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
            } 
            else            if(searchmeth.equals("Email")){
               us.EditUserEmail(uuID, usersarr, data);
                          try {
                        User.UpdateUsers(usersarr);
                    } catch (IOException ex) {
                        Logger.getLogger(UserSettingsGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }             
          
        }
        if (ae.getSource() == b2) {
            this.setVisible(false);
           
                new UsersGUI().setVisible(true);
        

        }

    }
}
