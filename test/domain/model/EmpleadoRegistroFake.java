package domain.model;

import domain.portsout.Registro;

public class EmpleadoRegistroFake implements Registro {

	@Override
	public String leerDatos() {

		return "Young, Angus,1982/04/08, angus@acdc.com\n" + "Johnson, Brian,1992/04/22, brian@acdc.com";
	}

}
