create table life_time;
create table type_time(
	id bigint not null AUTO_INCREMENT PRIMARY KEY,
	day_id bigint comment '今天表Id',
	day_start timestamp comment '开始时间',
	day_end timestamp comment '结束时间',
	remark varchar(255) comment '备注',
	what varchar(32) comment '做了什么',
	type varchar(10) not null comment '类型',
	gain text not null comment '收获',
	create_time timestamp not null comment '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table day_time(
	id bigint not null AUTO_INCREMENT PRIMARY KEY,
	day timestamp comment '日期',
	feel_happy_type int comment '开心度',
	study_amount_type int comment '学习的容量',
	operator varchar(32) not null default '赵欢' comment '操作人',
	create_time bigint not null comment '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;