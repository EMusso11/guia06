package died.guia06;

import java.util.*;


public class Alumno implements Comparable {

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;
	
	public Alumno() {
		this.cursando = new ArrayList<Curso>();
		this.aprobados = new ArrayList<Curso>();
	}
	
	public Alumno(String nombre, Integer nroLibreta) {
		this.nombre = nombre;
		this.nroLibreta = nroLibreta;
		this.cursando = new ArrayList<Curso>();
		this.aprobados = new ArrayList<Curso>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public void setAprobados(List<Curso> listCursos) {
		this.aprobados = listCursos;	
	}
	
	public void setCursando(List<Curso> listCursos) {
		this.aprobados = listCursos;	
	}

	public Integer getNroLibreta() {
		return nroLibreta;
	}

	public void setNroLibreta(Integer nroLibreta) {
		this.nroLibreta = nroLibreta;
	}

	public List<Curso> getAprobados() {
		return aprobados;
	}
	
	public List<Curso> getCursando() {
		return cursando;
	}
	
		@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", nroLibreta=" + nroLibreta + "]";
	}

	public Integer creditosObtenidos() {
		Integer credit=0;
		for(Curso unCurso : aprobados){
			credit+=unCurso.getCreditos();
		}
		return credit;
	}

	public void aprobar(Curso c) {
		cursando.remove(c);
		aprobados.add(c);
	}

	public void inscripcionAceptada(Curso c) {
		cursando.add(c);
	}

	@Override
	public boolean equals(Object obj) {
		return ((obj instanceof Alumno) && ((Alumno)obj).nroLibreta==this.nroLibreta);
	}
	
	public int compareTo (Alumno a1, Alumno a2){
		return a1.getNombre().compareTo(a2.getNombre());
	}

}
