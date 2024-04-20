public class ImpegoOrario {
    protected Progetto progetto;
    protected double impOrario;

    public ImpegoOrario(Progetto progetto, double impOrario) {
        this.progetto = progetto;
        this.impOrario = impOrario;
    }

    public double getImpOrario() {
        return impOrario;
    }

    public Progetto getProgetto(){
		return progetto;
	}

    public String toString(){
        return "(" + progetto.getCodice() +","+ impOrario +")";
    }
}
