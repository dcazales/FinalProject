import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Writer {
	//Textfile
		public static boolean writeMembersToTextFile(String filename, 
			    ArrayList<Movie> movies) {
			        try {
			        	 
			            PrintWriter pw = new PrintWriter(new BufferedWriter(
			                new FileWriter(filename)));
			            for (Movie movie: movies) {
			                pw.println(movie);
			            }
			            pw.close();
			            return true;
			        	} catch (Exception ex) {
			        	System.out.println("Could not write it.");
			            return false;
			        }
			    }
}
