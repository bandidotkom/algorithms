package ha;


import java.util.Random;
import java.util.ArrayList;

public class MatrixChainMultiplikation {
        MatrixChain mC;
        
        public MatrixChainMultiplikation(){
                this.mC = new MatrixChain(2);
                mC.makeRandomMC();
        }
        
        public int[][] doMult(){
                int[][] res = mC.get(0);
                for (int m=0; m<mC.size-1; m++){
                		int nextIndex = m+1;
                        int[][] next = mC.get(nextIndex);
                        System.out.println("doMult: " + res.length + "x" + res[0].length + " mal " + next.length + "x" + next[0].length);
                        res = matrixProd(res, next);
                }
                return res;
        }
        public int[][] matrixProd(int[][] m1, int[][] m2){
                int d1 = m1.length;
                int d2 = m2[0].length;
                System.out.println("Berechne Produkt m1(" + d1 + "x" + m1[0].length +") mal m2(" +
                		m2.length + "x" + d2 + ")");
                int[][] res = new int[d1][d2];
                for (int i=0; i<d1; i++){//iterieren zeilenweise die 1. Matrix
                        for (int j=0; j<d2; j++){
                                int[] col = new int[m2.length];//brauchen j-te Spalte der 2. Matrix (d.h. j-tes Element in jedem Array
                                for (int k=0; k<m2.length; k++){
                                        col[k] = m2[k][j]; 
                                }
                                res[i][j] = scalarProd(m1[i], col);
                        }
                }
                return res;
        }
        
        public int scalarProd(int[] row, int[] col){
                int res = 0;
                for (int i=0; i<row.length; i++){
                       res += row[i]*col[i]; 
                }
                return res;
        }
        
        class MatrixChain{
                ArrayList<int[][]> container;
                int size;
                private MatrixChain(int n){
                        this.size = n;
                        this.container = new ArrayList(n);
                }
                public int[][] get (int i){
                        return container.get(i);
                }
                public void makeRandomMC(){
                        System.out.println("mache gerade eine Random-Matrixkette");
                		Random r = new Random();
                        int rows = r.nextInt(9)+1;
                        int cols = r.nextInt(9)+1;
                        for (int s=0; s<this.size; s++){
                        		System.out.println("rows: " + rows);
                        		System.out.println("cols: " + cols);
                                int[][] matrix = new int[rows][cols];
                                System.out.println("Matrix " + s + ": ");
                                for (int i=0; i<rows; i++){
                                    System.out.println("row " + i + ":");    
                                	for (int j=0; j<cols; j++){
                                                matrix[i][j] = r.nextInt(10)+1;
                                                System.out.print(matrix[i][j] + "\t");
                                        }
                                	System.out.println();
                                }
                                rows = cols;
                                cols = r.nextInt(9)+1;
                                container.add(matrix);
                        }

                }
        }
        
        public static void main(String[] args){
                MatrixChainMultiplikation test = new MatrixChainMultiplikation();
                int[][] resMatrix = test.doMult();
                for (int i=0; i<resMatrix.length; i++){
                        System.out.print(i+1 + ": ");
                        for (int j=0; j<resMatrix[0].length; j++){
                                System.out.print(resMatrix[i][j] + "\t");
                        }
                        System.out.println();
                }
        }
}