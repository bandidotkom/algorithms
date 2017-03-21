package ha;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class SchulMultiplikation {
        private int fact1, fact2;
        private ArrayList<Integer> digits1, digits2;
        int n, m;
        
        public SchulMultiplikation(int f1, int f2){
                this.fact1 = f1;
                this.fact2 = f2;
                this.digits1 = getDigits(fact1);
                this.digits2 = getDigits(fact2);
                this.n = digits1.size();
                this.m = digits2.size();
        }
        
        public int doSchulMultiplikation(){            
            System.out.println("Multipliziere " + fact1 +" und " + fact2);    
        	//berechnen Zeilen
                ArrayList<Integer>[] summands = computeRows();
                //berechnen Summe
                ArrayList<Integer> resList = computeSum(summands);
                //geben Ergebnis zurueck
                return getRes(resList);
        }
        
        private ArrayList<Integer> getDigits (int f){
                ArrayList<Integer> listOfDigits = new ArrayList<Integer>();
                while (f > 0) {
                    listOfDigits.add( f % 10 );
                    f = f / 10;
                }
                return listOfDigits;
        }
        
        private ArrayList<Integer>[] computeRows (){
        	//erzeugen m FIFOs fuer die Summanden
            ArrayList<Integer>[] summands = new ArrayList[m];
            for(int x = 0; x < m; x++){
            summands[x] = new ArrayList<Integer>();
            }
            //berechnen Summanden und fuellen die FIFOs auf
            for (int i=0; i<m; i++){
                    int digit1 = digits2.get(i);
                    //zuerst mit 0-en auffuellen
                    for (int j=0; j<i; j++){
                            summands[i].add(0);
                    }
                    //dann Ziffern multiplizieren
                    int uebertrag=0;
                    for (int k=0; k<n; k++){
                            int digit2 = digits1.get(k);
                            int zwerg = (digit1 * digit2) + uebertrag;
                            uebertrag = zwerg / 10;
                            summands[i].add(zwerg % 10);
                    }
                    if (uebertrag>0){
                            summands[i].add(uebertrag);
                    }
                    //schliesslich fuehrende 0-en auffuellen
                    int missingZeros = n+m-summands[i].size();
      
                    for (int r=0; r<missingZeros; r++){
                            summands[i].add(0);
                    }
            }
            return summands;
        }
        
        private ArrayList<Integer> computeSum (ArrayList<Integer>[] summands){
        	ArrayList<Integer> resList = new ArrayList<Integer>();
        	int uebertragAdd = 0;
            for (int i=0; i<n+m; i++){ //alle Spalten
            	int zwergAdd = 0;
            	for (int j=0; j<m; j++){ //alle Zeilen
            		zwergAdd += summands[j].get(i);
            	}
            	zwergAdd = zwergAdd+uebertragAdd;
            	resList.add((zwergAdd) % 10);
            	uebertragAdd = zwergAdd / 10;
            }
            return resList;
        }
        
        private int getRes(ArrayList<Integer> resList){
        	int res=0;
            for (int i=0; i<resList.size(); i++){
            	res += resList.get(i) * Math.pow(10, i);
            }
            return res;
        }
        
        public static void main(String[] args){
                SchulMultiplikation schm = new SchulMultiplikation(12, 10000);
                System.out.println("Das Ergebnis: " + schm.doSchulMultiplikation());
        }
        
}
