package pri.shen.daily.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

import pri.shen.daily.constant.Constant;
import pri.shen.daily.dao.ArticleDao;
import pri.shen.daily.dao.impl.ArticleDaoImpl;
import pri.shen.daily.entity.Article;
import pri.shen.daily.exception.NoOneParamException;
import pri.shen.daily.exception.NullParamException;
import pri.shen.daily.exception.TypeNotMatchException;
import pri.shen.daily.model.Page;
import pri.shen.daily.service.ArticleService;
import pri.shen.daily.util.ValidUtil;

public class ArticleServiceImpl implements ArticleService {
	
	private ArticleDao articleDao;
	
	public ArticleServiceImpl() {
		articleDao=new ArticleDaoImpl();
	}
	@Override
	public void add(String articleTitleParam, String articleContentParam) throws NullParamException, TypeNotMatchException, SQLException, NumberFormatException {
		ValidUtil.validArticle(articleTitleParam, articleContentParam);
		Article article=new Article(articleTitleParam, articleContentParam);
		articleDao.add(article);

	}

	@Override
	public void delete(String articleIdParam) throws NumberFormatException, SQLException {
		articleDao.delete(Long.valueOf(articleIdParam));

	}

	@Override
	public void update(String articleIdParam, String articleTitleParam, String articleContentParam) throws NoOneParamException, TypeNotMatchException, SQLException {
		if((articleTitleParam==null||articleTitleParam.equals(""))&&(articleContentParam==null||articleContentParam.equals(""))) {
			throw new NoOneParamException("至少更新标题或者内容");
		}else if(articleTitleParam==null||articleTitleParam.equals("")){
			if(!Pattern.matches(Constant.TITLE_REGEX, articleTitleParam)) {
				throw new TypeNotMatchException("文章标题长度最多20字");
			}
		}else if(articleContentParam==null||articleContentParam.equals("")) {
			if(!Pattern.matches(Constant.CONTENT_REGEX, articleContentParam)) {
				throw new TypeNotMatchException("文章内容长度最多1000字");
			}
		}
		
		Article article=new Article(articleTitleParam, articleContentParam);
		article.setArchiveId(Long.valueOf(articleIdParam));
		
		articleDao.update(article);
		

	}

	@Override
	public Article get(String articleIdParam) throws NumberFormatException, SQLException {
		return articleDao.get(Long.valueOf(articleIdParam));
		
	}

	@Override
	public Page<List<Article>> list(String currentPageParam,String pageSizeParam) throws NumberFormatException,SQLException {
		int currentPage;
		int pageSize;
		if(currentPageParam==null||currentPageParam.equals("")) {
			currentPage=Constant.DEFAULT_CURRENT_PAGE;
		}else {
			try {
				currentPage=Integer.valueOf(currentPageParam);
			} catch (NumberFormatException e) {
				currentPage=Constant.DEFAULT_CURRENT_PAGE;
			}
		}
		if(pageSizeParam==null||currentPageParam.equals("")) {
			pageSize=Constant.DEFAULT_PAGE_SIZE;
		}else {
			try {
				pageSize=Integer.valueOf(pageSizeParam);
			} catch (NumberFormatException e) {
				pageSize=Constant.DEFAULT_PAGE_SIZE;
			}
		}
		
		Page<List<Article>> page=articleDao.list(currentPage, pageSize);
		
		return page;
	}

}
