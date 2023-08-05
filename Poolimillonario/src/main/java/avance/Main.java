package avance;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Configuracion configuracion = new Configuracion();

		Scanner sc = new Scanner(System.in);
		System.out.println(
				"Ingrese el indice \n1.Administrar términos académicos \n2.Administrar materias y paralelos \n3.Administrar preguntas \n4.Salir");
		int opcion = sc.nextInt();
		sc.nextLine();

		while (opcion != 4) {
			switch (opcion) {
			case 1:
				boolean confiTermino = true;
				while (confiTermino) {
					confiTermino = configuracion.menuTermino();
				}

				break;
			case 2:
				boolean confiMateria = true;
				while (confiMateria) {
					confiMateria = configuracion.menuMateria();
				}
				break;
			case 3:
				boolean confiPregunta = true;
				while (confiPregunta) {
					confiPregunta = configuracion.menuPregunta();
				}
				break;
			}
			System.out.println(
					"Ingrese el indice \n1.Administrar términos académicos \n2.Administrar materias y paralelos \n3.Administrar preguntas \n4.Salir");
			opcion = sc.nextInt();
			sc.nextLine();
		}
		Juego juego = new Juego(configuracion);
		juego.iniciarJuego();

		Reporte report = new Reporte(configuracion, juego);
		report.mostrarReporte();

	}

}
