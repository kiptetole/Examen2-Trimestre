'''
Clase Cuadrado hereda de la clase rectangulo.

metodo diferente a la clase rectangulo:

 -Compara Cuadrado. Compara 2 cuadrados para ver cual es mas grande.

@author: Jose Notario Millan
'''
from Ejercicio3_Examen2ºTrimestre.Rectangulo import Rectangulo

class Cuadrado(Rectangulo):

    def __init__(self, lado):
        super().__init__(lado, lado)

    @property
    def lado(self):
        return self.ancho

    @lado.setter
    def lado(self, lado):
        Cuadrado.verifica_lado(lado)
        self.alto = lado
        self.ancho = lado
    
    def __gt__(self, other):
        return (self.lado) > (other.lado)

    def __ge__(self, other):
        return (self.lado) >= (other.lado)

    def __eq__(self, other):
        return (self.lado) == (other.lado)

    @staticmethod
    def __verifica_lado(num):
        if (num <= 0 or num > 10):
            raise ArithmeticError()    