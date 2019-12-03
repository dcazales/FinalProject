import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;  
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 

public class webApp extends JFrame {
    private String textToShow; // this is what the text area will show
    private JTextArea txaWords;  // known throughout the class
    
    public void setupMenu() {
        JMenuBar mbar = new JMenuBar();
        JMenu mnuFile = new JMenu("File");        
        JMenuItem miExit = new JMenuItem("Exit");
        miExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JMenu mnuHelp = new JMenu("Help");
        JMenuItem miAbout = new JMenuItem("About");
        miAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(null,"Something smart goes here");
                }            
        });
        
        mnuFile.add(miExit);
        mbar.add(mnuFile);
        mbar.add(mnuHelp);
        mnuHelp.add(miAbout);
        setJMenuBar(mbar);
    }
    
    
    public void setupUI() {
        textToShow = "";
        setTitle("Web Scrapper");
        setBounds(100,100,500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JPanel panNorth = new JPanel();
        panNorth.setLayout(new FlowLayout());
        JLabel labelURL = new JLabel("Enter text:");
        JTextField txtTextToAdd = new JTextField(25); // 30 lower-case m's
        JButton btnFetch = new JButton("Fetch");
        /* the JButton when clicked will take the text in the text field and
         * add it to textToShow. Then it will to the text area to set its 
         * text to it.
         */
        btnFetch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = txtTextToAdd.getText();
                textToShow = textToShow + "\n" + text;
                txaWords.setText(textToShow);
            }
        });
        setupMenu();
        JPanel panSouth = new JPanel();
        panSouth.setLayout(new FlowLayout());
        JButton btnJson = new JButton("Save to json");
        JButton btnText = new JButton("Save to text");

        panNorth.add(labelURL);
        panNorth.add(txtTextToAdd);
        panNorth.add(btnFetch);
        panSouth.add(btnText);
        panSouth.add(btnJson);
        c.add(panNorth,BorderLayout.NORTH);
        c.add(panSouth,BorderLayout.SOUTH);
        txaWords = new JTextArea();
        txaWords.setEditable(false);
        c.add(txaWords,BorderLayout.CENTER);
        
        
    }
    public webApp() {
        setupUI();
    }
    public static void main(String[] args) {
        webApp demo = new webApp();
        demo.setVisible(true);
    }
}