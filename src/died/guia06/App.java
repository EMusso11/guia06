package died.guia06;

import java.util.*;

public class App {

	public static void main(String[] args) {
		Curso c1 = new Curso("DIED", 10, 40, 2);
		Curso c2 = new Curso("Algoritmos", 40, 0, 10);
		Curso c3 = new Curso("Fisica", 20, 0, 10);
		Curso c4 = new Curso("Gestion de Datos", 10, 10, 10);
		
		
		/*
		 * 
		 * ALUMNO 1 -> aprobo algoritmos
		 * 
		 * */
			
		Alumno a1 = new Alumno("Emilio", (Integer)24715);
		System.out.println("-------------------"+a1.getNombre()+"---------------------");
		c2.inscribir(a1);
		a1.aprobar(c2);						// alcanza los creditos para inscribirese a c1
		
		if(!c1.inscribir(a1)) System.out.println("No se ha podido inscribir a "+c1.getNombre());
		if(!c3.inscribir(a1)) System.out.println("No se ha podido inscribir a "+c3.getNombre());
		if(!c4.inscribir(a1)) System.out.println("No se ha podido inscribir a "+c4.getNombre());
		
		System.out.println("Creditos de "+a1.getNombre()+" -> "+a1.creditosObtenidos());
		
		System.out.println(a1.getNombre()+" se encuentra cursando : ");
		for(Curso unCurso : a1.getCursando()){
			System.out.println(unCurso.getNombre());
		};
		System.out.println(a1.getNombre()+" tiene aprobados : ");
		for(Curso unCurso : a1.getAprobados()){
			System.out.println(unCurso.getNombre());
		};
		
		/*
		 * 
		 * ALUMNO 2 -> aprobo fisica
		 * 
		 * */
		
		Alumno a2 = new Alumno("Lenny", (Integer)24716);
		System.out.println("-------------------"+a2.getNombre()+"-----------------------");
		if(!c3.inscribir(a2)) System.out.println("No se ha podido inscribir a "+c3.getNombre());
		a2.aprobar(c3);
		if(!c1.inscribir(a2)) System.out.println("No se ha podido inscribir a "+c1.getNombre());
		if(!c4.inscribir(a2)) System.out.println("No se ha podido inscribir a "+c4.getNombre());
		
		
		System.out.println("Creditos de "+a2.getNombre()+" -> "+a2.creditosObtenidos());
		
		System.out.println(a2.getNombre()+" se encuentra cursando : ");
		for(Curso unCurso : a2.getCursando()){
			System.out.println(unCurso.getNombre());
		};
		System.out.println(a2.getNombre()+" tiene aprobados : ");
		for(Curso unCurso : a2.getAprobados()){
			System.out.println(unCurso.getNombre());
		};
		
		/*
		 * 
		 * ALUMNO 3 -> se intenta inscribir sin nina materia aprobada
		 * 
		 * */
		
		Alumno a3 = new Alumno("Carl", (Integer)24800);	//intentar inscribir a c1
		System.out.println("-------------------"+a3.getNombre()+"-----------------------");
		if(!c3.inscribir(a3)) System.out.println("No se ha podido inscribir a "+c3.getNombre());
		if(!c1.inscribir(a3)) System.out.println("No se ha podido inscribir a "+c1.getNombre());
		if(!c4.inscribir(a3)) System.out.println("No se ha podido inscribir a "+c4.getNombre());
		
		System.out.println("Creditos de "+a3.getNombre()+" -> "+a3.creditosObtenidos());
		
		System.out.println(a3.getNombre()+" se encuentra cursando : ");
		for(Curso unCurso : a3.getCursando()){
			System.out.println(unCurso.getNombre());
		};
		System.out.println(a3.getNombre()+" tiene aprobados : ");
		for(Curso unCurso : a3.getAprobados()){
			System.out.println(unCurso.getNombre());
		};
		
		
		System.out.println("-------------------"+c2.getNombre()+"-----------------------");
		System.out.println("Contiene los siguientes alumnos : ");
		for(Alumno unAlum : c2.getInscriptos()){
			System.out.println(unAlum.getNombre());
		};
		
	}
}
