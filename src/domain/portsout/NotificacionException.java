package domain.portsout;

public class NotificacionException extends RuntimeException {

	public NotificacionException(Exception e, String msg) {
		super(msg, e);
	}

	public NotificacionException(String msg) {
		super(msg);
	}

}
