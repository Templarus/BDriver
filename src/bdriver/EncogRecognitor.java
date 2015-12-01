package bdriver;

import org.encog.Encog;
import org.encog.engine.network.activation.ActivationSigmoid;
import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataPair;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.neural.networks.training.propagation.resilient.ResilientPropagation;

/**
 *
 * @author RusTe
 */
public class EncogRecognitor {

    public static double XORINPUT[][] = {{0.0, 0.0},
    {1.0, 0.0}, {0.0, 1.0}, {1.0, 1.0}};

    /**
     * The ideal data necessary for XOR.
     */
    public static double XORIDEAL[][] = {{0.0}, {1.0}, {1.0}, {0.0}};

    /**
     * The main method.
     *
     * @param args No arguments are used.
     */
    public EncogRecognitor() {
        //create a neural network, without using a factory
        BasicNetwork network = new BasicNetwork();
        network.addLayer(new BasicLayer(null, true, 2));
        network.addLayer(new BasicLayer(new ActivationSigmoid(), true, 3));
        network.addLayer(new BasicLayer(new ActivationSigmoid(), false, 1));
        network.getStructure().finalizeStructure();
        network.reset();
        //createtrainingdata
        MLDataSet trainingSet = new BasicMLDataSet(XORINPUT, XORIDEAL);
        //traintheneuralnetwork
        final ResilientPropagation train = new ResilientPropagation(network, trainingSet);
        int epoch = 1;
        do {
            train.iteration();
            System.out.println("Epoch num " + epoch + " Error:" + train.getError());
            epoch++;
        } while (train.getError() > 0.01);
        train.finishTraining();
        //test the neural network
        System.out.println("NeuralNetworkResults:");
        for (MLDataPair pair : trainingSet) {
            final MLData output = network.compute(pair.getInput());
            System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) + " ,actual =" + output.getData(0) + " ,ideal = " + pair.getIdeal().getData(0));
        }
        Encog.getInstance().shutdown();
    }

}
