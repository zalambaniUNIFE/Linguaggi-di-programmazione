public class Squash extends Campo{
    private float altezza;
    private int piano;
    
    public Squash(int codice, String sport, String nomeCampo, float larghezza, float lunghezza, float costoOrario,
            float altezza, int piano) {
        super(codice, sport, nomeCampo, larghezza, lunghezza, costoOrario);
        this.altezza = altezza;
        this.piano = piano;
    }

    public String toString(){
        return super.toString() +"\t-\t-\t"+ altezza +"\t"+ piano +"\t"+ super.costoOrario;
    }
}
