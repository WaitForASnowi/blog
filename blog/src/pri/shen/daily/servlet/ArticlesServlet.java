package pri.shen.daily.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pri.shen.daily.constant.Message;
import pri.shen.daily.dto.Result;
import pri.shen.daily.entity.Article;
import pri.shen.daily.model.Page;
import pri.shen.daily.service.ArticleService;
import pri.shen.daily.service.impl.ArticleServiceImpl;

public class ArticlesServlet extends HttpServlet {
	private static final long serialVersionUID = -8121835688013668459L;
	private ArticleService articleService;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String currentPageParam=req.getParameter("currentPage");
		String pageSizeParam=req.getParameter("pageSize");
		try {
			Page<List<Article>> page=articleService.list(currentPageParam, pageSizeParam);
			req.setAttribute("result", new Result<>(true, page));
		} catch (NumberFormatException|SQLException e) {
			req.setAttribute("result",new Result<>(false, Message.LIST_FAILURE));
		}
		req.getRequestDispatcher("/jsp/list.jsp").forward(req, resp);
	}
	@Override
	public void init() throws ServletException {
		this.articleService=new ArticleServiceImpl();
	}
	
	
	
}
