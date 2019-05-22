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

class Rectangulo():
    
    def __init__(self, ancho, alto):
        Rectangulo.__comprobarAncho(ancho)
        Rectangulo.__comprobarAlto(alto)
        self.__ancho = ancho
        self.__alto = alto
    
    @property
    def ancho(self):
        return self.__ancho
    @property
    def alto(self):
        return self.__alto
    
    ##Setters##
    @ancho.setter
    def ancho(self, ancho):
        Rectangulo.__comprobarAncho(ancho)
        self.__ancho = ancho
        
    @alto.setter
    def alto(self, alto):
        Rectangulo.__comprobarAlto(alto)
        self.__alto = alto
    
    ## Lanzamiento de Exepciones ##
    @staticmethod
    def __comprobarAncho(ancho):
        if ancho <= 0 or ancho > 10:
            raise TypeError("El ancho indicado es inválido.")
    
    @staticmethod
    def __comprobarAlto(alto):
        if alto <= 0 or alto > 10:
            raise TypeError("El alto indicado es inválido.")
        
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