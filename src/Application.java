import Models.RoutesModel;
import Models.ShortestRoutesModel;
import parser.RouteFileParser;
import solver.RouteSolver;
import solver.Solver;



/**
 * The Application class defines a template method to call the elements to
 * solve the problem Unreal-Networks is faï¿½ï¿½ï¿½ing.
 * 
 * @author François Caron <francois.caron.7@ens.etsmtl.ca>
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
		RouteFileParser rfp = new RouteFileParser();
		Solver<RoutesModel, ShortestRoutesModel> rs = new RouteSolver();
		rs.solve(rfp.parse(args[0]));
		
	}
}
