insert into cms.category (id, created_at, last_modified_at, me)
values (1, '1900-1-1', '1900-1-1', '热点新闻'),
       (2, '1900-1-1', '1900-1-1', '通知公告'),
       (3, '1900-1-1', '1900-1-1', '仪器设备'),
       (4, '1900-1-1', '1900-1-1', '科研成果'),
       (5, '1900-1-1', '1900-1-1', '开发交流');

insert into cms.post (id, created_at, last_modified_at, content, title)
values (1, '1900-1-1', '1900-1-1', 'hello', 'news'),
       (2, '1900-1-1', '1900-1-1', 'hello', 'notify'),
       (3, '1900-1-1', '1900-1-1', 'hello', 'instrument');


INSERT INTO cms.category_posts (category_id, posts_id)
VALUES (1, 1),
       (2, 2),
       (3, 3);

INSERT INTO cms.post_categories (post_id, categories_id)
VALUES (1, 1),
       (2, 2),
       (3, 3);
