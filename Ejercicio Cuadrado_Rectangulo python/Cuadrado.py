'''
Clase Cuadrado hereda de la clase rectangulo.

metodo diferente a la clase rectangulo:

 -Compara Cuadrado. Compara 2 cuadrados para ver cual es mas grande.

@author: Jose Notario Millan
'''
from Ejercicio3_Examen2ºTrimestre.Rectangulo import Rectangulo

class Cuadrado(Rectangulo):
    
    def __init__(self,alto,ancho):
        Rectangulo.__init__(self,alto,ancho)
        
    def comparaCuadrado(self, cuadrado):
        if self.alto == cuadrado.alto:
            return "Los cuadrados son iguales"
        if self.alto < cuadrado.alto:
            return "El primer cuadrado es menor que el dado"
        if self.alto > cuadrado.alto:
            return "EL primer cuadrado es mayor que el dado"