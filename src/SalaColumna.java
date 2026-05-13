
public class SalaColumna extends Sala{
	
	String nombre = "Sala Columna";
	public SalaColumna(Tresor tresor, Monstre monstre) {
		super(tresor, monstre);
		explorada=false;
	}
	
	public SalaColumna() {
		explorada=false;
	}
	
	
	public boolean intentarSortir(Personaje personaje) {
		
		return true;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
