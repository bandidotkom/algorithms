package alp3_mulzer_u02_sorting;

import java.util.ArrayList;

public class Quicksort <T extends Comparable<T>>{
	ArrayList<T> a;
	int size;
	
	protected ArrayList <T> sort (ArrayList<T> a){
		this.a = a;
		this.size = a.size();
		doSort(a, 0, size-1);
		return a;
	}
	
	private void doSort (ArrayList<T> a, int left, int right){
		if (left < right){
			int i = partition (a, left, right);
			doSort(a, left, i-1);
			doSort(a, i+1, right);
		}
		
	}
	
	private int partition (ArrayList<T> a, int left, int right){
		int i = left;
		int j = right-1;
		T pivot = (T) a.get(right);
		T help;
		
		while (i<=j){
			if (((Comparable<T>) a.get(i)).compareTo(pivot) > 0){
				help = (T) a.get(i);
				a.set(i, a.get(j));
				a.set(j, help);
				j--;
			}
			else{
				i++;
			}
		}
		help = (T) a.get(i);
		a.set(i, pivot);
		a.set(right, help);
		return i;
	}
}
