package pri.shen.daily.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import pri.shen.daily.entity.Article;
import pri.shen.daily.exception.NoOneParamException;
import pri.shen.daily.exception.NullParamException;
import pri.shen.daily.exception.TypeNotMatchException;
import pri.shen.daily.model.Page;
import pri.shen.daily.service.ArticleService;
import pri.shen.daily.service.impl.ArticleServiceImpl;

public class TestArticleService {
	private ArticleService articleService=new ArticleServiceImpl();
	@Test
	public void testAdd() {
		try {
			articleService.add("1", "1");
		} catch (SQLException | NullParamException | TypeNotMatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testDelete() {
		try {
			articleService.delete("1");
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testUpdate() {
		try {
			articleService.update("211", null, null);
		} catch (SQLException | NoOneParamException | TypeNotMatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testGet() {
		try {
			Article article=articleService.get("3");
			System.out.println(article);
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testList() {
		try {
			Page<List<Article>> page=articleService.list("2", "5");
			System.out.println(page);
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
