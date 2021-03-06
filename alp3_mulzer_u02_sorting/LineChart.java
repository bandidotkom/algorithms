package alp3_mulzer_u02_sorting;

import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class LineChart extends ApplicationFrame {
	public LineChart(final String title, XYSeriesCollection dataset) {
    	super(title);
    	
    	final JFreeChart chart = createChart(dataset);
    	final ChartPanel chartPanel = new ChartPanel(chart);
    	chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));;
    	setContentPane(chartPanel);
    }
  
         
    /**     * Creates a chart.     *      * @param dataset  the data for the chart.     *      * @return a chart.     */
    private JFreeChart createChart(final XYDataset dataset) {
        // create the chart
    	final JFreeChart chart = ChartFactory.createXYLineChart(
    			"Sorting",      	// chart title            
    			"n",            	// x axis label            
    			"running time (ms)",// y axis label
    			dataset,            // data
    			PlotOrientation.VERTICAL,            
    			true,               // include legend
    			true,               // tooltips
    			false               // urls
    	);
    	//CUSTOMISATION OF THE CHART
    	chart.setBackgroundPaint(Color.white);
    	          
    	// get a reference to the plot for further customisation...
    	final XYPlot plot = chart.getXYPlot();
    	plot.setBackgroundPaint(Color.lightGray);
    	plot.setDomainGridlinePaint(Color.white);
    	plot.setRangeGridlinePaint(Color.white);
        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesShapesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        renderer.setSeriesShapesVisible(2, false);
        plot.setRenderer(renderer);
        // change the auto tick unit selection to integer units only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
     // OPTIONAL CUSTOMISATION COMPLETED.                        
        return chart;
    }
 }
