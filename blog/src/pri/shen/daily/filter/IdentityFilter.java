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
 * 阻止一般用户访问管理员接口
 */
public class IdentityFilter extends HttpFilter {
	private static final long serialVersionUID = -2910604153138012440L;

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session=request.getSession();
		Integer identity=(Integer) session.getAttribute("identity");
		String method=request.getMethod();
		String uri=request.getRequestURI();
		if("POST".equalsIgnoreCase(method)||(uri!=null&&uri.endsWith("/jsp/new.jsp"))) {
			if(identity==null||identity!=1) {
				response.sendError(401);
			}
		}
		chain.doFilter(request, response);
	}
	
}
