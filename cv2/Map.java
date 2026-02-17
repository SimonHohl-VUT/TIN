package cv2;
import java.util.ArrayList;
import java.util.List;

public class Map {
    
    private List<Auto> seznamAut; 

    public Map() {
        this.seznamAut = new ArrayList<>();
    }



    public void addAuto(Auto a) {
        seznamAut.add(a);
    }

    public Auto getAuto(int index) {

        if (index >= 0 && index < seznamAut.size()) {
            return seznamAut.get(index);
        }
        return null; 
    }

    public void removeAuto(int index) {
        if (index >= 0 && index < seznamAut.size()) {
            seznamAut.remove(index);
        }
    }
    
    public void removeAuto(Auto a) {
        seznamAut.remove(a);
    }

    public int getPocetAut() {
        return seznamAut.size();
    }
}
