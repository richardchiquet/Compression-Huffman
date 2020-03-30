public class Tuple implements Comparable<Object> {
    Character caractere;
    Integer frequence;

    public Tuple(Character caractere,int frequence){
        this.caractere=caractere;
        this.frequence=frequence;




    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Tuple){
            Tuple t = (Tuple)o;

            // si this < t retourner -1
            if(this.frequence<t.frequence){
                return -1;
            }
            // si this > t retourner 1
            if(this.frequence>t.frequence){
                return 1;
            }
            // si this = t retourner 0
            if(this.frequence.equals(t.frequence)){
                if((int)this.caractere<(int)t.caractere){
                    return -1;
                }
                if((int)this.frequence>(int)t.caractere){
                    return 1;
                }
            }
        }
        return 0;
    }

}