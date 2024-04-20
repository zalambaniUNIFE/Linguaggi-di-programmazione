class Socio:
    def __init__(self, codiceSocio, nomeCognome, eta, categoria) -> None:
        self._codiceSocio = codiceSocio
        self._nomeCognome = nomeCognome
        self._eta = eta
        self._categoria = categoria
        self._prenotazioni = []

    def addPrenotazioni(self, prenotazione):
        self._prenotazioni.append(prenotazione)
    
    def __str__(self) -> str:
        return str(self._codiceSocio) +"\t"+ self._nomeCognome +"\t"+ str(self._eta) +"\t"+ str(self._categoria) +"\t"+ str([str(prenotazione) for prenotazione in self._prenotazioni])