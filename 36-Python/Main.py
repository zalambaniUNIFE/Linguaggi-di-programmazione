import sys
import argparse

from Cittadino import Cittadino
from Ipermercato import Ipermercato
from Cliente import Cliente
from Visita import Visita


class Main:
    def __init__(self, arg):
        self._arg = arg
    
    def main(self):
        supermercati = []
        clienti = []

        try: 
            f = open("supermercati.txt", "r")
            line = f.readline().strip()
            while (line != ''):
                tok = line.split()
                codice = int(tok[0])
                tipo = tok[1]
                indirizzo = f.readline().strip()
                line = f.readline().strip()
                tok = line.split()
                if (tipo == "cittadino"):
                    orarioApertura = int(tok[0])
                    orarioChiusura = int(tok[1])
                    mq = float(tok[2])
                    addetti = int(tok[3])
                    s = Cittadino(codice, tipo, indirizzo, mq, addetti, orarioApertura, orarioChiusura)
                    supermercati.append(s)
                else:
                    mq = float(tok[0])
                    addetti = int(tok[1])
                    nomeIper = f.readline().strip()
                    s = Ipermercato(codice, tipo, indirizzo, mq, addetti, nomeIper)
                    supermercati.append(s)
                line = f.readline().strip()
            f.close()
        except IOError as i:
            print(i)
        except Exception as e:
            print(e)

        try:
            f = open("clienti.txt", "r")
            line = f.readline().strip()
            while (line != ''):
                cognome = line
                nome = f.readline().strip()
                c = Cliente(cognome, nome)
                clienti.append(c)
                line = f.readline().strip()
                while (line != ''):
                    tok = line.split()
                    codice = int(tok[0])
                    importo = float(tok[1])
                    spesa = Visita(codice, importo)
                    c.addVisita(spesa)
                    line = f.readline().strip()
                line = f.readline().strip()
            f.close()
        except IOError as i:
            print(i)
        except Exception as e:
            print(e)

        print("codice, tipo, indirizzo, apertura, chiusura, superficie, n.addetti, centro commerciale")
        for s in supermercati:
            print(s)
        
        print("\n")
        print("cognome, nome, spesa totale")
        for c in clienti:
            print(c)

        print("\n")

        try:
            cod = int(self._arg)
            totale = 0.0
            n_visite = 0
            for c in clienti:
                visite = c.getVisite()
                for v in visite:
                    if (cod == v.getCodice()):
                        n_visite = n_visite + 1
                        totale = totale + v.getSpesa()
            spesa_media = totale/n_visite
            print(str(cod) + "\t" + str(spesa_media))
        except IOError as i:
            print(i)

if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument('supermercato', action='store')
    pa = parser.parse_args()
    m = Main(pa.supermercato)
    m.main()