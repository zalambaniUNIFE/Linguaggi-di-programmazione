import java.util.List;

public class Privato extends Cliente{
    private String nomeCognome;

    public Privato(String tipo, int codiceCliente, float premioCorrente, Filiale codiceFilialeAttuale, List<Filiale> codiceFilialiPassate, String nomeCognome) {
        super(tipo, codiceCliente, premioCorrente, codiceFilialeAttuale, codiceFilialiPassate);
        this.nomeCognome = nomeCognome;
    }

    public String toString(){
        return super.tipo + "\t" + nomeCognome + "\t" + super.toString() + "\t-";
    }
}
