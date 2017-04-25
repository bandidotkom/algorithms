package alp3_mulzer_u04_dequeue;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
	public static void main(String[] args){
		List<?> x = new ArrayList<String>();
		//List<Object> y = new ArrayList<Integer>();
		List<? extends Number> y2 = new ArrayList<Integer>();
		Object[] z = new Integer[3];
		z[2] = "ALP3";
	}
}
