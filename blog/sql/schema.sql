USE daily;

CREATE TABLE user_(
	user_id BIGINT AUTO_INCREMENT COMMENT '用户id',
	username VARCHAR(20) NOT NULL COMMENT '用户名',
	password VARCHAR(30) NOT NULL COMMENT '密码',
	identity TINYINT UNSIGNED DEFAULT 0 COMMENT '身份',
	PRIMARY KEY pk_user_id(user_id),
	UNIQUE INDEX idx_username(username)
)ENGINE InnoDB DEFAULT CHARSET UTF8 COMMENT '用户表';

CREATE TABLE article_(
	article_id BIGINT AUTO_INCREMENT COMMENT '文章id',
	article_title VARCHAR(30) NOT NULL COMMENT '文章标题',
	article_content VARCHAR(1000) NOT NULL COMMENT '文章内容',
	publication_time DATE NOT NULL COMMENT '发表日期',
	PRIMARY KEY pk_article_id(article_id)
)ENGINE InnoDB DEFAULT CHARSET UTF8 COMMENT '文章表';