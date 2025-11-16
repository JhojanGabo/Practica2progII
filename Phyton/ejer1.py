class RAM:
    def __init__(self, capacidad, marca, tipo):
        self._capacidad = 4
        self.set_capacidad(capacidad)
        self.marca = marca
        self.tipo = tipo

    def get_capacidad(self):
        return self._capacidad

    def set_capacidad(self, capacidad):
        if 4 <= capacidad <= 64:
            self._capacidad = capacidad
        else:
            print(f"Error: Capacidad de RAM debe estar entre 4 y 64 GB. Se asignó 4GB.")
            self._capacidad = 4

    def mostrar(self):
        print(f"  RAM: {self.marca} {self.tipo} {self._capacidad}GB")

class DiscoDuro:
    def __init__(self, capacidad, marca, modelo):
        self.capacidad = capacidad
        self.marca = marca
        self.modelo = modelo

    def get_capacidad(self):
        return self.capacidad

    def set_capacidad(self, capacidad):
        self.capacidad = capacidad

    def mostrar(self):
        print(f"  Disco: {self.marca} {self.modelo} {self.capacidad}GB")

class Computadora:
    def __init__(self, anio_ensamblaje, *args):
        self.anio_ensamblaje = anio_ensamblaje
        
        if len(args) == 2 and isinstance(args[0], RAM) and isinstance(args[1], DiscoDuro):
            self.ram = args[0]
            self.disco = args[1]
        elif len(args) == 6:
            cap_ram, marca_ram, tipo_ram, cap_disco, marca_disco, modelo_disco = args
            self.ram = RAM(cap_ram, marca_ram, tipo_ram)
            self.disco = DiscoDuro(cap_disco, marca_disco, modelo_disco)
        else:
            self.ram = RAM(8, "Kingston", "DDR4")
            self.disco = DiscoDuro(500, "Seagate", "HDD")

    def encender(self):
        print(f"Computadora {self.anio_ensamblaje} encendiendo...")

    def mostrar(self):
        print(f"--- Computadora {self.anio_ensamblaje} ---")
        self.ram.mostrar()
        self.disco.mostrar()
        print("---------------------------")

    def modificar_capacidad_ram(self, nueva_capacidad):
        self.ram.set_capacidad(nueva_capacidad)
        print(f"Capacidad de RAM modificada a {nueva_capacidad}GB.")

    def modificar_capacidad_disco(self, nueva_capacidad):
        self.disco.set_capacidad(nueva_capacidad)
        print(f"Capacidad de Disco modificada a {nueva_capacidad}GB.")

if __name__ == "__main__":
    c1 = Computadora(2024, 16, "Corsair", "DDR5", 1000, "Samsung", "SSD")
    c2 = Computadora(2025)

    ram3 = RAM(32, "Crucial", "DDR4")
    disco3 = DiscoDuro(2000, "WD", "HDD")
    c3 = Computadora(2023, ram3, disco3)

    c1.encender()
    c1.mostrar()

    c2.mostrar()
    c2.modificar_capacidad_ram(100) 
    c2.mostrar()

    c3.mostrar()
    c3.modificar_capacidad_disco(4000)
    c3.mostrar()