package ha;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static BigInteger two = new BigInteger("2");
    static BigInteger one = new BigInteger("1");
    static BigInteger zero = new BigInteger("0");
	
	static private String playTheGame (BigInteger n){
        int player = 1;
        while (n.compareTo(one)>0){
            if (powerOfTwo(n)){
                player = (player+1)%2;
                n = n.divide(two);
                System.out.println("power " + n + " player " + player);
            }
            else {
                player = (player+1)%2;
                n = n.subtract(findLargestPower(n));
                System.out.println("nonpower " + n + " player " + player);
            }
        }
        if (player==1){
            return "Richard";
        }
        else{return "Louise";}
    }
    
    static private boolean powerOfTwo(BigInteger x){
        if(x.equals(two)){return true;}
        if(x.mod(two).equals(one)){return false;}
    	BigInteger curr = two;
        boolean found = false;
        while (curr.compareTo(x)<=0){
            if (curr.equals(x)){
                found = true;
                break;
            }
            curr = curr.multiply(two);
        }
        return found;
    }
    
    static private BigInteger findLargestPower(BigInteger n){
        BigInteger curr = one;
      
        while (curr.compareTo(n) < 0){
            curr = curr.multiply(two);
        }
        return curr.divide(two);
    }
    public static void main(String[] args) {
        //t = Integer.parseInt(in.nextLine());
        BigInteger n = new BigInteger("6703734870638684097");
        //n = Integer.parseInt(in.nextLine());
        String res = playTheGame(n);
        System.out.println(res);
    }
}