public class Teoria extends Corso{
    private int codAula, ore;
    private double oreLez;
    
    public Teoria(int codice, String tipo, String nomeCorso, String nomeDocente, int codAula, int ore, double oreLez) {
        super(codice, tipo, nomeCorso, nomeDocente);
        this.codAula = codAula;
        this.ore = ore;
        this.oreLez = oreLez;
    }

    public String toString(){
        return super.toString() + codAula + "\t" + ore + "\t" + oreLez + "\t-\t-\t-"; 
    }
}
