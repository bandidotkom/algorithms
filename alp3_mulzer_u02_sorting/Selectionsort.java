package alp3_mulzer_u02_sorting;

import java.util.ArrayList;

public class Selectionsort <T extends Comparable<T>> {
	ArrayList<T> a;
	int size;
	
	protected ArrayList <T> sort (ArrayList<T> a){
		this.size = a.size();
		for (int i=0; i<size-1; i++){
			int min = findMin(a, i);
			T curr = (T) a.get(i);
			a.set(i, a.get(min));
			a.set(min, curr);
		}
		return a;
	}
	
	private int findMin (ArrayList<T> a, int i){
		int min = i;
		for (int j = i+1; j<size; j++){
			if (((Comparable<T>) a.get(j)).compareTo((T) a.get(min)) < 0){
				min = j;
			}
		}
		return min;
	}
}
