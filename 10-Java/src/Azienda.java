import java.util.List;

public class Azienda extends Cliente{
    private String ragSociale;
    private float premioTasse;
    
    public Azienda(String tipo, int codiceCliente, float premioCorrente, Filiale codiceFilialeAttuale,
            List<Filiale> codiceFilialiPassate, String ragSociale, float premioTasse) {
        super(tipo, codiceCliente, premioCorrente, codiceFilialeAttuale, codiceFilialiPassate);
        this.ragSociale = ragSociale;
        this.premioTasse = premioTasse;
    }

    public String toString(){
        return tipo + "\t" + ragSociale + "\t" + super.toString() + "\t" + premioTasse;
    }
}
