public class Esame {
    protected int codice;
    protected String voto;
    
    public Esame(int codice, String voto) {
        this.codice = codice;
        this.voto = voto;
    }

    public int getVotoInt(){
        if (voto.equals("30L"))
            return 31;
        else
            return Integer.parseInt(voto);     
    }

    public String getVotoString(){
        return voto;
    }

    public int getCorso(){
        return codice;
    }

    public String toString(){
        return "(" + codice + "," + voto + ")";
    }
}
