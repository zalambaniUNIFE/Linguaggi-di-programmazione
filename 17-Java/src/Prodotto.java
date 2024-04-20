public class Prodotto {
    private String descrizione;
    private int quantita, prezzo, totale;
    
    public Prodotto(String descrizione, int quantita, int prezzo, int totale) {
        this.descrizione = descrizione;
        this.quantita = quantita;
        this.prezzo = prezzo;
        this.totale = totale;
    }

    public String toString(){
        return descrizione + "\t" + quantita + "\t" + prezzo + "\t" + totale;
    }
}
