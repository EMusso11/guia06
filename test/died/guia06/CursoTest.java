package died.guia06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class CursoTest {
	Curso c1, c2, c3, c4;
	Alumno a1, a2, a3;
	
	@Before
	public void setUp(){
		c1 = new Curso();
		c2 = new Curso();
		c3 = new Curso();
		c4 = new Curso();
		a1 = new Alumno();
		a2 = new Alumno();
		a3 = new Alumno();
	}
	@Test
	public void testInscribirSinCreditosSuficientes() {
		c1.setCreditos(10);
		c2.setCreditos(12);
		c3.setCreditosRequeridos(50);
		List<Curso> list = new ArrayList<Curso>();
		
		list.add(c1); list.add(c2);
		a1.setCursando(list);
		
		assertFalse(c3.inscribir(a1));
	}
	@Test
	public void testInscribirSinCupoSuficiente() {
		List<Alumno> list = new ArrayList<Alumno>();
		c1.setCupo(2);
		list.add(a1); list.add(a2);
		
		c1.setInscriptos(list);
		
		assertFalse(c1.inscribir(a3));
	}
	@Test
	public void testInscribirCursandoMasDeTresMaterias() {
		List<Curso> list = new ArrayList<Curso>();
		list.add(c1); list.add(c2); list.add(c3);
		a1.setCursando(list);
		
		assertFalse(c4.inscribir(a1));
	}
	@Test
	public void testInscribirCorrecta() {
		c1.inscribir(a1);
		assertTrue(c1.getInscriptos().contains(a1));
	}

}
