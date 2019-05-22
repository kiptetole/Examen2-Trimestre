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
        self.lado = lado
        
    @property
    def lado(self):
        return self.__lado
    
    @lado.setter
    def lado(self, lado):
        self.__lado = lado

    """
    Método equals para comprar los lados de un cuadrado.
    """
    
    def __eq__(self, comparacion):
        if self.__lado == comparacion.__lado:
            return "Los cuadrados son iguales."
        else:
            if  self.__lado >= comparacion.__lado:
                return "El cuadrado 1 es mayor."
            else:
                return "El cuadrado 1 es menor."
        