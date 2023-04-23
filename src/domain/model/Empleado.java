package domain.model;

import java.time.LocalDate;

import domain.portsin.DomainException;
import domain.portsin.Usuario;

//apellido, nombre, fecha de nacimiento, email
public class Empleado implements Usuario {

	private String    nombre;
	private String    apellido;
	private String    email;
	private LocalDate fecha;

	public Empleado(String apellido, String nombre, LocalDate fecha, String email) {
		this.nombre   = nombre;
		this.apellido = apellido;
		this.email    = email;
		this.fecha    = fecha;

		validarDatos(apellido, nombre, fecha, email);
	}

	private void validarDatos(String apellido, String nombre, LocalDate fecha, String email) {
		if (apellido == null || apellido.equals(""))
			throw new DomainException("Ingrese un APELLIDO.");

		if (nombre == null || nombre.equals(""))
			throw new DomainException("Ingrese un NOMBRE.");

		if (fecha.equals(null))
			throw new DomainException("Ingrese una FECHA.");

		if (email == null || email.equals(""))
			throw new DomainException("Ingrese un Email");

	}

	// Young, Angus, 1982/10/08, angus@acdc.com

	public String datos() {
		return nombre + ", " + apellido + "," + fecha.toString() + ", " + email;
	}

	public boolean cumpleAnios(LocalDate fecha) {

		int mes            = this.fecha.getMonthValue();
		int dia            = this.fecha.getDayOfMonth();

		int mesComparacion = fecha.getMonthValue();
		int diaComparacion = fecha.getDayOfMonth();

		return (mes == mesComparacion && dia == diaComparacion);
	}

	public String nombre() {
		return nombre;
	}

	public String email() {

		return email;
	}
}
