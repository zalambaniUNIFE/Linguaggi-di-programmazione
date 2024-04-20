class Campo:
    def __init__(self, codice, sport, nomeCampo, larghezza, lunghezza, costoOrario) -> None:
        self._codice = codice
        self._sport = sport
        self._nomeCampo = nomeCampo
        self._larghezza = larghezza
        self._lunghezza = lunghezza
        self._costoOrario = costoOrario
        self._prenotazioni = 0

    def addPrenotazioni(self):
        self._prenotazioni += 1
    
    def incasso(self):
        return self._prenotazioni * self._costoOrario

    def __str__(self) -> str:
        return self._sport +"\t"+ self._nomeCampo +"\t"+ str(self._codice) +"\t"+ str(self._larghezza) +"\t"+ str(self._lunghezza)