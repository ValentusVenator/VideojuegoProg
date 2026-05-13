
public class Tresor {

	String nom;
	int valor;
	double pes;
	
	
	
	public Tresor(String nom, int valor, double pes) {
		setNom(nom);
		setValor(valor);
		setPes(pes);
	}
	
	public String toString() {
		return "Nom: " + nom + "\nValor: " + valor;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public double getPes() {
		return pes;
	}

	public void setPes(double pes) {
		this.pes = pes;
	}
	
}
