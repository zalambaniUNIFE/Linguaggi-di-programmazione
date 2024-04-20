from Progetto import Progetto

class Innovazione(Progetto):
    def __init__(self, codice, tipo, titolo, nomeCognome, coordinatore, milioni, numAziende) -> None:
        super().__init__(codice, tipo, titolo, nomeCognome, coordinatore, milioni)
        self._numAziende = numAziende

    def __str__(self) -> str:
        return super().__str__() +"\t-\t-\t"+ str(self._numAziende) + str(self._milioni * 1000)