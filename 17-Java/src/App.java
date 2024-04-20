import java.io.*;
import java.util.*;

public class App {
    static List<Scontrino> scontrini = new LinkedList<Scontrino>();
    static List<Prodotto> prodotti = new LinkedList<Prodotto>();
    static Map<String, Integer> totali = new HashMap<String, Integer>();
    static Map<Integer,Integer> totClienti = new HashMap<Integer,Integer>();
    public static void main(String[] args) {
        //PUNTO 1:
        try {
            BufferedReader br = new BufferedReader(new FileReader("scontrini.txt"));
            String line = br.readLine();
            int codice;
            while (line != null){
                StringTokenizer tok = new StringTokenizer(line);
                String tipo = tok.nextToken();
                int id = Integer.parseInt(tok.nextToken());
                line = br.readLine();
                tok = new StringTokenizer(line);
                int giorno = Integer.parseInt(tok.nextToken());
                int mese = Integer.parseInt(tok.nextToken());
                int anno = Integer.parseInt(tok.nextToken());
                if (tipo.equals("privato")){
                    String nomeCognome = br.readLine();
                    String indirizzo = br.readLine();
                    line = br.readLine();
                    tok = new StringTokenizer(line);
                    String codFiscale = tok.nextToken();
                    codice = Integer.parseInt(tok.nextToken());
                    Scontrino s = new Privato(tipo, indirizzo, codice, id, giorno, mese, anno, nomeCognome, codFiscale);
                    scontrini.add(s);
                }
                else{
                    String RagSoc = br.readLine();
                    int iva = Integer.parseInt(br.readLine());
                    codice = Integer.parseInt(br.readLine());
                    String indirizzo = br.readLine();
                    Scontrino s = new Azienda(tipo, indirizzo, codice, id, giorno, mese, anno, RagSoc, iva);
                    scontrini.add(s);
                }
                
                line = br.readLine();
                while(line != null && !line.isEmpty()){
                    String descrizione = line;
                    line = br.readLine();
                    tok = new StringTokenizer(line);
                    int quantita = Integer.parseInt(tok.nextToken());
                    int prezzo = Integer.parseInt(tok.nextToken());
                    int totale = quantita * prezzo;
                    Prodotto p = new Prodotto(descrizione, quantita, prezzo, totale);
                    prodotti.add(p);
                    
                    Integer tot = totali.get(descrizione);
                    if (tot == null)
              			totali.put(descrizione, new Integer(totale));
              		else
              			totali.put(descrizione, new Integer(tot + totale));
                    
                    Integer totCl = totClienti.get(codice);
                    if (totCl == null)
                        totClienti.put(codice, new Integer(totale));
                    else
                        totClienti.put(codice, new Integer(totCl + totale));
                    
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

        //PUNTO 2:
        System.out.println("ID\tData\tNome\tIndirizzo\tCodiceFiscale\tRagioneSociale\tPartitaIva\tCodiceCliente");
        for (Scontrino s : scontrini)
            System.out.println(s);
        
        System.out.println();
        //PUNTO 3:
        for (Prodotto p : prodotti)
            System.out.println(p);

        System.out.println();
        //PUNTO 4:
        System.out.println(totali);

        System.out.println();
        //PUNTO 5
        int cod = Integer.parseInt(args[0]);
        System.out.println("\nTotale cliente "+cod+": "+totClienti.get(cod));

    }
}
