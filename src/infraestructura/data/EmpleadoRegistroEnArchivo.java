package infraestructura.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import domain.portsout.Registro;
import domain.portsout.RegistroException;

public class EmpleadoRegistroEnArchivo implements Registro {

	private String ruta;

	public EmpleadoRegistroEnArchivo(String ruta) {
		this.ruta = ruta;
	}

	public String leerDatos() {

		String  datos   = "";
		File    archivo = new File(ruta);
		Scanner scanner;

		try {
			scanner = new Scanner(archivo);

			while (scanner.hasNextLine()) {
				datos += scanner.nextLine() + "\n";
			}
		} catch (FileNotFoundException e) {
			throw new RegistroException("Error leer datos en archivo");

		}
		return datos;
	}

}
