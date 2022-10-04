/*Algorithm created based on information from https://www.codingame.com/playgrounds/3771/machine-learning-with-java---part-1-linear-regression & 
https://waikato.github.io/weka-wiki/use_weka_in_your_java_code/*/

import weka.classifiers.functions.LinearRegression;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class LinearRegressionAlgo {
    Instances cpu = null;
    LinearRegression lReg;
    static long startTime = System.nanoTime();

    public void loadFile(String input) {
        DataSource source = null;
        try {
            source = new DataSource(input);
            cpu = source.getDataSet();
            cpu.setClassIndex(cpu.numAttributes() - 1);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buildModel(){
        lReg = new LinearRegression();
        try {
            lReg.buildClassifier(cpu);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(lReg);
    }

    public static void main(String[] args) throws Exception {
        LinearRegressionAlgo test = new LinearRegressionAlgo();
        test.loadFile("sensory.arff");
        test.buildModel();

        long endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");
    }
}
