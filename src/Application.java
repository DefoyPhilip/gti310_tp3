import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import parser.RouteFileParser;
import solver.RouteSolver;
import writer.RouteFileWriter;



/**
 * The Application class defines a template method to call the elements to
 * solve the problem Unreal-Networks is fa���ing.
 * 
 * @author Fran���ois Caron <francois.caron.7@ens.etsmtl.ca>
 */
public class Application {

	/**
	 * The Application's entry point.
	 * 
	 * The main method makes a series of calls to find a solution to the
	 * problem. The program awaits two arguments, the complete path to the
	 * input file, and the complete path to the output file.
	 * 
	 * @param args The array containing the arguments to the files.
	 */
	public static void main(String args[]) {
		System.out.println("Unreal Networks Solver !");
		RouteFileWriter writer = new RouteFileWriter();
		try {
			writer.write(args[1], new RouteSolver().solve(new RouteFileParser().parse(args[0])));
		} catch (FileNotFoundException e) {
			System.out.println("Fichier introuvable");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
