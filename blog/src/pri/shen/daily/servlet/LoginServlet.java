package pri.shen.daily.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pri.shen.daily.constant.Message;
import pri.shen.daily.dto.Result;
import pri.shen.daily.entity.User;
import pri.shen.daily.exception.LoginException;
import pri.shen.daily.exception.NullParamException;
import pri.shen.daily.exception.TypeNotMatchException;
import pri.shen.daily.service.UserService;
import pri.shen.daily.service.impl.UserServiceImpl;

/**
 * @author ZhiqiangShen
 * µÇÂ¼¿ØÖÆÆ÷
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 3886154674635040255L;
	private UserService userService;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String usernameParam=req.getParameter("username");
		String passwordParam=req.getParameter("password");
		try {
			User user=userService.login(usernameParam, passwordParam);
		    HttpSession session=req.getSession();
		    session.setAttribute("username", user.getUsername());
		    session.setAttribute("identity", user.getIdentity());
		} catch (NullParamException | TypeNotMatchException | LoginException e) {
			req.setAttribute("result", new Result<>(false, e.getMessage()));
		} catch (SQLException e) {
			req.setAttribute("result", new Result<>(false, Message.LOGIN_FAILURE));
		}
		
		req.setAttribute("username", usernameParam);
		req.setAttribute("password", passwordParam);
		
		resp.sendRedirect(req.getContextPath()+"/articles");
	}

	@Override
	public void init() throws ServletException {
		this.userService=new UserServiceImpl();
	}
	
}
