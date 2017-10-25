package pri.shen.daily.util;

import java.util.regex.Pattern;

import pri.shen.daily.constant.Constant;
import pri.shen.daily.entity.User;
import pri.shen.daily.exception.NullParamException;
import pri.shen.daily.exception.TypeNotMatchException;

public class ValidUtil {
	public static User validUser(String usernameParam,String passwordParam) throws NullParamException, TypeNotMatchException {
		if(usernameParam==null) {
			throw new NullParamException("用户名不能为空");
		}
		if(passwordParam==null) {
			throw new NullParamException("密码不能为空");
		}
		if(!Pattern.matches(Constant.USERNAME_REGEX, usernameParam)) {
			throw new TypeNotMatchException("用户名长度最多20位");
		}
		if(!Pattern.matches(Constant.PASSWORD_REGEX, passwordParam)) {
			throw new TypeNotMatchException("密码长度最多30位");
		}
		
		return new User(usernameParam, passwordParam);
	}
	
	public static void validArticle(String articleTitleParam,String articleContentParam) throws NullParamException, TypeNotMatchException {
		if(articleTitleParam==null||articleTitleParam.equals("")) {
			throw new NullParamException("文章标题不能为空");
		}
		if(articleContentParam==null||articleContentParam.equals("")) {
			throw new NullParamException("文章内容不能为空");
		}
		if(!Pattern.matches(Constant.TITLE_REGEX, articleTitleParam)) {
			throw new TypeNotMatchException("文章标题长度最多20字");
		}
		if(!Pattern.matches(Constant.CONTENT_REGEX, articleContentParam)) {
			throw new TypeNotMatchException("文章内容长度最多1000字");
		}
	}
	
}
