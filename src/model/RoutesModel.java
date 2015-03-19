/**
 * Date: 10 Mars 2015
 * Description: Classe qui gère l'information relative à un graphe bidirectionnel, utilisant
 * 				une matrice de poids. 
 * 
 * @author Stéphane Lam, Philip Defoy
 */

package model;

public class RoutesModel {
	
	private int _nbSommet;
	private int _sommetDepart;
	private int[][] _matriceVille;

	public RoutesModel(int nbSommet) {
		_nbSommet = nbSommet;
		_matriceVille = new int [nbSommet][nbSommet];
	}
	public int getNbSommet() {
		return _nbSommet;
	}
	public int getSommetDepart() {
		return _sommetDepart;
	}

	public void setSommetDepart(int sommetDepart) {
		_sommetDepart = sommetDepart;
	}

	public int[][] get_matriceVille() {
		return _matriceVille;
	}

	public void setPoids(int villeDepart, int villeFin, int poids) {
		_matriceVille[villeDepart-1][villeFin-1] = poids;
	}
	public int getPoids(int villeDepart, int villeFin) {
		return _matriceVille[villeDepart-1][villeFin-1];
	}
	

}
