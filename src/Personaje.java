
public class Personaje implements Combatent{

	int nivel;
	String nom;
	int vida;
	int vidaMaxima;
	int energia;
	int energiaMaxima;
	int atac;
	double experiencia;
	int agilitat;
	int forsa;
	Posicion posicion;
	Tresor[] equipament;
	Pocio[] pocions;
	int pocionsEnergia;

	int mostrosDerrotados;
	int tesorosRecogidos;
	int dañoTotalNormal;
	int dañoTotalCritico;

	public Personaje(String nom, int vida, int atac, int agilitat, int forsa, int energia) {
		setNom(nom);
		setVida(vida);
		this.vidaMaxima=vida;
		setAtac(atac);
		setExperiencia(0);
		setAgilitat(agilitat);
		setForsa(forsa);
		setEnergia(energia);
		this.energiaMaxima=energia;
		setPosicion(new Posicion(0,0));
		setEquipament(forsa);
		this.pocionsEnergia = 3;
		this.pocions = new Pocio[3];
		this.pocions[0] = new Pocio("Poción pequeña", 10);
		this.pocions[1] = new Pocio("Poción pequeña", 10);
		this.pocions[2] = new Pocio("Poción pequeña", 10);
		setNivel(1);

		this.mostrosDerrotados = 0;
		this.tesorosRecogidos = 0;
		this.dañoTotalNormal = 0;
		this.dañoTotalCritico = 0;

	}


	public void subirNivel() {
		int numeroAleatorio;
		int bonusVida=0;
		int bonusEnergia=0;
		int bonusAtac=0;
		int bonusAgilitat=0;
		int bonusForsa=0;

		this.setNivel(this.nivel+1);

		if(!(vida>=20)) {
			numeroAleatorio = (int) (Math.floor(Math.random()*(100-0+1)+0));

			if(numeroAleatorio>100-(this.vidaMaxima*5)) {
				bonusVida = 2;

			}

			System.out.println("PV " + this.vidaMaxima + " + " + bonusVida + " = " + (this.vidaMaxima+bonusVida));
			setVidaMaxima(this.vidaMaxima+bonusVida);

		}else {
			System.out.println("La vida no puede aumentar más!");
		}

		numeroAleatorio = (int) (Math.floor(Math.random()*(100-0+1)+0));

		if(numeroAleatorio>100-energia*4) {
			bonusEnergia=4;
		}

		System.out.println("Energía " + this.energiaMaxima + " + " + bonusEnergia + " = " + (this.energiaMaxima+bonusEnergia));

		if(!(atac>=20)) {
			numeroAleatorio = (int) (Math.floor(Math.random()*(100-0+1)+0));

			if(numeroAleatorio>100-atac*10) {
				bonusAtac=1;

			}

			System.out.println("Ataque " + this.atac + " + " + bonusAtac + " = " + (this.atac+bonusAtac));
			setAtac(this.atac+bonusAtac);

		}else {
			System.out.println("El ataque no puede aumentar más!");
		}

		if(!(agilitat>=20)) {
			numeroAleatorio = (int) (Math.floor(Math.random()*(100-0+1)+0));

			if(numeroAleatorio>100-agilitat*4) {
				bonusAgilitat=1;
			}

			System.out.println("Agilidad " + this.agilitat + " + " + bonusAgilitat + " = " + (this.agilitat+bonusAgilitat));
			setAgilitat(this.agilitat+bonusAgilitat);

		}else {
			System.out.println("La agilidad no puede aumentar más!");
		}

		numeroAleatorio = (int) (Math.floor(Math.random()*(100-0+1)+0));


		if(!(forsa>=11)) {
			if(numeroAleatorio>100-forsa*4) {
				bonusForsa=1;
			}

			System.out.println("Fuerza " + this.forsa + " + " + bonusForsa + " = " + (this.forsa+bonusForsa));
			setForsa(this.forsa+bonusForsa);

		}else {
			System.out.println("La fuerza no puede aumentar más!");
		}
		
		setVida(this.vidaMaxima);

		setEnergiaMaxima(this.energiaMaxima+bonusEnergia);
		setEnergia(this.energiaMaxima);

	}

