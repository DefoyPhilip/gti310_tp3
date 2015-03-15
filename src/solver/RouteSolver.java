/**
 * 
 */
package solver;

import java.util.LinkedList;

import Models.RoutesModel;
import Models.ShortestRoutesModel;

/**
 * @author Stéphane
 *
 */
public class RouteSolver implements Solver<RoutesModel, ShortestRoutesModel> {
	
	/* This model will contain the shortest route starting from the given vertex */
	ShortestRoutesModel shortestRoutes;
	
	/* visited vertices list, and remaining vertices queue */
	LinkedList<Integer> s = new LinkedList<Integer>(); // linked list because we don't need random access
	LinkedList<Integer> q = new LinkedList<Integer>();
	

	@Override
	/**
	 * Solves using djikstra's algorithm
	 * @see solver.Solver#solve(java.lang.Object)
	 */
	public ShortestRoutesModel solve(RoutesModel input) {
		/* Benchmark */
		long startTime = System.currentTimeMillis();
		
		/* current vertex u */
		int u = input.getStartingVertex();
		
		this.q = initQueue(input.getNbVertexes());
		this.shortestRoutes = new ShortestRoutesModel(input.getNbVertexes(), input.getStartingVertex());
		
		
		/* while the vertices haven't all been visited */
		while (s.size() < input.getNbVertexes()){
			
			/* add current vertex to the visited ones */
			s.add(u);
			
			LinkedList<Integer> neighbors = input.getNeighbors(u);
			
			/* for each neighboors of the current vertex */
			for (int neighbor : neighbors) {
				
				/* get the distance from starting vertex to this neighboor */
				int newDistance = input.getData()[u][neighbor] + shortestRoutes.getShortestDistance(u);
				
				if (neighbor > 0 // if neighboor exists (!=0)
						&& neighbor != input.getStartingVertex() // and the neighboor is not the starting vertex
						&& (newDistance < (shortestRoutes.getShortestDistance(neighbor)) // and the newly calculated distance is shorter than the neighboor's current distance
							|| shortestRoutes.getShortestDistance(neighbor) <= 0)){ // or if the neighboor's distance hasn't been set yet
					
					/* then we set the new distance for the neighboor and intermediary */
					shortestRoutes.setShortestDistance(neighbor, newDistance);
					shortestRoutes.setIntermediaryVertex(neighbor, u);
				}
			}
			
			/* get the next vertex */
			u = namaste();
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime-startTime) + "ms"); 
		
		shortestRoutes.print();
		return shortestRoutes;
	}
	
	
	
	/**
	 * Removing a constraint (removing a tension; relaxation)
	 * 
	 * @return int nextU, the next vertex to analyze
	 */
	private int namaste(){
		int min = 2147483647;
		int nextU = 0;
		int uIndex = 0;
		
		/* */
		for (int i = 1; i <= q.size(); i++) {
			
			if (shortestRoutes.getShortestDistance(i) < min && shortestRoutes.getShortestDistance(i) > 0){
				nextU = q.get(i-1);
				uIndex = i-1;
				min = shortestRoutes.getShortestDistance(i);
			}
			
		}
		
		// remove from queue
		q.remove(uIndex);
		
		return nextU;
	}
	
	/**
	 * Generates the queue (q)
	 * 
	 * returns the queue
	 */
	private LinkedList<Integer> initQueue(int length){
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		for (int i = 0; i < length; i++) {
			queue.add(i+1);
		}
		
		return queue;
	}
	


}
