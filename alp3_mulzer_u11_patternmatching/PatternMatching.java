package alp3_mulzer_u11_patternmatching;

public class PatternMatching {
	private String text;
	private String pattern;
	
	public int doNaiveMatching(String t, String p){
		this.text = t;
		this.pattern = p;
		int j;
		for (int i=0; i<=this.text.length()-this.pattern.length(); i++){
			j = 0;
			while (j<=i && j<this.pattern.length() && this.text.charAt(i+j) == this.pattern.charAt(j)){
				j++;
				if(j==this.pattern.length()){
					return i;
				}
			}
		}
		return -1;
	}
	
	public int doRabinKarp(String t, String p){
		this.text = t;
		this.pattern = p;
		int patternLen = this.pattern.length();
		int hashPattern = hash(this.pattern);
		for (int i=0; i<=this.text.length()-this.pattern.length(); i++){
			String slice = this.text.substring(i, i+patternLen);
			if (hash(slice) == hashPattern){
				if (slice.equals(this.pattern)){
					return i;
				}
			}
		}
		return -1;
	}
	
	private int hash(String s){
		int alphabet = 256;
		int hashVal = 0;
		for (int i=0; i<s.length(); i++){
			hashVal += (int) s.charAt(i)*Math.pow(alphabet, s.length()-1-i);
		}
		return hashVal % 13;
	}
	
	public String getText(){
		return this.text;
	}
	public String getPattern(){
		return this.pattern;
	}
}
