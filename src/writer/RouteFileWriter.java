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
	public void write(String filename, ShortestRouteModel output) throws FileNotFoundException, UnsupportedEncodingException {
		_writer = new PrintWriter(filename, "UTF-8");
		_writer.println(output.getStartPoint());
		for (int i = 1; i <= output.getNbSommet(); i++) {
			_writer.println(i+"\t"+output.getSommetParent(i)+"\t"+output.getPoids(i));
		}
		_writer.close();
	}
}
