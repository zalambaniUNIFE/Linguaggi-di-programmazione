class Prenotazione:
    def __init__(self, codice, oraInizio) -> None:
        self._codice = codice
        self._oraInizio = oraInizio
    
    def __str__(self) -> str:
        return "("+ str(self._codice) +","+ str(self._oraInizio) +")"