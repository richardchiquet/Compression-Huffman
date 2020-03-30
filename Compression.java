import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.*;

public class Compression {
    String text;
    ArrayList<Character> alphabet = new ArrayList<Character>();
    ArrayList<Integer> frequence = new ArrayList<Integer>();
    ArrayList<Node> nodes=new ArrayList<Node>();
    TreeSet<Tuple> tuples = new TreeSet<Tuple>();
    Node tree=null;

    String newLine = System.getProperty("line.separator");

    public Compression(String adresse) throws IOException{
        this.alphabet=alphabet;
        this.frequence=frequence;
        this.text=this.defText(adresse);
        this.text=this.defText(adresse);
        this.defalphafreq();
        this.tuples=new TreeSet<Tuple>();
        this.defTreeSet();
        this.tree=defTree();

    }






    public String getText() {
        return this.text;
    }
    public ArrayList<Character> getAlphabet() {
        return this.alphabet;
    }
    public ArrayList<Integer> getFrequence() {
        return this.frequence;
    }
    public TreeSet<Tuple> getTuples() {
        return this.tuples;
    }

    public String defText(String adresse) throws IOException
    {
        String texte="";
        BufferedReader lecteurAvecBuffer = null;
        String ligne="";

        try
        {
            lecteurAvecBuffer = new BufferedReader(new FileReader(adresse));
        }
        catch(FileNotFoundException exc)
        {
            System.out.println("Erreur d'ouverture");
        }
        while (( ligne = lecteurAvecBuffer.readLine()) != null)
            texte+=ligne+newLine;
        lecteurAvecBuffer.close();
        return texte;

    }
    public void defalphafreq(){
        Boolean in = false;
        for(int i=0;i<this.text.length();i++){
            for(int j=0;j<this.alphabet.size();j++){
                if(this.alphabet.get(j).equals(this.text.charAt(i))){
                    in=true;
                    this.frequence.set(j, this.frequence.get(j)+1);
                }
            }
            if(in==false){
                char carac = this.text.charAt(i);
                this.alphabet.add(carac);
                this.frequence.add(1);
            }
            in=false;
        }
    }

    public void defTreeSet(){
        for(int i = 0; i<this.alphabet.size();i++){
            Tuple tuple= new Tuple(this.alphabet.get(i),this.frequence.get(i));
            this.tuples.add(tuple);
        }

    }
    public Node defTree(){
        ArrayList<Node> nodes = null;

        while(this.tuples.isEmpty()){
            Tuple l=this.tuples.pollFirst();
            Tuple r=this.tuples.pollFirst();
            int freq=l.frequence+r.frequence;
            Node left=new Node(l.frequence,l.caractere);
            Node right=new Node(r.frequence,r.caractere);
            nodes.add(new Node(freq,left,right));
            }
        while(nodes.size()!=1){
            ArrayList<Node> nodes2 = null;
            while(nodes.isEmpty()){
                Node l =nodes.remove(0);
                Node r =nodes.remove(0);
                int freq=l.getFrequence()+r.getFrequence();
                nodes.add(new Node(freq,l,r));
            }
            while(nodes2.isEmpty()){
                nodes.add(nodes2.remove(0));
            }

        }
        return nodes.get(0);



    }

}