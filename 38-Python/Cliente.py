class Cliente:
    def __init__(self, codice, nome, cognome, indirizzo) -> None:
        self._codice = codice
        self._nome = nome
        self._cognome = cognome
        self._indirizzo = indirizzo
        self._noleggi = []

    def addNoleggio(self, noleggio):
        self._noleggi.append(noleggio)

    def __str__(self):
        return str(self._codice) + "\t" + self._cognome + "\t" + self._nome +"\t" + self._indirizzo + "\t" +str([str(noleggio) for noleggio in self._noleggi])