import java.util.Random;

public class SalaTeranyina extends Sala{

	
	public SalaTeranyina(Tresor tresor, Monstre monstre) {
		super(tresor, monstre);
		explorada=false;
	}
	
	public SalaTeranyina() {
		explorada=false;
	}
	public boolean intentarSortir(Personaje personaje) {

		Random rand = new Random();

		// Genera un número entre 1 y 12
		int tirada = rand.nextInt(12) + 1;

		// Si la tirada es menor o igual a la fuerza se sale
		if (tirada <= personaje.getForsa()) {
			System.out.println("\n" + "Has superado la telaraña.");
			return true;
		} else {
			System.out.println("La telaraña te ha atrapado, no has podido salir.");
			return false;
		}
	}
	
}
