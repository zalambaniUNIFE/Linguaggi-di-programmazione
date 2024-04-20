from Veicolo import Veicolo

class Caravan(Veicolo):
    def __init__(self, codice, marca, larghezza, lunghezza, costo, posti, potenza) -> None:
        super().__init__(codice, marca, larghezza, lunghezza, costo, posti)
        self._potenza = potenza

    def __str__(self) -> str:
        return "caravan\t" + super().__str__() + "\t-\t-\t" + str(self._potenza) + "\t" + str(self._costo)