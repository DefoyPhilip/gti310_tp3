package parser;

import java.io.BufferedReader;
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
					if(currentLine == 1){
						_route = new RoutesModel(Integer.parseInt(splitedLine[0]));
					}
					else if(currentLine == 2){
						_route.setSommetDepart(Integer.parseInt(splitedLine[0]));
					}
					else{
						_route.setPoids(Integer.parseInt(splitedLine[0]), Integer.parseInt(splitedLine[1]), Integer.parseInt(splitedLine[2]));
					}
					
				}
					
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return _route;
	}

}
