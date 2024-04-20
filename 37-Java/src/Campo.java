public class Campo {
    protected int codice;
    protected String sport, nomeCampo;
    protected float larghezza, lunghezza, costoOrario;
    protected int prenotazioni;
    
    public Campo(int codice, String sport, String nomeCampo, float larghezza, float lunghezza, float costoOrario) {
        this.codice = codice;
        this.sport = sport;
        this.nomeCampo = nomeCampo;
        this.larghezza = larghezza;
        this.lunghezza = lunghezza;
        this.costoOrario = costoOrario;
        prenotazioni = 0;
    }

    public void addPrenotazione(){
        prenotazioni++;
    }

    public int getCodice() {
        return codice;
    }

    public float incasso(){
        return prenotazioni * costoOrario;
    }

    public String toString(){
        return sport +"\t"+ nomeCampo +"\t"+ codice +"\t"+ larghezza +"\t"+ lunghezza;
    }
}
