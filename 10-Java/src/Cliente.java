import java.util.*;

public class Cliente {
    protected String tipo;
    protected int codiceCliente;
    protected float premioCorrente;
    protected Filiale codiceFilialeAttuale;
    protected List<Filiale> codiceFilialiPassate;
    
    public Cliente(String tipo, int codiceCliente, float premioCorrente, Filiale codiceFilialeAttuale, List<Filiale> codiceFilialiPassate) {
        this.tipo = tipo;
        this.codiceCliente = codiceCliente;
        this.premioCorrente = premioCorrente;
        this.codiceFilialeAttuale = codiceFilialeAttuale;
        this.codiceFilialiPassate = codiceFilialiPassate;
        codiceFilialeAttuale.addClienteAttuale(this);
        for (Filiale f : codiceFilialiPassate)
            f.addClientePassato(this);
    }

    public String toString(){
        return codiceCliente + "\t" + codiceFilialeAttuale.getNomeFiliale() + "\t" + premioCorrente;
    }
}
