package Models;

public class ShortestRoutesModel {
	int[][] routes;
	int startingVertex;
	
	
	public ShortestRoutesModel(int nbVertexes, int startingVertex) {
		
		this.startingVertex = startingVertex;
		this.routes = new int[nbVertexes][2];
		
		
	}
	
	public void setShortestDistance(int vertex, int distance){
		this.routes[vertex-1][1] = distance;
	}
	
	public int getShortestDistance(int vertex){
		return this.routes[vertex-1][1];
	}
	
	public void setIntermediaryVertex(int targetVertex, int intermediaryVertex) {
		this.routes[targetVertex-1][0] = intermediaryVertex;
	}
	
	public void print() {
		for (int i = 0; i < this.routes.length; i++) {
			System.out.print(i+1);
			System.out.print("\t");
			System.out.print(this.routes[i][0]);
			System.out.print("\t");
			System.out.print(this.routes[i][1]);
			System.out.print("\t");
			System.out.println("");
		}
	}
	
	
	
	
}
