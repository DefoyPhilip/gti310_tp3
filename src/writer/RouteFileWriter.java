/**
 * Date: 10 Mars 2015
 * Description: � la r�ception d'un ShortestRouteModel contenant les distances et chemins optimaux, cette
 * 				classe �crit les informations relatives au ShortestRouteModel dans un fichier texte
 * 				afin que les utilisateurs puisse les consulter.
 * 
 * @author St�phane Lam, Philip Defoy
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
	 * Description: M�thode qui �crit les distances optimales dans un fichier texte
	 * 
	 * @param	filename		le path du fichier � cr�er
	 * @param	output			le mod�le qui contient les distances et routes optimales
	 * 
	 * @author St�phane Lam, Philip Defoy
	 */
	public void write(String filename, ShortestRouteModel output) throws FileNotFoundException, UnsupportedEncodingException {
		_writer = new PrintWriter(filename, "UTF-8");
		try {
			_writer.println(output.getStartPoint());
		
			for (int i = 1; i <= output.getNbSommet(); i++) {
				_writer.println(i+"\t"+output.getSommetParent(i)+"\t"+output.getPoids(i));
			}
			
			System.out.println("Fichier de sortie '" +filename+ "' g�n�r� : " + filename);
		} catch(Exception e) {
			System.out.println("Aucun fichier de sortie n'a �t� g�n�r�.");
		}
		_writer.close();
	}
}
