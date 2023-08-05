package avance;

import java.util.ArrayList;

public class Paralelo {
	private Materia materia;
	private Termino termino;
	private int numParalelo;
	private ArrayList<Participante> participantes;

	public Paralelo(Materia materia, Termino termino, int numParalelo, ArrayList<Participante> participantes) {
		this.materia = materia;
		this.termino = termino;
		this.numParalelo = numParalelo;
		this.participantes = participantes;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Termino getTermino() {
		return termino;
	}

	public void setTermino(Termino termino) {
		this.termino = termino;
	}

	public int getNumParalelo() {
		return numParalelo;
	}

	public void setNumParalelo(int numParalelo) {
		this.numParalelo = numParalelo;
	}

	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}

}
