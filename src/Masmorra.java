import java.util.Scanner;

public class Masmorra {

	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {


		Personaje alisa = new Personaje("Alisa", 15, 4, 10, 8, 10);

		Monstre[] monstres = {new Monstre("Hueco", 10, 2, 0), 	// 0
				new Monstre("Slime", 5, 3, 0),					// 1
				new Monstre("Marioneta Asesina", 5, 7, 2),		// 2
				new Monstre("Rata Pegajosa", 1, 1, 3),			// 3
				new Monstre("Dragón Anciano", 50, 15, 3),		// 4
				new Monstre("Cultista", 15, 4, 2),				// 5
				new Monstre("Bufón Maligno", 22, 8, 2),			// 6
				new Monstre("Pulpo Terrestre", 25, 5, 3),		// 7
				new Monstre("Bala Perdida", 5, 5, 3),			// 8
				new Monstre("Espada Maldita", 5, 14, 1),		// 9
				new Monstre("Gran Árbol", 40, 2, 1),			// 10
				new Monstre("Alpaca Cibernética", 12, 4, 2)};	// 11

		Tresor[] tresors = new Tresor[10];

		tresors[0] = new Tresor("Corona del Rei Obscur", 120, 2.5);
		tresors[1] = new Tresor("Espasa de Foc Antic", 95, 3.2);
		tresors[2] = new Tresor("Anell dels Somnis", 60, 0.5);
		tresors[3] = new Tresor("Calze d'Or Etern", 80, 1.8);
		tresors[4] = new Tresor("Pergamí Prohibit", 45, 0.3);
		tresors[5] = new Tresor("Martell del Nan Perdut", 110, 4.0);
		tresors[6] = new Tresor("Collaret de les Ombres", 70, 0.7);
		tresors[7] = new Tresor("Gema del Drac Blau", 150, 1.2);
		tresors[8] = new Tresor("Escut Trencat del Guardià", 65, 3.5);
		tresors[9] = new Tresor("Bossa d'Or Maleït", 90, 2.0);

		int numeroAleatorio=0;
		Sala[][] masmorra1 = new Sala[5][5];

		for (int i = 0;i<masmorra1.length;i++) {
			for (int j = 0; j < masmorra1[i].length;j++) {
				numeroAleatorio = (int) (Math.floor(Math.random()*(100-0+1)+0));
				if(numeroAleatorio<=60) {
					masmorra1[i][j]= new SalaColumna();
					masmorra1[i][j].setTipoSala("común");
				}else if(numeroAleatorio<=40 && numeroAleatorio>20) {
					masmorra1[i][j]= new SalaPont();
					masmorra1[i][j].setTipoSala("con puente");
				}else {
					masmorra1[i][j]= new SalaTeranyina();
					masmorra1[i][j].setTipoSala("con telaraña");
				}
			}
		}

		for (int i = 0;i<masmorra1.length;i++) {
			for (int j = 0; j < masmorra1[i].length;j++) {
				numeroAleatorio = (int) (Math.floor(Math.random()*(100-0+1)+0));
				if(numeroAleatorio>=85) {
					numeroAleatorio = (int) (Math.floor(Math.random()*(100-0+1)+0));
					if(numeroAleatorio<=1) {
						masmorra1[i][j].setTresor(tresors[7]);
					}else if(numeroAleatorio<=6) {
						masmorra1[i][j].setTresor(tresors[0]);
					}else if(numeroAleatorio<=14) {
						masmorra1[i][j].setTresor(tresors[5]);
					}else if(numeroAleatorio<=22) {
						masmorra1[i][j].setTresor(tresors[1]);
					}else if(numeroAleatorio<=31) {
						masmorra1[i][j].setTresor(tresors[9]);
					}else if(numeroAleatorio<=42) {
						masmorra1[i][j].setTresor(tresors[3]);
					}else if(numeroAleatorio<=58) {
						masmorra1[i][j].setTresor(tresors[6]);
					}else if(numeroAleatorio<=66) {
						masmorra1[i][j].setTresor(tresors[8]);
					}else if(numeroAleatorio<=80) {
						masmorra1[i][j].setTresor(tresors[2]);
					}else if(numeroAleatorio<=100) {
						masmorra1[i][j].setTresor(tresors[4]);
					}
				}
			}
		}

		for (int i = 0;i<masmorra1.length;i++) {
			for (int j = 0; j < masmorra1[i].length;j++) {
				numeroAleatorio = (int) (Math.floor(Math.random()*(100-0+1)+0));
				if(numeroAleatorio>=40) {
					numeroAleatorio = (int) (Math.floor(Math.random()*(100-0+1)+0));
					if(numeroAleatorio<=1) {
						masmorra1[i][j].setMonstre(monstres[4]);
					}else if(numeroAleatorio<=6) {
						masmorra1[i][j].setMonstre(monstres[10]);
					}else if(numeroAleatorio<=14) {
						masmorra1[i][j].setMonstre(monstres[7]);
					}else if(numeroAleatorio<=22) {
						masmorra1[i][j].setMonstre(monstres[6]);
					}else if(numeroAleatorio<=31) {
						masmorra1[i][j].setMonstre(monstres[5]);
					}else if(numeroAleatorio<=42) {
						masmorra1[i][j].setMonstre(monstres[9]);
					}else if(numeroAleatorio<=58) {
						masmorra1[i][j].setMonstre(monstres[11]);
					}else if(numeroAleatorio<=66) {
						masmorra1[i][j].setMonstre(monstres[0]);
					}else if(numeroAleatorio<=80) {
						masmorra1[i][j].setMonstre(monstres[8]);
					}else if(numeroAleatorio<=100) {
						masmorra1[i][j].setMonstre(monstres[2]);
					}
				}
			}
		}


		char opcion ;

		System.out.println("\n" + "Bievenido a la Mas morra" + "\n");

		while (alisa.estaViu() && !Sala.todasExploradas(masmorra1)) {

			imprimirMasmorra(masmorra1, alisa);

			menu(masmorra1, alisa);
		}

		if (!alisa.estaViu()) {
			System.out.println("Has muerto. Fin del juego.");

			mostrarResumen(alisa);
		} else {
			System.out.println("¡Has explorado toda la mazmorra!");

			mostrarResumen(alisa);
		}



	}

