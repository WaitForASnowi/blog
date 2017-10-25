package pri.shen.daily.service;

import java.sql.SQLException;
import java.util.List;

import pri.shen.daily.entity.Article;
import pri.shen.daily.exception.NoOneParamException;
import pri.shen.daily.exception.NullParamException;
import pri.shen.daily.exception.TypeNotMatchException;
import pri.shen.daily.model.Page;

/**
 * @author ZhiqiangShen
 * 与文章有关的业务逻辑
 */
public interface ArticleService {
	public void add(String articleTitleParam,String articleContentParam) throws NullParamException, TypeNotMatchException, SQLException;
	public void delete(String articleIdParam) throws NumberFormatException, SQLException;
	public void update(String articleIdParam,String articleTitleParam,
			String articleContentParam) throws NoOneParamException, TypeNotMatchException, SQLException;
	public Article get(String articleIdParam) throws NumberFormatException, SQLException;
	public Page<List<Article>> list(String currentPageParam,String pageSizeParam) throws NumberFormatException,SQLException;
}
