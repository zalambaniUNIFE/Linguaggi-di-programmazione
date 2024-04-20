class Noleggio:
    def __init__(self, codice, giorni) -> None:
        self._codice = codice
        self._giorni = giorni

    def getGiorni(self):
        return self._giorni
    
    def __str__(self):
        return "("+str(self._codice) + "," + str(self._giorni) + ")"