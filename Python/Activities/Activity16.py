class Car:
    'This class represents a car'

    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer + " " + self.model + " is moving.")

    def stop(self):
        print(self.manufacturer + " " + self.model + " has stopped.")


car1 = Car("Hyundai", "Verna", "2016", "Automatic", "Black")
car2 = Car("Maruti", "SCross", "2015", "Manual", "Brown")
car3 = Car("Tata", "Hexa", "2017", "Manual", "Blue")

car1.accelerate()
car1.stop()

car2.accelerate()
car2.stop()

car3.accelerate()
car3.stop()
