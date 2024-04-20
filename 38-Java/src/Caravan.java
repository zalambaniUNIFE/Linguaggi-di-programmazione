public class Caravan extends Veicolo {
    private int potenza;
    
    public Caravan(int codice, int postiLetto, String tipo, String marca, float lunghezza, float larghezza,
            float costoGiornaliero, int potenza) {
        super(codice, postiLetto, tipo, marca, lunghezza, larghezza, costoGiornaliero);
        this.potenza = potenza;
    }

    public String toString(){
        return super.toString() + "\t-\t-\t" + potenza + "\t" + costoGiornaliero;
    }
}
