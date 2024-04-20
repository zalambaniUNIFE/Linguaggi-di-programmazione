import java.util.*;

public class Filiale {
    private String nomeFiliale, indirizzo;
    private int codiceFiliale;
    protected List<Cliente> clientiPassati;
    protected List<Cliente> clientiAttuali;
    
    public Filiale(String nomeFiliale, String indirizzo, int codiceFiliale) {
        this.nomeFiliale = nomeFiliale;
        this.indirizzo = indirizzo;
        this.codiceFiliale = codiceFiliale;
        clientiPassati = new LinkedList<Cliente>();
        clientiAttuali = new LinkedList<Cliente>();
    }

    public void addClienteAttuale(Cliente c){
        clientiAttuali.add(c);
    }

    public void addClientePassato(Cliente c){
        clientiPassati.add(c);
    }

    public int contaAttuali(){
        return clientiAttuali.size();
    }

    public int contaPassati(){
        return clientiPassati.size();
    }

    public int getCodiceFiliale() {
        return codiceFiliale;
    }

    public String getNomeFiliale() {
        return nomeFiliale;
    }

    public String toString(){
        int numAttuali = contaAttuali();
        int numTotali = numAttuali + contaPassati();
        return nomeFiliale + "\t" + numAttuali + "\t" + numTotali;
    }
}
