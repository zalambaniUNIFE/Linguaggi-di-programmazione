import java.util.*;

public class Cliente {
    private int codCliente;
    private String nome, cognome, indirizzo;
    private List<Prenotazione> prenotazione;
    
    public Cliente(int codCliente, String nome, String cognome, String indirizzo) {
        this.codCliente = codCliente;
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        prenotazione = new LinkedList<Prenotazione>();
    }

    public void addPrenotazione(Prenotazione p){
        prenotazione.add(p);
    }

    public String toString(){
        return codCliente + "\t" + cognome + "\t" + nome + "\t" + indirizzo + "\t" + prenotazione;
    }
}
