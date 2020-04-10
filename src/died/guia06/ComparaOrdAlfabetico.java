package died.guia06;

import java.util.Comparator;

public class ComparaOrdAlfabetico implements Comparator<Alumno> {
	public int compare (Alumno a1, Alumno a2){
		return a1.getNombre().compareTo(a2.getNombre());
	}
}
