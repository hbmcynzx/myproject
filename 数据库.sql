create table dict_cate(
	cate_id varchar(64) primary key comment '主键',
	cate_ename varchar(30) comment '科目标识',
	cate_cname varchar(50) comment '科目名称',
	cate_remark varchar(100) comment '描述',
	status TINYINT(1) DEFAULT 1 comment '启用状态',
	order_num int comment '排序',
	create_user varchar(50) comment '创建用户',
	create_time datetime comment '创建时间',
	update_user varchar(50) comment '修改用户',
	update_time datetime comment '修改时间',
	del_status varchar(2) default 'F' comment '删除状态'
);

create table dict_item(
	item_id varchar(64) primary key comment '主键',
	cate_ename varchar(30) comment '科目标识',
	item_value varchar(30) comment '字典标识',
	item_text varchar(50) comment '字典值',
	item_remark varchar(100) comment '描述',
	status TINYINT(1) DEFAULT 1 comment '启用状态',
	order_num int comment '排序',
	sub_count int default 0 comment '子节点数',
	tree_level int default 1 comment '字典等级',
	father_id varchar(64) comment '父节点主键',
	father_value varchar(30) default '0' comment '父节点标识',
	full_ename varchar(200) comment '全标识',
	full_cname varchar(200) comment '全名称',
	create_user varchar(50) comment '创建用户',
	create_time datetime comment '创建时间',
	update_user varchar(50) comment '修改用户',
	update_time datetime comment '修改时间',
	del_status varchar(2) default 'F' comment '删除状态'
);