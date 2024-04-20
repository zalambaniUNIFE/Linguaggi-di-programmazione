from Campo import Campo
class Tennis(Campo):
    def __init__(self, codice, sport, nomeCampo, larghezza, lunghezza, costoOrario, temperatura, terreno) -> None:
        super().__init__(codice, sport, nomeCampo, larghezza, lunghezza, costoOrario)
        self._temperatura = temperatura
        self._terreno = terreno

    def __str__(self) -> str:
        return super().__str__() +"\t"+ str(self._temperatura) +"\t"+ self._terreno +"\t-\t-\t"+ str(self._costoOrario)