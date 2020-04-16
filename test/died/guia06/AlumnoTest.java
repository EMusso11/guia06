package died.guia06;

import static org.junit.Assert.*;

import org.junit.Test;

class AlumnoTest {

	@Test
	void testCreditosObtenidos() {
		List<Curso> listCursos = new ArrayList<Curso>();
		Curso c1 = new Curso(30);
		listCursos.add(c1);
		Curso c2 = new Curso(20);
		listCursos.add(c2);
		Alumno unAlum = new Alumno();
		unAlum.setAprobados(listCursos);
		
		assertSame(50, unAlum.creditosObtenidos());
	}
/*
	@Test
	void testAprobarEliminaCursada() {
		List<Curso> list1 = new ArrayList<Curso>();
		List<Curso> list2 = new ArrayList<Curso>();
		Alumno unAlum = new Alumno();
		
		Curso unCurso = new Curso();
		unCurso.setId(1234);
		list1.add(unCurso);
		unAlum.setCursando(list1);				// estaba cursando un curso
		
		unAlum.aprobar(unCurso);				// lo aprueba
		
		assertSame(unAlum.getCursando(), list2);// deberia quedar sin cursos en cursando
	}
	
	@Test
	void testAprobarAgregaAprobada() {
		List<Curso> list1 = new ArrayList<Curso>();
		List<Curso> list2 = new ArrayList<Curso>();
		Alumno unAlum = new Alumno();
		
		Curso unCurso = new Curso();
		unCurso.setId(1234);
		list2.add(unCurso);
		unAlum.setCursando(list1);
		
		unAlum.aprobar(unCurso);
		
		assertSame(unAlum.getAprobados(), list2);
	}
	@Test
	void testInsripcionAceptada() {
		List<Curso> list1 = new ArrayList<Curso>();
		List<Curso> list2 = new ArrayList<Curso>();
		Alumno unAlum = new Alumno();
		
		Curso unCurso = new Curso();
		unCurso.setId(1234);
		list2.add(unCurso);
		unAlum.setCursando(list1);
		
		unAlum.inscripcionAceptada(unCurso);
		
		assertSame(unAlum.getCursando(), list2);
	}*/
}

