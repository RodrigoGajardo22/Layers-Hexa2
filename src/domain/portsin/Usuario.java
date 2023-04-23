package domain.portsin;

import java.time.LocalDate;

public interface Usuario {

	String datos();

	String nombre();

	boolean cumpleAnios(LocalDate fecha);

}
