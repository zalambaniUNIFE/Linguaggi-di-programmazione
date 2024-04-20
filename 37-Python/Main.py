import sys
import argparse

from Campo import Campo
from Tennis import Tennis
from Squash import Squash
from Socio import Socio
from Prenotazione import Prenotazione

class Main:

    def __init__(self, arg) -> None:
        self._arg = arg

    def main(self):
        campi = []
        soci = []
        codCampi = {}

        try:
            f = open("campi.txt", "r")
            line = f.readline().strip()
            while (line != ''):
                tok = line.split()
                codice = int(tok[0])
                sport = tok[1]
                nomeCampo = f.readline().strip()
                line = f.readline().strip()
                if (sport == "tennis"):
                    tok = line.split()
                    larghezza = float(tok[0])
                    lunghezza = float(tok[1])
                    temperatura = float(tok[2])
                    terreno = f.readline().strip()
                    costoOrario = float(f.readline().strip())
                    c = Tennis(codice, sport, nomeCampo, larghezza, lunghezza, costoOrario, temperatura, terreno)
                    campi.append(c)
                    codCampi[codice] = c
                else:
                    tok = line.split()
                    larghezza = float(tok[0])
                    lunghezza = float(tok[1])
                    altezza = float(tok[2])
                    piano = float(tok[3])
                    costoOrario = float(tok[4])
                    c = Squash(codice, sport, nomeCampo, larghezza, lunghezza, costoOrario, altezza, piano)
                    campi.append(c)
                    codCampi[codice] = c
                line = f.readline().strip()
            f.close()
        except IOError as i:
            print(i)
        except Exception as e:
            print(e)

        try:
            f = open("soci.txt", "r")
            line = f.readline().strip()
            while (line != ''):
                codiceSocio = int(line)
                nomeCognome = f.readline().strip()
                line = f.readline().strip()
                tok = line.split()
                eta = int(tok[0])
                categoria = int(tok[1])
                s = Socio(codiceSocio, nomeCognome, eta, categoria)
                soci.append(s)
                line = f.readline()
                tok = line.split()
                for i in range(len(tok)//2):
                    print(i)
                    codice = int(tok[i*2])
                    oraInizio = int (tok[i*2+1])
                    p = Prenotazione (codice, oraInizio)
                    s.addPrenotazioni(p)
                    codCampi[codice].addPrenotazioni()
                line = f.readline().strip()
            f.close()
        except IOError as i:
            print(i)
        except Exception as e:
            print(e)

        print("sport, nome del campo, codice, larghezza, lunghezza, temperatura, terreno, altezza, piano, costo")
        for c in campi:
            print(c)

        print("codice, nome e cognome, età, categoria, prenotazioni")
        for s in soci:
            print(s)

        try:
            cod = int(self._arg)
            print(str(codCampi.get(cod).incasso()))
        except IOError as i:
            print(i)

if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument('campo', action='store')
    pa = parser.parse_args()
    m = Main(pa.campo)
    m.main()
        