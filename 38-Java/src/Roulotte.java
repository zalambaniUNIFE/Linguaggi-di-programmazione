public class Roulotte extends Veicolo {
    private int peso;
    private String veranda;
    
    
    public Roulotte(int codice, int postiLetto, String tipo, String marca, float lunghezza, float larghezza,
            float costoGiornaliero, int peso, String veranda) {
        super(codice, postiLetto, tipo, marca, lunghezza, larghezza, costoGiornaliero);
        this.peso = peso;
        this.veranda = veranda;
    }


    public String toString(){
        return super.toString() + "\t" + peso + "\t" + veranda + "\t-\t" + costoGiornaliero;
    }
}
