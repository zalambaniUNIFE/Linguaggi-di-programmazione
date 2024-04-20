import java.util.*;

public class Studente {
    private int matricola;
    private String nomeStudente;
    private List <Esame> libretto;
    
    public Studente(int matricola, String nomeStudente) {
        this.matricola = matricola;
        this.nomeStudente = nomeStudente;
        this.libretto= new LinkedList<Esame>();
    }

    public int getMatricola(){
        return matricola;
    }

     public String getNomeStudente() {
        return nomeStudente;
    }

    public Esame votoMax(){
        int max = 0;
        Esame maxEsame = null;
        for (Esame e : libretto){
            if (e.getVotoInt()>max){
                max = e.getVotoInt();
                maxEsame = e;
            }
        }
        return maxEsame;
    }

    public void addEsame(Esame e){
        libretto.add(e);
    }
    
    public double getMedia(){
        double tot = 0;
        for (Esame e : libretto)
            tot += e.getVotoInt();
        return tot/libretto.size();
    }

    public String toString(){
        return nomeStudente + "\t" + getMedia() + "\t" + libretto;
    }
}
