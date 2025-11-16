class NumeroInvalidoException(Exception):
    pass

class Calculadora:
    
    @staticmethod
    def sumar(a, b):
        return a + b

    @staticmethod
    def restar(a, b):
        return a - b

    @staticmethod
    def multiplicar(a, b):
        return a * b

    @staticmethod
    def dividir(a, b):
        if b == 0:
            raise ZeroDivisionError("No se puede dividir por cero.")
        return a / b

    @staticmethod
    def convertir_a_numero(texto):
        try:
            return int(texto)
        except ValueError:
            raise NumeroInvalidoException(f"El valor '{texto}' no es un número válido.")

if __name__ == "__main__":
    print("Probando Calculadora...")

    print(f"Suma 5 + 3 = {Calculadora.sumar(5, 3)}")
    print(f"Resta 10 - 4 = {Calculadora.restar(10, 4)}")
    print(f"Mult 6 * 7 = {Calculadora.multiplicar(6, 7)}")

    try:
        print(f"Div 10 / 2 = {Calculadora.dividir(10, 2)}")
        print(f"Div 10 / 0 = {Calculadora.dividir(10, 0)}")
    except ZeroDivisionError as e:
        print(f"Error en división: {e}")

    try:
        num1 = Calculadora.convertir_a_numero("123")
        print(f"Convertido '123' a {num1}")
        
        num2 = Calculadora.convertir_a_numero("abc")
        print(f"Convertido 'abc' a {num2}")
        
    except NumeroInvalidoException as e:
        print(f"Error de conversión: {e}")

    try:
        num3 = Calculadora.convertir_a_numero("5.5")
        print(f"Convertido '5.5' a {num3}")
        
    except NumeroInvalidoException as e:
        print(f"Error de conversión: {e}")