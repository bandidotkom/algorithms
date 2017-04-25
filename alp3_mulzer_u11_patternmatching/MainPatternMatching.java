package alp3_mulzer_u11_patternmatching;

public class MainPatternMatching {
	public static void main(String[] args){
		PatternMatching pmTest = new PatternMatching();
		int res1 = pmTest.doNaiveMatching("es war einmal ein K�nig, ...", "ein");
		System.out.println("Text: " + pmTest.getText());
		System.out.println("Pattern: " + pmTest.getPattern());
		System.out.println("Result: " + res1);
		
		int res2 = pmTest.doNaiveMatching("es war einmal ein K�nig, ...", "...");
		System.out.println("Text: " + pmTest.getText());
		System.out.println("Pattern: " + pmTest.getPattern());
		System.out.println("Result: " + res2);
		
		int res3 = pmTest.doNaiveMatching("es war einmal ein K�nig, ...", "waren");
		System.out.println("Text: " + pmTest.getText());
		System.out.println("Pattern: " + pmTest.getPattern());
		System.out.println("Result: " + res3);
		
		//------------------------------------------------------------------------------
		int res4 = pmTest.doRabinKarp("es war einmal ein K�nig, ...", "ein");
		System.out.println("Text: " + pmTest.getText());
		System.out.println("Pattern: " + pmTest.getPattern());
		System.out.println("Result: " + res4);
		
		int res5 = pmTest.doRabinKarp("es war einmal ein K�nig, ...", "...");
		System.out.println("Text: " + pmTest.getText());
		System.out.println("Pattern: " + pmTest.getPattern());
		System.out.println("Result: " + res5);
		
		int res6 = pmTest.doRabinKarp("es war einmal ein K�nig, ...", "waren");
		System.out.println("Text: " + pmTest.getText());
		System.out.println("Pattern: " + pmTest.getPattern());
		System.out.println("Result: " + res6);
	}
}
