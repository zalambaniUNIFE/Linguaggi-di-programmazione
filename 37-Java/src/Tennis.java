public class Tennis extends Campo {
    private float temperatura;
    private String terreno;
    
    public Tennis(int codice, String sport, String nomeCampo, Float larghezza, Float lunghezza, Float costoOrario,
            float temperatura, String terreno) {
        super(codice, sport, nomeCampo, larghezza, lunghezza, costoOrario);
        this.temperatura = temperatura;
        this.terreno = terreno;
    }

    public String toString(){
        return super.toString() +"\t"+ temperatura +"\t"+ terreno +"\t-\t-\t"+ super.costoOrario;
    }
}
