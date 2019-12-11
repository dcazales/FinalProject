import java.util.ArrayList;
import java.util.Scanner;
import java.lang.reflect.Array;
import java.net.URL;

public class InternetScrapper {
	
/**
 * Linked that was used: https://www.the-numbers.com/movies/year/2020
 * @author Diana.Cazales
 *Not sure how to add the data so we can create an object.
 *
 */
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
            		System.out.println(title);

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
