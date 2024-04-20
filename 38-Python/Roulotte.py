from Veicolo import Veicolo

class Roulotte(Veicolo):
    def __init__(self, codice, marca, larghezza, lunghezza, costo, posti, peso, veranda) -> None:
        super().__init__(codice, marca, larghezza, lunghezza, costo, posti)
        self._peso = peso
        self._veranda = veranda

    def __str__(self) -> str:
        return "roulotte\t" + super().__str__() + "\t" + self._veranda + "\t-\t" + str(self._costo)