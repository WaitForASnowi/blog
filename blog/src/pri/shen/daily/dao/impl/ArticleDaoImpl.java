package pri.shen.daily.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pri.shen.daily.dao.ArticleDao;
import pri.shen.daily.entity.Article;
import pri.shen.daily.model.Page;
import pri.shen.daily.util.DBUtil;

/**
 * @author ZhiqiangShen
 * 文章数据操作
 */
public class ArticleDaoImpl implements ArticleDao {
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public void add(Article article) throws SQLException {
		
		connection=DBUtil.getConnection();
		
		String sql="INSERT article_ (article_title,article_content,publication_time) "
				+ "VALUES (?,?,?)";
		
		ps=connection.prepareStatement(sql);
		ps.setString(1, article.getArticleTitle());
		ps.setString(2, article.getArticleContent());
		ps.setDate(3, new java.sql.Date(new Date().getTime()));
		ps.execute();
		
		DBUtil.closeResource(connection, ps, rs);

	}

	@Override
	public void delete(Long articleId) throws SQLException {
		
		connection=DBUtil.getConnection();
		
		String sql="DELETE FROM article_ WHERE article_id=?";
		
		ps=connection.prepareStatement(sql);
		ps.setLong(1, articleId);
		ps.execute();
		
		DBUtil.closeResource(connection, ps, rs);

	}

	@Override
	public void update(Article article) throws SQLException {
		
		connection=DBUtil.getConnection();
		
		StringBuilder sql=new StringBuilder("UPDATE article_ SET ");
		
		List<String> params=new ArrayList<>();
		if(article.getArticleTitle()!=null) {
			sql.append("article_title=?,");
			params.add(article.getArticleTitle());
		}
		if(article.getArticleContent()!=null) {
			sql.append("article_content=?,");
			params.add(article.getArticleContent());
		}
		
		sql=sql.append("publication_time=?,");
		
		String finalSql=sql.substring(0, sql.length()-1)+" WHERE article_id=?";
		
		ps=connection.prepareStatement(finalSql);
		
		int i;
		for (i = 0; i < params.size(); i++) {
			ps.setString(i+1, params.get(i));
		}
		
		ps.setDate(++i, new java.sql.Date(new Date().getTime()));
		ps.setLong(++i, article.getArticleId());
		
		ps.executeUpdate();
		
		DBUtil.closeResource(connection, ps, rs);
	}

	@Override
	public Article get(Long articleId) throws SQLException {
		connection=DBUtil.getConnection();
		
		String sql="SELECT article_id,article_title,article_content,publication_time "
				+ "FROM article_ "
				+ "WHERE article_id=?";
		
		ps=connection.prepareStatement(sql);
		ps.setLong(1, articleId);
		rs=ps.executeQuery();
		
		Article article=null;
		if(rs.next()) {
			article=new Article();
			article.setArchiveId(rs.getLong(1));
			article.setArticleTitle(rs.getString(2));
			article.setArticleContent(rs.getString(3));
			article.setPublicationTime(rs.getDate(4));
		}
		
		DBUtil.closeResource(connection, ps, rs);
		
		return article;
		
	}

	@Override
	public Page<List<Article>> list(int currentPage,int pageSize) throws SQLException {
		connection=DBUtil.getConnection();
		
		String sql="SELECT article_id,article_title,article_content,publication_time "
				+ "FROM article_ "
				+ "ORDER BY article_id DESC "
				+ "LIMIT ?,?";
		String countSql="SELECT COUNT(article_id) "
				+ "FROM article_ ";
		
		Page<List<Article>> page=null;
		List<Article> articles=new ArrayList<>();
		
		ps=connection.prepareStatement(countSql);
		
		rs=ps.executeQuery();
		if(rs.next()) {
			page=new Page<List<Article>>(currentPage, pageSize, rs.getInt(1), articles);
		}
		
		ps=connection.prepareStatement(sql);
		ps.setInt(1, (page.getCurrentPage()-1)*pageSize);
		ps.setInt(2, pageSize);
		
		rs=ps.executeQuery();
		while(rs.next()) {
			Article article=new Article();
			article.setArchiveId(rs.getLong(1));
			article.setArticleTitle(rs.getString(2));
			article.setArticleContent(rs.getString(3));
			article.setPublicationTime(rs.getDate(4));
			articles.add(article);
		}
		
		
		
		DBUtil.closeResource(connection, ps, rs);
		
		return page;
	}

}
