public class Scontrino {
    protected String tipo, indirizzo;
    protected int codice, id, giorno, mese, anno;
    
    public Scontrino(String tipo, String indirizzo, int codice, int id, int giorno, int mese, int anno) {
        this.tipo = tipo;
        this.indirizzo = indirizzo;
        this.codice = codice;
        this.id = id;
        this.giorno = giorno;
        this.mese = mese;
        this.anno = anno;
    }

}
