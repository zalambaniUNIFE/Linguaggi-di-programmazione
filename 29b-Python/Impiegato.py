from Servizio import Servizio

class Impiegato:
    codice: int
    tipo: str
    nome: str
    costo_orario: float # Python non ha il tipo Double

    servizi: list[Servizio]

    def __init__(self, codice: int, tipo: str, nome: str, costo_orario: float, servizi: list[Servizio] = None):
        self.codice = codice
        self.tipo = tipo
        self.nome = nome
        self.costo_orario = costo_orario

        if servizi is None:
            self.servizi = []
        else:
            self.servizi = servizi

    def add_servizio(self, servizio: Servizio):
        self.servizi.append(servizio)

    def numero_servizi(self) -> int:
        return len(self.servizi)

    def __str__(self) -> str:
        return self.nome + ", " + str(self.codice) + ", " + self.tipo