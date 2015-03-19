package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

import model.RoutesModel;

public class RouteFileParser implements Parser<RoutesModel>{
	
	private RoutesModel _route;

	public RouteFileParser() {
		
	}

	@Override
	public RoutesModel parse(String filename) {
		try {
			BufferedReader textReader = new BufferedReader(new FileReader(filename));

			if (!getFileExtension(filename).equals(".txt")){
				System.out.println("Le fichier d'entrée doit être au format .txt");
				System.exit(0);
			}

			Boolean stillReading = true;
			int currentLine = 0;
			while (stillReading) {
				String line = textReader.readLine();
				currentLine++;

				if(Pattern.matches("[$]", line)){
					stillReading = false;
				}
				else{
					String[] splitedLine = line.split("\\t");
					
					if (splitedLine.length < 1 || splitedLine.length > 3) invalidData();
					for (int i = 0; i < splitedLine.length; i++) {
						try {
							Integer.parseInt(splitedLine[i]);
						} catch(Exception e) {
							invalidData();
						}
					}
					
					if(currentLine == 1){
						_route = new RoutesModel(Integer.parseInt(splitedLine[0]));
					}
					else if(currentLine == 2){
						if (Integer.parseInt(splitedLine[0]) > _route.getNbSommet()) invalidData();
						_route.setSommetDepart(Integer.parseInt(splitedLine[0]));
					}
					else{
						if (splitedLine.length < 3) invalidData();
						if (Integer.parseInt(splitedLine[0]) > _route.getNbSommet()) invalidData();
						_route.setPoids(Integer.parseInt(splitedLine[0]), Integer.parseInt(splitedLine[1]), Integer.parseInt(splitedLine[2]));
					}
					
				}
					
			}
			
			textReader.close(); 
			
		} catch (FileNotFoundException e) {
			System.out.println("Fichier introuvable");
		} catch (IOException e) {

		}
		
		return _route;
	}

	private String getFileExtension(String filename) {
	    int lastIndexOf = filename.lastIndexOf(".");
	    if (lastIndexOf == -1) {
	        return ""; // empty extension
	    }
	    return filename.substring(lastIndexOf);
	}
	
	private void invalidData() {
		System.out.println("Données invalide");
		System.exit(0);
	}
}
