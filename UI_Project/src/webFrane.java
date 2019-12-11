
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
public class webFrane {
    public static void main(String[] args) {
		System.out.print("Enter url: ");
        Scanner sc = new Scanner(System.in);
        String address = sc.nextLine();
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
                } 
                
            	 if(line.contains("<td><b><a href=\"/movie/")) {
            		String[] movieLine= line.split(">");
            		movieName = movieLine[3].replace("</b","");
            		System.out.println(movieName);

            	}
            	
            	if(line.contains("href=\"/market/genre/")) {
            		String[] genres= line.split(">");
                	genre = genres[2].replace("</a", "");
            		System.out.println(genre);
            	}
            	 if (line.contains("<td>Theatrical</td>")||(line.contains("<td>Video</td>"))) {
                	videoType = line.replace("<td>", "").replace("</td>", "");
                	System.out.println(videoType);
            	}
            }
            linksc.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Could not connect to the website.");
        }
         
    }
}
