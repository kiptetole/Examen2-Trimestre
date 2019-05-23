'''
Esta es la clase Rectangulo donde va a tener en cuenta:
 Campos: 
     - Ancho:Valor de la base del rectangulo 
     - Alto:Valor de la altura del rectangulo.
  
 Metodos: 
       - Getters y setters: Respectivamente de cada campo. 
       - Dibuja : Este metodo devuelve la cadena de caracteres que representa graficamente
           el cuadrado.

@author: Jose Notario Millan
'''

class Rectangulo:

    def __init__(self, ancho, alto):
        self.__ancho = ancho
        self.__alto = alto

    @property
    def ancho(self):
        return self.__ancho

    @ancho.setter
    def ancho(self, an):
        Rectangulo.verifica_lado(an)
        self.__ancho = an

    @property
    def alto(self):
        return self.__alto

    @alto.setter
    def alto(self, al):
        Rectangulo.verifica_lado(al)
        self.__alto = al

    @staticmethod
    def verifica_lado(num):
        if (num <= 0 or num > 10):
            raise ArithmeticError()
        
    '''
    
        Metodo que dibuja el rectangulo segun su altura y anchura.
    
    '''
    def __str__(self):
        linea = ""
        
        for i in range(0,self.ancho):
            linea += "[]"
        linea += "\n"
          
        for i in range(1,self.alto-1):
            for j in range(0,self.ancho):
                if j == 0 or j == self.ancho-1:
                    linea += "[]"
                else:
                    linea += "  "
        
            linea += "\n"
        
        if self.alto>1:
            for i in range(0,self.ancho):
                linea += "[]"
        
        return linea