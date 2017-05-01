package alp3_mulzer_u07_sorteddict;

public class MainSortedDict {
	public static void main(String[] args){
		SkipListSortedDict<Integer, Integer> test = new SkipListSortedDict<Integer, Integer>();
		test.put(2, 256);
		test.put(3, 445);
		test.put(4,  653);
		test.put(5, 891);
		test.put(1, 123);
		test.remove(999);
		test.remove(4);
		test.put(4, 111);
		test.put(4, 222);
		System.out.println(test.get(1));
		System.out.println(test.min());
		System.out.println(test.max());
		System.out.println(test.pred(1));
		System.out.println(test.pred(4));
		System.out.println(test.succ(5));
		System.out.println(test.succ(3));
		
		
	}
}
