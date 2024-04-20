import java.util.LinkedList;
import java.util.List;

public class Veicolo {
    protected int codice, postiLetto;
    protected String tipo, marca;
    protected float lunghezza, larghezza, costoGiornaliero;
    protected List<Prenotazione> prenotazioni;
    
    public Veicolo(int codice, int postiLetto, String tipo, String marca, float lunghezza, float larghezza,
            float costoGiornaliero) {
        this.codice = codice;
        this.postiLetto = postiLetto;
        this.tipo = tipo;
        this.marca = marca;
        this.lunghezza = lunghezza;
        this.larghezza = larghezza;
        this.costoGiornaliero = costoGiornaliero;
        prenotazioni = new LinkedList<Prenotazione>();
    }
    
    public void addPrenotazione(Prenotazione p){
        prenotazioni.add(p);
    }

    public float incasso(){
        int giorni = 0;
        for (Prenotazione p : prenotazioni)
            giorni = giorni + p.getGiorni();
        return giorni * costoGiornaliero;
    }

    public int getCodice() {
        return codice;
    }

    public String toString(){
        return tipo + "\t" + codice + "\t" + marca + "\t" + larghezza + "\t" + lunghezza + "\t" + postiLetto;
    }
}
