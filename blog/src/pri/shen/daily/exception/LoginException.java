package pri.shen.daily.exception;

public class LoginException extends Throwable {
	private static final long serialVersionUID = -2097881807415236563L;
	
	public LoginException(String message) {
		super(message);
	}
}
