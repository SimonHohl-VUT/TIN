package cv2;

public class Main {
    public static void main(String[] args) {
        Map mojeMapa = new Map();

        Auto a1 = new Auto("Skoda", 10, 20);
        Auto a2 = new Auto("BMW", 50, 60);
        Auto a3 = new Auto("Audi", 100, 100);

        mojeMapa.addAuto(a1);
        mojeMapa.addAuto(a2);
        mojeMapa.addAuto(a3);

        System.out.println("Pocet aut na mape: " + mojeMapa.getPocetAut());
        
        Auto vybrane = mojeMapa.getAuto(0); 
        System.out.println("Prvni auto je: " + vybrane.getNazev());
    }
}
