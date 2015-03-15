package Models;

import java.util.ArrayList;
import java.util.LinkedList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class RoutesModel {
	
	int nbVertexes, nbEdges;
	int addedVertexes = 0;
	int[][] data;
	int startingVertex = 0;
	int currentVertex = 1;
	
	
	public RoutesModel() {
		
	}
	
	public void init(int nbVertexes) {
		this.nbVertexes = nbVertexes;
		data = new int[nbVertexes+1][nbVertexes+1];
	}
	
	
	
	public void addVertex(int vertexValue) {
		if (addedVertexes < vertexValue){
			int difference = vertexValue - addedVertexes;
			
			for (int i = 1; i <= difference; i++){
				data[0][addedVertexes+1] = addedVertexes + 1;
				data[addedVertexes+1][0] = addedVertexes + 1;
				addedVertexes++;
			}
		}
	}
	
	public void addEdge(int origin, int target, int weight) {
		this.addVertex(origin);
		this.addVertex(target);
		
		data[origin][target] = weight;
		data[target][origin] = weight;

	}
	
	public LinkedList<Integer> getNeighbors(){
		return this.getNeighbors(currentVertex);
	}
	
	public LinkedList<Integer> getNeighbors(int vertex){
		LinkedList <Integer> neighbours = new LinkedList<Integer>();
		for (int i = 0; i < this.data[vertex].length; i++) {
			if (this.data[vertex][i] > 0){
				neighbours.add(i);
			}
		}
		return neighbours;
	}


	public int getNbVertexes() {
		return nbVertexes;
	}


	public void setNbVertexes(int nbVertexes) {
		this.nbVertexes = nbVertexes;
	}


	public int getNbEdges() {
		return nbEdges;
	}


	public void setNbEdges(int nbEdges) {
		this.nbEdges = nbEdges;
	}


	public int[][] getData() {
		return data;
	}


	public void setData(int[][] data) {
		this.data = data;
	}
	
	

	public int getStartingVertex() {
		return startingVertex;
	}

	public void setStartingVertex(int startingVertex) {
		this.startingVertex = startingVertex;
	}

	public void print() {
		for (int i = 0; i < this.getData().length; i++) {
			for (int j = 0; j < this.getData()[i].length; j++) {
				System.out.print(this.getData()[i][j]);
				System.out.print("\t");
			}
			System.out.println("");
		}
	}
	
	
	
	

}
