class ProductoNoEncontradoException(Exception):
    def __init__(self, mensaje):
        super().__init__(mensaje)


class StockInsuficienteException(Exception):
    def __init__(self, mensaje):
        super().__init__(mensaje)
class Producto:
    def __init__(self, codigo, nombre, precio, stock):
        self.codigo = codigo
        self.nombre = nombre
        self.precio = precio
        self.stock = stock

    def reducir_stock(self, cantidad):
        self.stock -= cantidad

    def mostrar_producto(self):
        print(f"{self.codigo} | {self.nombre} | Precio: {self.precio} | Stock: {self.stock}")
class Inventario:
    def __init__(self):
        self.productos = []

    def agregar_producto(self, producto):
        if producto.precio < 0 or producto.stock < 0:
            raise Exception("Precio o stock negativo.")
        
        for p in self.productos:
            if p.codigo == producto.codigo:
                raise Exception("Código duplicado.")
        
        self.productos.append(producto)

    def buscar_producto(self, codigo):
        for p in self.productos:
            if p.codigo == codigo:
                return p
        raise ProductoNoEncontradoException(f"No existe un producto con código {codigo}")

    def vender_producto(self, codigo, cantidad):
        producto = self.buscar_producto(codigo)

        if producto.stock < cantidad:
            raise StockInsuficienteException("Stock insuficiente.")

        producto.reducir_stock(cantidad)

    def mostrar_inventario(self):
        print("=== INVENTARIO ===")
        for p in self.productos:
            p.mostrar_producto()
if __name__ == "__main__":
    inv = Inventario()

    try:
        inv.agregar_producto(Producto("P1", "Pan", 2.5, 10))
        inv.agregar_producto(Producto("P1", "Agua", 1.0, 5))  
    except Exception as e:
        print("ERROR:", e)

    try:
        inv.vender_producto("P1", 20)  
    except Exception as e:
        print("ERROR VENTA:", e)

    try:
        inv.vender_producto("X9", 2)  
    except Exception as e:
        print("ERROR VENTA:", e)

    inv.mostrar_inventario()
