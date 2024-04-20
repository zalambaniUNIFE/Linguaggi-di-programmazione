import argparse

from Progetto import Progetto
from Ricerca import Ricerca
from Innovazione import Innovazione
from Ricercatore import Ricercatore

class Main:
    def __init__(self, arg) -> None:
        self._arg = arg
    
    def main(self):
        progetti = []
        ricercatori = []
        codProgetto = {}
        #PUNTO 1:
        try:
            f = open("progetti.txt", "r")
            line = f.readline().strip()
            while (line != ''):
                tok = line.split()
                codice = int(tok[0])
                tipo = tok[1]
                titolo = f.readline().strip()
                nomeCognome = f.readline().strip()
                coordinatore = f.readline().strip()
                line = f.readline().strip()
                if (tipo == "ricerca"):
                    tok = line.split()
                    argomento = tok[0]
                    numPartner = int(tok[1])
                    milioni = float(f.readline())
                    p = Ricerca(codice, tipo, titolo, nomeCognome, coordinatore, milioni, argomento, numPartner)
                    progetti.append(p)
                    codProgetto[codice] = p
                else:
                    tok = line.split()
                    numAziende = int(tok[0])
                    milioni = float(tok[1])
                    p = Innovazione(codice, tipo, titolo, nomeCognome, coordinatore, milioni, numAziende)
                    progetti.append(p)
                    codProgetto[codice] = p
                line = f.readline().strip()
            f.close()
        except IOError as i:
            print(i)
        except Exception as e:
            print(e)

        #PUNTO 2:
        try:
            f = open("ricercatori.txt", "r")
            line = f.readline().strip()
            while(line != ''):
                nomeRic = line
                cognomeRic = f.readline().strip()
                r = Ricercatore(nomeRic, cognomeRic)
                ricercatori.append(r)
                line = f.readline().strip()
                while(line != ''):
                    tok = line.split()
                    codiceProgetto = int(tok[0])
                    impOrario = float(tok[1])
                    r.addImpegno(codProgetto.get(codiceProgetto), impOrario)
                    line = f.readline().strip()
                line = f.readline().strip()
            f.close()
        except IOError as i:
            print(i)
        except Exception as e:
            print(e)

        #PUNTO 3:
        print("tipo, titolo, codice, coordinatore, organizzazione, argomento, partner, aziende, importo totale in migliaia di euro")
        for p in progetti:
            print(p)
        
        #PUNTO 4:
        print("\n")
        for r in ricercatori:
            print(r)

        #PUNTO 5:
        print("\n")
        try:
            cognome = str(self._arg)
            for r in ricercatori:
                if (r.getCognome() == cognome):
                    i = r.getImpegnoMaggiore()
                    print(r.getNome() +" "+ r.getCognome() +" "+ str(i.getImpOrario()) +" "+ i.getProgetto().getTitolo())
        except IOError as i:
            print(i)

if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument('progetto', action='store')
    pa = parser.parse_args()
    m = Main(pa.progetto)
    m.main()