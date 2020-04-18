package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import died.guia06.util.Registro;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo; 
	private List<Alumno> inscriptos;
	private Integer cupo;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	private Registro log;
	
	public Curso() {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	
	public Curso(String nombre, Integer creditos, Integer creditosRequeridos, Integer cupo) {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
		this.nombre = nombre;
		this.creditos = creditos;
		this.creditosRequeridos = creditosRequeridos;
		this.cupo = cupo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCupo() {
		return cupo;
	}

	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	public Integer getCreditosRequeridos() {
		return creditosRequeridos;
	}

	public void setCreditosRequeridos(Integer creditosRequeridos) {
		this.creditosRequeridos = creditosRequeridos;
	}
	
	public List<Alumno> getInscriptos() {
		return inscriptos;
	}
	
	public void setInscriptos(List<Alumno> list) {
		this.inscriptos = list;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + "]";
	}

	/**
	 * Este método, verifica si el alumno se puede inscribir y si es así lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que está inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno está inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultáneo a no más de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 */
	public boolean inscribir(Alumno a) {
		try {
			if(a.creditosObtenidos()<this.creditosRequeridos)
				return false;
			if(this.inscriptos.size()>=cupo)
				return false;
			if(a.getCursando().size()>=3)
				return false;
			else{
				log.registrar(this, "inscribir ",a.toString());
				a.inscripcionAceptada(this);
				inscriptos.add(a);
				return true;
			}
		} catch(IOException e) {
			System.err.println("Error E/S : "+e.getMessage());
		}
		return false;
	}
	
	
	/**
	 * imprime los inscriptos en orden alfabetico
	 */
	public void imprimirInscriptos() {
		try {
			Collections.sort(this.inscriptos, new ComparaOrdAlfabetico());
			System.out.println(this.inscriptos);
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		} catch (IOException e) {
			System.err.println("Error E/S : "+e.getMessage());
		}
	}


}
