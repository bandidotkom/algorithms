package alp3_mulzer_u02_sorting;

import java.util.ArrayList;

public class Mergesort<T extends Comparable<T>> {
	int size;
	ArrayList<T> a, tempArr;
	
	
	protected ArrayList<T> sort(ArrayList<T> a){
		this.size = a.size();
		this.a = a;
		this.tempArr = new ArrayList<T>();
		for (int i = 0; i < size; i++) {
			  tempArr.add(null);
			}
		doSort(0, size-1);
		return a;
	}
	private void doSort(int from, int to){
		if (from < to){
			int m = (int) (Math.floor((to-from) / 2) + from);
			doSort(from, m);
			doSort(m+1, to);
			merge (from, m, to);
		}
	}
	
	private void merge (int from, int m, int to){
		int i = from;
		int j = m+1;
		int k = from;
		for (int ind = 0; ind < size; ind++){
			tempArr.set(ind, this.a.get(ind));
		}
		while (i <= m && j <= to){
			if (((Comparable<T>) tempArr.get(i)).compareTo((T) tempArr.get(j))<0){
				this.a.set(k, tempArr.get(i));
				i++;
			}
			else {
				this.a.set(k, tempArr.get(j));
				j++;
			}
			k++;
		}
		while (i <= m){
			this.a.set(k, tempArr.get(i));
			k++;
			i++;
		}
		
		while (j <= m){
			this.a.set(k, tempArr.get(j));
			k++;
			j++;
		}
	}
}
