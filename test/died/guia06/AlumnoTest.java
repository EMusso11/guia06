package died.guia06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class AlumnoTest {
	List<Curso> list1, list2;
	Alumno unAlum;
	Curso c1, c2;
	
	public AlumnoTest() {}
	
	@Before
	public void setUp(){
		list1 = new ArrayList<Curso>();
		list2 = new ArrayList<Curso>();
		unAlum = new Alumno();
		c1 = new Curso();
		c2 = new Curso();
	}
	
	@Test
	public void testCreditosObtenidos() {
		c1 = new Curso();
		list1.add(c1);
		c2 = new Curso();
		list1.add(c2);
		unAlum.setAprobados(list1);
		int results = unAlum.creditosObtenidos();
		
		assertEquals(50, results);
	}
	
	@Test
	public void testAprobarEliminaCursada() {
		list1.add(c1);
		unAlum.setCursando(list1);				// estaba cursando un curso
		
		unAlum.aprobar(c1);						// lo aprueba
		
		assertSame(unAlum.getCursando(), list2);// deberia quedar sin cursos en cursando
	}
	
	@Test
	public void testAprobarAgregaAprobada() {
		list2.add(c1);
		unAlum.setCursando(list1);
		unAlum.aprobar(c1);
		
		assertSame(unAlum.getAprobados(), list2);
	}
	@Test
	public void testInsripcionAceptada() {
		c1.setId(1234);
		list2.add(c1);
		unAlum.setCursando(list1);
		
		unAlum.inscripcionAceptada(c1);
		
		assertSame(unAlum.getCursando(), list2);
	}
}

