'''
Prueba de la clase Cuadrado.

@author: Jose Notario Millan.
'''
from Ejercicio3_Examen2ºTrimestre.Cuadrado import Cuadrado

cuadrado = Cuadrado(int(input("Introduzca el valor del lado del 1º Cuadrado: ")))  
cuadrado2 = Cuadrado(int(input("Introduzca el valor del lado del 2º Cuadrado: ")))

print(cuadrado)

print(cuadrado.__eq__(cuadrado2))