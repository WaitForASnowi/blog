package pri.shen.daily.exception;

/**
 * @author ZhiqiangShen
 * ����Ϊ���쳣
 */
public class NullParamException extends Throwable {

	private static final long serialVersionUID = 6246452712825426413L;
	
	public NullParamException(String message) {
		super(message);
	}
}
