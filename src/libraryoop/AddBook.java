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
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddBook extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField tTitle,tISBN,tAuthor,tPrice,tNumOfCopies,tGenre,tLocation;
    private JButton b1,b2;
    JComboBox comboBox;
        

    public AddBook() {
        setBounds(600, 200, 518, 442);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel lISBN = new JLabel("ISBN");
	lISBN.setForeground(new Color(47, 79, 79));
	lISBN.setFont(new Font("Tahoma", Font.BOLD, 14));
	lISBN.setBounds(40, 51, 140, 22);
	contentPane.add(lISBN);

	JLabel lTitle = new JLabel("Title");
	lTitle.setForeground(new Color(47, 79, 79));
	lTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
	lTitle.setBounds(40, 84, 140, 22);
	contentPane.add(lTitle);        

	JLabel lGenre = new JLabel("Genre");
	lGenre.setForeground(new Color(47, 79, 79));
	lGenre.setFont(new Font("Tahoma", Font.BOLD, 14));
	lGenre.setBounds(40, 117, 140, 22);
	contentPane.add(lGenre);        
        
	JLabel lAuthor = new JLabel("Author");
	lAuthor.setForeground(new Color(47, 79, 79));
	lAuthor.setFont(new Font("Tahoma", Font.BOLD, 14));
	lAuthor.setBounds(40, 150, 140, 22);
	contentPane.add(lAuthor);
        

	JLabel lLocation = new JLabel("Location");
	lLocation.setForeground(new Color(47, 79, 79));
	lLocation.setFont(new Font("Tahoma", Font.BOLD, 14));
	lLocation.setBounds(40, 183, 140, 22);
	contentPane.add(lLocation);
        
        

	JLabel lPrice = new JLabel("Price");
	lPrice.setForeground(new Color(47, 79, 79));
	lPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
	lPrice.setBounds(40, 216, 140, 22);
	contentPane.add(lPrice);

	JLabel lNumberOfCopies = new JLabel("Number Of Copies");
	lNumberOfCopies.setForeground(new Color(47, 79, 79));
	lNumberOfCopies.setFont(new Font("Tahoma", Font.BOLD, 14));
	lNumberOfCopies.setBounds(40, 249, 140, 22);
	contentPane.add(lNumberOfCopies);


	tISBN = new JTextField();
	tISBN.setForeground(new Color(47, 79, 79));
	tISBN.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	tISBN.setBounds(169, 54, 198, 20);
	contentPane.add(tISBN);
	tISBN.setColumns(10);
        
        
	tTitle = new JTextField();
	tTitle.setForeground(new Color(47, 79, 79));
	tTitle.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	tTitle.setColumns(10);
	tTitle.setBounds(169, 87, 198, 20);
	contentPane.add(tTitle);
        


        
        
        
	tLocation = new JTextField();
	tLocation.setForeground(new Color(47, 79, 79));
	tLocation.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	tLocation.setColumns(10);
	tLocation.setBounds(169, 186, 194, 20);
	contentPane.add(tLocation);

	tGenre = new JTextField();
	tGenre.setForeground(new Color(47, 79, 79));
	tGenre.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	tGenre.setColumns(10);
	tGenre.setBounds(169, 120, 198, 20);
	contentPane.add(tGenre);
        
        
                
	tNumOfCopies = new JTextField();
	tNumOfCopies.setForeground(new Color(47, 79, 79));
	tNumOfCopies.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	tNumOfCopies.setColumns(10);
	tNumOfCopies.setBounds(169, 252, 198, 20);
	contentPane.add(tNumOfCopies);

	tAuthor = new JTextField();
	tAuthor.setForeground(new Color(47, 79, 79));
	tAuthor.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	tAuthor.setColumns(10);
	tAuthor.setBounds(169, 153, 198, 20);
	contentPane.add(tAuthor);

        tPrice = new JTextField();
	tPrice.setForeground(new Color(47, 79, 79));
	tPrice.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	tPrice.setColumns(10);
	tPrice.setBounds(169, 219, 198, 20);
	contentPane.add(tPrice);




        


        b1 = new JButton("Add");
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
	panel.setBounds(10, 29, 398, 344);
	contentPane.add(panel);
        
        panel.setBackground(Color.WHITE);
        contentPane.setBackground(Color.WHITE);
        addWindowListener(new User.WindowEventHandler());


    }
    
    public void actionPerformed(ActionEvent ae){
        //,,,,,,;
    

            if(ae.getSource() == b1){
                    String Title = tTitle.getText();
            String ISBN = tISBN.getText();
            String Author = tAuthor.getText();
            String Price = tPrice.getText();
            String NumOfCopies = tNumOfCopies.getText();
            String Genre = tGenre.getText();
            String Location = tLocation.getText();
                        ArrayList bookinfo = new ArrayList<>();
        Books b = new Books();
                try {
                    b.readBooks(bookinfo);
                } catch (IOException ex) {
                    Logger.getLogger(AddBook.class.getName()).log(Level.SEVERE, null, ex);
                }
                Books.BookInfo obj = new Books.BookInfo();
                
                              
                
                obj.setISBN(ISBN);
              
            
                obj.setTitle(Title);
               
                
                obj.setAuthor(Author);
             
             
                obj.setLocation(Location);
                
            
                obj.setNumOfCopies(NumOfCopies);
              
            
                obj.setGenre(Genre);
               
                double FixedPrice = 0;
                try {
                    FixedPrice = Double.parseDouble(Price);
                } catch (NumberFormatException numberFormatException) {
                }
                obj.setPrice(FixedPrice);
                obj.setRent(false);
                
                  if (Title.equals("") || ISBN.equals("") || Author.equals("") || Price.equals("") || NumOfCopies.equals("") || Genre.equals("") || Location.equals("")) {
                        JOptionPane.showMessageDialog(null, "Don't leave any field empty!");
                    } else {
                      JOptionPane.showMessageDialog(null, "Book added!");
                this.setVisible(false);
		
                bookinfo.add(obj);
                new ReadersGUI().setVisible(true);
                  }/// adding every user at the array list;
            try {
                b.fileUpdateBooks(bookinfo);
            } catch (IOException ex) {
                Logger.getLogger(AddBook.class.getName()).log(Level.SEVERE, null, ex);
            }
                

            }
            if(ae.getSource() == b2){
                this.setVisible(false);
		new ReadersGUI().setVisible(true);

            }
    

    }
}
