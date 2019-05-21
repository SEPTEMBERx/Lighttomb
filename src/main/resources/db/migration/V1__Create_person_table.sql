create table USER
(
  ID            INTEGER   AUTO_INCREMENT PRIMARY KEY NOT NULL,
  USER_NAME      VARCHAR(50),
  ACCOUNT_ID     VARCHAR(100),
  COOKIE         CHAR(36),
  GMT_CREATETIME BIGINT,
  GMT_MODIFIED   BIGINT
);
comment on table USER is '登陆系统的用户表';
