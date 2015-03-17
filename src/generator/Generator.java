package generator;

import java.util.ArrayList;


public class Generator {
	ArrayList<ArrayList<int[]>> vertices = new ArrayList<ArrayList<int[]>>();
	
	public Generator(){
		
	}
	
	public void generate(int nbEdges){
		
		int[] blank = new int[3];
		ArrayList<int[]> blankAL = new ArrayList<int[]>();
		blankAL.add(blank);
		vertices.add(blankAL);
		System.out.println("============");
		for (int i = 1; i <= nbEdges; i++) {
			int nbOfNeighbors = (int) (Math.random() * nbEdges + 1);
			ArrayList<int[]> neighbors = new ArrayList<int[]>();
			
			
			for (ArrayList<int[]> vertex : vertices) {
				int eN = 1;
				
				for (int[] existingNeighbor : vertex) {
					if (existingNeighbor[1] == i) {
						int[] neighbor = new int[3];
						neighbor[0] = i;
						neighbor[1] = existingNeighbor[0];
						neighbor[2] = existingNeighbor[2];
						
						neighbors.add(neighbor);
					}
					eN++;
					//System.out.println(eN);
				}
				
				
			}
			
			for (int j = 0; j < nbOfNeighbors; j++) {
				int neighborId = (int) (Math.random() * nbEdges + 1);
				
				Boolean duplicate = false;
				
				neighborId = (int) (Math.random() * nbEdges + 1);
				
				for (int[] ks : neighbors) {
					if (ks[1] == neighborId) {
						duplicate = true;
					}
				}


				
				if (duplicate || neighborId <= i) {
					break;
				} else {
					int neighborDistance = (int) (Math.random() * 2000 + 1);
					
					int[] neighbor = new int[3];
					neighbor[0] = i;
					neighbor[1] = neighborId;
					neighbor[2] = neighborDistance;
					
					//System.out.println(i + "\t" + neighborId + "\t" + neighborDistance);
					neighbors.add(neighbor);
				}
				
				
			}
			
			
			vertices.add(neighbors);
		}
		
	
	}
	
	public void print() {
		int v = 0;
		System.out.println("============");
		for (ArrayList<int[]> arrayList : vertices) {
			for (int[] is : arrayList) {
				System.out.print(v+ "\t");
				System.out.print(is[1] + "\t");
				System.out.print(is[2]);
				System.out.println("");
			}
			
			//System.out.println(" ++++ " + arrayList.size());
			
			v++;
		}
	}
}
