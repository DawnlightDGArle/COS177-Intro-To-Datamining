import java.io.BufferedReader;
import java.io.FileReader;
import weka.classifiers.trees.J48;
import weka.core.Instances;

public class J48Model {
    public static void main(String[] args) {
        try {

            //Settings
            J48 tree = new J48();
            String dataset = "glass.arff";
            BufferedReader br = new BufferedReader(new FileReader(dataset));
            Instances instances = new Instances(br);
            br.close();

            instances.setClassIndex(instances.numAttributes() - 1);

            //Create Decision Tree Using J48 Classifier
            String[] options = new String[1];
            options[0] = "-U";
            tree.setOptions(options);
            tree.buildClassifier(instances);

            //Print tree
            System.out.println(tree);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
