package pri.shen.daily.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pri.shen.daily.constant.Message;
import pri.shen.daily.dto.Result;
import pri.shen.daily.entity.Article;
import pri.shen.daily.exception.NoOneParamException;
import pri.shen.daily.exception.NullParamException;
import pri.shen.daily.exception.TypeNotMatchException;
import pri.shen.daily.service.ArticleService;
import pri.shen.daily.service.impl.ArticleServiceImpl;

public class ArticleServlet extends HttpServlet{
	private static final long serialVersionUID = -8121835688013668459L;
	private ArticleService articleService;
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String articleIdParam=req.getParameter("articleId");
		
		try {
			articleService.delete(articleIdParam);
			req.setAttribute("result", new Result<>(true, Message.DELETE_SUCCESS));
		} catch (NumberFormatException | SQLException e) {
			req.setAttribute("result", new Result<>(false, Message.DELETE_FAILURE));
		}
		req.getRequestDispatcher("/articles").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String articleIdParam=req.getParameter("articleId");
		
		try {
			Article article=articleService.get(articleIdParam);
			req.setAttribute("result", new Result<Article>(true,article));
			req.getRequestDispatcher("/jsp/detail.jsp").forward(req, resp);
		} catch (NumberFormatException | SQLException e) {
			req.setAttribute("result", new Result<>(false, Message.GET_FAILURE));
			req.getRequestDispatcher("/jsp/list.jsp").forward(req, resp);
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method=req.getParameter("_method");
		if(method!=null&&!method.equals("")) {
			if(method.equalsIgnoreCase("put")) {
				this.doPut(req, resp);
				return;
			}else if(method.equalsIgnoreCase("delete")){
				this.doDelete(req, resp);
				return;
			}
		}
		
		String articleTitleParam=req.getParameter("articleTitle");
		String articleContentParam=req.getParameter("articleContent");
		
		try {
			articleService.add(articleTitleParam, articleContentParam);
			req.setAttribute("result", new Result<>(true, Message.ADD_SUCCESS));
		} catch ( NullParamException | TypeNotMatchException e) {
			req.setAttribute("result", new Result<>(false, e.getMessage()));
		} catch (SQLException e) {
			req.setAttribute("result", new Result<>(false, Message.ADD_FAILURE));
		}
		
		req.setAttribute("articleTitle", articleTitleParam);
		req.setAttribute("articleContent", articleContentParam);
		
		req.getRequestDispatcher("/jsp/new.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String articleIdParam=req.getParameter("articleId");
		String articleTitleParam=req.getParameter("articleTitle");
		String articleContentParam=req.getParameter("articleContent");
		
		try {
			articleService.update(articleIdParam, articleTitleParam, articleContentParam);
			req.setAttribute("result",new Result<>(true,Message.UPDATE_SUCCESS));
		} catch (NoOneParamException | TypeNotMatchException e) {
			req.setAttribute("result", new Result<>(false, e.getMessage()));
		} catch (SQLException e) {
			req.setAttribute("result", new Result<>(false, Message.UPDATE_FAILURE));
		}
		req.setAttribute("articleId", articleIdParam);
		req.setAttribute("articleTitle", articleTitleParam);
		req.setAttribute("articleContent", articleContentParam);
		req.getRequestDispatcher("/jsp/detail.jsp").forward(req, resp);
	}
	@Override
	public void init() throws ServletException {
		this.articleService=new ArticleServiceImpl();
	}
	
}
