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
		printModel();
	}
	public void setPoids(int sommet, int parent, int poids){
		System.out.println("save: "+sommet+" avec"+parent+": "+poids);
		_shortRouteArr[sommet-1][0] = parent;
		_shortRouteArr[sommet-1][1] = poids;
	}
	public int getPoids(int sommet){
		return _shortRouteArr[sommet-1][1];
	}
	public void printModel(){
		System.out.println("////////PrintModelHere");
		for (int i = 0; i < _shortRouteArr.length; i++) {
			System.out.println(i+1+" "+_shortRouteArr[i][0]+" "+_shortRouteArr[i][1]);
		}
		System.out.println("////////////////");
	}
}
