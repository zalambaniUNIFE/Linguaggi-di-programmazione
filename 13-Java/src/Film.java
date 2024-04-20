public class Film extends Spettacolo{
    private String durata;

    public Film(String titolo, String tipo, String produttore, int codice, int anno, String durata) {
        super(titolo, tipo, produttore, codice, anno);
        this.durata = durata;
    }

    public String toString(){
        return super.toString() + "\t-\t-\t" + durata + "\t" + super.anno + "\t" + super.produttore;
    }
}
