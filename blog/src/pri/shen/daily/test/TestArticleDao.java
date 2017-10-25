package pri.shen.daily.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import pri.shen.daily.dao.ArticleDao;
import pri.shen.daily.dao.impl.ArticleDaoImpl;
import pri.shen.daily.entity.Article;
import pri.shen.daily.model.Page;

public class TestArticleDao {
	private ArticleDao articleDao;
	@Test
	public void testAdd() {
		for (int i = 0; i < 100; i++) {
			articleDao=new ArticleDaoImpl();
			Article article=new Article();
			article.setArticleTitle("12344");
			article.setArticleContent("12345644");
			try {
				articleDao.add(article);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	@Test
	public void testUpdate() {
		articleDao=new ArticleDaoImpl();
		Article article=new Article();
		article.setArchiveId(1L);

	
		try {
			articleDao.update(article);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDelete() {
		articleDao=new ArticleDaoImpl();
		try {
			articleDao.delete(2L);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGet() {
		articleDao=new ArticleDaoImpl();
		try {
			Article article=articleDao.get(3L);
			System.out.println(article);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testList() {
		articleDao=new ArticleDaoImpl();
		try {
			Page<List<Article>> page=articleDao.list(3, 5);
			System.out.println(page);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
