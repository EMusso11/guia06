package died.guia06;

import java.io.IOException;
import java.util.*;
import java.lang.Exception;
import java.lang.Throwable;

import died.guia06.util.Registro;
import died.guia06.util.RegistroAuditoriaException;

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
	 * Este mÃ©todo, verifica si el alumno se puede inscribir y si es asÃ­ lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que estÃ¡ inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno estÃ¡ inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultÃ¡neo a no mÃ¡s de 3 cursos del mismo ciclo lectivo.
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
	
	
	/*
	 * Luego en el punto 7 cuando tienen que crear excepciones personalizadas,
	 * si el método retornará verdadero si pudo inscribir y lanzará una excepción
	 * por cada posible error (de lógica o de registro).
	 * En este caso es probable que el método nunca retorne falso, y si lo rediseñamos,
	 * podríamos ver que podría no retornar nada (void) dado que ejecuta exitosamente y
	 * me inscribió o lanza una excepción
	 * */
	
	public void inscribirAlumno(Alumno a) throws 	CreditosInsuficientesException,
													CupoCubiertoException,
													RegistroAuditoriaException {
		
		try {
			if(a.creditosObtenidos()<this.creditosRequeridos)
				throw new CreditosInsuficientesException("Los creditos obtenidos("+a.creditosObtenidos()+") no alcanzan los requeridos("+this.getCreditosRequeridos()+").");
			if(this.inscriptos.size()>=cupo)
				throw new CupoCubiertoException("El cupo ya esta completo.");
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		} catch(IOException e) {
			throw new RegistroAuditoriaException();
		}
		
			
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
