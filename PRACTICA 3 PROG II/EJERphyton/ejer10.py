import json
import os
class Persistencia:
    def __init__(self, nombre_archivo):
        self.nombre_archivo = nombre_archivo
        self._verificar_archivo()

    def _verificar_archivo(self):
       
        if not os.path.exists(self.nombre_archivo) or os.stat(self.nombre_archivo).st_size == 0:
            with open(self.nombre_archivo, 'w') as f:
                json.dump([], f)

    def guardar_datos(self, datos):
        with open(self.nombre_archivo, 'w') as f:
            json.dump(datos, f, indent=4)

    def cargar_datos(self):
        try:
            with open(self.nombre_archivo, 'r') as f:
                return json.load(f)
        except json.JSONDecodeError:
            
            with open(self.nombre_archivo, 'w') as f:
                json.dump([], f)
            return []

    
    def _serializar(self, objeto):
        if isinstance(objeto, list):
            return [self._serializar(item) for item in objeto]
        if hasattr(objeto, '__dict__'):
          
            data = objeto.__dict__.copy()
            
            limpio = {}
            for key, value in data.items():
                if key.startswith('_'):
                    limpio[key.lstrip('_')] = value 
                else:
                    limpio[key] = value
            return limpio
        return objeto

    def _deserializar(self, data, clase):
        if isinstance(data, dict):
            return clase(**data)
        return data
class Jugador:
    def __init__(self, nombre, nivel, puntaje):
       
        self._nombre = nombre
        self._nivel = nivel
        self._puntaje = puntaje
    def mostrar_datos(self):
        print(f"Nombre: {self._nombre}, Nivel: {self._nivel}, Puntaje: {self._puntaje}")
    def get_nombre(self):
        return self._nombre

class ArchivoJugador(Persistencia):
    def __init__(self, nombre_archivo="jugadores_e10.txt"):
        super().__init__(nombre_archivo)
    def cargar(self):
        data = super().cargar_datos()
        return [self._deserializar(d, Jugador) for d in data]
    def guardar(self, jugadores):
        data = self._serializar(jugadores)
        super().guardar_datos(data)
    def agregar(self, jugador):
        jugadores = self.cargar()
        jugadores.append(jugador)
        self.guardar(jugadores)
    def mostrar_todos(self):
        jugadores = self.cargar()
        print("--- Lista de Jugadores ---")
        for j in jugadores:
            j.mostrar_datos()
    def buscar_por_nombre(self, nombre):
        jugadores = self.cargar()
        for j in jugadores:
            if j.get_nombre() == nombre:
                print(f"Jugador encontrado:")
                j.mostrar_datos()
                return
        print(f"Jugador {nombre} no encontrado.")
print("\n--- EJERCICIO 10: Jugadores (VERSIÓN FINAL) ---")
arch_jugador = ArchivoJugador("jugadores_e10.txt")

j1 = Jugador("DarkKnight", 10, 5000)
j2 = Jugador("GamerPro", 20, 12000)
arch_jugador.guardar([j1, j2]) 
arch_jugador.agregar(Jugador("NoobSlayer", 5, 1000))
arch_jugador.mostrar_todos()
arch_jugador.buscar_por_nombre("DarkKnight")