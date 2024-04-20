import java.io.*;
import java.util.*;

public class App {
    static List<Campo> campi = new LinkedList<Campo>();
    static List<Socio> soci = new LinkedList<Socio>();
    static Map<Integer,Campo> codCampo = new HashMap<Integer, Campo>();

    public static void main(String[] args) {
        //PUNTO 1:
        try {
            BufferedReader br = new BufferedReader(new FileReader("campi.txt"));
            String line = br.readLine();
            while (line != null){
                StringTokenizer tok = new StringTokenizer(line);
                int codice = Integer.parseInt(tok.nextToken());
                String sport = tok.nextToken();
                String nomeCampo = br.readLine();
                line = br.readLine();
                if (sport.equals("tennis")){
                    tok = new StringTokenizer(line);
                    float larghezza = Float.parseFloat(tok.nextToken());
                    float lunghezza = Float.parseFloat(tok.nextToken());
                    float temperatura = Float.parseFloat(tok.nextToken());
                    String terreno = br.readLine();
                    float costoOrario = Float.parseFloat(br.readLine());
                    Campo c = new Tennis(codice, sport, nomeCampo, larghezza, lunghezza, costoOrario, temperatura, terreno);
                    campi.add(c);
                    codCampo.put(codice, c);
                }
                else{
                    tok = new StringTokenizer(line);
                    float larghezza = Float.parseFloat(tok.nextToken());
                    float lunghezza = Float.parseFloat(tok.nextToken());
                    float altezza = Float.parseFloat(tok.nextToken());
                    int piano = Integer.parseInt(tok.nextToken());
                    float costoOrario = Float.parseFloat(tok.nextToken());
                    Campo c = new Squash(codice, sport, nomeCampo, larghezza, lunghezza, costoOrario, altezza, piano);
                    campi.add(c);
                    codCampo.put(codice, c);
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
            BufferedReader br = new BufferedReader(new FileReader("soci.txt"));
            String line = br.readLine();
            while(line != null){
                int codice = Integer.parseInt(line);
                String nomeCognome = br.readLine();
                StringTokenizer tok = new StringTokenizer(br.readLine());
                int eta = Integer.parseInt(tok.nextToken());
                int categoria = Integer.parseInt(tok.nextToken());
                Socio s = new Socio(codice, eta, categoria, nomeCognome);
                soci.add(s);
                line = br.readLine();
                tok = new StringTokenizer(line);
                while (tok.hasMoreTokens()){
                    int codiceCampo = Integer.parseInt(tok.nextToken());
                    int oraInizio = Integer.parseInt(tok.nextToken());
                    Prenotazione p = new Prenotazione(codiceCampo, oraInizio);
                    s.addPrenotazione(p);
                    codCampo.get(codiceCampo).addPrenotazione();
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
        System.out.println("sport, nome del campo, codice, larghezza, lunghezza, temperatura, terreno, altezza, piano, costo");
        for (Campo c : campi){
            System.out.println(c);
        }
        
        //PUNTO 4:
        System.out.println("codice, nome e cognome, età, categoria, prenotazioni");
        for (Socio s : soci){
            System.out.println(s);
        }

        //PUNTO 5:
        int cod = Integer.parseInt(args[0]);
        System.out.println(codCampo.get(cod).incasso());
    }
}
