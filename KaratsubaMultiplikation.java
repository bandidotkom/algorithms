package ha;

import java.util.ArrayList;
import java.util.Stack;

public class KaratsubaMultiplikation {
        
   
    public int doKaratsubaMultiplikation(int fact1, int fact2){
        ArrayList<Integer> digits1 = getDigits(fact1);
        ArrayList<Integer> digits2 = getDigits(fact2);
        System.out.println("computing: " + fact1 + " * "+ fact2);
        if (fact1==0 || fact2==0){return 0;}
        int n = digits1.size();
        int m = digits2.size();
        
        //Anker
        if (n==2){
                int aL = digits1.get(0);
                int aR = digits1.get(1);
                int bL = digits2.get(0);
                int bR = digits2.get(1);
                int aLbL = aL*bL;
                int aRbR = aR*bR;
                int res = 100*aLbL + 10*((aL+aR)*(bL+bR)-aLbL-aRbR) + aRbR;
                System.out.println("subres: " + res);
                return res;
        }
        else if (n==1){
        		int res = digits1.get(0)*digits2.get(0);
        		System.out.println("subres: " + res);
                return res;
        }
        else {//rekursive Berechnung auf die Haelften
                int middle = n/2;
       
                System.out.println("middle: " + middle);
              
                int aL = getVal(digits1, 0, middle-1);
                int aR = getVal(digits1, middle, n-1);
                int bL = getVal(digits2, 0, middle-1);
                int bR = getVal(digits2, middle, n-1);
                int aLbL = doKaratsubaMultiplikation(aL, bL);
                int aRbR = doKaratsubaMultiplikation(aR, bR);
                int B = doKaratsubaMultiplikation(aL+aR, bL+bR);
                int exp1 = 2*(n-middle);
                int exp2 = exp1-2;
                System.out.println("aL: " + aL);
                System.out.println("aR: " + aR);
                System.out.println("bL: " + bL);
                System.out.println("bR: " + bR);
                System.out.println("aLbL: " + aLbL);
                System.out.println("aRbR: " + aRbR);
                System.out.println("B: " + B);
                System.out.println("exp1: " + exp1);
                System.out.println("exp2: " + exp2);
                
                return (int) (Math.pow(10, exp1)*aLbL + Math.pow(10, exp2)*(B-aLbL-aRbR)+aRbR);
        }
        
    }
    
    private ArrayList<Integer> getDigits (int f){
            ArrayList<Integer> listOfDigits = new ArrayList<Integer>();
            Stack<Integer> helpStack = new Stack<Integer>();
            while (f > 0) {
                helpStack.push( f % 10 );
                f = f / 10;
            }
            while (!helpStack.isEmpty()){
                    listOfDigits.add(helpStack.pop());
            }     
            return listOfDigits;
    }
    
    
    private int getVal(ArrayList<Integer> resList, int from, int to){
        int res=0;
        for (int i=from; i<=to; i++){
                res += resList.get(i) * Math.pow(10, to-from+1-(i-from+1));
        }
        return res;
    }
    
    public static void main(String[] args){
            KaratsubaMultiplikation km = new KaratsubaMultiplikation();
            int fact1 = 10000000;
            int fact2 = 12345678;
            System.out.println("get " + fact1 +" * " + fact2);
            System.out.println("result: " + km.doKaratsubaMultiplikation(fact1,
fact2));
    }
        
        
}