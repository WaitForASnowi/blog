package pri.shen.daily.constant;

public interface Constant {
	public static final int DEFAULT_CURRENT_PAGE=1;
	public static final int DEFAULT_PAGE_SIZE=10;
	public static String USERNAME_REGEX="^.{1,20}$";
	public static String PASSWORD_REGEX="^.{1,30}$";
	public static String TITLE_REGEX="^.{0,30}$";
	public static String CONTENT_REGEX="^.{0,1000}$";
}
