package alp3_mulzer_u12_trie;

public class MainTrieVocabulary {
	
	public static void main(String[] args){
		TrieVocabulary test = new TrieVocabulary();
		
		
		test.put("tomika", 101);
		test.remove("tomika");
		test.put("tomi", 100);
		System.out.println(test.get("Tomi") + " <-- should be 100");
		System.out.println(test.get("tomika") + " <-- should be -1");
		test.put("tomika", 101);
		System.out.println(test.get("tomika") + " <-- should be 101");
		System.out.println(test.succ("tomi") + " <-- should be 101");
		System.out.println(test.get("Tamas") + " <-- should be -1");
		
		test.put("In", 23);
		test.put("Indien", 69);
		test.put("indigo", 88);
		test.remove("in");
		System.out.println(test.get("indien") + " <-- should be 69");
		System.out.println(test.get("indigo") + " <-- should be 88");
		System.out.println(test.get("in") + " <-- should be -1");
		System.out.println(test.succ("indien") + " <-- should be 88");
		System.out.println(test.succ("indigo") + " <-- should be 100");
		System.out.println(test.succ("tomika") + " <-- should be -1");
	}
}
