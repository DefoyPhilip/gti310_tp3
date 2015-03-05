package parser;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.regex.Pattern;

public class RouteFileParser implements Parser<Object>{

	public RouteFileParser() {
	}

	@Override
	public Object parse(String filename) {
		try {
			FileReader reader = new FileReader(filename);
			BufferedReader textReader = new BufferedReader(reader);
			Boolean stillReading = true;
			while (stillReading) {
				String line = textReader.readLine();
				if(Pattern.matches("[$]", line)){
					stillReading = false;
				}
				else{
					String[] splitedLine = line.split("\\t");
					for (int i = 0; i < splitedLine.length; i++) {
						System.out.println(splitedLine[i]);
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
		
		return null;
	}

}
