/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryoop;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.ABORT;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import static libraryoop.Loggedin.ClearSession;
import static libraryoop.LoginMenuGUI.LoginMenuGUI;

/**
 *
 * @author youse
 */
public class UsersGUI  extends JFrame implements ActionListener{
    
private JPanel contentPane;
        private JButton b1,b2,b3,b4,b5,b6;


        
        public UsersGUI() {
            Loggedin l = new Loggedin();
    String UserFname = l.fnameSession;
     String UserLname = l.lnameSession;
	
            setBounds(400, 150, 1000, 800);
            contentPane = new JPanel();
            setContentPane(contentPane);
            contentPane.setLayout(null);

            
            JMenuBar menuBar = new JMenuBar();
            menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 128, 0), new Color(128, 128, 128)));
            menuBar.setBackground(Color.CYAN);
            menuBar.setBounds(0, 10, 1000, 35);
            contentPane.add(menuBar);

            JMenu mnExit = new JMenu("Exit");
            mnExit.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
            
            
            JMenuItem mntmLogout = new JMenuItem("Logout");
            mntmLogout.setBackground(new Color(211, 211, 211));
            mntmLogout.setForeground(new Color(105, 105, 105));
            mntmLogout.addActionListener(this);
            mnExit.add(mntmLogout);
            
            JMenuItem mntmExit = new JMenuItem("Exit");
            mntmExit.setForeground(new Color(105, 105, 105));
            mntmExit.setBackground(new Color(211, 211, 211));
            mntmExit.addActionListener(this);
            mnExit.add(mntmExit);
                
            

//            JMenu mnHelp = new JMenu("Help");
//            mnHelp.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
//            
//
//            JMenuItem mntmReadme = new JMenuItem("Read Me");
//            mntmReadme.setBackground(new Color(211, 211, 211));
//            mntmReadme.setForeground(new Color(105, 105, 105));
//            mnHelp.add(mntmReadme);
//
//            JMenuItem mntmAboutUs = new JMenuItem("About Us");
//            mntmAboutUs.setForeground(new Color(105, 105, 105));
//            mntmAboutUs.setBackground(new Color(211, 211, 211));
//            mntmAboutUs.addActionListener(this);
//            mnHelp.add(mntmAboutUs);

            JMenu mnRecord = new JMenu("Record");
            mnRecord.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
            

            JMenuItem bookdetails = new JMenuItem("Book Details");
            bookdetails.addActionListener(this);
            bookdetails.setBackground(new Color(211, 211, 211));
            bookdetails.setForeground(Color.DARK_GRAY);
            mnRecord.add(bookdetails);

            JMenuItem studentdetails = new JMenuItem("User Details");
            studentdetails.setBackground(new Color(211, 211, 211));
            studentdetails.setForeground(Color.DARK_GRAY);
            studentdetails.addActionListener(this);
            mnRecord.add(studentdetails);
            
            menuBar.add(mnRecord);
       //    menuBar.add(mnHelp);
            menuBar.add(mnExit);

            
            JLabel l1 = new JLabel("Library Management System");
            l1.setForeground(new Color(204, 51, 102));
            l1.setFont(new Font("Segoe UI Semilight", Font.BOLD, 30));
            l1.setBounds(268, 30, 701, 80);
            contentPane.add(l1);
            
            JLabel usernameL = new JLabel("Welcome "+UserFname +" "+UserLname);
            usernameL.setForeground(new Color(204, 51, 102));
            usernameL.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
            usernameL.setBounds(20, 30, 701, 80);
            contentPane.add(usernameL);
            
            

            JLabel l2 = new JLabel("");
            l2.setVerticalAlignment(SwingConstants.TOP);
            ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icon/second.png"));
            Image i2 = i1.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            l2 = new JLabel(i3);
            l2.setBounds(60, 140, 159, 152);
            contentPane.add(l2);

            JLabel l3 = new JLabel("");
            ImageIcon i4  = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
            Image i5 = i4.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
            ImageIcon i6 = new ImageIcon(i5);
            l3 = new JLabel(i6);
            l3.setBounds(300, 160, 134, 128);
            contentPane.add(l3);

            JLabel l4 = new JLabel("");
            ImageIcon i7  = new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
            Image i8 = i7.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
            ImageIcon i9 = new ImageIcon(i8);
            l4 = new JLabel(i9);
            l4.setBounds(530, 140, 225, 152);
            contentPane.add(l4);

            b1 = new JButton("Buy Book");
            b1.addActionListener(this);
            b1.setBackground(Color.BLACK);
            b1.setForeground(Color.WHITE);
            b1.setBounds(60, 320, 159, 44);
            contentPane.add(b1);

            b2 = new JButton("Rent Books");
            b2.addActionListener(this);
            b2.setBackground(Color.BLACK);
            b2.setForeground(Color.WHITE);
            b2.setBounds(313, 320, 139, 44);
            contentPane.add(b2);

            b3 = new JButton("Update Your Account");
            b3.addActionListener(this);
            b3.setBackground(Color.BLACK);
            b3.setForeground(Color.WHITE);
            b3.setBounds(562, 320, 167, 44);
            contentPane.add(b3);

            JPanel panel = new JPanel();
            panel.setBorder(new TitledBorder(new LineBorder(new Color(250, 128, 114), 2), "Operation", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(220, 20, 60)));
            panel.setBounds(20, 120, 750, 260);
            panel.setBackground(Color.WHITE);
            contentPane.add(panel);

          

       
            this.addWindowListener(new User.WindowEventHandler());
	}
        
        
        public void actionPerformed(ActionEvent ae){
            String msg = ae.getActionCommand();
            if(msg.equals("Logout")){
                setVisible(false);
                try {
                    ClearSession();
                } catch (IOException ex) {
                    Logger.getLogger(UsersGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    LoginMenuGUI();
                    //new Login_user().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(UsersGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(msg.equals("Exit")){
                System.exit(ABORT);
            
            }else if(msg.equals("Read Me")){
            
            }else if(msg.equals("Block User")){
                setVisible(false);
                new BlockUser().setVisible(true);
	//	new aboutUs().setVisible(true);
            
            }else if(msg.equals("Book Details")){
                setVisible(false);
                try {
                    new BookDetails().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(UsersGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(msg.equals("User Details")){
                setVisible(false);
                try {
                    new UserDetails().setVisible(true);
                    //      new StudentDetails().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(UsersGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
			
            }
            
            if(ae.getSource() == b1){
                this.setVisible(false);
                new BuyBookGUI().setVisible(true);
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
                new RentBookGUI().setVisible(true);
                    //Sold Books
                    //new SoldBooksGUI().setVisible(true);
                    // new Statistics().setVisible(true);
               
            }
            if(ae.getSource() == b3){
                this.setVisible(false);
                try {
                    new UserSettingsGUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(UsersGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(ae.getSource() == b4){
                this.setVisible(false);
           new RemoveBookGUI().setVisible(true);
            }
            if(ae.getSource() == b5){
                this.setVisible(false);
                new ReturnBookGUI().setVisible(true);
            
            }
            if(ae.getSource() == b6){
                this.setVisible(false);
            //    new aboutUs().setVisible(true);
            
            }
            
        }
}