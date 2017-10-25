package pri.shen.daily.entity;

import java.util.Date;

/**
 * @author ZhiqiangShen
 * 文章对应实体类
 */
public class Article {
	private Long articleId;
	private String articleTitle;
	private String articleContent;
	private Date publicationTime;
	
	public Article() {
		super();
	}
	
	

	public Article(String articleTitle, String articleContent) {
		super();
		this.articleTitle = articleTitle;
		this.articleContent = articleContent;
	}

	public Long getArticleId() {
		return articleId;
	}

	public void setArchiveId(Long articleId) {
		this.articleId = articleId;
	}


	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public Date getPublicationTime() {
		return publicationTime;
	}

	public void setPublicationTime(Date publicationTime) {
		this.publicationTime = publicationTime;
	}



	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", articleTitle=" + articleTitle + ", articleContent="
				+ articleContent + ", publicationTime=" + publicationTime + "]";
	}

	
	
	
}
