public class Azienda extends Scontrino{
    private String RagSoc;
    private int iva;
    
    public Azienda(String tipo, String indirizzo, int codice, int id, int giorno, int mese, int anno, String ragSoc,
            int iva) {
        super(tipo, indirizzo, codice, id, giorno, mese, anno);
        RagSoc = ragSoc;
        this.iva = iva;
    }

    public String toString(){
        return id + "\t" + giorno + "/" + mese + "/" + anno + "\t-\t" + indirizzo + "\t-\t" + RagSoc + "\t" + iva + "\t" + codice;
    }
}
