package pri.shen.daily.exception;

/**
 * @author ZhiqiangShen
 * ����ȫ���쳣
 */
public class NoOneParamException extends Throwable{
	private static final long serialVersionUID = -3192951159146281117L;
	
	public NoOneParamException(String message) {
		super(message);
	}
}
