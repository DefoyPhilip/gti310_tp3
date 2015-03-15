/**
 * 
 */
package solver;

import java.util.ArrayList;
import java.util.LinkedList;

import Models.RoutesModel;
import Models.ShortestRoutesModel;

/**
 * @author Stéphane
 *
 */
public class RouteSolver implements Solver<RoutesModel, ShortestRoutesModel> {
	
	ShortestRoutesModel shortestRoutes;
	LinkedList<Integer> s = new LinkedList<Integer>(); // linked list because we don't need random access
	int[] q;

	@Override
	public ShortestRoutesModel solve(RoutesModel input) {
		int u = input.getStartingVertex();
		this.q = new int[input.getNbVertexes()];
		this.shortestRoutes = new ShortestRoutesModel(input.getNbVertexes(), input.getStartingVertex());
		
		
		while (s.size() < input.getNbVertexes()){
			s.add(u);
			
			LinkedList<Integer> neighbours = input.getNeighbours(u);
			
			for (int neighbour : neighbours) {
				int newDistance = input.getData()[u][neighbour] + shortestRoutes.getShortestDistance(u);
				
				if (neighbour > 0 
						&& neighbour != input.getStartingVertex() 
						&& (newDistance < (shortestRoutes.getShortestDistance(neighbour)) 
							|| shortestRoutes.getShortestDistance(neighbour) <= 0)){
					
					shortestRoutes.setShortestDistance(neighbour, newDistance);
					shortestRoutes.setIntermediaryVertex(neighbour, u);
				}
			}
			
			u = relax();
		}
		
		shortestRoutes.print();
		return shortestRoutes;
	}
	
	
	// removing a constraint (removing a tension; relaxation)
	private int relax(){
		int min = 2147483647;
		int nextU = 0;

		for (int i = 1; i <= q.length; i++) {
			
			if (shortestRoutes.getShortestDistance(i) < min && shortestRoutes.getShortestDistance(i) > 0 && q[i-1] == 0){
				nextU = i;
				min = shortestRoutes.getShortestDistance(i);
			}
			
		}
		
		// we should remove from queue...
		// but how to do it efficiently with something else than an array?
		if (nextU-1 >= 0)
			q[nextU-1] = 1;
		
		return nextU;
	}
	


}
