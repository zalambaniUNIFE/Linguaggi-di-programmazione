public class Privato extends Scontrino{
    
    private String nomeCognome, codFiscale;

    public Privato(String tipo, String indirizzo, int codice, int id, int giorno, int mese, int anno,
            String nomeCognome, String codFiscale) {
        super(tipo, indirizzo, codice, id, giorno, mese, anno);
        this.nomeCognome = nomeCognome;
        this.codFiscale = codFiscale;
    }

    public String toString(){
        return id + "\t" + giorno + "/" + mese + "/" + anno + "\t" + nomeCognome + "\t" + indirizzo + "\t" + codFiscale + "\t-\t-\t" + codice;
    }
}
