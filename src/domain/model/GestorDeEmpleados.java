package domain.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import domain.portsin.Gestor;
import domain.portsout.Notificacion;
import domain.portsout.Registro;

public class GestorDeEmpleados implements Gestor {

	private Notificacion notificacion;
	private Registro     registro;

	public GestorDeEmpleados(Notificacion notificacion, Registro registro) {
		this.notificacion = notificacion;
		this.registro     = registro;
	}

	public void cargarEmpleados(LocalDate fecha) {

		for (Empleado empleado : listaDeEmpleados())

			if (empleado.cumpleAnios(fecha)) {
				String msj = empleado.nombre() + " Feliz cumpleaños!!";
				notificacion.enviar(empleado.email(), "empresa@gmail.com", msj);
			}
	}

	private List<Empleado> listaDeEmpleados() {

		List<Empleado> empleados = new ArrayList<>();
		String         datos     = registro.leerDatos();

		String[]       linea     = datos.split("\n");   // cada linea son los datos de un empleado

		for (String lineaEmpleado : linea) {

			String[] datosEmpleado = lineaEmpleado.split(",");
			Empleado empleado      = convertirAEmpleado(datosEmpleado);
			empleados.add(empleado);

		}

		return empleados;

	}

	private Empleado convertirAEmpleado(String[] linea) {

		String            apellido  = linea[0];
		String            nombre    = linea[1];
		String            email     = linea[3];

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate         fecha     = LocalDate.parse(linea[2], formatter);

		return new Empleado(nombre, apellido, fecha, email);
	}

}
