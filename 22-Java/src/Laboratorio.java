public class Laboratorio extends Corso{
    private String nomeLab, nomeAss;
    private int postazioni;
    
    public Laboratorio(int codice, String tipo, String nomeCorso, String nomeDocente, String nomeLab, String nomeAss,
            int postazioni) {
        super(codice, tipo, nomeCorso, nomeDocente);
        this.nomeLab = nomeLab;
        this.nomeAss = nomeAss;
        this.postazioni = postazioni;
    }

    public String toString(){
        return super.toString() + "-\t-\t-\t" + nomeLab + "\t" + nomeAss + "\t" + postazioni;
    }
}
