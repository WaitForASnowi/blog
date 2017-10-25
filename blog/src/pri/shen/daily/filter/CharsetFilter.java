package pri.shen.daily.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ZhiqiangShen
 * ×Ö·û¹ýÂËÆ÷,±ÜÃâÂÒÂë
 */
public class CharsetFilter extends HttpFilter{
	private static final long serialVersionUID = -2393853277722023958L;
	private String charSet;
	
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(charSet);
		response.setCharacterEncoding(charSet);
		chain.doFilter(request, response);
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		charSet=filterConfig.getInitParameter("charSet");
	}
	
	
	
}
