public class Node {
    private int frequence;
    private char caracter='¤';
    private Node leftson=null;
    private Node rightson=null;


    public Node(int freq,char caract,Node l,Node r) {
        this.frequence=freq;
        this.caracter=caract;
        this.leftson=l;
        this.rightson=r;
    }
    public Node(int freq,Node l,Node r){
        this.frequence=freq;
        this.rightson=r;
        this.leftson=l;
        this.caracter='¤';
    }
    public Node(int freq,char caracter){
        this.frequence=freq;
        this.caracter=caracter;
        this.leftson=null;
        this.rightson=null;
    }
    public int getFrequence(){return this.frequence;}
}
