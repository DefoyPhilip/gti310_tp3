/**
 * Date: 10 Mars 2015
 * Description: Classe utilisant l'algorithme de Dijkstra afin de trouver le chemin le plus court
 * 
 * @author Stéphane Lam, Philip Defoy
 */
package solver;

import model.RoutesModel;
import model.ShortestRouteModel;

public class RouteSolver implements Solver<RoutesModel, ShortestRouteModel>{
	
	public RouteSolver() {
		
	}

	@Override
	/**
	* Process
	* This method computes the shortest route from a given starting point,
	* using an adaptation of the Dijkstra's algorithm
	* 
	* @param 	route	a RoutesModel containing the graph to analyze
	* @return	shortRoute	A model containing all the computed shortest paths
	* 
	* analyse asymptotique : 
	* 
	* s: nombre de sommets
	* 
	* Groupe O(s^2)
	*/
	public ShortestRouteModel solve(RoutesModel route) {
		try {
			ShortestRouteModel shortRoute = new ShortestRouteModel(route.getNbSommet(),route.getSommetDepart());			//1
			boolean[] sommetDejaVisite = new boolean[route.getNbSommet()];													//1
			int sommetCourant = route.getSommetDepart();																	//1
			//set le point de départ a déjà  visité
			sommetDejaVisite[sommetCourant-1] = true;																		//1
			// boucle a travers tout les sommets
			for(int i = route.getNbSommet(); i > 0; i--) {																	//s
				//initialise un poids/sommet de base pour compraré avec
				// les sommets pour avoir le prochain a utilisé (plus petit)
				int prochainSommetPoids = 10000000;																			//1
				int prochainSommet = 0;																						//1
				//boucle à  travert tout les sommets à  comparé.
				for(int s = 1; s <= route.getNbSommet();s++){																//s
					int poidsSommetCourantASommetS = route.getPoids(sommetCourant, s);										//1																			//1
					int plusPetitPoids = shortRoute.getPoids(s);															//1
					// Vérifie si le sommet a comparé est adjacent est au sommet courant
					if(s != sommetCourant && poidsSommetCourantASommetS != 0){												//1
						int poidsAComparer = poidsSommetCourantASommetS + shortRoute.getPoids(sommetCourant);				//1	
						if(poidsAComparer < plusPetitPoids){																//1
							plusPetitPoids = poidsAComparer;																//1
							shortRoute.setPoids(s, sommetCourant, poidsAComparer);											//1
						}
					}
					// vérifie si le sommet à  comparé devrais àªtre le prochain pls petit sommet à  visité
					if(plusPetitPoids < prochainSommetPoids && !sommetDejaVisite[s-1] && plusPetitPoids!=0){				//1
						prochainSommetPoids = plusPetitPoids;																//1
						prochainSommet = s;																					//1
					}
					
				}
				//System.out.println(sommetCourant);
				//shortRoute.printModel();
				sommetCourant = prochainSommet;																				//1
				// si prochainSommet = 0, il n'y a plus de sommet à  visité.
				if(prochainSommet != 0)																						//1
					sommetDejaVisite[prochainSommet-1] = true;																//1
			}
			return shortRoute;
		} catch (Exception e) {
			System.out.println("Données invalides");
		}
		
		return null;
	}
}