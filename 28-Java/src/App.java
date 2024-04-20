import java.io.*;
import java.util.*;

public class App {
    static List<Veicoli> veicoli = new LinkedList<Veicoli>();
    static List<Cliente> clienti = new LinkedList<Cliente>();
    static Map<Integer, String> codTarga = new HashMap<Integer, String>();
    static Map<Integer, Double> codCosto = new HashMap<Integer, Double>();
    static Map<Integer, Double> codTOT = new HashMap<Integer, Double>();
    public static void main(String[] args) {
        //PUNTO 1:
        try {
            BufferedReader br = new BufferedReader(new FileReader("veicoli.txt"));
            String line = br.readLine();
            while (line != null){
                StringTokenizer tok = new StringTokenizer(line);
                int cod = Integer.parseInt(tok.nextToken());
                String tipo = tok.nextToken();
                String targa = tok.nextToken();
                line = br.readLine();
                
                if (tipo.equals("auto")){
                    tok = new StringTokenizer(line);
                    int cilindrata = Integer.parseInt(tok.nextToken());
                    boolean diesel=Boolean.parseBoolean(tok.nextToken());
                    line = br.readLine();
                    String modello = line;
                    line = br.readLine();
                    String marca = line;
                    Auto auto = new Auto(cod, targa, modello, marca, cilindrata, diesel);
                    veicoli.add(auto);
                    codTarga.put(cod, targa);
                    codCosto.put(cod, 10.0);
                    codTOT.put(cod, 0.0);
                }
                else{
                    String categoria = line;
                    line = br.readLine();
                    int posti = Integer.parseInt(line);
                    line = br.readLine();
                    String modello = line;
                    line = br.readLine();
                    String marca = line;
                    Furgone furgone = new Furgone(cod, targa, modello, marca, posti, categoria);
                    veicoli.add(furgone);
                    codTarga.put(cod, targa);
                    codCosto.put(cod, 15.0);
                    codTOT.put(cod, 0.0);
                }
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        //PUNTO 2:
        try {
            BufferedReader br = new BufferedReader(new FileReader("posteggi.txt"));
            String line = br.readLine();
            while (line != null){
                String nomeCognome = line;
                Cliente c = new Cliente(nomeCognome);
                clienti.add(c);
                line = br.readLine();
                StringTokenizer tok = new StringTokenizer(line);
                while(tok.hasMoreElements()){
                    int cod = Integer.parseInt(tok.nextToken());
                    int giorni = Integer.parseInt(tok.nextToken());
                    String targa = codTarga.get(cod);
                    double costo = codCosto.get(cod);
                    c.addPosteggio(targa, giorni, costo);
                    double current = codTOT.get(cod);
                    codTOT.put(cod, current + giorni * costo);
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
        System.out.println("tipo, targa, codice, modello, marca, cilindrata, diesel, categoria, numero di posti");
        for (Veicoli v : veicoli)
            System.out.println(v);
        System.out.println();

        //PUNTO 4:
        for (Cliente c : clienti)
            System.out.println(c);
        System.out.println();

        //PUNTO 5:
        int targa = Integer.parseInt(args[0]);
        double tot = codTOT.get(targa);
                System.out.println(targa + " " + tot);
    }
}
