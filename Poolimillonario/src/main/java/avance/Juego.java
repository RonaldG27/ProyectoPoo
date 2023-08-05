package avance;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Juego {

	private Materia materia;
	private Paralelo paralelo;
	private Termino termino;
	private Participante participante;
	private Participante companero;
	private Comodin comodin;
	private int preguntasPorNivel;
	private int nivelMaximoAlcanzado;
	private int preguntasContestadas;
	private String premio;
	private int preguntaActualIndex;
	private Configuracion configuracion;
	private ArrayList<Pregunta> preguntas;

	public Juego(Configuracion configuracion) {
		this.configuracion = configuracion;
	}

	Scanner sc = new Scanner(System.in);
	Random random = new Random();

	public void iniciarJuego() {
		BienvenidaJuego();
		mostrarPregunta();

	}

	// seleciona materia, paralelo, estudiante y compañero
	public void BienvenidaJuego() {

		System.out.println("¡Bienvenido al Nuevo juego!");

		configuracion.mostrarMateria();

		System.out.println("Seleccione la Materia: ");
		int indiceMateria = sc.nextInt();
		sc.nextLine();

		materia = configuracion.getLista_materias().get(indiceMateria - 1);
		preguntas = materia.getPreguntas();

		configuracion.mostrarParalelo();

		System.out.println("Seleccione el paralelo: ");
		int indiceParalelo = sc.nextInt();

		paralelo = configuracion.getLista_paralelos().get(indiceMateria - 1);

		sc.nextLine();

		// Seleccionar o ingresar participante
		System.out.println("Ingrese el número de matrícula del participante (0 para seleccionar aleatoriamente): ");
		int matriculaParticipante = sc.nextInt();

		if (matriculaParticipante != 0) {
			participante = buscarPorMatricula(matriculaParticipante);
			if (participante == null) {
				System.out.println(
						"No se encontró al partipante con la matrícula ingresada. Se seleccionará uno aleatoriamente.");
				participante = seleccionarAleatorio();
			}
		}
		if (participante == null && matriculaParticipante == 0) {
			participante = seleccionarAleatorio();
		}

		System.out.println("El participante seleccionado es: " + participante.getNombre());
		sc.nextLine();

		// Seleccionar compañero para comodin 50/50

		System.out.print("Ingresa el número de matrícula del compañero de apoyo(0 para seleccionar aleatoriamente): ");
		int matriculaCompanero = sc.nextInt();
		sc.nextLine();

		if (matriculaCompanero != 0) {
			companero = buscarPorMatricula(matriculaCompanero);
			if (companero == null) {
				System.out.println(
						"No se encontró al compañero con la matrícula ingresada. Se seleccionará uno aleatoriamente.");
				companero = seleccionarAleatorio();
			}
		}
		if (companero == null && matriculaCompanero == 0) {
			companero = seleccionarAleatorio();
		}

		System.out.println("Compañero de apoyo: " + companero.getNombre());
		sc.nextLine();
		System.out.println("¡Que comience el juego!");
	}

	// mostrar preguntas y respuesta

	public void mostrarPregunta() {

		int nivelActual = 1;
		int preguntasCorrectas = 0;

		for (Pregunta pregunta : preguntas) {

			System.out.println("\n" + pregunta.getEnunciado());

			ArrayList<String> opciones = new ArrayList<>();
			opciones.add(pregunta.getRespuestaCorrecta());
			opciones.add(pregunta.getRespuestaInco1());
			opciones.add(pregunta.getRespuestaInco2());
			opciones.add(pregunta.getRespuestaInco3());

			ArrayList<String> opciones2 = new ArrayList<>();
			opciones2.addAll(opciones);
			
			String respuestaCorrecta = "";
			String respuestaSeleccionadaTexto = "";

			// Mostrar las opciones de forma aleatoria
			do {
			
				for (int i = 0; i < 4; i++) {
					int indiceAleatorio = (int) (Math.random() * opciones.size());
					System.out.println(indiceAleatorio);
					System.out.println((i + 1) + ". " + opciones.get(indiceAleatorio));
					//opciones.remove(indiceAleatorio);
				}
	
				System.out.println(5 + ". Usar comodin ");
	
				System.out.print("Seleccione la opción correcta o elija un comodin : ");
	
				int opcionrespuesta = sc.nextInt();
	
				if (opcionrespuesta == 5) {
					System.out.println("\nCOMODINES:");
					System.out.println("1. 50/50");
					System.out.println("2. Consulta al compañero");
					System.out.println("3. Consulta al salón");
	
					System.out.print("Seleccione el comodín que desea usar: ");
					int opcionComodin = sc.nextInt();
	
					switch (opcionComodin){
					case 1:
						if (comodin.isComodin5050Disponible()== true) {
							comodin.usarComodin5050(opciones2);
						} else {
							System.out.println("El comodín 50/50 ya fue utilizado.");
						}
						break;
					case 2:
						if (comodin.isComodinConsultaCompaneroDisponible()== true) {
							comodin.usarComodinConsultaCompanero(companero, opciones2);
						} else {
							System.out.println("El comodín de consulta al compañero ya fue utilizado.");
						}
						break;
					case 3:
						if (comodin.isComodinConsultaSalonDisponible()== true) {
							comodin.usarComodinConsultaSalon(opciones2);
						} else {
							System.out.println("El comodín de consulta al salón ya fue utilizado.");
						}
						break;
					default:
						System.out.println("Opción inválida.");
						break;
					}
	
				}
				respuestaCorrecta = pregunta.getRespuestaCorrecta();
				System.out.println(respuestaCorrecta);
				respuestaSeleccionadaTexto = opciones2.get(opcionrespuesta - 1);
				System.out.println(respuestaSeleccionadaTexto);
	
				// si la repuesta es correcta sigue el juego si no finaliza
			
				if (respuestaSeleccionadaTexto.equals(respuestaCorrecta)) {
					System.out.println("¡Correcto!"  + "siguiente Prengunta");
					preguntasCorrectas++;
					nivelActual++;
				} else {
					System.out.println("¡Esto no fue correcto!" + "Intentar este juego de nuevo");
				}
				}
			while( respuestaSeleccionadaTexto.equals(respuestaCorrecta) || nivelActual == nivelMaximoAlcanzado );
				

			// si contesta todo termina el juego

			if (preguntasContestadas == preguntas.size()) {
				System.out.println("¡Felicidades! Has respondido correctamente todas las preguntas del juego.");
				System.out.println("Ingrese el premio: ");
				premio = sc.nextLine();
				System.out.println("Recibe" + premio);
				nivelMaximoAlcanzado = nivelActual;
			}

		}

	}

	public void mostrarSiguientePregunta() {
		if (preguntaActualIndex < preguntas.size()) {
			Pregunta preguntaActual = preguntas.get(preguntaActualIndex);
			System.out.println(preguntaActual);

			preguntaActualIndex++;
		} else {
			System.out.println("No hay más preguntas para mostrar");
		}
	}

	public Participante buscarPorMatricula(int matricula) {

		for (Participante participante : paralelo.getParticipantes()) {
			if (participante.getMatricula() == matricula) {
				return participante;
			}
		}
		return null;
	}

	public Participante seleccionarAleatorio() {
		ArrayList<Participante> listaParticipantes = paralelo.getParticipantes();
		int indiceAleatorio = (int) (Math.random() * listaParticipantes.size());
		return listaParticipantes.get(indiceAleatorio);
	}

	public Materia getMateria() {
		return materia;
	}

	public Paralelo getParalelo() {
		return paralelo;
	}

	public Participante getParticipante() {
		return participante; // revisar porque hay un tostring que retorna participante
	}

	public int getNivelMaximoAlcanzado() {
		return nivelMaximoAlcanzado;
	}

	public int getPreguntasContestadas() {
		return preguntasContestadas;
	}

	public Termino getTermino() {
		// TODO Auto-generated method stub
		return null;
	}

}
