from Campo import Campo
class Squash(Campo):
    def __init__(self, codice, sport, nomeCampo, larghezza, lunghezza, costoOrario, altezza, piano) -> None:
        super().__init__(codice, sport, nomeCampo, larghezza, lunghezza, costoOrario)
        self._altezza = altezza
        self._piano = piano
    
    def __str__(self) -> str:
        return super().__str__() +"\t-\t-\t"+ str(self._altezza) +"\t"+ str(self._piano) +"\t"+ str(self._costoOrario)