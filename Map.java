public class Map {
    Auto[] cars;
    
    public Map() {
        cars = new Auto[4];
        initializeCars();
    }
    
    private void initializeCars() {
        cars[0] = new Auto();
        cars[0].brand = "Skoda";
        cars[0].cena = 100;
        cars[0].direction = "North";
        
        cars[1] = new Auto();
        cars[1].brand = "Audi";
        cars[1].cena = 500;
        cars[1].direction = "East";
        
        cars[2] = new Auto();
        cars[2].brand = "BMW";
        cars[2].cena = 300;
        cars[2].direction = "South";
        
        cars[3] = new Auto();
        cars[3].brand = "Ferrari";
        cars[3].cena = 1000;
        cars[3].direction = "West";
    }
    
    public void displayCars() {
        for (int i = 0; i < cars.length; i++) {
            System.out.println("Car " + (i+1) + ": " + cars[i].brand + 
                             " - Price: " + cars[i].cena + 
                             " - Direction: " + cars[i].direction);
        }
    }
    
    public static void main(String[] args) {
        Map gameMap = new Map();
        gameMap.displayCars();
    }
}
