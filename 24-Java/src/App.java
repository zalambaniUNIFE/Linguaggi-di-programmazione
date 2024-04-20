import java.util.*;
import java.io.*;

public class App {
    static List<Progetto> progetti = new LinkedList<Progetto>();
    static List<Ricercatore> ricercatori = new LinkedList<Ricercatore>();
    static Map<Integer, Progetto> codProgetto = new HashMap<Integer, Progetto>();
    public static void main(String[] args) {
        //PUNTO 1:
        try {
            BufferedReader br = new BufferedReader(new FileReader("progetti.txt"));
            String line = br.readLine();
            while(line != null){
                StringTokenizer tok = new StringTokenizer(line);
                int codice = Integer.parseInt(tok.nextToken());
                String tipo = tok.nextToken();
                String titolo = br.readLine();
                String nomeCognome = br.readLine();
                String organizzazione = br.readLine();
                line = br.readLine();
                if (tipo.equals("ricerca")){
                    tok = new StringTokenizer(line);
                    String argomento = tok.nextToken();
                    int numPartner = Integer.parseInt(tok.nextToken());
                    double milioni = Double.parseDouble(br.readLine());
                    Progetto p = new Ricerca(codice, tipo, titolo, nomeCognome, organizzazione, milioni, argomento, numPartner);
                    progetti.add(p);
                    codProgetto.put(codice, p);
                }
                else{
                    tok = new StringTokenizer(line);
                    int numAziende = Integer.parseInt(tok.nextToken());
                    double milioni = Double.parseDouble(tok.nextToken());
                    Progetto p = new Innovazione(codice, tipo, titolo, nomeCognome, organizzazione, milioni, numAziende);
                    progetti.add(p);
                    codProgetto.put(codice, p);
                }
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //PUNTO 2:
        try {
            BufferedReader br = new BufferedReader(new FileReader("ricercatori.txt"));
            String line = br.readLine();
            while (line != null){
                String nomeRic = line;
                String cognomeRic = br.readLine();
                Ricercatore r = new Ricercatore(nomeRic, cognomeRic);
                ricercatori.add(r);
                line = br.readLine();

                while (line != null && !line.equals("")){
                    StringTokenizer tok = new StringTokenizer(line);
                    tok = new StringTokenizer(line);
                    int codiceProgetto = Integer.parseInt(tok.nextToken());
                    double impOrario = Double.parseDouble(tok.nextToken());
                    r.addImpegno(codProgetto.get(codiceProgetto), impOrario);
                    line = br.readLine();
                }
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //PUNTO 3:
        System.out.println("tipo, titolo, codice, coordinatore, organizzazione, argomento, partner, aziende, importo totale in migliaia di euro");
        for (Progetto p : progetti)
            System.out.println(p);

        //PUNTO 4:
        System.out.println();
        for (Ricercatore r : ricercatori)
            System.out.println(r);

        //PUNTO 5:
        System.out.println();
        String cognome = args[0];
        for (Ricercatore r : ricercatori){
            if (r.getCognomeRic().equals(cognome)){
                ImpegoOrario i = r.getImpegnoMaggiore();
                System.out.println(r.getNomeRic() +" "+ r.getCognomeRic() +" "+ i.getImpOrario() +" "+ i.getProgetto().getTitolo());

            }
        }
    }
}
