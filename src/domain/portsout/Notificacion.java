package domain.portsout;

public interface Notificacion {

	void enviar(String destino, String origen, String mensaje);
}
