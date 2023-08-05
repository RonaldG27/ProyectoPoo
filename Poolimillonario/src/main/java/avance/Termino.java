package avance;

import java.util.Scanner;

public class Termino {
	private int anio;
	private int numeroTermin;
	Scanner sc = new Scanner(System.in);

	public Termino() {
		System.out.println("Ingrese el año");
		this.anio = sc.nextInt();
		System.out.println("Ingrese el termino Academico");
		this.numeroTermin = sc.nextInt();
	}

	public Termino(int a, int num) {
		this.anio = a;
		this.numeroTermin = num;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getNumeroTermin() {
		return numeroTermin;
	}

	public void setNumeroTermin(int numeroTermin) {
		this.numeroTermin = numeroTermin;
	}

}
