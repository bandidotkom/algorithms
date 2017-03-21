package ha_mulzer_u09;

public class PageRank {
	double d;
	double[][] adjMatrix;
	double absError;
	
	public PageRank (double[][] adjMatrix, double d, double absError){
		this.d = d;
		this.adjMatrix = adjMatrix;
		this.absError = absError;
	}
	
	public void doPageRank(){
		double error = Double.MAX_VALUE;
		int n = this.adjMatrix.length;
		double[] distribution = new double[n];
		for (int i=0; i<n; i++){
			distribution[i] = 1.0/n;
		}
		int counter = 0;
		while (this.absError < error){
			double[] oldDistribution = distribution;
			distribution = matrixMult(distribution, adjMatrix);
			counter ++;
			error = 0;
			System.out.print("round " + counter + ": ");
			for (int i=0; i<n; i++){
				System.out.print(distribution[i] + " ");
				error += Math.abs(distribution[i]-oldDistribution[i]);
			}
			
			error = error/n;
			System.out.print(" error: " + error);
			System.out.println();
		}
	}
	
	private double[] matrixMult(double[] vector, double[][] matrix){
		int n = vector.length;
		double[] res = new double[n];
		for (int i=0; i<n; i++){
			for (int j=0; j<n; j++){
				res[i] += vector[j]*matrix[j][i];
			}
		}
		return res;
	}
	
	public static void main(String[] args){
		double[][] adjMatrix = new double[4][4];
		adjMatrix[0] = new double[]{0.0625, 0.0625, 0.8125, 0.0625};
		adjMatrix[1] = new double[]{0.8125, 0.0625, 0.0625, 0.0625};
		adjMatrix[2] = new double[]{0.0625, 0.4375, 0.0625, 0.4375};
		adjMatrix[3] = new double[]{0.0625, 0.8125, 0.0625, 0.0625};
		PageRank test = new PageRank(adjMatrix, 0.25, 0.001);
		test.doPageRank();
	}
}
