package avance;

import java.util.ArrayList;
import java.util.Scanner;

public class Configuracion {
	private ArrayList<Termino> lista_terminos = new ArrayList<>();
	private ArrayList<Materia> lista_materias = new ArrayList<>();
	private ArrayList<Paralelo> lista_paralelos = new ArrayList<>();

	private Termino termJuego;

	Scanner sc = new Scanner(System.in);

	// Configuracion menuTermino
	public boolean menuTermino() {
		mostrarTerminos();

		System.out.println("\nMENU:" + "\n1. Ingresar Termino" + "\n2. Editar Termino"
				+ "\n3. Configurar Termino para el juego \n4. Atras");

		int opcion = sc.nextInt();

		switch (opcion) {
		case 1:
			System.out.println("-- INGRESE EL TERMINO--");
			Termino termino = new Termino();

			if (termJuego == null) {
				// System.out.println(comprobarTerminoAnioRepetido(termino));
				while (!comprobarTerminoAnioRepetido(termino)) {
					termino = new Termino();
				}
			} else {
				// System.out.println(comprobarTerminoAnioRepetido(termino) + " " +
				// comprobarTerminoAnioMenor(termino));

				while (!comprobarTerminoAnioRepetido(termino) || !comprobarTerminoAnioMenor(termino)) {
					termino = new Termino();
				}
			}
			ingresarTermino(termino);
			return true;
		case 2:
			editarTermino();
			return true;
		case 3:
			termJuego = seleccionarTermino();
			// System.out.println("IMPRIMIENDO Term juego");
			// System.out.println(termJuego.getAnio() + " " + termJuego.getNumeroTermin());
			return true;
		case 4:
			return false;
		default:
			return false;

		}

	}

	public void mostrarTerminos() {
		System.out.println("Lista de Terminos academicos: ");

		if (lista_terminos.size() == 0) {
			System.out.println("----Lista Vacia----");
		} else {
			for (int i = 0; i < lista_terminos.size(); i++) {
				int indice = i + 1;
				System.out.println(indice + ". " + lista_terminos.get(i).getAnio() + "-"
						+ lista_terminos.get(i).getNumeroTermin());
			}
		}
	}

	public void ingresarTermino(Termino termino) {
		lista_terminos.add(termino);

	}

	public boolean comprobarTerminoAnioRepetido(Termino termino) {

		int anio = termino.getAnio();
		int num = termino.getNumeroTermin();

		boolean repetido = false;
		for (Termino term : lista_terminos) {
			if (term.getAnio() == anio && term.getNumeroTermin() == num) {
				repetido = true;
			}
		}

		if (!repetido) {
			return true;
		}
		return false;

	}

	public boolean comprobarTerminoAnioMenor(Termino termino) {
		int anio = termino.getAnio();

		if (anio > termJuego.getAnio()) {
			return true;
		}
		return false;

	}

	public void editarTermino() {

		mostrarTerminos();
		System.out.println("Seleccione el termino que desea editar:");
		int indice = sc.nextInt();
		sc.nextLine();
		System.out.println("Cree el nuevo Termino");
		Termino termino2 = new Termino();
		lista_terminos.set(indice - 1, termino2);

	}

	public Termino seleccionarTermino() {
		mostrarTerminos();
		System.out.println("Seleccion el termino del Juego");
		int indice = sc.nextInt();
		sc.nextLine();
		Termino temJuego = lista_terminos.get(indice - 1);
		return temJuego;

	}

	// Configuracion Materia y Paralelos

	public boolean menuMateria() {
		mostrarMateria();
		System.out.println("\nMENU:" + "\n1. Ingresar Materia" + "\n2. Editar Materia" + "\n3. Agregar Paralelo"
				+ "\n4. Eliminar Materia" + "\n5. Atras");

		int opcion = sc.nextInt();

		switch (opcion) {
		case 1:
			System.out.println("Ingrese un termino");
			Materia materia = new Materia();
			ingresarMateria(materia);

			return true;
		case 2:
			editMateria();
			return true;
		case 3:
			agregarParalelo();
			return true;
		case 4:
			eliminarParalelo();
			return true;
		case 5:
			return false;
		default:
			return false;

		}

	}

	public void mostrarMateria() {
		System.out.println("Lista de Materias : ");

		if (lista_materias.size() == 0) {
			System.out.println("----Lista Vacia----");
		} else {
			for (int i = 0; i < lista_materias.size(); i++) {
				int indice = i + 1;
				System.out.println(indice + ". " + lista_materias.get(i).getCodigo() + "-"
						+ lista_materias.get(i).getNombre() + "-" + lista_materias.get(i).getNumNiveles());
			}
		}
	}

	public void ingresarMateria(Materia materia) {
		lista_materias.add(materia);
	}

