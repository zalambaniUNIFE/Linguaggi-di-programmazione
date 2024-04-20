public class Corso {
    protected int codice;
    protected String tipo, nomeCorso, nomeDocente;
    
    public Corso(int codice, String tipo, String nomeCorso, String nomeDocente) {
        this.codice = codice;
        this.tipo = tipo;
        this.nomeCorso = nomeCorso;
        this.nomeDocente = nomeDocente;
    }

    public String toString(){
        return nomeCorso + "\t" + codice + "\t" + nomeDocente + "\t" + tipo + "\t"; 
    }
}
