public class Prenotazione {
    protected int codice;
    protected int oraInizio;
    
    public Prenotazione(int codice, int oraInizio) {
        this.codice = codice;
        this.oraInizio = oraInizio;
    }

    public String toString(){
        return "("+ codice +","+ oraInizio +")";
    }
}
