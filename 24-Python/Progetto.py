class Progetto:
    def __init__(self, codice, tipo, titolo, nomeCognome, coordinatore, milioni) -> None:
        self._codice = codice
        self._tipo = tipo
        self._titolo = titolo
        self._nomeCognome = nomeCognome
        self._coordinatore = coordinatore
        self._milioni = milioni
        self._impegno = []

    def getCodice(self):
        return self._codice
    
    def addImpegno(self, impegno):
        self._impegno.append(impegno)

    def getTitolo(self):
        return self._titolo

    def __str__(self) -> str:
        return self._tipo +"\t"+ self._titolo +"\t"+ str(self._codice) +"\t"+ self._nomeCognome +"\t"+ self._coordinatore