	public void ataqueNormal(Monstre monstre) {

		int dañoNormal = calcularAtac();

		this.dañoTotalNormal += dañoNormal;

		monstre.rebreDany(dañoNormal);

		System.out.println("\n Ataque normal.");
		System.out.println("Haces " 
				+ dañoNormal 
				+ " de daño a " 
				+ monstre.getNom());

		System.out.println(monstre.getNom()
				+ " PV restantes: "
				+ monstre.getVida());

		// si muere
		if (!monstre.estaViu()) {

			experiencia += monstre.getValorExperiencia();

			System.out.println("Has derrotado a " + monstre.getNom());

			System.out.println("Has ganado "
					+ (int)monstre.getValorExperiencia()
					+ " exp.");

			while(this.experiencia>=20*(this.nivel*1.5)) {

				double coste = 20 * (this.nivel * 1.5);

				System.out.println("\n¡Has subido de nivel!");
				subirNivel();
				setExperiencia(this.experiencia-coste);
			}

			this.mostrosDerrotados++;
		}
	}

	public void ataqueCritico(Monstre monstre) {

		int costeEnergia = 7;

		if (energia >= costeEnergia) {

			energia -= costeEnergia; // gastar energía

			int dañoBase = calcularAtac(); // daño base del personaje

			int dañoExtra = dañoBase*3; // daño extra crítico

			int dañoTotal = dañoBase + dañoExtra; // daño total

			this.dañoTotalCritico += dañoTotal; // estadísticas Daño total critico

			monstre.rebreDany(dañoTotal); // aplicar daño

			System.out.println("\n¡Has usado ataque crítico!" + "\n");
			System.out.println("Consumes " + costeEnergia + " de Energia " + "\n");
			System.out.println("- Energia restante: "+ energia + "/" + energiaMaxima);
			System.out.println("- Daño base: " + dañoBase);
			System.out.println("- Daño crítico extra: " + dañoExtra);
			System.out.println("- Daño total: " + dañoTotal);
			System.out.println("\n - Haces " + dañoTotal + " de daño en total a " + monstre.getNom() + " LV restantes: " + monstre.getVida() + "\n");

			// si muere
			if (!monstre.estaViu()) {

				System.out.println("Has derrotado a "
						+ monstre.getNom());

				experiencia += monstre.getValorExperiencia();

				System.out.println("- Has ganado "
						+ (int)monstre.getValorExperiencia()
						+ " de experiencia.");


				while(this.experiencia>=20*(this.nivel*1.5)) {

					double coste = 20 * (this.nivel * 1.5);

					System.out.println("\n¡Has subido de nivel!");
					subirNivel();
					setExperiencia(this.experiencia-coste);
				}


				this.mostrosDerrotados++;
			}



		} else {

			System.out.println("No tienes energía suficiente.");
			System.out.println("Energía actual: "
					+ energia
					+ "/"
					+ energiaMaxima);

		}
	}


	public void explorar(Sala sala) {
		Tresor tresorTrobat = sala.getTresor();

		if (tresorTrobat != null) {
			if (afegirTresor(tresorTrobat)) {
				System.out.println("Has encontrado: " + tresorTrobat);
			} else {
				System.out.println("¡Inventario lleno!");
			}
		} else {
			System.out.println("No encuentras nada.");
		}

		sala.setExplorada(true);


	}

	public boolean afegirTresor(Tresor tesoro) {

		if (tesoro == null) return false;

		for (int i = 0; i < equipament.length; i++) {

			if (equipament[i] == null) {

				equipament[i] = tesoro;

				this.tesorosRecogidos++;

				System.out.println("\nTesoro añadido.");

				return true;
			}
		}

		System.out.println("Inventario lleno.");

		return false;
	}