	public static void imprimirMasmorra(Sala[][] masmorra, Personaje jugador) {

		for (int i = 0; i < masmorra.length; i++) {

			for (int j = 0; j < masmorra[i].length; j++) {

				Sala sala = masmorra[i][j];

				// Posición actual del jugador
				if (jugador.posicion.getFila() == i && jugador.posicion.getColumna() == j) {

					System.out.print("[ & ]");

				}

				// Sala no explorada
				else if (!sala.isExplorada()) {

					System.out.print("[ - ]");

				}

				// Sala explorada
				else {

					String contenido = "";

					// Si queda monstruo vivo
					if (sala.getMonstre() != null &&
							sala.getMonstre().estaViu()) {

						contenido += "M";
					}

					// Si queda tesoro
					if (sala.getTresor() != null) {

						contenido += "T";
					}

					// Sala completamente limpia
					if (contenido.equals("")) {

						contenido = "*";
					}

					System.out.print("[ " + contenido + " ]");
				}
			}

			System.out.println();
		}
	}

	public static void Moviment(Sala[][] masmorra, Personaje jugador, char direccio) {

		Posicion posicion = jugador.getPosicion();

		int f = posicion.getFila();
		int c = posicion.getColumna();

		Sala salaActual = masmorra[f][c];

		// Intentar salir
		if (!salaActual.intentarSortir(jugador)) {
			System.out.println("No pots sortir!");
			return;
		}

		// Daño por huida
		Monstre m = salaActual.getMonstre();
		if (m != null && m.estaViu()) {
			System.out.println("El monstruo te ataca mientras huyes!" + "\n");
			jugador.rebreDany(m.getPenalizatcio());

		}

		// Mover jugador
		jugador.moure(direccio);

		// nueva posición
		int novaF = jugador.posicion.getFila();
		int novaC = jugador.posicion.getColumna();

		// Comprobar salida
		if (novaF < 0 || novaF >= masmorra.length ||
				novaC < 0 || novaC >= masmorra[0].length) {

			System.out.println("Has sortit de la masmorra!");
			return;
		}

		// Actualizar posición
		posicion.setFila(novaF);
		posicion.setColumna(novaC);

		imprimirMasmorra(masmorra, jugador);

		System.out.println("\n" + "Nova posició: (" + novaF + ", " + novaC + ")");
	}

