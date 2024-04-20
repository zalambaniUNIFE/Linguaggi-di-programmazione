public class Innovazione extends Progetto{
    private int numAziende;

    public Innovazione(int codice, String tipo, String titolo, String nomeCognome, String organizzazione,
            double milioni, int numAziende) {
        super(codice, tipo, titolo, nomeCognome, organizzazione, milioni);
        this.numAziende = numAziende;
    }

    public String toString(){
        return super.toString() +"\t-\t-\t"+ numAziende +"\t"+ super.milioni*1000;  
    }
}
