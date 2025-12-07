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
            print(f"Advertencia: Archivo {self.nombre_archivo} corrupto. Reiniciando contenido.")
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
class Producto:
    def __init__(self, codigo, nombre, precio, stock):
        self._codigo = codigo
        self._nombre = nombre
        self._precio = precio
        self._stock = stock
    def mostrar_datos(self):
        print(f"Código: {self._codigo}, Nombre: {self._nombre}, Precio: {self._precio}, Stock: {self._stock}")
    def get_codigo(self):
        return self._codigo
    def get_precio(self):
        return self._precio
class ArchProducto(Persistencia):
    def __init__(self, nombre_archivo="productos_e3.txt"):
        super().__init__(nombre_archivo)
    def cargar(self):
        data = super().cargar_datos()
        return [self._deserializar(d, Producto) for d in data]
    def guardar(self, productos):
        data = self._serializar(productos)
        super().guardar_datos(data)
    def guardar_producto(self, producto):
        productos = self.cargar()
        productos.append(producto)
        self.guardar(productos)
    def busca_producto(self, codigo):
        """Busca y muestra un producto por su código."""
        productos = self.cargar()
        for p in productos:
            if p.get_codigo() == codigo:
                print("--- Producto Encontrado ---")
                p.mostrar_datos()
                return
        print(f"Producto con código {codigo} no encontrado.")
    def calcular_promedio_precios(self):
        """Calcula y devuelve el precio promedio de todos los productos."""
        productos = self.cargar()
        if not productos:
            return 0.0
        total_precios = sum(p.get_precio() for p in productos)
        return total_precios / len(productos)
    def mostrar_producto_mas_caro(self):
        """Muestra los datos del producto con el precio más alto."""
        productos = self.cargar()
        if not productos:
            return None
        producto_max = max(productos, key=lambda p: p.get_precio())
        print("--- Producto Más Caro ---")
        producto_max.mostrar_datos()
        return producto_max
print("\n--- EJERCICIO 3: Gestión de Productos ---")
arch_producto = ArchProducto("productos_e3.txt")
p1 = Producto(1, "Laptop", 5000.0, 10)
p2 = Producto(2, "Mouse", 50.0, 100)
p3 = Producto(3, "Monitor", 2500.0, 25)
arch_producto.guardar([p1, p2, p3])

arch_producto.busca_producto(1)
print(f"\nPromedio de precios: {arch_producto.calcular_promedio_precios():.2f} Bs.")
arch_producto.mostrar_producto_mas_caro()
p4 = Producto(4, "Teclado", 150.0, 50)
arch_producto.guardar_producto(p4)
print("\nVerificando que se agregó Teclado:")
arch_producto.busca_producto(4)