	public static void menu(Sala[][] masmorra, Personaje jugador) {

		int f = jugador.posicion.getFila();
		int c = jugador.posicion.getColumna();

		Sala salaActual = masmorra[f][c];

		/*
		 * Registro el monstruo actual de la sala para saber
		 * si el tesoro está bloqueado o no.
		 */
		Monstre monstreSala = salaActual.getMonstre();

		// INFO SALA
		if (!salaActual.isExplorada()) {
			System.out.println("\n" + "Estás en una sala desconocida...");
		} 

		// MENÚ
		System.out.println("\n===== MENÚ =====" + "\n");

		if (!salaActual.isExplorada()) {

			System.out.println("1. Explorar");

		} else if (salaActual.getTresor() != null && (monstreSala == null || !monstreSala.estaViu())) { //Si ya fue explorada y hay tesoro,solo permito recogerlo si no hay monstruo vivo.

			System.out.println("1. Recoger tesoro");

		}

		System.out.println("2. Moverse (W,S,A,D)");

		if (salaActual.isExplorada() &&
				salaActual.getMonstre() != null &&
				salaActual.getMonstre().estaViu()) {

			System.out.println("3. Comenzar combate");
		}

		System.out.println("4. Ver equipo");
		System.out.println("5. Ver personaje");
		System.out.println();

		// INPUT
		System.out.print("Elige opción: ");

		int opcion = teclado.nextInt();

		System.out.println();

		switch (opcion) {

		//  EXPLORAR
		case 1:

			// Caso normal: sala sin explorar.

			if (!salaActual.isExplorada()) {

				salaActual.setExplorada(true);

				System.out.println("Exploras la sala...\n");

				if (salaActual.getTresor() != null) {
					System.out.println(salaActual.getTresor());
				} else {
					System.out.println("- No hay tesoro.\n");
				}

				if (monstreSala != null && monstreSala.estaViu()) {

					System.out.println("- "
							+ monstreSala.getNom()
							+ ", PV: "
							+ monstreSala.getVida());

				} else {

					System.out.println("\n- No hay enemigos.");
				}
			}


			//Caso de recoger tesoro solo si no hay monstruo vivo bloqueándolo.

			else if (salaActual.getTresor() != null &&
					(monstreSala == null || !monstreSala.estaViu())) {

				boolean añadido =
						jugador.afegirTresor(salaActual.getTresor());

				if (añadido) {

					salaActual.setTresor(null);

					System.out.println("Has recogido el tesoro.");
				}
			}


			// Si hay monstruo vivo, bloqueo el tesoro.

			else if (monstreSala != null && monstreSala.estaViu()) {

				System.out.println("Debes derrotar al monstruo antes de recoger el tesoro.");
			}

			else {

				System.out.println("Ya exploraste esta sala.");
			}

			break;


			// MOVER / HUIR
		case 2:

			System.out.print("Dirección (W,S,A,D): ");
			char dir = teclado.next().toUpperCase().charAt(0);

			Monstre mostro = salaActual.getMonstre();

			// huir si hay monstruo
			if (mostro != null && mostro.estaViu()) {

				System.out.println("\n" + "¡Huyes del monstruo!" + "\n");

				jugador.rebreDany(mostro.getPenalizatcio());

				System.out.println("Recibes " + mostro.getPenalizatcio() + " de daño por huir." + "\n");

				System.out.println("Tus puntos de vida son: " + (jugador.getVida()- mostro.getPenalizatcio()) + "\n");
			}

			Moviment(masmorra, jugador, dir);
			break;

			// ATAQUE
		case 3:

			if (salaActual.isExplorada() && salaActual.getMonstre() != null && salaActual.getMonstre().estaViu()) {

				// Llamamos al submenú de combate
				menuCombate(salaActual, jugador, teclado);

				// Al volver del combate, si el jugador ha muerto
				if (!jugador.estaViu()) {
					return;
				}

			} else {
				System.out.println("No hay nadie a quien atacar aquí.");
			}

			break;

			// EQUIPO
		case 4:

			jugador.mostrarEquipament();

			break;

			// PERSONAJE
		case 5:

			System.out.println("\n===== Ficha =====");

			System.out.println(jugador);

			break;

		default:

			System.out.println("Opción inválida.");

		}

		System.out.println("\n---------------------------");
	}

