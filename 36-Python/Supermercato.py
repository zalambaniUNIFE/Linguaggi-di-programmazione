class Supermercato:
    def __init__(self, codice, tipo, indirizzo, mq, addetti) -> None:
        self._codice = codice
        self._tipo = tipo
        self._indirizzo = indirizzo
        self._mq = mq
        self._addetti = addetti
    
    def __str__(self) -> str:
        return str(self._codice) + "\t" + self._tipo + "\t" + self._indirizzo