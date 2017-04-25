package alp3_mulzer_u09_coins;
import java.util.Scanner;

public class GreedyCoins {
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int betrag;
		System.out.println("Geben Sie den Betrag ein: ");
		betrag = input.nextInt();
		
		GreedyCoins gc = new GreedyCoins();
		gc.calculateChange(betrag);
		input.close();
	}
	
	public void calculateChange(int x){
		int[] coins = {200, 100, 50, 20, 10, 5, 2, 1};
		for (int c : coins){
			int nr = x/c;
			System.out.println(c + " Cent x " + nr);
			x %= c;
		}	
	}
}
