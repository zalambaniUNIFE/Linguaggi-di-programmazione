import java.util.*;

public class Ricercatore {
    private String nomeRic, cognomeRic;
    private List<ImpegoOrario> impegno;
    
    public Ricercatore(String nomeRic, String cognomeRic) {
        this.nomeRic = nomeRic;
        this.cognomeRic = cognomeRic;
        impegno = new LinkedList<ImpegoOrario>();
    }

    public void addImpegno(Progetto progetto, double imp){
        impegno.add(new ImpegoOrario(progetto, imp));
    }
    
    public double getTotale(){
        double tot_impegni = 0;
        for (ImpegoOrario i : impegno){
            tot_impegni += i.getImpOrario();
        }
        return tot_impegni;
    }

    public int getProgetti(){
        return impegno.size();
    }

    public String getCognomeRic() {
        return cognomeRic;
    }

    public String getNomeRic() {
        return nomeRic;
    }

    public ImpegoOrario getImpegnoMaggiore(){
        double impegnoMaggiore = -1000;
        ImpegoOrario io = null;
        for (ImpegoOrario i : impegno){
            if (i.getImpOrario() > impegnoMaggiore){
                impegnoMaggiore = i.getImpOrario();
                io = i;
            }
        }
        return io;
    }

    public String toString(){
        double impegnoTotale  = getTotale();
        int numProgetti = getProgetti();
        return nomeRic +"\t"+ cognomeRic +"\t"+ impegnoTotale +"\t"+ numProgetti +"\t"+ impegno;
    }

}
