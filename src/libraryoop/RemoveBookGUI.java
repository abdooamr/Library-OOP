/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryoop;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
public class RemoveBookGUI extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField tISBN;
    private JButton b1,b2;
    JComboBox comboBox;
        

    public RemoveBookGUI() {
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
        
        




        


        b1 = new JButton("Remove Book");
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
	panel.setBorder(new TitledBorder(new LineBorder(new Color(138, 43, 226), 2), "Remove Book", TitledBorder.LEADING,
			TitledBorder.TOP, null, new Color(0, 0, 255)));
	panel.setBounds(10, 29, 398, 150);
	contentPane.add(panel);
        
        panel.setBackground(Color.WHITE);
        contentPane.setBackground(Color.WHITE);
addWindowListener(new User.WindowEventHandler());

    }
    
    public void actionPerformed(ActionEvent ae){
        //,,,,,,;
    

            if(ae.getSource() == b1){
                    ArrayList<Books.BookInfo> bookarr=new ArrayList();
           String ISBN = tISBN.getText();
                try {
                    Books.readBooks(bookarr);
                } catch (IOException ex) {
                    Logger.getLogger(RemoveBookGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                Books.RemoveBook(ISBN, bookarr);
                try {
                    Books.fileUpdateBooks(bookarr);
                } catch (IOException ex) {
                    Logger.getLogger(RemoveBookGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
      
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
		new ReadersGUI().setVisible(true);

            }
    

    }
}