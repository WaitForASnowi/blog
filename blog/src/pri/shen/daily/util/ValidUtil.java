package pri.shen.daily.util;

import java.util.regex.Pattern;

import pri.shen.daily.constant.Constant;
import pri.shen.daily.entity.User;
import pri.shen.daily.exception.NullParamException;
import pri.shen.daily.exception.TypeNotMatchException;

public class ValidUtil {
	public static User validUser(String usernameParam,String passwordParam) throws NullParamException, TypeNotMatchException {
		if(usernameParam==null) {
			throw new NullParamException("�û�������Ϊ��");
		}
		if(passwordParam==null) {
			throw new NullParamException("���벻��Ϊ��");
		}
		if(!Pattern.matches(Constant.USERNAME_REGEX, usernameParam)) {
			throw new TypeNotMatchException("�û����������20λ");
		}
		if(!Pattern.matches(Constant.PASSWORD_REGEX, passwordParam)) {
			throw new TypeNotMatchException("���볤�����30λ");
		}
		
		return new User(usernameParam, passwordParam);
	}
	
	public static void validArticle(String articleTitleParam,String articleContentParam) throws NullParamException, TypeNotMatchException {
		if(articleTitleParam==null||articleTitleParam.equals("")) {
			throw new NullParamException("���±��ⲻ��Ϊ��");
		}
		if(articleContentParam==null||articleContentParam.equals("")) {
			throw new NullParamException("�������ݲ���Ϊ��");
		}
		if(!Pattern.matches(Constant.TITLE_REGEX, articleTitleParam)) {
			throw new TypeNotMatchException("���±��ⳤ�����20��");
		}
		if(!Pattern.matches(Constant.CONTENT_REGEX, articleContentParam)) {
			throw new TypeNotMatchException("�������ݳ������1000��");
		}
	}
	
}
