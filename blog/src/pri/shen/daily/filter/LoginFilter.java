package pri.shen.daily.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author ZhiqiangShen
 * ¹ýÂËÎ´µÇÂ¼ÓÃ»§
 */
public class LoginFilter extends HttpFilter {
	private static final long serialVersionUID = -4238715380533335021L;

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session=request.getSession();
		Integer identity=(Integer) session.getAttribute("identity");
		if(identity!=null&&(1==identity||0==identity)) {
			chain.doFilter(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
	}
	
}
