import java.util.*;

public class Socio {
    private int codiceSocio, eta, categoria;
    private String nomeCognome;
    private List<Prenotazione> prenotazioni;

    public Socio(int codiceSocio, int eta, int categoria, String nomeCognome) {
        this.codiceSocio = codiceSocio;
        this.eta = eta;
        this.categoria = categoria;
        this.nomeCognome = nomeCognome;
        prenotazioni = new LinkedList<Prenotazione>();
    }

    public void addPrenotazione(Prenotazione p){
        prenotazioni.add(p);
    }

    public String toString(){
        return codiceSocio +"\t"+ nomeCognome +"\t"+ eta +"\t"+ categoria +"\t"+ prenotazioni;
    }
}
