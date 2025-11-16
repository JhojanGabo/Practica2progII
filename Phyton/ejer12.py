class Doctor:
    def __init__(self, nombre, especialidad):
        self.nombre = nombre
        self.especialidad = especialidad

    def mostrar(self):
        print(f"  - Dr. {self.nombre} (Especialidad: {self.especialidad})")

    def get_nombre(self):
        return self.nombre

class Hospital:
    def __init__(self, nombre):
        self.nombre = nombre
        self.doctores = []

    def asignar_doctor(self, doctor):
        self.doctores.append(doctor)
        print(f"El Dr. {doctor.get_nombre()} ha sido asignado al {self.nombre}")

    def mostrar_doctores(self):
        print(f"Doctores en {self.nombre}:")
        if not self.doctores:
            print("  (No hay doctores asignados)")
        for doctor in self.doctores:
            doctor.mostrar()

if __name__ == "__main__":
    dr1 = Doctor("Juan Perez", "Cardiología")
    dr2 = Doctor("Ana Gomez", "Pediatría")
    dr3 = Doctor("Luis Soliz", "Neurología")

    hospital_a = Hospital("Hospital General")
    hospital_b = Hospital("Clínica del Sur")

    hospital_a.asignar_doctor(dr1)
    hospital_a.asignar_doctor(dr2)

    hospital_b.asignar_doctor(dr3)
    hospital_b.asignar_doctor(dr1)

    hospital_a.mostrar_doctores()
    print()
    hospital_b.mostrar_doctores()