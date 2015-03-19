/**
 * Date: 10 Mars 2015
 * Description: À la réception d'un ShortestRouteModel contenant les distances et chemins optimaux, cette
 * 				classe écrit les informations relatives au ShortestRouteModel dans un fichier texte
 * 				afin que les utilisateurs puisse les consulter.
 * 
 * @author Stéphane Lam, Philip Defoy
 */

package writer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import model.ShortestRouteModel;

public class RouteFileWriter implements Writer<ShortestRouteModel>{
	PrintWriter _writer;
	public RouteFileWriter() {	
	}

	@Override
	/**
	 * Date: 10 Mars 2015
	 * Description: Méthode qui écrit les distances optimales dans un fichier texte
	 * 
	 * @param	filename		le path du fichier à créer
	 * @param	output			le modèle qui contient les distances et routes optimales
	 * 
	 * @author Stéphane Lam, Philip Defoy
	 */
	public void write(String filename, ShortestRouteModel output) throws FileNotFoundException, UnsupportedEncodingException {
		_writer = new PrintWriter(filename, "UTF-8");
		try {
			_writer.println(output.getStartPoint());
		
			for (int i = 1; i <= output.getNbSommet(); i++) {
				_writer.println(i+"\t"+output.getSommetParent(i)+"\t"+output.getPoids(i));
			}
			
			System.out.println("Fichier de sortie '" +filename+ "' généré : " + filename);
		} catch(Exception e) {
			System.out.println("Aucun fichier de sortie n'a été généré.");
		}
		_writer.close();
	}
}
