package alp3_mulzer_u02_sorting;

import java.awt.Window;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class MainSorting {
	static int N = 10000;
	static int step = 1000;
	static ArrayList<Long> nArray = new ArrayList<Long>();
	static ArrayList<Long> resarrayBS = new ArrayList<Long>();
	static ArrayList<Long> resarrayIS = new ArrayList<Long>();
	static ArrayList<Long> resarrayMS = new ArrayList<Long>();
	static ArrayList<Long> resarrayQS = new ArrayList<Long>();
	static ArrayList<Long> resarraySS = new ArrayList<Long>();
		
	public static void main(String[] args){
			for (int i=100; i<N; i=i+step){
				int n = i;
				nArray.add((long) n);
				ArrayList<Long> testarray = new ArrayList<Long>(n);
				for (int j=1; j<=n; j++){
					testarray.add(Math.round(100*Math.random()));
				}
				
				ArrayList<Long> testarrayBS = new ArrayList<Long>(testarray);
				ArrayList<Long> testarrayIS = new ArrayList<Long>(testarray);
				ArrayList<Long> testarrayMS = new ArrayList<Long>(testarray);
				ArrayList<Long> testarrayQS = new ArrayList<Long>(testarray);
				ArrayList<Long> testarraySS = new ArrayList<Long>(testarray);
				
				Bubblesort<Long> bs = new Bubblesort<Long>();
				//System.out.println("Array to sort:" + testarrayBS);
				//System.out.println("Sorting with Bubblesort");
				long timeStart = System.currentTimeMillis();
				bs.sort(testarrayBS);
				long timeEnd = System.currentTimeMillis();
				long runningTime = timeEnd-timeStart;
				resarrayBS.add(runningTime);
				//System.out.println("result: " + testarrayBS);
				//System.out.println("It took " + runningTime + " mseconds with Bubblesort");
				
				Insertionsort<Long> is = new Insertionsort<Long>();
				//System.out.println("Array to sort:" + testarrayIS);
				//System.out.println("Sorting with Insertionsort");
				timeStart = System.currentTimeMillis();
				is.sort(testarrayIS);
				timeEnd = System.currentTimeMillis();
				runningTime = timeEnd-timeStart;
				resarrayIS.add(runningTime);
				//System.out.println("result: " + testarrayIS);
				//System.out.println("It took " + runningTime + " mseconds with Insertionsort");
				
				Mergesort<Long> ms = new Mergesort<Long>();
				//System.out.println("Array to sort:" + testarrayMS);
				//System.out.println("Sorting with Mergesort");
				timeStart = System.currentTimeMillis();
				ms.sort(testarrayMS);
				timeEnd = System.currentTimeMillis();
				runningTime = timeEnd-timeStart;
				resarrayMS.add(runningTime);
				//System.out.println("result: " + testarrayMS);
				//System.out.println("It took " + runningTime + " seconds with Mergesort");
				
				Quicksort<Long> qs = new Quicksort<Long>();
				//System.out.println("Array to sort:" + testarrayQS);
				//System.out.println("Sorting with Quicksort");
				timeStart = System.currentTimeMillis();
				qs.sort(testarrayQS);
				timeEnd = System.currentTimeMillis();
				runningTime = timeEnd-timeStart;
				resarrayQS.add(runningTime);
				//System.out.println("result: " + testarrayQS);
				//System.out.println("It took " + runningTime + " seconds with Quicksort");
				
				Selectionsort<Long> ss = new Selectionsort<Long>();
				//System.out.println("Array to sort:" + testarraySS);
				//System.out.println("Sorting with Insertionsort");
				timeStart = System.currentTimeMillis();
				ss.sort(testarraySS);
				timeEnd = System.currentTimeMillis();
				runningTime = timeEnd-timeStart;
				resarraySS.add(runningTime);
				//System.out.println("result: " + testarraySS);
				//System.out.println("It took " + runningTime + " mseconds with Selectionsort");
			}
			//show results
			final XYSeriesCollection dataset = new XYSeriesCollection();
		    final XYSeries series0 = new XYSeries("Bubblesort");
		    for (int i=0; i<nArray.size(); i++){
		    	series0.add(nArray.get(i), resarrayBS.get(i));
		    }
		      
		    final XYSeries series1 = new XYSeries("Insertionsort");
		    for (int i=0; i<nArray.size(); i++){
		    	series1.add(nArray.get(i), resarrayIS.get(i));
		    }
		    
		    final XYSeries series2 = new XYSeries("Mergesort");
		    for (int i=0; i<nArray.size(); i++){
		    	series2.add(nArray.get(i), resarrayMS.get(i));
		    }
		    		    
		    dataset.addSeries(series0);
		    System.out.println("series0:" +  series0.toString());
		    dataset.addSeries(series1);
		    System.out.println("series1:" +  series1.toString());
		    dataset.addSeries(series2);
		    System.out.println("series2:" +  series2.toString());
			final LineChart plot = new LineChart("Line Chart Sorting", dataset);
		    plot.pack();
		    RefineryUtilities.centerFrameOnScreen(plot);
		    plot.setVisible(true);
		}	
		
}
