'''
Prueba de la clase Cuadrado.

@author: Jose Notario Millan.
'''
from Ejercicio3_Examen2║Trimestre.Cuadrado import Cuadrado

lado = int(input("Introduzca el valor del lado del 1┬║ Cuadrado: "))
lado2= int(input("Introduzca el valor del lado del 2┬║ Cuadrado: "))

cuadrado = Cuadrado(lado, lado)  
cuadrado2 = Cuadrado(lado2, lado2)

print(cuadrado.dibujo())

print(cuadrado.comparaCuadrado(cuadrado2)) 