USE daily;

CREATE TABLE user_(
	user_id BIGINT AUTO_INCREMENT COMMENT '�û�id',
	username VARCHAR(20) NOT NULL COMMENT '�û���',
	password VARCHAR(30) NOT NULL COMMENT '����',
	identity TINYINT UNSIGNED DEFAULT 0 COMMENT '���',
	PRIMARY KEY pk_user_id(user_id),
	UNIQUE INDEX idx_username(username)
)ENGINE InnoDB DEFAULT CHARSET UTF8 COMMENT '�û���';

CREATE TABLE article_(
	article_id BIGINT AUTO_INCREMENT COMMENT '����id',
	article_title VARCHAR(30) NOT NULL COMMENT '���±���',
	article_content VARCHAR(1000) NOT NULL COMMENT '��������',
	publication_time DATE NOT NULL COMMENT '��������',
	PRIMARY KEY pk_article_id(article_id)
)ENGINE InnoDB DEFAULT CHARSET UTF8 COMMENT '���±�';