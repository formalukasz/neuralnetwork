package neural;

import java.text.NumberFormat;

public class TestNeuralNetwork {
    public static void main(String args[])
    {
        double xorInput[][] =
                {
                        {0.0,1.0, 2.0},
                        {1.0,0.0, 0.5},
                        {0.0,2.0, 3.0},
                        {1.0,1.0, 1.0}};

        double xorIdeal[][] =
                { {1.0},{0.0},{1.0},{0.0}};

        double toGuess[][] = {
                {2.0, 4.0, 8.0},
                {2.0, 2.0, 2.0},
                {6.0, 4.0, 2.0}
        };

        System.out.println("Learn:");

        Network network = new Network(3,3,1,0.7,0.9);

        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMinimumFractionDigits(4);


        for (int i=0;i<10000;i++) {
            for (int j=0;j<xorInput.length;j++) {
                network.computeOutputs(xorInput[j]);
                network.calcError(xorIdeal[j]);
                network.learn();
            }
            System.out.println( "Trial #" + i + ",Error:" +
                    percentFormat .format(network.getError(xorInput.length)) );
        }

        System.out.println("Recall:");

        for (int i=0;i<toGuess.length;i++) {

            for (int j=0;j<toGuess[0].length;j++) {
                System.out.print( toGuess[i][j] +":" );
            }

            double out[] = network.computeOutputs(toGuess[i]);
            System.out.println("="+out[0]);
        }
    }
}