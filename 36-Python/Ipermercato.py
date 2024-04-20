from Supermercato import Supermercato

class Ipermercato (Supermercato):
    def __init__(self, codice, tipo, indirizzo, mq, addetti, nomeIper) -> None:
        super().__init__(codice, tipo, indirizzo, mq, addetti)
        self._nomeIper = nomeIper
    
    def __str__(self) -> str:
        return super().__str__() + "\t-\t-\t" + str(self._mq) + "\t" + str(self._addetti) + "\t" + self._nomeIper