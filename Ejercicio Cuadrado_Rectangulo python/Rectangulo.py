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
    
    def __init__(self,alto,ancho):
    
        self.setAlto(alto)
        self.setAncho(ancho)
    
    '''

        Metodo para asignar el valor la altura de el rectangulo.
    
    '''

    def setAlto(self, alto):
        
        try:
            if alto <= 0 or alto > 10: 
                raise Exception
        except Exception:  
            print('La altura no puede ser negativo o mayor que 10')
            self.alto = 0
        else:
            self.alto = alto
            
    '''

        Metodo para asignar el valor de ancho de el rectangulo.
    
    '''
    def setAncho(self, ancho):
        
        try:
            if ancho <= 0 or ancho > 10:
                raise Exception()
        except Exception: 
            print('El ancho no puede ser negativo o mayor que 10')
            self.ancho = 0;
        else:
            self.ancho = ancho
            
    '''
    
        Metodo que dibuja el rectangulo segun su altura y anchura.
    
    '''
    def dibujo(self):
        linea = ""
        
        
        for i in range(0,self.alto):
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