	public void editMateria() {
		mostrarMateria();

		System.out.println("Seleccione el termino que desea editar:");
		int indice = sc.nextInt();
		sc.nextLine();

		System.out.println("Ingrese el nombre y la cantidad de niveles");
		System.out.println("Nombre:");
		String nombre = sc.nextLine();
		System.out.println("Nivel: ");
		int nivel = sc.nextInt();
		sc.nextLine();

		String codigo = lista_materias.get(indice - 1).getCodigo();
		Materia materia2 = new Materia(codigo, nombre, nivel);

		lista_materias.set(indice - 1, materia2);

	}

	public void agregarParalelo() {

		System.out.println("Seleccione una Materia:");
		mostrarMateria();
		int index1 = sc.nextInt();
		sc.nextLine();

		System.out.println("Seleccione un Termino:");
		mostrarTerminos();
		int index2 = sc.nextInt();
		sc.nextLine();

		Materia materia = lista_materias.get(index1 - 1);
		Termino termino = lista_terminos.get(index2 - 1);

		System.out.println("Ingrese el numero del paralelo: ");
		int numParalelo = sc.nextInt();
		sc.nextLine();

		ArrayList<Participante> participantes = agregarEstudiantes();

		Paralelo paralelo = new Paralelo(materia, termino, numParalelo, participantes);

		lista_paralelos.add(paralelo);

	}

	public ArrayList<Participante> agregarEstudiantes() {

		ArrayList<Participante> participantes = new ArrayList<>();

		participantes.add(new Participante(202104816,"AZU PERLAZA NICOLE FERNANDA", "nfazu@espol.edu.ec"));
		participantes.add(new Participante(202100772,"GUAMAN QUIJIJE RONALD STEVEN", "rsguaman@espol.edu.ec"));
		participantes.add(new Participante(202207726,"POVEDA QUIMIZ MICHAEL CRESCENCIO","mcpoveda@espol.edu.ec"));
		participantes.add(new Participante(202006086,"CABRERA VIVANCO ALVARO DAVID", "alvdcabr@espol.edu.ec"));
		participantes.add(new Participante(20207924,"RIVAS ABAD BRAULIO DE JESUS", "brarabad@espol.edu.ec"));
		participantes.add(new Participante(202106050,"ZAMORA CEDEÑO JORDY STEVEN", "jszamora@espol.edu.ec"));

		return participantes;

	}

	public void eliminarParalelo() {
		mostrarParalelo();

		System.out.println("Ingrese el Paralelo a eliminar");
		int index = sc.nextInt();
		sc.nextLine();

		lista_paralelos.remove(index - 1);

	}

	public void mostrarParalelo() {
		System.out.println("Mostrando paralelos");
		int i = 1;

		for (Paralelo par : lista_paralelos) {
			System.out.println(i + ".- El paralelo " + par.getNumParalelo());
			System.out.println(par.getParticipantes());
			i++;
		}

	}

	// Configuraciones menuPregunta
	public boolean menuPregunta() {
		System.out.println("MENU MODIFICAR TERMINO:" + "\n1. Visualizar preguntas" + "\n2. Agregar preguntas"
				+ "\n3. Eliminar preguntas\n4.Volver a configuraciones");
		int opcion = sc.nextInt();

		switch (opcion) {
		case 1:
			visualizarPregunta();
			return true;
		case 2:
			System.out.println("-- INGRESE LA PREGUNTA A AGREGAR --");
			Pregunta pregunta1 = new Pregunta();
			agregarPregunta(pregunta1);
			return true;
		case 3:
			eliminarPregunta();
			return true;
		case 4:
			return false;
		default:
			return false;
		}
	}

	public void visualizarPregunta() {
		System.out.println("Lista de Materias con sus preguntas : ");

		if (lista_materias.size() == 0) {
			System.out.println("----Lista Vacia----");
		} else {
			for (int i = 0; i < lista_materias.size(); i++) {
				int indice = i + 1;
				System.out.println(indice + ". " + lista_materias.get(i).getCodigo() + "-"
						+ lista_materias.get(i).getNombre() + "-" + lista_materias.get(i).getNumNiveles());
				lista_materias.get(i).mostrarPreguntas();
			}
		}

	}

	public void agregarPregunta(Pregunta pregunta) {
		mostrarMateria();
		System.out.println("Seleccione la materia que desea agregrar la pregunta:");
		int index = sc.nextInt();
		sc.nextLine();

		Materia materia = lista_materias.get(index - 1);
		materia.addPreguntas(pregunta);

	}

	public void eliminarPregunta() {
		mostrarMateria();

		System.out.println("Seleccione la materia que la cual desea eliminar una pregunta:");
		int index = sc.nextInt();
		sc.nextLine();

		Materia materia = lista_materias.get(index - 1);

		materia.mostrarPreguntas();
		System.out.println("Seleccione la pregunta que quiere eliminar :");
		int index2 = sc.nextInt();
		sc.nextLine();

		materia.eliminarPregunta(index2);

	}

	public ArrayList<Materia> getLista_materias() {
		return lista_materias;
	}

}