	public static void menuCombate(Sala salaActual, Personaje jugador, Scanner teclado) {

		Monstre monstre = salaActual.getMonstre();

		// Mientras ambos estén vivos

		while (jugador.estaViu() && monstre.estaViu()) {

			System.out.println("\n===== COMBATE =====" + "\n");

			System.out.println(jugador.getNom() + " (PV: " + jugador.getVida() + ")");

			System.out.println(monstre.getNom() + " (PV: " + monstre.getVida() + ")"+ "\n");

			System.out.println("-------------------");

			System.out.println("1. Atacar");

			System.out.println("2. Curarse");

			System.out.println("3. Huir" + "\n" );

			System.out.print("Selecciona opción: ");

			int opcion = teclado.nextInt();

			switch (opcion) {

			case 1:

				// Submenu de tipos de ataque
				System.out.println("\n--- TIPO DE ATAQUE ---");
				System.out.println("\n" + "1. Ataque normal");
				System.out.println("2. Ataque crítico");
				System.out.println();
				System.out.print("Selecciona ataque: ");

				int tipoAtaque = teclado.nextInt();

				// ataque normal
				if (tipoAtaque == 1) {

					jugador.ataqueNormal(monstre);

				}

				// ataque critico
				else if (tipoAtaque == 2) {

					jugador.ataqueCritico(monstre);

				}

				else {

					System.out.println("Tipo de ataque no válido.");

				}

				// ¿murió?
				if (!monstre.estaViu()) {					
					return;
				}

				//======== contraataque del monstruo ===========
				// comprobar esquive

				int dañoEnemigo = monstre.calcularAtac(); // variable que guarda el daño para notificar por mensaje el calculo de daño real esta en el personaje

				System.out.println("\n" + monstre.getNom() + " contraataca!...");

				boolean esquivado = jugador.esquivarAtac();
				// si NO esquiva → recibe daño
				if (!esquivado) {

					System.out.println("\n" + monstre.getNom() + " hace " + dañoEnemigo + " de daño.");

					jugador.rebreDany(dañoEnemigo);

				}

				break;

			case 2: // CURARSE

				// Submenu de tipo de pociones
				System.out.println("\n--- TIPO DE POCIONES ---");
				System.out.println("\n" + "1. Pocion de Curar");
				System.out.println("2. Pocion de Energia");
				System.out.println();
				System.out.print("Selecciona una pocion: ");

				int curitaEnergia = teclado.nextInt();

				// El monstruo aprovecha que te curas para golpearte

				switch(curitaEnergia) {

				case 1:
					jugador.usarPocion();
					break;
				case 2:
					jugador.usarPocionEnergia();
					break;
				default:
					System.out.println("Opcion no valida");
					break;

				}

				break;

			case 3: // HUIR

				System.out.println("¡Intentas escapar!");

				return; // Salimos del combate

			default:

				System.out.println("Opción no válida.");

				break;
			}

			// CONTROL DE MUERTE DEL JUGADOR (Inmediato tras el contraataque)
			if (!jugador.estaViu()) {

				System.out.println("\n*************************");

				System.out.println("¡HAS MUERTO EN COMBATE!");

				System.out.println("*************************");

			}
		}
	}

	public static void mostrarResumen(Personaje jugador) {

		System.out.println("\n===== RESUMEN DE PARTIDA =====");

		System.out.println(jugador);

		System.out.println("\nMonstruos derrotados: "
				+ jugador.getMostrosDerrotados());

		System.out.println("Tesoros recogidos: "
				+ jugador.getTesorosRecogidos());

		System.out.println("Daño normal total: "
				+ jugador.getDañoTotalNormal());

		System.out.println("Daño crítico total: "
				+ jugador.getDañoTotalCritico());

		double experienciaTotal=0;
		for(int i = 1; i<=jugador.nivel; i++) {
			experienciaTotal=20*(i*1.5);
		}
		
		System.out.println("Experiencia total: "
				+ jugador.getExperiencia());

		System.out.println("Pociones curativas restantes: "
				+ jugador.getPocionsCurativasRestantes());

		System.out.println("Pociones de energía restantes: "
				+ jugador.getPocionsEnergia());
	}

}