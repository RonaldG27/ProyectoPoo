package avance;

import java.util.ArrayList;
import java.util.Scanner;

public class Materia {
	private String codigo;
	private String nombre;
	private int numNiveles;
	
	public ArrayList<Pregunta> preguntas = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public Materia() {
		System.out.println("Ingrese el codigo: ");
		this.codigo = sc.nextLine();
		System.out.println("Ingrese el nombre: ");
		this.nombre = sc.nextLine();
		System.out.println("Ingrese el numero de niveles: ");
		this.numNiveles = sc.nextInt();
	}

	public Materia(String c, String n, int nm) {
		this.codigo = c;
		this.nombre = n;
		this.numNiveles = nm;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumNiveles() {
		return numNiveles;
	}

	public void setNumNiveles(int numNiveles) {
		this.numNiveles = numNiveles;
	}

	public void addPreguntas(Pregunta pregunta) {
		preguntas.add(pregunta);

	}
	public ArrayList<Pregunta> getPreguntas(){
		return preguntas;
	}

	public void mostrarPreguntas() {
		if (preguntas != null) {
			int i = 1;
			for (Pregunta pregunta : preguntas) {
				System.out.println(i + ".- " + pregunta);
				i += 1;
			}
		} else {
			System.out.println("No hay preguntas para mostrar");
		}
	}

	public void eliminarPregunta(int index) {
		preguntas.remove(index - 1);
	}

}
