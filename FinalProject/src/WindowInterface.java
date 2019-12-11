
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
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
  * Linked that was used: https://www.the-numbers.com/movies/year/2020
  * ideally, the window should have a scroll bar if the data cannot fit. 
  * @author Diana.Cazales
  *
  */
public class WindowInterface extends JFrame {
    private String textToShow; // this is what the text area will show
    private JTextArea txaWords;  // known throughout the class
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
            	JOptionPane.showMessageDialog(null,"Ideally, the window had to display the internet\n"
            			+ "data from:\n https://www.the-numbers.com/movies/year/2020");
                }            
        });
        //Adding everything we just created into the window. So they can actually appear.
        mnuFile.add(miExit);
        mbar.add(mnuFile);
        mbar.add(mnuHelp);
        mnuHelp.add(miAbout);
        setJMenuBar(mbar);
    }
    
    
  // Panel Stuff Begin  
    public void setupUI() {
    	setupMenu();
        textToShow = "";
        setTitle("WEB SCRAPPER");
        setBounds(200,100,500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JPanel panNorth = new JPanel();
        panNorth.setLayout(new FlowLayout());
        
        
        //Bottom
        JPanel panSouth = new JPanel();
        panSouth.setLayout(new FlowLayout());
        
        //TOP PANNEL
        JLabel url = new JLabel("Enter URL");
        JTextField txtTextToAdd = new JTextField(20); // 30 lower-case m's
        
        //Buttons
        JButton btnAddText = new JButton("Fetch");
        btnAddText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String address = txtTextToAdd.getText();
                
                
                String line;
                try {
                    URL link = new URL(address);
                    Scanner linksc = new Scanner(link.openStream());
                    ArrayList<Movie> movies = new ArrayList<Movie>();
                    String title,movieName,genre,videoType;

                    while (linksc.hasNextLine()) {

                        line = linksc.nextLine();
                        
                        //System.out.println(line);
                        
                    	if (line.contains("<title>")) {
                        	title =  line.replace("<title>", "").replace("</title>", "");
                        	textToShow = textToShow + " "  + title +" "+ "\n \n";
                            txaWords.setText(textToShow);

                        } 
                        
                    	 if(line.contains("<td><b><a href=\"/movie/")) {
                    		String[] movieLine= line.split(">");
                    		movieName = movieLine[3].replace("</b","");
                    		textToShow = textToShow + "Movie Name: "  + movieName +"\n";
                            txaWords.setText(textToShow);
                    		

                    	}
                    	
                    	if(line.contains("href=\"/market/genre/")) {
                    		String[] genres= line.split(">");
                        	genre = genres[2].replace("</a", "");
                    		textToShow = textToShow + " Genre: "  + genre +" ";
                            txaWords.setText(textToShow);
                    	}
                    	 if (line.contains("<td>Theatrical</td>")||(line.contains("<td>Video</td>"))) {
                        	videoType = line.replace("<td>", "").replace("</td>", "");
                        	textToShow = textToShow + "Video Release: "  + videoType+ "\n\n";
                            txaWords.setText(textToShow);
                    	}
                    	 
                    }
                    linksc.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("Could not connect to the website.");
                }
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
            }
        });
        
        //BOTTOM BUTTONS
        JButton btnJson = new JButton("Save to json");
        btnJson.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//files.writeMoviesToTextFile(movies);
            }
        });
       
        
        JButton btnText = new JButton("Save to text");
        btnText.addActionListener(new ActionListener() {
	   	 public void actionPerformed(ActionEvent e) {
        		//files.writeMoviesToTextFile(movies);
   	 	}
   	 });
      
        //TOP PANEL
        panNorth.add(url);
        panNorth.add(txtTextToAdd);
        panNorth.add(btnAddText);
        c.add(panNorth,BorderLayout.NORTH);
        txaWords = new JTextArea();
        txaWords.setEditable(false);
        c.add(txaWords,BorderLayout.CENTER);
        //Buttom Pannel
        c.add(panSouth,BorderLayout.SOUTH);
        panSouth.add(btnText);
        panSouth.add(btnJson);
        
        Font font = new Font ("Monospaced", Font.PLAIN,15);
        txaWords.setFont(font);
        JScrollPane scrollpane = new JScrollPane(txaWords);
        scrollpane.setPreferredSize(new Dimension(400,300));
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        c.add(scrollpane, BorderLayout.CENTER);
        

        
      
        
    }
    public WindowInterface() {
        setupUI();
    }
    public static void main(String[] args) {
        WindowInterface demo = new WindowInterface();
        demo.setVisible(true);
    }
}