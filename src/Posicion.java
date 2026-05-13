
public class Posicion {

	int fila;
	int columna;

	public Posicion(int fila, int columna) {
		setFila(fila);
		setColumna(columna);

	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		if (this.fila>=0) {
			this.fila = fila;
		}else {
			this.fila = 0;
		}
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		if(this.columna>=0) {
			this.columna = columna;
		}else {
			this.columna = 0;
		}
	}

}
