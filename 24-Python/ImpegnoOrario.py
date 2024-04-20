class ImpegnoOrario:
    def __init__(self, progetto, impOrario) -> None:
        self._progetto = progetto
        self._impOrario = impOrario

    def getImpOrario(self):
        return self._impOrario
    
    def getProgetto(self):
        return self._progetto

    def __str__(self) -> str:
        return "(" + str(self._progetto.getCodice()) +","+ str(self._impOrario) +")"