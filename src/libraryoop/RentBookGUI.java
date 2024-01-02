/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryoop;

import static com.oracle.webservices.internal.api.databinding.DatabindingModeFeature.ID;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import static libraryoop.Borrow.ReadRentedBooks;
import libraryoop.Borrow.RentedBookInfo;
import static libraryoop.Borrow.fileUpdateRentedBooks;

/**
 *
 * @author youse
 */
public class RentBookGUI extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField tISBN;
    private JButton b1, b2;
    JComboBox comboBox;
    private JPanel pane;
    private JFrame frame;

    public RentBookGUI() {
        setBounds(600, 200, 518, 250);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lISBN = new JLabel("Book ISBN");
        lISBN.setForeground(new Color(47, 79, 79));
        lISBN.setFont(new Font("Tahoma", Font.BOLD, 14));
        lISBN.setBounds(40, 51, 140, 22);
        contentPane.add(lISBN);

        tISBN = new JTextField();
        tISBN.setForeground(new Color(47, 79, 79));
        tISBN.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        tISBN.setBounds(169, 54, 198, 20);
        contentPane.add(tISBN);
        tISBN.setColumns(10);

        b1 = new JButton("Buy");
        b1.addActionListener(this);
        b1.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b1.setBounds(102, 90, 130, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b2.setBounds(250, 90, 108, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        contentPane.add(b2);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(138, 43, 226), 2), "Buy Book", TitledBorder.LEADING,
                TitledBorder.TOP, null, new Color(0, 0, 255)));
        panel.setBounds(10, 29, 398, 150);
        contentPane.add(panel);

        panel.setBackground(Color.WHITE);
        contentPane.setBackground(Color.WHITE);
        addWindowListener(new User.WindowEventHandler());

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {
            ArrayList<Books.BookInfo> bookinfo = new ArrayList();
        
                ArrayList<RentedBookInfo> RentedBookInfo = new ArrayList();
            try {
                ReadRentedBooks(RentedBookInfo);
            } catch (IOException ex) {
                Logger.getLogger(RentBookGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            Books b = new Books();
            try {
                b.readBooks(bookinfo);
            } catch (IOException ex) {
                Logger.getLogger(BuyBookGUI.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (int i = 0; i < bookinfo.size(); ++i) {

                Books.BookInfo obj1 = bookinfo.get(i);
                if ((obj1.getISBN()).equals(tISBN.getText())) {
                    bookinfo.get(i);
                    int num1 = Integer.parseInt(bookinfo.get(i).getNumOfCopies());
                    if (num1 <= 0) {
                        JOptionPane.showMessageDialog(null, "there's no copy left");
                        System.out.println("there's no copy left");
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "You have rented the book for 14 days make sure to return it before Due date to avoid getting blocked!");
                        int num = Integer.parseInt(bookinfo.get(i).getNumOfCopies());
                        int newnum = num - 1;
                        String newcopynum = String.valueOf(newnum);
                        bookinfo.get(i).setNumOfCopies(newcopynum);
                        try {
                            Books.fileUpdateBooks(bookinfo);
                        } catch (IOException ex) {
                            Logger.getLogger(BuyBookGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                         SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	//Getting current date
	Calendar cal = Calendar.getInstance();
	//Displaying current date in the desired format
	//System.out.println("Current Date: "+sdf.format(cal.getTime()));
	   
	//Number of Days to add

	//Displaying the new Date after addition of Days to current date

                                    Borrow.RentedBookInfo obj = new Borrow.RentedBookInfo();
                            obj.setID(Loggedin.IDSession);
                            obj.setISBN(tISBN.getText());
                            obj.setRequestDate(sdf.format(cal.getTime()));
                            cal.add(Calendar.DAY_OF_MONTH, 7);  
                            String newDate = sdf.format(cal.getTime());  
                            obj.setDueDate(newDate);
                            RentedBookInfo.add(obj);
                        try {
                            fileUpdateRentedBooks(RentedBookInfo);
                        } catch (IOException ex) {
                            Logger.getLogger(RentBookGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            }

        }
        if (ae.getSource() == b2) {
            this.setVisible(false);
            new UsersGUI().setVisible(true);

        }

    }
}
