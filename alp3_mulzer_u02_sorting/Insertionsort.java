package alp3_mulzer_u02_sorting;

import java.util.ArrayList;

public class Insertionsort <T extends Comparable<T>>{
		ArrayList<T> a;
		int size;
		
	protected ArrayList<T> sort (ArrayList<T> a){
		this.size = a.size();
			for (int i=1; i<size; i++){
				T curr = (T) a.get(i);
				int j = i;
				while (j>0 && ((Comparable<T>) a.get(j-1)).compareTo(curr) > 0){
					a.set(j, a.get(j-1));
					j--;
				}
				a.set(j,  curr); 
				//System.out.println("step " + i + ": " + a);
		}
		return a;
	}
}
