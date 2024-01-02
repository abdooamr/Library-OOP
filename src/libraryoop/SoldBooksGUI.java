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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import static libraryoop.Loggedin.ClearSession;

/**
 *
 * @author youse
 */
public class SoldBooksGUI extends JFrame implements ActionListener {

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

    private JButton b1, b2, b3;
    private DefaultTableModel listTableModel;
    Choice c1;

    static Object[][] rowData = {};
    private static final Object[] columnNames = {"Book ISBN", "User ID", "Purchase date"};

    public SoldBooksGUI() throws IOException {
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
        ArrayList<Purchase.SoldBookInfo> soldbooksarr = new ArrayList();

        Purchase.ReadSoldBooks(soldbooksarr);
                        listTableModel = new DefaultTableModel(rowData, columnNames);
                for (int i = 0; i < soldbooksarr.size(); ++i) {
                     Purchase.SoldBookInfo obj = soldbooksarr.get(i);
                    
                    while (true) {
                      
                            soldbooksarr.get(i);
                            //First Name", "Last Name","ID","Address","Cell Phone","Email"};
                            String rowString = obj.getISBN();
                            String lname = obj.getID();
                            String uid = obj.getID();
                            String uaddress = obj.getRequestDate();
                  
                            listTableModel.addRow(new Object[]{rowString, lname, uid, uaddress});
                            //   System.out.println("ID:" + obj.getISBN() + " Title:" + obj.getTitle() + " Author:" + obj.getAuthor() + " Location:" + obj.getLocation() + " Number of copies:" + obj.getNumOfCopies() + " Genre:" + obj.getGenre() + " Price:" + obj.getPrice());
                           
                            break;
                        }
                    }
                
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


        JLabel l1 = new JLabel("Sold Books Details");
        l1.setForeground(new Color(107, 142, 35));
        l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
        l1.setBounds(300, 15, 400, 47);
        contentPane.add(l1);





        JLabel l3 = new JLabel("Back");
        l3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new ReadersGUI().setVisible(true);
            }
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


    }
}
