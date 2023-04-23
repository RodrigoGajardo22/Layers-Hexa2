package domain.model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class modelTest {

	@Test
	void testMail() {

		var               mailFake     = new MailFake();
		var               registroFake = new EmpleadoRegistroFake();

		GestorDeEmpleados gestor       = new GestorDeEmpleados(mailFake, registroFake);
		LocalDate         fecha        = LocalDate.of(2023, 4, 22);
		gestor.cargarEmpleados(fecha);

		assertTrue(mailFake.startWitch("Johnson"));
	}

	@Test
	void testCumpleAnios() {

		Empleado e1, e2;

		e1 = new Empleado("Perez", "Alberto", LocalDate.of(1992, 4, 02), "albertoPerez@gmail.com");
		e2 = new Empleado("Melaslavo", "Joni", LocalDate.of(1995, 7, 15), "joniMelaslavo@gmail.com");

		LocalDate fecha = LocalDate.of(2023, 4, 02);

		assertTrue(e1.cumpleAnios(fecha));
		assertFalse(e2.cumpleAnios(fecha));

	}

}
