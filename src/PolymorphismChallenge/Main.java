package PolymorphismChallenge;

class Car {
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        this.engine = true;
        this.wheels = 4;
    }

    public boolean isEngine() {
        System.out.println("Car -> isEngine()");
        return engine;
    }

    public int getCylinders() {
        System.out.println("Car -> getCylinders()");
        return cylinders;
    }

    public int getWheels() {
        System.out.println("Car -> getWheels()");
        return wheels;
    }

    public String run() {
        return getClass().getSimpleName() + " Not running!";
    }

    public String getName() {
   //     System.out.println("Car -> getName()");
        return name;
    }
}

class Eclipse extends Car {

    public Eclipse(int cylinders, String name) {
        super(cylinders, name);
    }

    public String run() {
        return getClass().getSimpleName() + " Running Eclipse";
    }
}

class Shadow extends Car {

    public Shadow(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String run() {
        return getClass().getSimpleName() + " Running Shadow";
    }
}

class Mirage extends Car {

    public Mirage(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String run() {
        return getClass().getSimpleName() + " Running Mirage";
    }
}

class Unknown extends Car {
    public Unknown(int cylinders, String name) {
        super(cylinders, name);
    }

    // No plot method
}


public class Main {

    public static void main(String[] args) {
        for(int i=1; i<11; i++) {
            Car car = randomCar();
            System.out.println("Car #" + i +
                    " : " + car.getName() + "\n" +
                    "Running: " + car.run() + "\n");
        }
    }

    public static Car randomCar() {
        int randomNumber = (int) (Math.random() * 4) +1;
        System.out.println("Random number generated was: " + randomNumber);
        switch (randomNumber) {
            case 1:
                return new Eclipse(6, "E GTS");
            case 2:
                return new Unknown(0, "na");
            case 3:
                return new Shadow(4, "S LS");
            case 4:
                return new Mirage(4, "M LS");
        }

        return null;
    }
}
