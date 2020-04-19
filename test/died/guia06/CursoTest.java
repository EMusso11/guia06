package died.guia06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class CursoTest {
	Curso c1, c2, c3, c4;
	Alumno a1, a2, a3;
	List<Curso> listCurso;
	List<Alumno>listAlumno;
	
	@Before
	public void setUp(){
		c1 = new Curso();
		c2 = new Curso();
		c3 = new Curso();
		c4 = new Curso();
		a1 = new Alumno();
		a2 = new Alumno();
		a3 = new Alumno();
		listCurso = new ArrayList<Curso>();
		listAlumno = new ArrayList<Alumno>();
	}
	@Test
	public void testInscribirSinCreditosSuficientes() {
		c1.setCreditos(10);
		c2.setCreditos(12);
		c3.setCreditosRequeridos(50);
		
		listCurso.add(c1); listCurso.add(c2);
		a1.setCursando(listCurso);
		
		assertFalse(c3.inscribir(a1));
	}
	@Test
	public void testInscribirSinCupoSuficiente() {
		c1.setCupo(2);
		listAlumno.add(a1); listAlumno.add(a2);
		
		c1.setInscriptos(listAlumno);
		
		assertFalse(c1.inscribir(a3));
	}
	@Test
	public void testInscribirCursandoMasDeTresMaterias() {
		listCurso.add(c1); listCurso.add(c2); listCurso.add(c3);
		a1.setCursando(listCurso);
		
		assertFalse(c4.inscribir(a1));
	}
	@Test
	public void testInscribirCorrecta() {
		c1.setCupo(10);
		c1.inscribir(a1);
		assertTrue(c1.getInscriptos().contains(a1));
	}

}
