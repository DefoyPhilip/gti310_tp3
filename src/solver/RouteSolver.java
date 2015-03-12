package solver;

import model.RoutesModel;
import model.ShortestRouteModel;

public class RouteSolver implements Solver<RoutesModel, ShortestRouteModel>{
	public RouteSolver() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ShortestRouteModel solve(RoutesModel route) {
		ShortestRouteModel shortRoute = new ShortestRouteModel(route.getNbSommet(),route.getSommetDepart());
		boolean[] sommetDejaVisite = new boolean[route.getNbSommet()];
		int sommetCourant = route.getSommetDepart();
		//set le point de départ a déjà visité
		sommetDejaVisite[sommetCourant-1] = true;
		// boucle a travers tout les sommets
		for(int i = route.getNbSommet(); i > 0; i--) {
			//initialise un poids/sommet de base pour compraré avec
			// les sommets pour avoir le prochain a utilisé (plus petit)
			int prochainSommetPoids = 10000000;
			int prochainSommet = 0;
			//boucle à travert tout les sommets à comparé.
			for(int s = 1; s <= route.getNbSommet();s++){
				int poidsSommetCourantASommetS = route.getPoids(sommetCourant, s);
				int plusPetitPoids = shortRoute.getPoids(s);
				// Vérifie si le sommet a comparé est adjacent est au sommet courant
				if(s != sommetCourant && poidsSommetCourantASommetS != 0){
					int poidsAComparer = poidsSommetCourantASommetS + shortRoute.getPoids(sommetCourant);		
					if(poidsAComparer < plusPetitPoids){
						plusPetitPoids = poidsAComparer;
						shortRoute.setPoids(s, sommetCourant, poidsAComparer);
					}
				}
				// vérifie si le sommet à comparé devrais être le prochain pls petit sommet à visité
				if(plusPetitPoids < prochainSommetPoids && !sommetDejaVisite[s-1] && plusPetitPoids!=0){
					prochainSommetPoids = plusPetitPoids;
					prochainSommet = s;
				}
				
			}
			System.out.println(sommetCourant);
			shortRoute.printModel();
			sommetCourant = prochainSommet;
			// si prochainSommet = 0, il n'y a plus de sommet à visité.
			if(prochainSommet != 0)
				sommetDejaVisite[prochainSommet-1] = true;
		}
		return shortRoute;
	}
}