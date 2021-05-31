class Car:
  
  def __init__(self, manufacturer, model, make, transmission, color):
    self.manufacturer = manufacturer
    self.model = model
    self.make = make
    self.transmission = transmission
    self.color = color
    
  def accelerate(self):
    print(self.manufacturer + " " + self.model + " is moving")
  def stop(self):
    print(self.manufacturer + " " + self.model + " has stopped")

car1 = Car("Kia", "Seltos", 2020, "Manual", "White")
car2 = Car("Maruti Suzuki", "Baleno", 2017, "Manual", "White")
car3 = Car("Hyundai", "Santro", 2011, "Manual", "Grey")

car1.accelerate()
car1.stop()