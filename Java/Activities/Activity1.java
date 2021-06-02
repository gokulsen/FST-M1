package activities;

public class Activity1 {

	public static void main(String[] args) {
    	Car myCar = new Car();
    	myCar.color = "White";
    	myCar.transmission = "Manual";
    	myCar.make = "2020";
    	myCar.displayCharacteristics();
    	myCar.accelarate();
    	myCar.brake();
    }

}
