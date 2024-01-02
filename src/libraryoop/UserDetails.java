/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryoop;

/**
 *
 * @author youse
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import static libraryoop.Loggedin.ClearSession;

public class UserDetails extends JFrame implements ActionListener {

    static class WindowEventHandler extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent evt) {

            try {
                ClearSession();
            } catch (IOException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    private JPanel contentPane;
    private JTable table;
    private JTextField search;
    private JButton b1, b2, b3;
    private DefaultTableModel listTableModel;
    Choice c1;

    static Object[][] rowData = {};
    private static final Object[] columnNames = {"First Name", "Last Name", "ID", "Address", "Cell Phone", "Email"};

    public UserDetails() throws IOException {
        setBounds(350, 200, 890, 475);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(79, 133, 771, 282);
        contentPane.add(scrollPane);

        //  ArrayList bookinfo = new ArrayList<>();
        ArrayList<Books.BookInfo> bookarr = new ArrayList();

        Books.readBooks(bookarr);
//                boolean found = false;
//        for (int i = 0; i < list.size(); ++i) {
//            Books.BookInfo obj = list.get(i);
//            while ((obj.getGenre()).equals("Genr1")) {
//                if ((obj.getGenre()).equals("Genr1")) {
//                    list.get(i);
//                    System.out.println("ID:" + obj.getISBN() + " Title:" + obj.getTitle() + " Author:" + obj.getAuthor() + " Location:" + obj.getLocation() + " Number of copies:" + obj.getNumOfCopies() + " Genre:" + obj.getGenre() + " Price:" + obj.getPrice());
//                    found = true;
//                    break;
//                }
//            }
//        }
//        if (!found) {
//            System.out.println("Book not found");
//        }
//  DefaultTableModel listTableModel;

//    for (int i = 1; i < 25; i++) {
//        String rowString = "Quiz #" + i;
//        listTableModel.addRow(new Object[]{rowString, i, i, i,i,i,i});
//    }
        // Column Names
        //   String[] columnNames = { "ISBN", "Title", "Author", "Location","Number of Copies","Genre","Price"};
        table = new JTable(listTableModel);
//	table.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent arg0) {
//                int row = table.getSelectedRow();
//		search.setText(table.getModel().getValueAt(row, 1).toString());
//            }
//	});
        table.setBackground(new Color(240, 248, 255));
        table.setForeground(Color.DARK_GRAY);
        table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        scrollPane.setViewportView(table);

        b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setBorder(new LineBorder(new Color(255, 20, 147), 2, true));
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/eight.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b1.setIcon(i3);
        b1.setForeground(new Color(199, 21, 133));
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        b1.setBounds(564, 89, 138, 33);
        contentPane.add(b1);

        JLabel l1 = new JLabel("User Details");
        l1.setForeground(new Color(107, 142, 35));
        l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
        l1.setBounds(300, 15, 400, 47);
        contentPane.add(l1);

        c1 = new Choice();
        c1.add("FirstName");
        c1.add("LastName");
        c1.add("ID");
        c1.add("Cellphone");
        c1.add("Email");
        c1.add("Address");

        c1.setBounds(712, 89, 138, 33);
        contentPane.add(c1);

        search = new JTextField();
        search.setBackground(new Color(255, 240, 245));
        search.setBorder(new LineBorder(new Color(255, 105, 180), 2, true));
        search.setForeground(new Color(47, 79, 79));
        search.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
        search.setBounds(189, 89, 357, 33);
        contentPane.add(search);
        search.setColumns(10);

        JLabel l3 = new JLabel("Back");
        l3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
				setVisible(false);
//				new ReadersGUI().setVisible(true);
        ArrayList<User.userInfo> usersarr = new ArrayList();
                            try {
                                //  ArrayList<Books.BookInfo> bookarr=new ArrayList();
                                User.ReadUsers(usersarr);
                            } catch (IOException ex) {
                                Logger.getLogger(BookDetails.class.getName()).log(Level.SEVERE, null, ex);
                            }
                                     Loggedin l = new Loggedin();
    String UserFname = l.fnameSession;
     String UserLname = l.lnameSession;
     String IDUser = l.IDSession;
     String isAdmin ;
     
             for (int i = 0; i < usersarr.size(); ++i) {

            User.userInfo user = usersarr.get(i);

            if ((user.getID()).equals(IDUser)) {
                usersarr.get(i);
                System.out.println("ID:" + user.getID() + " First name:" + user.getFirstName() + " Last name:" + user.getLasttName()
                        + " Address:" + user.getAdress() + " Phone:" + user.getCellPhone() + " Email:" + user.getEmail() + " Blocked:" + user.getIsBlocked());
                if(user.getIsadmin()==true)
                { new ReadersGUI().setVisible(true);  
                }
                
                else if(user.getIsadmin()==false)
                {   new UsersGUI().setVisible(true);
                        }
            }

        }}
        });
        l3.setForeground(Color.GRAY);
        l3.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/tenth.png"));
        Image i8 = i7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        l3.setIcon(i9);
        l3.setBounds(97, 89, 72, 33);
        contentPane.add(l3);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 128), 3, true), "Book-Details",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
        panel.setBounds(67, 54, 793, 368);
        contentPane.add(panel);
        panel.setBackground(Color.WHITE);
        addWindowListener(new User.WindowEventHandler());

    }

    public void actionPerformed(ActionEvent ae) {

        //       conn con = new conn();
        if (ae.getSource() == b1) {
            String searchmeth = c1.getSelectedItem();
            if (searchmeth.equals("ID")) {
                ArrayList<User.userInfo> usersarr = new ArrayList();

                try {
                    User.ReadUsers(usersarr);
                } catch (IOException ex) {
                    Logger.getLogger(BookDetails.class.getName()).log(Level.SEVERE, null, ex);
                }
                listTableModel = new DefaultTableModel(rowData, columnNames);
                for (int i = 0; i < usersarr.size(); ++i) {
                    User.userInfo obj = usersarr.get(i);
                    boolean found = false;
                    while ((obj.getID()).equals(search.getText())) {
                        if ((obj.getID()).equals(search.getText())) {
                            usersarr.get(i);
                            //First Name", "Last Name","ID","Address","Cell Phone","Email"};
                            String rowString = obj.getFirstName();
                            String lname = obj.getLasttName();
                            String uid = obj.getID();
                            String uaddress = obj.getAdress();
                            String ucell = obj.getCellPhone();

                            String Pricefixx = obj.getEmail();
                            listTableModel.addRow(new Object[]{rowString, lname, uid, uaddress, ucell, Pricefixx});
                            //   System.out.println("ID:" + obj.getISBN() + " Title:" + obj.getTitle() + " Author:" + obj.getAuthor() + " Location:" + obj.getLocation() + " Number of copies:" + obj.getNumOfCopies() + " Genre:" + obj.getGenre() + " Price:" + obj.getPrice());
                            found = true;
                            break;
                        }
                    }
                }

                table.setModel(listTableModel);

            }
            if (searchmeth.equals("FirstName")) {
                ArrayList<User.userInfo> usersarr = new ArrayList();

                try {
                    User.ReadUsers(usersarr);
                } catch (IOException ex) {
                    Logger.getLogger(BookDetails.class.getName()).log(Level.SEVERE, null, ex);
                }
                listTableModel = new DefaultTableModel(rowData, columnNames);
                for (int i = 0; i < usersarr.size(); ++i) {
                    User.userInfo obj = usersarr.get(i);
                    boolean found = false;
                    while ((obj.getFirstName()).equals(search.getText())) {
                        if ((obj.getFirstName()).equals(search.getText())) {
                            usersarr.get(i);
                            //First Name", "Last Name","ID","Address","Cell Phone","Email"};
                            String rowString = obj.getFirstName();
                            String lname = obj.getLasttName();
                            String uid = obj.getID();
                            String uaddress = obj.getAdress();
                            String ucell = obj.getCellPhone();

                            String Pricefixx = obj.getEmail();
                            listTableModel.addRow(new Object[]{rowString, lname, uid, uaddress, ucell, Pricefixx});
                            //   System.out.println("ID:" + obj.getISBN() + " Title:" + obj.getTitle() + " Author:" + obj.getAuthor() + " Location:" + obj.getLocation() + " Number of copies:" + obj.getNumOfCopies() + " Genre:" + obj.getGenre() + " Price:" + obj.getPrice());
                            found = true;
                            break;
                        }
                    }
                }

                table.setModel(listTableModel);

            }
            if (searchmeth.equals("LastName")) {
                ArrayList<User.userInfo> usersarr = new ArrayList();

                try {
                    User.ReadUsers(usersarr);
                } catch (IOException ex) {
                    Logger.getLogger(BookDetails.class.getName()).log(Level.SEVERE, null, ex);
                }
                listTableModel = new DefaultTableModel(rowData, columnNames);
                for (int i = 0; i < usersarr.size(); ++i) {
                    User.userInfo obj = usersarr.get(i);
                    boolean found = false;
                    while ((obj.getLasttName()).equals(search.getText())) {
                        if ((obj.getLasttName()).equals(search.getText())) {
                            usersarr.get(i);
                            //First Name", "Last Name","ID","Address","Cell Phone","Email"};
                            String rowString = obj.getFirstName();
                            String lname = obj.getLasttName();
                            String uid = obj.getID();
                            String uaddress = obj.getAdress();
                            String ucell = obj.getCellPhone();

                            String Pricefixx = obj.getEmail();
                            listTableModel.addRow(new Object[]{rowString, lname, uid, uaddress, ucell, Pricefixx});
                            //   System.out.println("ID:" + obj.getISBN() + " Title:" + obj.getTitle() + " Author:" + obj.getAuthor() + " Location:" + obj.getLocation() + " Number of copies:" + obj.getNumOfCopies() + " Genre:" + obj.getGenre() + " Price:" + obj.getPrice());
                            found = true;
                            break;
                        }
                    }
                }

                table.setModel(listTableModel);

            }

            if (searchmeth.equals("Cellphone")) {
                ArrayList<User.userInfo> usersarr = new ArrayList();

                try {
                    User.ReadUsers(usersarr);
                } catch (IOException ex) {
                    Logger.getLogger(BookDetails.class.getName()).log(Level.SEVERE, null, ex);
                }
                listTableModel = new DefaultTableModel(rowData, columnNames);
                for (int i = 0; i < usersarr.size(); ++i) {
                    User.userInfo obj = usersarr.get(i);
                    boolean found = false;
                    while ((obj.getCellPhone()).equals(search.getText())) {
                        if ((obj.getCellPhone()).equals(search.getText())) {
                            usersarr.get(i);
                            //First Name", "Last Name","ID","Address","Cell Phone","Email"};
                            String rowString = obj.getFirstName();
                            String lname = obj.getLasttName();
                            String uid = obj.getID();
                            String uaddress = obj.getAdress();
                            String ucell = obj.getCellPhone();

                            String Pricefixx = obj.getEmail();
                            listTableModel.addRow(new Object[]{rowString, lname, uid, uaddress, ucell, Pricefixx});
                            //   System.out.println("ID:" + obj.getISBN() + " Title:" + obj.getTitle() + " Author:" + obj.getAuthor() + " Location:" + obj.getLocation() + " Number of copies:" + obj.getNumOfCopies() + " Genre:" + obj.getGenre() + " Price:" + obj.getPrice());
                            found = true;
                            break;
                        }
                    }
                }

                table.setModel(listTableModel);

            }
            if (searchmeth.equals("Email")) {
                ArrayList<User.userInfo> usersarr = new ArrayList();

                try {
                    User.ReadUsers(usersarr);
                } catch (IOException ex) {
                    Logger.getLogger(BookDetails.class.getName()).log(Level.SEVERE, null, ex);
                }
                listTableModel = new DefaultTableModel(rowData, columnNames);
                for (int i = 0; i < usersarr.size(); ++i) {
                    User.userInfo obj = usersarr.get(i);
                    boolean found = false;
                    while ((obj.getEmail()).equals(search.getText())) {
                        if ((obj.getEmail()).equals(search.getText())) {
                            usersarr.get(i);
                            //First Name", "Last Name","ID","Address","Cell Phone","Email"};
                            String rowString = obj.getFirstName();
                            String lname = obj.getLasttName();
                            String uid = obj.getID();
                            String uaddress = obj.getAdress();
                            String ucell = obj.getCellPhone();

                            String Pricefixx = obj.getEmail();
                            listTableModel.addRow(new Object[]{rowString, lname, uid, uaddress, ucell, Pricefixx});
                            //   System.out.println("ID:" + obj.getISBN() + " Title:" + obj.getTitle() + " Author:" + obj.getAuthor() + " Location:" + obj.getLocation() + " Number of copies:" + obj.getNumOfCopies() + " Genre:" + obj.getGenre() + " Price:" + obj.getPrice());
                            found = true;
                            break;
                        }
                    }
                }

                table.setModel(listTableModel);

            }
                        if (searchmeth.equals("Address")) {
                ArrayList<User.userInfo> usersarr = new ArrayList();

                try {
                    User.ReadUsers(usersarr);
                } catch (IOException ex) {
                    Logger.getLogger(BookDetails.class.getName()).log(Level.SEVERE, null, ex);
                }
                listTableModel = new DefaultTableModel(rowData, columnNames);
                for (int i = 0; i < usersarr.size(); ++i) {
                    User.userInfo obj = usersarr.get(i);
                    boolean found = false;
                    while ((obj.getAdress()).equals(search.getText())) {
                        if ((obj.getAdress()).equals(search.getText())) {
                            usersarr.get(i);
                            //First Name", "Last Name","ID","Address","Cell Phone","Email"};
                            String rowString = obj.getFirstName();
                            String lname = obj.getLasttName();
                            String uid = obj.getID();
                            String uaddress = obj.getAdress();
                            String ucell = obj.getCellPhone();

                            String Pricefixx = obj.getEmail();
                            listTableModel.addRow(new Object[]{rowString, lname, uid, uaddress, ucell, Pricefixx});
                            //   System.out.println("ID:" + obj.getISBN() + " Title:" + obj.getTitle() + " Author:" + obj.getAuthor() + " Location:" + obj.getLocation() + " Number of copies:" + obj.getNumOfCopies() + " Genre:" + obj.getGenre() + " Price:" + obj.getPrice());
                            found = true;
                            break;
                        }
                    }
                }

                table.setModel(listTableModel);

            }

        }

    }
}

