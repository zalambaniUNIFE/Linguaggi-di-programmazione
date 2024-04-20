import java.io.*;
import java.util.*;

public class App {
    static List<Spettacolo> spettacoli = new LinkedList<Spettacolo>();
    static List<Utente> visti = new LinkedList<Utente>();

    public static void main(String[] args) {
        //PUNTO 1:
       try {
        BufferedReader br = new BufferedReader(new FileReader("spettacoli.txt"));
        String line = br.readLine();
        while(line != null){
            String titolo = line;
            line = br.readLine();
            StringTokenizer tok = new StringTokenizer(line);
            int codice = Integer.parseInt(tok.nextToken());
            String tipo = tok.nextToken();
            if (tipo.equals("serie")){
                line = br.readLine();
                tok = new StringTokenizer(line);
                int stagione = Integer.parseInt(tok.nextToken());
                int numPuntate = Integer.parseInt(tok.nextToken());
                String produttore = br.readLine();
                int anno = Integer.parseInt(br.readLine());
                Spettacolo s = new Serie(titolo, tipo, produttore, codice, anno, stagione, numPuntate);
                spettacoli.add(s);
            }
            else{
                String durata = br.readLine();
                String produttore = br.readLine();
                int anno = Integer.parseInt(br.readLine());
                Spettacolo s = new Film(titolo, tipo, produttore, codice, anno, durata);
                spettacoli.add(s);
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
            BufferedReader br = new BufferedReader(new FileReader("visualizzazioni.txt"));
            String line = br.readLine();
            while (line != null){
                StringTokenizer tok = new StringTokenizer(line);
                int codiceP = Integer.parseInt(tok.nextToken());
                String nome = tok.nextToken();
                String cognome = tok.nextToken();
                Utente u = new Utente(codiceP, nome, cognome);
                tok = new StringTokenizer(br.readLine());
                while (tok.hasMoreTokens()){
                    int codiceS = Integer.parseInt(tok.nextToken());
                    Spettacolo s = trovaSpettacolo(codiceS);
                    u.addVisualizzazione(s);
                }
                visti.add(u);
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //PUNTO 3:
        System.out.println("tipo\ttitolo\tcodice\tstagione\tn. puntate\tdurata\tanno\tproduttore\n");
        for (Spettacolo s : spettacoli)
            System.out.println(s);

        //PUNTO 4:
        for (Utente u : visti){
            System.out.println(u.getNome() + " " + u.getCognome());
            for (Spettacolo s : u.getVisti()){
                System.out.println("\t" + s.getTitolo() + " - " + 
                                (s.getClass().equals(Film.class) ? "Film" : "SerieTV"));
            }
        }

        //PUNTO 5:
        for (Utente u : visti){
            System.out.println(u.getNome() + " " + u.getCognome() + ": " + u.getVisti().size());
        }
    }
    
    private static Spettacolo trovaSpettacolo(int codiceS) {
        Spettacolo s = null;
        for (Spettacolo e : spettacoli) {
            if (e.getCodice() == codiceS) {
                s = e;
            }
        }
        return s;
    }
}
