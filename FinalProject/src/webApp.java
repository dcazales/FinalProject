
import java.util.Scanner;
import java.net.URL;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Writer;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 
/**
 * 
 * @author Diana.Cazales
 * Interface class where the windows, textbox, buttons and menus are drawn.
 *
 */
public class webApp extends JFrame {
    
    public void setupMenu() {
    	//Creating the menus
        JMenuBar mbar = new JMenuBar();
        JMenu mnuFile = new JMenu("File");        
        JMenuItem miExit = new JMenuItem("Exit");
        //First Menu. implementing the action on what they will do when clicked
        miExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        //Second Menu
        JMenu mnuHelp = new JMenu("Help");
        JMenuItem miAbout = new JMenuItem("About");
        miAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(null,"Something smart goes here");
                }            
        });
        //Adding everything we just created into the window. So they can actually appear.
        mnuFile.add(miExit);
        mbar.add(mnuFile);
        mbar.add(mnuHelp);
        mnuHelp.add(miAbout);
        setJMenuBar(mbar);
    }
    
   //not sure if the void has to be there.  
    public void setupUI() {
        //Creating the window and demensions
        setTitle("Web Scrapper");
        setBounds(100,100,500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //
       
        JPanel panSouth = new JPanel();
        panSouth.setLayout(new FlowLayout());
        JPanel panNorth = new JPanel();
        panNorth.setLayout(new FlowLayout());
        JLabel labelURL = new JLabel("Enter URL:");
        JTextField txtUrl = new JTextField(25); // 30 lower-case m's
        JButton btnFetch = new JButton("Fetch");
        /** the JButton when clicked will take the text in the text field and
         * add it to textToShow.
         */
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        
        
        
        JButton btnJson = new JButton("Save to json");
        btnJson.addActionListener(new ActionListener() {
       	 public void actionPerformed(ActionEvent e) {/*
       	 try {
       	 Reader r = new Reader();
       	 Writer writer = new Writer();
       	 writer.writeToJSON(r.getMovies());
       	 } catch(Exception ex) {
       	 System.out.println("Something went wrong");
       	 		}
       	 	*/}
       	 });
        
        JButton btnText = new JButton("Save to text");
        btnText.addActionListener(new ActionListener() {
	   	 public void actionPerformed(ActionEvent e) {/*
	   	 try {
	   		 //Reader r = new Reader();
	   		 Writer writer = new Writer();
   	 
	   		 writer.writeToText(r.getMovies());
	   	 	} catch(Exception ex) {
	   		 System.out.println("Something went wrong");
   	 		}*/
   	 	}
   	 });
        
        

        //Add it, to physically see it 
        panNorth.add(labelURL);
        panNorth.add(txtUrl);
        panNorth.add(btnFetch);
        panSouth.add(btnText);
        panSouth.add(btnJson);
        
        c.add(panNorth,BorderLayout.NORTH);
        c.add(panSouth,BorderLayout.SOUTH);
               
        JTextArea txt = new JTextArea();
        Font font = new Font ("Monospaced", Font.BOLD,20);
        txt.setFont(font);
        JScrollPane scrollpane = new JScrollPane(txt);
        scrollpane.setPreferredSize(new Dimension(400,300));
        /**Instead of printing in the console like the class example, it will print
        in the window instead. 
        */
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        c.add(scrollpane, BorderLayout.CENTER);
    
    
    
         btnFetch.addActionListener(new ActionListener() {
    	 public void actionPerformed(ActionEvent e) {
    	 String text = labelURL.getText();
    	 Scanner sc = new Scanner(text);
    	 String address = sc.nextLine();
    	 String line;
    	 /**
    	 * @return website content
    	 * if it can not read it
    	 * it will print "Something went wrong."
    	 */
    	 try {
    	 URL link = new URL(address);
    	 Scanner linkscanner = new Scanner(link.openStream());
    	 while (linkscanner.hasNextLine()) {
    	 line = linkscanner.nextLine();
    	 System.out.print(line);
    	 //txt.setText(txt.getText() + line + "\n");
    	 }
    	 linkscanner.close();
    	 } catch (Exception ex) {
    	 ex.printStackTrace();
    	 System.out.println("Something went wrong");
    	 		}
    	 	}
    	 });
    	 setupMenu();
    	 }
    	
    	 
    	 
    	 
    	 
    public webApp() {
        setupUI();
    }
    
    
    public static void main(String[] args) {
          
                webApp demo = new webApp();
                demo.setVisible(true);
    	}
    }
