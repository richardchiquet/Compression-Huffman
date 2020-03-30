import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException{

        Compression alice = new Compression("E:/ricky/Documents/Compression-inte/donnees/alice.txt");
        System.out.println(alice.getAlphabet());
        System.out.println(alice.getFrequence());
        System.out.println(alice.getAlphabet().size());
        System.out.println(alice.getFrequence().size());
        System.out.println(alice.getTuples());
    }
}