	public void usarPocion() {

		boolean encontrada = false;

		for (int i = 0; i < pocions.length; i++) {

			if (pocions[i] != null && !encontrada) {

				encontrada = true;

				int curacion = pocions[i].getCuracio();

				vida += curacion;

				if (vida > vidaMaxima) {
					vida = vidaMaxima;
				}

				System.out.println("\n - Has usado: " + pocions[i].getNom() +
						" LP actuales: " + this.getVida());

				pocions[i] = null;
			}
		}

		if (!encontrada) {

			System.out.println("No te quedan pociones.");
		}
	}

	public int getPocionsCurativasRestantes() {

		int contador = 0;

		for (int i = 0; i < pocions.length; i++) {

			if (pocions[i] != null) {
				contador++;
			}
		}

		return contador;
	}

	public void usarPocionEnergia() {

		int energiaExtra = 10; // cantidad de energia que dan las posiones

		if (pocionsEnergia > 0) { // Comprueba que existan posiones

			energia += energiaExtra; // recuperar energía

			if (energia > energiaMaxima) {
				energia = energiaMaxima;
			}

			pocionsEnergia--; // gastar una poción

			System.out.println("\nUsas una poción de energía");

			System.out.println(" - Recuperas " + energiaExtra + " puntos de energía.");

			System.out.println(" - Energía actual: " + energia + "/" + energiaMaxima);

			System.out.println(" - Pociones restantes: " + pocionsEnergia);

		} else {

			System.out.println("No quedan pociones.");
		}
	}

	public boolean esquivarAtac() {


		// número aleatorio entre 1 y 100

		int tirada = (int)(Math.random() * 100) + 1;

		// cuanto más agilidad, más probabilidad
		// ejemplo: agilidad 10 = 30% aprox

		int limite = 100 - (agilitat * 3);

		System.out.println("Tirada: "
				+ tirada
				+ " / "
				+ limite);

		if (tirada > limite) {

			System.out.println("¡Has esquivado el ataque!");
			return true;

		} else {

			return false;
		}

	}

	public void mostrarPociones() {

		System.out.println("===== POCIONES =====");

		boolean vacio = true;

		for (int i = 0; i < pocions.length; i++) {

			if (pocions[i] != null) {

				vacio = false;

				System.out.println((i + 1) + ". " + pocions[i]);

			}
		}

		if (vacio) System.out.println("No quedan pociones.");

	}

	public void mostrarEquipament() {

		System.out.println("\n===== INVENTARIO =====");

		// TESOROS

		System.out.println("\nTesoros:");

		boolean vacio = true;

		for (int i = 0; i < equipament.length; i++) {

			if (equipament[i] != null) {

				vacio = false;

				System.out.println((i+1)
						+ ". "
						+ equipament[i]);
			}
		}

		if (vacio) {
			System.out.println("X No tienes tesoros.");
		}

	}

	public void moure(char direccio) {

		switch (direccio) {
		case 'W':
			posicion.setFila(posicion.getFila()-1);
			break;
		case 'S':
			posicion.setFila(posicion.getFila()+1);
			break;
		case 'D':
			posicion.setColumna(posicion.getColumna()+1);
			break;
		case 'A':
			posicion.setColumna(posicion.getColumna()-1);
			break;
		default:
			System.err.println("Solo se acepta movimiento tipo WASD");
			break;
		}
	}

	@Override
	public void rebreDany(int quantitat) {

		this.vida=this.vida-quantitat;
	}

	@Override
	public boolean estaViu() {

		if(this.vida>0) {
			return true;
		}else {
			return false;
		}

	}

	@Override
	public int calcularAtac() {
		return (int)(Math.random()*this.atac)+1;
	}

