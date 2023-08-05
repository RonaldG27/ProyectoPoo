package avance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Participante implements Serializable, Comparable<Participante>{

            
    private int matricula;
    private String nombre;
    private String correo;

    public Participante(int matricula, String nombre, String correo) {
            this.matricula = matricula;
            this.nombre = nombre;
            this.correo = correo;
    }
	
    public int getMatricula() {
            return matricula;
    }
    public String getNombre() {
            return nombre;
    }

    public String getCorreo() {
            return correo;
    }

    @Override
    public String toString() {
            return "Participante [matricula=" + matricula + ", nombre=" + nombre + ", correo=" + correo + "]";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Participante other = (Participante) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
    return true;
    }
    @Override
    public int compareTo(Participante o) {

        return nombre.compareToIgnoreCase(o.nombre);
    }
        
    public static ArrayList<Participante> cargarParticipantes(String ruta) {
        ArrayList<Participante> participantes = new ArrayList<>();


        try(BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea = null;

            while ((linea = br.readLine()) != null) //iterar mientras haya lineas
            {
                String[] info = linea.split(",");//separar los datos por coma
                //crear objeto y agregar a la lista
                participantes.add(new Participante(Integer.parseInt(info[0]),info[1],info[2]));

            }
        }  catch (IOException ex) {
            System.out.println("Error al leer el archivo");
        }  catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        } 
        
       return participantes;
        }

}
