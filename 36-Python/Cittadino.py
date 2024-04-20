from Supermercato import Supermercato

class Cittadino (Supermercato):
    def __init__(self, codice, tipo, indirizzo, mq, addetti, orarioApertura, orarioChiusura) -> None:
        super().__init__(codice, tipo, indirizzo, mq, addetti)
        self._orarioApertura = orarioApertura
        self._orarioChiusura = orarioChiusura

    def __str__(self) -> str:
        return super().__str__() + "\t" + str(self._orarioApertura) + "\t" + str(self._orarioChiusura) + "\t" + str(self._mq) + "\t" + str(self._addetti) + "\t-"