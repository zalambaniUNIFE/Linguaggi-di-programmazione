public class Veicoli {
    protected int codice;
    protected String targa, modello, marca;
    protected double costo;
    
    public Veicoli(int codice, String targa, String modello, String marca, double costo) {
        this.codice = codice;
        this.targa = targa;
        this.modello = modello;
        this.marca = marca;
        this.costo = costo;
    }

    public int getCodice() {
        return codice;
    }

    public String getTarga() {
        return targa;
    }

    public String toString(){
        return targa + "\t" + codice + "\t" + modello + "\t" +marca;
    }
}
