import java.util.*;

public class Progetto {
    protected int codice;
    protected String tipo, titolo, nomeCognome, organizzazione;
    protected double milioni;
    private List<ImpegoOrario> impegno;

    
    public Progetto(int codice, String tipo, String titolo, String nomeCognome, String organizzazione, double milioni) {
        this.codice = codice;
        this.tipo = tipo;
        this.titolo = titolo;
        this.nomeCognome = nomeCognome;
        this.organizzazione = organizzazione;
        this.milioni = milioni;
        impegno = new LinkedList<ImpegoOrario>();
    }

    public void addImpegno(ImpegoOrario imp){
        impegno.add(imp);
    }

    public String getTitolo(){
        return titolo;
    }

    public int getCodice() {
        return codice;
    }

    public String toString(){
        return tipo +"\t"+ titolo +"\t"+ codice +"\t"+ nomeCognome +"\t"+ organizzazione;
    }
}
