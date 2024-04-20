import java.util.*;

public class Utente {
    private int codice;
    private String nome, cognome;

    private List<Spettacolo> visti;

    public Utente(int codice, String nome, String cognome) {
        this.codice = codice;
        this.nome = nome;
        this.cognome = cognome;
        this.visti = new ArrayList<Spettacolo>();
    }

    public void addVisualizzazione(Spettacolo s){
        visti.add(s);
    }

    public List<Spettacolo> getVisti() {
        return visti;
    }
    
    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }
}
