class Veicolo:
    def __init__(self, codice, marca, larghezza, lunghezza, costo, posti) -> None:
        self._codice = codice
        self._marca = marca
        self._larghezza = larghezza
        self._lunghezza = lunghezza
        self._costo = costo
        self._posti = posti
        self._noleggi = []

    def addNoleggio(self, noleggi):
        self._noleggi.append(noleggi)

    def incasso(self):
        giorni = 0
        for n in self._noleggi:
            giorni = giorni + n.getGiorni()
        return giorni * self._costo

    def getCodice(self):
        return self._codice
    
    def __str__(self) -> str:
        return str(self._codice) + "\t" + self._marca + "\t" + str(self._larghezza) + "\t" + str(self._lunghezza) + "\t" + str(self._posti)