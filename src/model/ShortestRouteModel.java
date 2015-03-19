/**
 * Date: 10 Mars 2015
 * Description: Classe utilisée lors du calcul des chemins le plus court. Se construit graduellement pour
 * 				finalement contenir les différentes distances optimales.
 * 
 * @author Stéphane Lam, Philip Defoy
 */

package model;

public class ShortestRouteModel {
	int[][] _shortRouteArr;
	int _startPoint;
	public ShortestRouteModel(int nbSommet, int startPoint) {
		_shortRouteArr = new int[nbSommet][2];
		_startPoint = startPoint;
		for (int i = 0; i < _shortRouteArr.length; i++) {
			if(i == _startPoint-1){
				_shortRouteArr[startPoint-1][0] = -1;
				_shortRouteArr[startPoint-1][1] = 0;
			}
			else{
				_shortRouteArr[i][0] = 0;
				_shortRouteArr[i][1] = 10000000;
			}
		}
	}
	public void setPoids(int sommet, int parent, int poids){
		_shortRouteArr[sommet-1][0] = parent;
		_shortRouteArr[sommet-1][1] = poids;
	}
	public int getPoids(int sommet){
		return _shortRouteArr[sommet-1][1];
	}
	public int getSommetParent(int sommet){
		return  _shortRouteArr[sommet-1][0];
	}
	public int getNbSommet(){
		return _shortRouteArr.length;
	}
	public int getStartPoint() {
		return _startPoint;
	}
	public void printModel(){
		System.out.println("////////PrintModelHere");
		for (int i = 0; i < _shortRouteArr.length; i++) {
			System.out.println(i+1+" "+_shortRouteArr[i][0]+" "+_shortRouteArr[i][1]);
		}
		System.out.println("////////////////");
	}
}
