package avance;

import java.util.Scanner;

public class Pregunta {

	private String enunciado;
	private int nivel;
	private String respuestaCorrecta;
	private String respuestaInco1;
	private String respuestaInco2;
	private String respuestaInco3;

	Scanner sc = new Scanner(System.in);

	public Pregunta() {
		System.out.println("Ingrese el enunciado");
		this.enunciado = sc.nextLine();
		System.out.println("Ingrese el nivel");
		this.nivel = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese el respuesta Correcta");
		this.respuestaCorrecta = sc.nextLine();

		System.out.println("Ingrese el respuesta la opcion incorrecta 1");
		this.respuestaInco1 = sc.nextLine();

		System.out.println("Ingrese el respuesta la opcion incorrecta 2");
		this.respuestaInco2 = sc.nextLine();
		System.out.println("Ingrese el respuesta la opcion incorrecta 3");
		this.respuestaInco3 = sc.nextLine();
	}

	public Pregunta(String e, int n, String rc, String ri1, String ri2, String ri3) {
		this.enunciado = e;
		this.nivel = n;
		this.respuestaCorrecta = rc;
		this.respuestaInco1 = ri1;
		this.respuestaInco2 = ri2;
		this.respuestaInco3 = ri3;
	}

	@Override
	public String toString() {
		return "Pregunta [enunciado=" + enunciado + ", respuestaCorrecta= " + respuestaCorrecta + ", respuestaIncorrecta1= "+ respuestaInco1+"respuestaIncorrecta2= " +respuestaInco2+", respuestaIncorrecta3= "+"respuestaInco3"+"]";
	}
// getters 
	public String getEnunciado() {
		return enunciado;
	}
	
	public int getNivel() {
		return nivel;
	}
	public String getRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	public String getRespuestaInco2() {
		return respuestaInco2;
	}

	public String getRespuestaInco3() {
		return respuestaInco3;
	}

	public String getRespuestaInco1() {
		return respuestaInco1;
	}

}
