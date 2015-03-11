package solver;

import model.RoutesModel;
import model.ShortestRouteModel;

public class RouteSolver implements Solver<RoutesModel, ShortestRouteModel>{
	boolean[] _sommetDejaVisite;
	public RouteSolver() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ShortestRouteModel solve(RoutesModel route) {
		ShortestRouteModel shortRoute = new ShortestRouteModel(route.getNbSommet(),route.getSommetDepart());
		System.out.println("ici");
		_sommetDejaVisite = new boolean[route.getNbSommet()];
		int sommetCourant = route.getSommetDepart();
		_sommetDejaVisite[sommetCourant-1] = true;
		for(int i = route.getNbSommet(); i > 0; i--) {
			System.out.println("///"+sommetCourant);
			int prochainSommetPoids = 10000000;
			int prochainSommet = 0;
			for(int s = 1; s <= route.getNbSommet();s++){
				int sommetCourantPoids = shortRoute.getPoids(sommetCourant);
				int poidsCourantASommetS = route.getPoids(sommetCourant, s);
				int plusPetitPoids = shortRoute.getPoids(s);
				int poidsUtilise = plusPetitPoids;
				if(sommetCourant != s && poidsCourantASommetS != 0){
					int poidsAComparer = poidsCourantASommetS +sommetCourantPoids;
					System.out.println("J'ajoute: "+sommetCourantPoids);
					System.out.println("De "+sommetCourant+" a "+s+": "+poidsAComparer +" comparé a: "+plusPetitPoids);
					
					if(poidsAComparer < plusPetitPoids){
						poidsUtilise = poidsAComparer;
						shortRoute.setPoids(s, sommetCourant, poidsAComparer);
					}
					else{
						poidsUtilise = plusPetitPoids;
					}
				}
				if(poidsUtilise < prochainSommetPoids && !_sommetDejaVisite[s-1]){
					prochainSommetPoids = poidsUtilise;
					prochainSommet = s;
					System.out.println(s+" est le prochain avec: "+poidsUtilise);
				}
				
			}
			sommetCourant = prochainSommet;
			_sommetDejaVisite[prochainSommet-1] = true;
			shortRoute.printModel();
		}
			//get plus petit
			//for sommet
				// addapte pour plus petit
		return shortRoute;
	}
	private int getMinSommet(){
		int position = 1;
		return position;
	}

}