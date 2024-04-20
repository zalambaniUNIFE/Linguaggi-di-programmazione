import java.io.*;
import java.util.*;

public class App {
    static List<Veicolo> veicoli = new LinkedList<Veicolo>();
    static List<Cliente> clienti = new LinkedList<Cliente>();
    static Map<Integer, Veicolo> codVeicolo = new HashMap<Integer, Veicolo>();
    static Map<Integer,String> codTarga = new HashMap<Integer,String>();
    static Map<String,Integer> targaNoleggi = new HashMap<String,Integer>();
    public static void main(String[] args) {
        //PUNTO 1:
        try {
            BufferedReader br = new BufferedReader(new FileReader("veicoli.txt"));
            String line = br.readLine();
            while (line != null){
                StringTokenizer tok = new StringTokenizer(line);
                int codice = Integer.parseInt(tok.nextToken());
                String tipo = tok.nextToken();
                String targa = tok.nextToken();
                String modello = br.readLine();
                String marca = br.readLine();
                line = br.readLine();
                if (tipo.equals("auto")){
                    tok = new StringTokenizer(line);
                    double capienza = Double.parseDouble(tok.nextToken());
                    int cilindrata = Integer.parseInt(tok.nextToken());
                    String categoria = br.readLine();
                    double costoGiornaliero = Double.parseDouble(br.readLine());
                    Veicolo v = new Auto(codice, tipo, targa, modello, marca, costoGiornaliero, capienza, cilindrata, categoria);
                    veicoli.add(v);
                    codVeicolo.put(codice, v);
                    codTarga.put(codice, targa);
                }
                else{
                    tok = new StringTokenizer(line);
                    boolean rimorchio = Boolean.parseBoolean(tok.nextToken());
                    int nposti = Integer.parseInt(tok.nextToken());
                    boolean vanoCarico = Boolean.parseBoolean(tok.nextToken());
                    double costoGiornaliero = Double.parseDouble(br.readLine());
                    Veicolo v = new Furgone(codice, tipo, targa, modello, marca, costoGiornaliero, rimorchio, vanoCarico, nposti);
                    veicoli.add(v);
                    codVeicolo.put(codice, v);
                    codTarga.put(codice, targa);
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
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("clienti.txt"));
            String line = br.readLine();
            while (line != null){
                String nomeCognome = line;
                Cliente c = new Cliente(nomeCognome);
                clienti.add(c);
                line = br.readLine();
                while (line != null && !line.equals("")){
                    StringTokenizer tok = new StringTokenizer(line);
                    int codiceV = Integer.parseInt(tok.nextToken());
                    int ngiorni = Integer.parseInt(tok.nextToken());
                    String targa = codTarga.get(codiceV);
                    c.addNoleggio(codVeicolo.get(codiceV), ngiorni);
                    Integer noleggi = targaNoleggi.get(targa);
                    if (noleggi == null)
                        targaNoleggi.put(targa,1);
                    else
                        targaNoleggi.put(targa, noleggi + 1);
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
        System.out.println("tipo, targa, codice, modello, marca, costo giornaliero, bagagliaio, cilindrata, categoria, rimorchio, numero di posti, vano di carico");
        for (Veicolo v : veicoli){
            System.out.println(v);
        }

        //PUNTO 4:
        System.out.println();
        for (Cliente c : clienti){
            System.out.println(c);
        }

        System.out.println();
        //PUNTO 5:
        System.out.println("Inserisci la targa: ");
        Scanner sc = new Scanner(System.in);
        String targa = sc.nextLine();
       
        int n = targaNoleggi.get(targa);
        System.out.println(n);
  
        sc.close();
    }
}
