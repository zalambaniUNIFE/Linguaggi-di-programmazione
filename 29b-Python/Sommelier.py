from Impiegato import Impiegato

class Sommelier(Impiegato):
    ore_settimanli: int
    specialita: str

    def __init__(self, codice: int, tipo: str, nome: str, costo_orario: float, ore_settimanali: int, specialita: str):
        super().__init__(codice, tipo, nome, costo_orario)
        self.ore_settimanli = ore_settimanali
        self.specialita = specialita

    def __str__(self) -> str:
        return super().__str__() + ", " + str(self.ore_settimanli) + ", " + self.specialita + ", -, -, -, " + str(self.costo_orario)