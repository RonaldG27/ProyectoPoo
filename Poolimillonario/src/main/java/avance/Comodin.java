package avance;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Comodin {
	private boolean comodin5050Disponible;
    private boolean comodinConsultaCompaneroDisponible;
    private boolean comodinConsultaSalonDisponible;
	private Pregunta pregunta;
	private Participante companero;
	
	
	Scanner sc = new Scanner(System.in);
	
	public Comodin() {
        this.comodin5050Disponible = true;
        this.comodinConsultaCompaneroDisponible = true;
        this.comodinConsultaSalonDisponible = true;
    }
	
	public boolean isComodin5050Disponible() {
        return comodin5050Disponible;
    }

    public boolean isComodinConsultaCompaneroDisponible() {
        return comodinConsultaCompaneroDisponible;
    }

    public boolean isComodinConsultaSalonDisponible() {
        return comodinConsultaSalonDisponible;
    }

    public void usarComodin5050(ArrayList<String> opciones) {
    	
    	Random random = new Random();
        int descartar1 = random.nextInt(opciones.size());
        opciones.remove(descartar1);

        int descartar2 = random.nextInt(opciones.size());
        opciones.remove(descartar2);
        
        comodin5050Disponible = false;
    }

    public void usarComodinConsultaCompanero(Participante companero,ArrayList<String> opciones ) {
    	System.out.println("Consultando ingrese la respuesta del compañero");
    	String respuestaCorrecta = sc.nextLine();
    	System.out.println(companero + " dice que la respuesta es: " + respuestaCorrecta);
        comodinConsultaCompaneroDisponible = false;
    }

    public void usarComodinConsultaSalon(ArrayList<String> opciones) {
    	System.out.println("Consultando ingrese la respuesta del salon");
    	String respuestaCorrecta = sc.nextLine();
    	System.out.println("La mayoria del salon dice que la respuesta es: " + respuestaCorrecta);
        comodinConsultaSalonDisponible = false;
    }
}
