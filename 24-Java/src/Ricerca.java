public class Ricerca extends Progetto{
    private String argomento;
    private int numPartner;
    
    public Ricerca(int codice, String tipo, String titolo, String nomeCognome, String organizzazione, double milioni,
            String argomento, int numPartner) {
        super(codice, tipo, titolo, nomeCognome, organizzazione, milioni);
        this.argomento = argomento;
        this.numPartner = numPartner;
    }

    public String toString(){
        return super.toString() +"\t"+ argomento +"\t"+ numPartner +"\t-\t"+ super.milioni*1000;
    }
}
