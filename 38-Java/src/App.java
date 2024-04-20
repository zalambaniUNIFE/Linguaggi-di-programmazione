import java.io.*;
import java.util.*;

public class App {
    static List<Veicolo> veicoli = new LinkedList<Veicolo>();
    static List<Cliente> clienti = new LinkedList<Cliente>();
    static Map<Integer, Veicolo> codVeicolo = new HashMap<Integer,Veicolo>();
    public static void main(String[] args) {
        //PUNTO 1:
        try {
            BufferedReader br = new BufferedReader(new FileReader("veicoli.txt"));
            String line = br.readLine();
            while(line != null){
                StringTokenizer tok = new StringTokenizer(line);
                int codice = Integer.parseInt(tok.nextToken());
                String tipo = tok.nextToken();
                String marca = br.readLine();
                if (tipo.equals("roulotte")){
                    tok = new StringTokenizer(br.readLine());
                    int peso = Integer.parseInt(tok.nextToken());
                    float lunghezza = Float.parseFloat(tok.nextToken());
                    float larghezza = Float.parseFloat(tok.nextToken());
                    int postiLetto = Integer.parseInt(tok.nextToken());
                    tok = new StringTokenizer(br.readLine());
                    String veranda = tok.nextToken();
                    float costoGiornaliero = Float.parseFloat(tok.nextToken());
                    Veicolo v = new Roulotte(codice, postiLetto, tipo, marca, lunghezza, larghezza, costoGiornaliero, peso, veranda);
                    veicoli.add(v);
                    codVeicolo.put(codice, v);
                }
                else{
                    tok = new StringTokenizer(br.readLine());
                    float lunghezza = Float.parseFloat(tok.nextToken());
                    float larghezza = Float.parseFloat(tok.nextToken());
                    int potenza = Integer.parseInt(tok.nextToken());
                    int postiLetto = Integer.parseInt(tok.nextToken());
                    float costoGiornaliero = Float.parseFloat(tok.nextToken());
                    Veicolo v = new Caravan(codice, postiLetto, tipo, marca, lunghezza, larghezza, costoGiornaliero, potenza);
                    veicoli.add(v);
                    codVeicolo.put(codice, v);
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
            BufferedReader br = new BufferedReader(new FileReader("clienti.txt"));
            String line = br.readLine();
            while (line != null){
                int codCliente = Integer.parseInt(line);
                String nome = br.readLine();
                String cognome = br.readLine();
                String indirizzo = br.readLine();
                Cliente c = new Cliente(codCliente, nome, cognome, indirizzo);
                clienti.add(c);
                line = br.readLine();
                
                while (line != null && !line.equals("")){
                    StringTokenizer tok = new StringTokenizer(line);
                    tok = new StringTokenizer(line);
                    int codice = Integer.parseInt(tok.nextToken());
                    Prenotazione p = new Prenotazione(codice,Integer.parseInt(tok.nextToken()));
                    c.addPrenotazione(p);
                    Veicolo v = codVeicolo.get(codice);
                    v.addPrenotazione(p);
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
        System.out.println("tipo, codice, marca, larghezza, lunghezza, posti letto, peso, veranda, potenza, costo");
        for (Veicolo v : veicoli)
            System.out.println(v);
        System.out.println();
        //PUNTO 4:
        System.out.println("codice, cognome, nome, indirizzo, prenotazioni");
        for (Cliente c : clienti)
            System.out.println(c);
        System.out.println();
        //PUNTO 5:
        System.out.println("codice, incasso");
        for (Veicolo v : veicoli)
            System.out.println(v.getCodice() + "\t" + v.incasso());
    }
}
