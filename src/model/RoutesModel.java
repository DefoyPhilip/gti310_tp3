package model;

public class RoutesModel {
	
	private int _nbSommet;
	private int _sommetDepart;
	private int[][] _matriceVille;

	public RoutesModel(int nbSommet) {
		_nbSommet = nbSommet;
		_matriceVille = new int [nbSommet][nbSommet];
	}
	public int getnbSommet() {
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
		_matriceVille[villeDepart][villeFin] = poids;
	}
	
	

}
