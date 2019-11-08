package br.ufsc.ftsm.util;

import br.ufsc.ftsm.core.Point;

public class Distance {
	public static double euclidean(Point p1,Point p2){
		double distX = Math.abs(p1.getX()-p2.getX());
		double distXSquare = distX*distX;
		
		double distY = Math.abs(p1.getY()-p2.getY());
		double distYSquare = distY*distY;
		
		return Math.sqrt(distXSquare+distYSquare);
	}	
}
