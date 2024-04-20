public class Spettacolo {
    protected String titolo, tipo, produttore;
    protected int codice, anno;

    public Spettacolo(String titolo, String tipo, String produttore, int codice, int anno) {
        this.titolo = titolo;
        this.tipo = tipo;
        this.produttore = produttore;
        this.codice = codice;
        this.anno = anno;
    }

    public int getCodice() {
        return codice;
    }

    public String getTitolo() {
        return titolo;
    }
    
    public String toString(){
        return tipo + "\t" + titolo + "\t" + codice;
    }
}
