/**
 * Date: 10 Mars 2015
 * Description: Classe utilisant l'algorithme de Dijkstra afin de trouver le chemin le plus court
 * 
 * @author St�phane Lam, Philip Defoy
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
	* analyse asymptotique
	* 
	*/
	public ShortestRouteModel solve(RoutesModel route) {
		try {
			ShortestRouteModel shortRoute = new ShortestRouteModel(route.getNbSommet(),route.getSommetDepart());
			boolean[] sommetDejaVisite = new boolean[route.getNbSommet()];
			int sommetCourant = route.getSommetDepart();
			//set le point de d�part a d�j� visit�
			sommetDejaVisite[sommetCourant-1] = true;
			// boucle a travers tout les sommets
			for(int i = route.getNbSommet(); i > 0; i--) {
				//initialise un poids/sommet de base pour comprar� avec
				// les sommets pour avoir le prochain a utilis� (plus petit)
				int prochainSommetPoids = 10000000;
				int prochainSommet = 0;
				//boucle � travert tout les sommets � compar�.
				for(int s = 1; s <= route.getNbSommet();s++){
					int poidsSommetCourantASommetS = route.getPoids(sommetCourant, s);
					int plusPetitPoids = shortRoute.getPoids(s);
					// V�rifie si le sommet a compar� est adjacent est au sommet courant
					if(s != sommetCourant && poidsSommetCourantASommetS != 0){
						int poidsAComparer = poidsSommetCourantASommetS + shortRoute.getPoids(sommetCourant);		
						if(poidsAComparer < plusPetitPoids){
							plusPetitPoids = poidsAComparer;
							shortRoute.setPoids(s, sommetCourant, poidsAComparer);
						}
					}
					// v�rifie si le sommet � compar� devrais �tre le prochain pls petit sommet � visit�
					if(plusPetitPoids < prochainSommetPoids && !sommetDejaVisite[s-1] && plusPetitPoids!=0){
						prochainSommetPoids = plusPetitPoids;
						prochainSommet = s;
					}
					
				}
				//System.out.println(sommetCourant);
				//shortRoute.printModel();
				sommetCourant = prochainSommet;
				// si prochainSommet = 0, il n'y a plus de sommet � visit�.
				if(prochainSommet != 0)
					sommetDejaVisite[prochainSommet-1] = true;
			}
			return shortRoute;
		} catch (Exception e) {
			System.out.println("Donn�es invalides");
		}
		
		return null;
	}
}