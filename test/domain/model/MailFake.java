package domain.model;

import domain.portsout.Notificacion;

public class MailFake implements Notificacion {

	private String msj;

	@Override
	public void enviar(String destino, String origen, String mensaje) {
		this.msj = mensaje;
	}

	public boolean startWitch(String start) {

		return this.msj.startsWith(start);
	}

}
