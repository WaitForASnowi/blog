package pri.shen.daily.dao;

import java.sql.SQLException;
import java.util.List;


import pri.shen.daily.entity.Article;
import pri.shen.daily.model.Page;

/**
 * @author ZhiqiangShen
 * 文章数据操作
 */
public interface ArticleDao {
	public void add(Article article) throws SQLException;
	public void delete(Long articleId) throws SQLException;
	public void update(Article article) throws SQLException;
	public Article get(Long articleId) throws SQLException;
	public Page<List<Article>> list(int currentPage,int pageSize) throws SQLException;
}
