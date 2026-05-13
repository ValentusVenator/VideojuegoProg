
public class Pocio {

    private String nom;
    private int curacio;

    // constructor
    public Pocio(String nom, int curacio) {
        this.nom = nom;
        this.curacio = curacio;
    }

    public String getNom() {
        return nom;
    }

    public int getCuracio() {
        return curacio;
    }

    @Override
    public String toString() {
        return nom + ", " + curacio + " vida)";
    }
}