	@Override
	public String toString() {

		return "\nNombre: " + nom
				+ "\nNivel: " + nivel
				+ "\nPV: " + vida + "/" + vidaMaxima
				+ "\nEnergia: " + energia + "/" + energiaMaxima
				+ "\nAtaque: " + atac
				+ "\nAgilidad: " + agilitat
				+ "\nFuerza: " + forsa

				+ "\nExperiencia: " + (int)experiencia;
	}




	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {

		if(vida>=5 && vida<=20) {
			this.vida = vida;
		}else if(vida>20){
			this.vida = 20;
		}else {
			this.vida=0;
		}
	}

	public int getAtac() {
		return atac;
	}
	public void setAtac(int atac) {
		if(atac>=1 && atac<=20) {
			this.atac = atac;
		}else if (atac>20) {
			this.atac = 20;
		}else {
			this.atac=1;
		}
	}

	public void setAgilitat(int agilitat) {
		if(agilitat>=4 && agilitat<=20) {
			this.agilitat = agilitat;
		}else if(agilitat>11) {
			this.agilitat = 11;
		}
		else {
			this.agilitat=4;
		}
	}

	public void setForsa(int forsa) {
		if(forsa>=4 && forsa<=11) {
			this.forsa = forsa;
		}else if(forsa>11) {
			this.forsa = 11;
		}
		else {
			this.forsa=4;
		}
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(double experiencia) {
		if(experiencia>=0) {
			this.experiencia = experiencia;
		}else {
			this.experiencia=0;
		}
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public Tresor[] getEquipament() {
		return equipament;
	}

	public void setEquipament(int forsa) {
		this.equipament = new Tresor[forsa];
	}

	public int getAgilitat() {
		return agilitat;
	}

	public int getForsa() {
		return forsa;
	}


	public int getNivel() {
		return nivel;
	}


	public void setNivel(int nivel) {
		this.nivel = nivel;
	}


	public int getEnergia() {
		return energia;
	}


	public void setEnergia(int energia) {
		this.energia = energia;
	}


	public int getVidaMaxima() {
		return vidaMaxima;
	}


	public void setVidaMaxima(int vidaMaxima) {
		if(this.vidaMaxima>=5 && this.vidaMaxima<=20) {
			this.vidaMaxima = vidaMaxima;
		}else if(this.vidaMaxima>20){
			this.vidaMaxima= 20;
		}else {
			this.vidaMaxima=0;
		}
	}


	public int getEnergiaMaxima() {
		return energiaMaxima;
	}


	public void setEnergiaMaxima(int energiaMaxima) {
		this.energiaMaxima = energiaMaxima;
	}


	public Pocio[] getPocions() {
		return pocions;
	}


	public void setPocions(Pocio[] pocions) {
		this.pocions = pocions;
	}


	public int getPocionsEnergia() {
		return pocionsEnergia;
	}


	public void setPocionsEnergia(int pocionsEnergia) {
		this.pocionsEnergia = pocionsEnergia;
	}


	public int getMostrosDerrotados() {
		return mostrosDerrotados;
	}


	public void setMostrosDerrotados(int mostrosDerrotados) {
		this.mostrosDerrotados = mostrosDerrotados;
	}


	public int getTesorosRecogidos() {
		return tesorosRecogidos;
	}


	public void setTesorosRecogidos(int tesorosRecogidos) {
		this.tesorosRecogidos = tesorosRecogidos;
	}


	public int getDañoTotalNormal() {
		return dañoTotalNormal;
	}


	public void setDañoTotalNormal(int dañoTotalNormal) {
		this.dañoTotalNormal = dañoTotalNormal;
	}


	public int getDañoTotalCritico() {
		return dañoTotalCritico;
	}


	public void setDañoTotalCritico(int dañoTotalCritico) {
		this.dañoTotalCritico = dañoTotalCritico;
	}


	public void setEquipament(Tresor[] equipament) {
		this.equipament = equipament;
	}







}
