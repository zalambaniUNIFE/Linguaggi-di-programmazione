/*
3. Il programma deve stampare a video l’elenco di tutti i clienti in una tabella con queste
intestazioni:
tipo, nome e cognome o ragione sociale, codice, nome filiale
attuale, premio corrente, premio corrente più tasse
Per i privati, si stampi “-“ per l’attributo “premio corrente più tasse”. Per “tipo” si stampi
privato o azienda a seconda del tipo di cliente.

4. Il programma deve stampare a video, per ciascuna filiale, il nome, il numero di clienti
attuale e il numero totale di clienti, attuali e del passato.
 */

import java.io.*;
import java.util.*;

public class App {
    static List<Filiale> filiali = new LinkedList<Filiale>();
    static List<Cliente> clienti = new LinkedList<Cliente>();
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("filiali.txt"));
            String line = br.readLine();
            while (line != null){
                String nomeFiliale = line;
                int codiceFiliale = Integer.parseInt(br.readLine());
                String indirizzo = br.readLine();
                Filiale f = new Filiale(nomeFiliale, indirizzo, codiceFiliale);
                filiali.add(f);
                line = br.readLine();
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader("clienti.txt"));
            String line = br.readLine();
            while (line != null){
                StringTokenizer tok = new StringTokenizer(line);
                String tipo = tok.nextToken();
                int codiceCliente = Integer.parseInt(tok.nextToken());
                line = br.readLine();
                String nomeCognome = line;
                String ragSociale = line;
                
                int codiceFilialeAttuale = Integer.parseInt(br.readLine());
                Filiale filialeAttuale = trovaFiliale(codiceFilialeAttuale);
                
                tok = new StringTokenizer(br.readLine());
                List<Filiale> filialiPassate  = new LinkedList<Filiale>();
                while (tok.hasMoreTokens()){
                    int cod = Integer.parseInt(tok.nextToken());
                    filialiPassate.add(trovaFiliale(cod));
                }
                float premioCorrente = Float.parseFloat(br.readLine());
                if (tipo.equals("azienda")){
                    float premioTasse = Float.parseFloat(br.readLine());
                    Azienda a = new Azienda(tipo, codiceCliente, premioCorrente, filialeAttuale, filialiPassate, ragSociale, premioTasse);
                    clienti.add(a);
                }
                else{
                    Privato p = new Privato(tipo, codiceCliente, premioCorrente, filialeAttuale, filialiPassate, nomeCognome);
                    clienti.add(p);
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

        System.out.println("tipo\tnome e cognome o ragione sociale\tcodice\tnome filiale attuale\tpremio corrente\tpremio corrente più tasse");
        for (Cliente c : clienti)
            System.out.println(c);

        System.out.println();

        for (Filiale f: filiali)
            System.out.println(f);
    }

    private static Filiale trovaFiliale(int codiceFiliale){
        Filiale filiale = null;
        for (Filiale f : filiali){
            if (f.getCodiceFiliale() == codiceFiliale)
                filiale = f;
        }
        return filiale;
    }    
}