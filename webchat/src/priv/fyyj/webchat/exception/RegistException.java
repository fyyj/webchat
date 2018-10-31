package priv.fyyj.webchat.exception;
/**
 * 注册异常
 * @author fyyj
 *
 */
public class RegistException extends Exception {
	public RegistException() {
		super();
	}
	public RegistException(Throwable cause) {
		super(cause);
	}
	public RegistException(String message, Throwable cause) {
		super(message, cause);
	}
	public RegistException(String message) {
		super(message);
	}
}
