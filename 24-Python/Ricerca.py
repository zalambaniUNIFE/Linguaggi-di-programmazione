from Progetto import Progetto

class Ricerca(Progetto):
    def __init__(self, codice, tipo, titolo, nomeCognome, coordinatore, milioni, argomento, numPartner) -> None:
        super().__init__(codice, tipo, titolo, nomeCognome, coordinatore, milioni)
        self._argomento = argomento
        self._numPartner = numPartner

    def __str__(self) -> str:
        return super().__str__() +"\t"+ self._argomento +"\t"+ str(self._numPartner) +"\t-\t"+ str(self._milioni * 1000)