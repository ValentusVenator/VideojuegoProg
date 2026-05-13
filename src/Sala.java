
public class Sala {

	Tresor tresor;
	Monstre monstre;
	boolean explorada;
	String tipoSala;
	
	public Sala(Tresor tresor, Monstre monstre) {
		setTresor(tresor);
		setMonstre(monstre);
		this.explorada=false;
	}
	
	public Sala() {
		explorada=false;
	}
	
	public boolean intentarSortir(Personaje personaje) {
		return false;
	}

	public Tresor getTresor() {
		return tresor;
	}

	public void setTresor(Tresor tresor) {
		this.tresor = tresor;
	}

	public Monstre getMonstre() {
		return monstre;
	}

	public void setMonstre(Monstre monstre) {
		this.monstre = monstre;
	}

	public boolean isExplorada() {
		return explorada;
	}

	public void setExplorada(boolean explorada) {
		this.explorada = explorada;
	}

	public String getTipoSala() {
		return tipoSala;
	}

	public void setTipoSala(String tipoSala) {
		this.tipoSala = tipoSala;
	}
	
	public static boolean todasExploradas(Sala[][] Sala) {

	    for (int i = 0; i < Sala.length; i++) {
	        for (int j = 0; j < Sala[i].length; j++) {

	            if (!Sala[i][j].isExplorada()) {
	                return false;
	            }
	        }
	    }

	    return true;
	}

	
}
