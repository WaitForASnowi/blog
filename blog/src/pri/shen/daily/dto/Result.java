package pri.shen.daily.dto;

/**
 * @author ZhiqiangShen
 * 向view层返回的结果
 * @param <T>
 */
public class Result<T>{
	private Boolean success;
	private Integer code;
	private T data;
	private String message;
	
	public Result() {
		super();
	}

	public Result(Boolean success, T data, String message) {
		super();
		this.success = success;
		this.data = data;
		this.message = message;
	}
	
	public Result(Boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public Result(Boolean success, T data) {
		super();
		this.success = success;
		this.data = data;
	}
	
	

	public Result(Boolean success, Integer code, String message) {
		super();
		this.success = success;
		this.code = code;
		this.message = message;
	}

	public Result(Boolean success, Integer code) {
		super();
		this.success = success;
		this.code = code;
	}

	public Result(Boolean success, Integer code, T data) {
		super();
		this.success = success;
		this.code = code;
		this.data = data;
	}

	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Result [success=" + success + ", code=" + code + ", data=" + data + ", message=" + message + "]";
	}
	
}
