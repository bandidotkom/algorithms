package alp3_mulzer_u02_sorting;

import java.util.ArrayList;

public class Bubblesort<T extends Comparable <T>> {
	
	protected ArrayList<T> sort(ArrayList<T> a){
		int size = a.size();
		int currSize=size;
		for (int j=0; j<size-1; j++){
			currSize--;
			if (currSize==1) break;
			for (int i=0; i<currSize; i++){
				if (a.get(i).compareTo(a.get(i+1)) > 0) {
					T bubble = a.get(i);
					a.set(i, a.get(i+1));
					a.set(i+1, bubble);
				}
			}
			//System.out.println((j+1) + "-te Runde (currSize: " + currSize  + "):" + a);
		}
		
		return a;
	}

	
}
