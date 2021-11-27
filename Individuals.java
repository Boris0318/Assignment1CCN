import java.util.Random;

public class Individuals {
    static char [] alphabet = new char[27];
    static String TARGET = "HELLO WORLD";

    public static Individual[] randomGeneration(){
        int popSize = 10;
        for (char c = 'A'; c <= 'Z'; c++) {
            alphabet[c - 'A'] = c;
        }
        alphabet[26] = ' '; // 26th element of the alphabet is the space
        Random generator = new Random(System.currentTimeMillis());
        Individual[] population = new Individual[popSize];
        // we initialize the population with random characters
        for (int i = 0; i < popSize; i++) {
            char[] tempChromosome = new char[TARGET.length()]; // Creates a char array with its length being equal to the target's length
            for (int j = 0; j < TARGET.length(); j++) { // iterate throughout the Target.length (HelloWorld) assign a random letter in the alphabet to each index in the new array
                tempChromosome[j] = alphabet[generator.nextInt(alphabet.length)];
            }
            population[i] = new Individual(tempChromosome); // add this random individual to the population

        }
        return population;
    }

    public static void main(String[] args) {
        Individual [] indiduals = randomGeneration();
        // individuals = [ind1, ind2, ind3]
        // .                      ^
        // String [] a = new String[3];
        // for (String cad: a){
        //      cad    
        //}
        for(Individual i : indiduals){
            System.out.println(i);
        }
        System.out.println();
        Random generator = new Random(System.currentTimeMillis());
        // 38833838, 38245, 849694, 338389
        // 20%10 = 0
        char [][] newInd = new char[10][11];
        for (int j=0; j<newInd.length; j++){
            for (int i=0; i<indiduals[0].chromosome.length; i++){
                int posInd =  generator.nextInt(10);
                newInd[j][i] = indiduals[posInd].chromosome[i];
            }
        }
        for (int j=0; j<newInd.length; j++){
            System.out.println(newInd[j]);
        }
    }
}