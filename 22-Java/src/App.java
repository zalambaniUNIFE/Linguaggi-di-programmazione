import java.io.*;
import java.util.*;

public class App {
    static List<Corso> corsi = new LinkedList<Corso>();
    static List<Studente> studenti = new LinkedList<Studente>();
    static Map<Integer,String> nomeCorsi = new HashMap<Integer,String>();
    public static void main(String[] args) {
       //PUNTO 1:
       try {
            BufferedReader br = new BufferedReader(new FileReader("corsi.txt"));
            String line = br.readLine();
            while (line != null){
                StringTokenizer tok = new StringTokenizer(line);
                int codice = Integer.parseInt(tok.nextToken());
                String tipo = tok.nextToken();
                line = br.readLine();
                String nomeCorso = line;
                line = br.readLine();
                String nomeDoc = line;
                nomeCorsi.put(codice, nomeCorso);
                line = br.readLine();
                if (tipo.equals("teoria")){
                    tok = new StringTokenizer(line);
                    int aula = Integer.parseInt(tok.nextToken());
                    int ore = Integer.parseInt(tok.nextToken());
                    double oreLez = Double.parseDouble(tok.nextToken());
                    Corso c = new Teoria(codice, tipo, nomeCorso, nomeDoc, aula, ore, oreLez);
                    corsi.add(c);
                }
                else{
                    String nomeLab = line;
                    line = br.readLine();
                    String nomeAss = line;
                    line = br.readLine();
                    int postazioni = Integer.parseInt(line);
                    Corso c = new Laboratorio(codice, tipo, nomeCorso, nomeDoc, nomeLab, nomeAss, postazioni);
                    corsi.add(c);
                }
                line = br.readLine();
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
            BufferedReader br = new BufferedReader(new FileReader("studenti.txt"));
            String line = br.readLine();
            while (line != null){
                int matricola = Integer.parseInt(line);
                String nome = br.readLine();
                line = br.readLine();
                Studente s = new Studente(matricola, nome);
                studenti.add(s);
                while(line != null && !line.equals("")){
                    StringTokenizer tok = new StringTokenizer(line);
                    int codice = Integer.parseInt(tok.nextToken());
                    String voto = tok.nextToken();
                    Esame e = new Esame(codice, voto);
                    s.addEsame(e);
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
        System.out.println("nome, codice, docente, tipo, aula, ore sett., ore/lez., lab., assistente, postazioni");
        for (Corso c : corsi)
            System.out.println(c);
        
        //PUNTO 4:
        for (Studente s : studenti)
            System.out.println(s);

        //PUNTO 5
        System.out.println();
        int matricola = Integer.parseInt(args[0]);
        for (Studente s : studenti){
            if (s.getMatricola() == matricola){
                Esame maxEsame = s.votoMax();
                int codc = maxEsame.getCorso();
                System.out.println(s.getNomeStudente()+" "+nomeCorsi.get(codc)+" "+maxEsame.getVotoString());
            }
        }
    }
}
