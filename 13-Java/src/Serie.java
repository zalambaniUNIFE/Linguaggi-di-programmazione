public class Serie extends Spettacolo {
    private int stagione, numPuntate;

    public Serie(String titolo, String tipo, String produttore, int codice, int anno, int stagione, int numPuntate) {
        super(titolo, tipo, produttore, codice, anno);
        this.stagione = stagione;
        this.numPuntate = numPuntate;
    }

    public String toString(){
        return super.toString() + "\t" + stagione + "\t" + numPuntate + "\t" + "-" + "\t" + super.anno + "\t" + super.produttore;
    }
}
