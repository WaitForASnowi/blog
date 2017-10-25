package pri.shen.daily.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pri.shen.daily.constant.Message;
import pri.shen.daily.dto.Result;
import pri.shen.daily.exception.LoginException;
import pri.shen.daily.exception.NullParamException;
import pri.shen.daily.exception.TypeNotMatchException;
import pri.shen.daily.service.UserService;
import pri.shen.daily.service.impl.UserServiceImpl;

/**
 * @author ZhiqiangShen
 * ×¢²áµÇÂ¼Æ÷
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = -1915213031326406906L;
	private UserService userService;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String usernameParam=req.getParameter("username");
		String passwordParam=req.getParameter("password");
		
		try {
			userService.register(usernameParam, passwordParam);
			req.setAttribute("result", new Result<>(true, Message.REGISTER_SUCCESS));
		} catch (NullParamException | TypeNotMatchException | LoginException e) {
			req.setAttribute("result", new Result<>(false, e.getMessage()));
		} catch (SQLException e) {
			req.setAttribute("result", new Result<>(false, Message.REGISTER_FAILURE));
		}
		req.setAttribute("username", usernameParam);
		req.setAttribute("password", passwordParam);
		
		req.getRequestDispatcher("/register.jsp").forward(req, resp);
	}

	@Override
	public void init() throws ServletException {
		this.userService=new UserServiceImpl();
	}
	
}
