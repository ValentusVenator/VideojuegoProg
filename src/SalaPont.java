import java.util.Random;

public class SalaPont extends Sala{

	
	public SalaPont(Tresor tresor, Monstre monstre) {
		super(tresor, monstre);
		explorada=false;
	}
	
	public SalaPont() {
		explorada=false;
	}
	
	public boolean intentarSortir(Personaje personaje) {

		Random rand = new Random();

		int tirada = rand.nextInt(12) + 1;

		// Si supera la agilidad puede salir
		if (tirada <= personaje.getAgilitat()) {
			System.out.println("Has cruzado el puente.");
			return true;
		} else {
			// Si falla pierde vida y no puede salir

			System.out.println("No has podido cruzar el puente. -1 PV");
			personaje.rebreDany(1);
			return false;
		}
	}
}
