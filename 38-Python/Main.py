import sys
import argparse

from Veicolo import Veicolo
from Roulotte import Roulotte
from Caravan import Caravan
from Cliente import Cliente
from Noleggio import Noleggio

class Main:
    def main():
        veicoli = []
        clienti = []
        codVeicoli = {}

        try:
            f = open("veicoli.txt" , "r")
            line = f.readline().strip()
            while (line != ''):
                tok = line.split()
                codice = int(tok[0])
                tipo = tok[1]
                marca = f.readline().strip()
                line = f.readline().strip()
                tok = line.split()
                if (tipo == "roulotte"):
                    peso = int(tok[0])
                    lunghezza = float(tok[1])
                    larghezza = float(tok[2])
                    posti = int(tok[3])
                    line = f.readline().strip()
                    tok = line.split()
                    veranda = tok[0]
                    costo = float(tok[1])
                    v = Roulotte(codice, marca, larghezza, lunghezza, costo, posti, peso, veranda)
                    veicoli.append(v)
                    codVeicoli[codice] = v
                else:
                    larghezza = float(tok[0])
                    lunghezza = float(tok[1])
                    potenza = int(tok[2])
                    posti = int(tok[3])
                    costo = float(tok[4])
                    v = Caravan (codice, marca, larghezza, lunghezza, costo, posti, potenza)
                    veicoli.append(v)
                    codVeicoli[codice] = v
                
                line = f.readline().strip()
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
                codice = int(line)
                nome = f.readline().strip()
                cognome = f.readline().strip()
                indirizzo = f.readline().strip()
                c = Cliente(codice, nome, cognome, indirizzo)
                clienti.append(c)
                line = f.readline().strip()
                while (line != ''):
                    tok = line.split()
                    codice = int(tok[0])
                    giorni = int(tok[1])
                    noleggio = Noleggio(codice, giorni)
                    c.addNoleggio(noleggio)
                    codVeicoli[codice].addNoleggio(noleggio)
                    line = f.readline().strip()
                
                line = f.readline().strip()
            f.close()
        except IOError as i:
            print(i)
        except Exception as e:
            print(e)

        print("tipo, codice, marca, larghezza, lunghezza, posti letto, peso, veranda, potenza, costo")
        for v in veicoli:
            print(str(v))
        
        print("\n")
        print("codice, cognome, nome, indirizzo, prenotazioni")
        for c in clienti:
            print(c)

        print("\n")
        print("codice, incasso")
        for v in veicoli:
            print(str(v.getCodice()) + "\t" + str(v.incasso()))

if __name__ == "__main__":
    Main.main()
