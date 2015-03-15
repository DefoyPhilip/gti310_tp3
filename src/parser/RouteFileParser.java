package parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import Models.RoutesModel;

public class RouteFileParser implements Parser<Object>{

	public RouteFileParser() {
	}

	@Override
	public RoutesModel parse(String filename) {
		
		RoutesModel routesModel;
		
		try {
			FileReader reader = new FileReader(filename);
			BufferedReader textReader = new BufferedReader(reader);
			Boolean stillReading = true;
			int currentLine = 0;
			routesModel = new RoutesModel();
			
			while (stillReading) {
				String line = textReader.readLine();

				// the first line contains the number of vertexes
				// so we can create the matrix
				if (currentLine == 0){
					routesModel.init(Integer.parseInt(line));
				}
				
				// check for end of document
				if(Pattern.matches("[$]", line)){
					stillReading = false;
				}
				
				// if not end of document
				else{
					String[] splitedLine = line.split("\\t");
						
					// the second line contains the information
					// for the first vertex to itself
					if (currentLine == 1 ) {
						routesModel.addVertex(Integer.parseInt(splitedLine[0]));
						routesModel.setStartingVertex(Integer.parseInt(splitedLine[0]));
						
					// for all the other vertexes
					} else {
						if (splitedLine.length == 3){
							routesModel.addEdge(Integer.parseInt(splitedLine[0]), 
										Integer.parseInt(splitedLine[1]), 
										Integer.parseInt(splitedLine[2]));
						}
	
					}
				}
				currentLine++;
			}
			
			textReader.close();
			
			//routesModel.print();
			
			return routesModel;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
