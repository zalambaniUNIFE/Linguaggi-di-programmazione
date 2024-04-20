from ImpegnoOrario import ImpegnoOrario

class Ricercatore:
    def __init__(self, nomeRic, cognomeRic) -> None:
        self._nomeRic = nomeRic
        self._cognomeRic = cognomeRic
        self._impegno = []

    def addImpegno(self, progetto, imp):
       impegnoOrario = ImpegnoOrario(progetto, imp)
       self._impegno.append(impegnoOrario)

    def getTotale(self):
        tot_impegni = 0
        for i in self._impegno:
            tot_impegni += i.getImpOrario()
        return tot_impegni
    
    def getCognome(self):
        return self._cognomeRic
    
    def getNome(self):
        return self._nomeRic
    
    def getProgetti(self):
        return len(self._impegno)
    
    def getImpegnoMaggiore(self):
        impegnoMaggiore = -1000
        for i in self._impegno:
            if (i.getImpOrario() > impegnoMaggiore):
                impegnoMaggiore = i.getImpOrario()
                io = i
        return io
    
    def __str__(self) -> str:
        self._totaleOre = self.getTotale()
        self._progetto = self.getProgetti()
        return  self._nomeRic +"\t"+ self._cognomeRic +"\t"+ str(self._totaleOre) +"\t"+ str(self._progetto) +"\t"+ str([str(imp) for imp in self._impegno])