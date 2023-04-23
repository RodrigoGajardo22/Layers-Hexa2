package main;

import java.time.LocalDate;

import domain.model.GestorDeEmpleados;
import domain.portsout.Registro;
import infraestructura.data.EmpleadoRegistroEnArchivo;
import infraestructura.mail.Mail;

public class Main {

	public static void main(String[] args) {

		String            ruta     = "C:\\Users\\Usuario\\Documents\\2 - UNIVERSIDAD RODRI\\Orientacion a Objetos 2\\Empleados.txt";

		Registro          registro = new EmpleadoRegistroEnArchivo(ruta);
		GestorDeEmpleados gestor   = new GestorDeEmpleados(new Mail(), registro);
		gestor.cargarEmpleados(LocalDate.now());

	}

}
