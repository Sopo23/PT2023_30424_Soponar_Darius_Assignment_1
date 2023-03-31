package modul;


import java.util.TreeMap;

public class Polinom {
    private TreeMap<Integer, Double> poly = new TreeMap<>();

    public Polinom(TreeMap<Integer, Double> poly) {
        this.poly = poly;
    }

    public Polinom() {

    }

    public TreeMap<Integer, Double> getPoly() {
        return poly;
    }

    public void setPoly(TreeMap<Integer, Double> poly) {
        this.poly = poly;
    }
public  int  maxGrade() {
    if (poly.size() == 0) {
        return 0;
    }
        return poly.lastKey();

}
}
