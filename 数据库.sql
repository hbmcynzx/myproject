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
--定时任务表
create table sys_task(
    task_id varchar(64) primary key comment '主键',
    cron varchar(50) comment 'cron表达式',
    class_name varchar(100) comment '类全限定名称',
    auto_start tinyint(1) comment '任务是否自启动',
    description varchar(100) comment '描述',
    task_type varchar(10) comment '任务类型',
    `period` int comment '周期',
    time_unit varchar(20) comment '周期单位'
);

--权限表
create table sys_act(
    act_id varchar(64) primary key comment '主键',
    act_ename varchar(50) comment '权限标识',
    act_cname varchar(50) comment '权限名称',
    full_ename varchar(200) comment '',
    full_cname varchar(200) comment '',
    tree_level int default 1 comment '级别',
    father_id varchar(64) comment '上级id',
    sub_count int default 0 comment '子节点数',
    status tinyint(1) default 1 comment '是否启用',
    remark varchar(50) comment '描述',
    org_id varchar(64) comment '所属机构，为空表示通用权限',
    extends int default 1 comment '继承性质',
    create_user varchar(50) comment '创建用户',
    create_time datetime comment '创建时间',
    update_user varchar(50) comment '修改用户',
    update_time datetime comment '修改时间',
    del_status varchar(2) default 'F' comment '删除状态'
);
-- 权限机构表，机构有哪些额外权限
create table sys_act_org(
    id varchar(64) primary key comment '主键',
    org_id varchar(64) comment '机构主键',
    act_id varchar(64) comment '权限主键'
);

create table sys_role(
    role_id varchar(64) primary key,
    roll_ename varchar(50) comment '角色标识',
    roll_cname varchar(50) comment '角色名称',
    status tinyint(1) default 1 comment '是否启用',
    remark varchar(50) comment '描述',
    role_type varchar(10) comment '角色类型',
    ext_id varchar(64) comment '外键',
    extends int default 1 comment '继承性质',
    create_user varchar(50) comment '创建用户',
    create_time datetime comment '创建时间',
    update_user varchar(50) comment '修改用户',
    update_time datetime comment '修改时间',
    del_status varchar(2) default 'F' comment '删除状态'
);

create table sys_role_org(
    id varchar(64) primary key comment '主键',
    role_id varchar(64) comment '角色主键',
    org_id varchar(64) comment '机构主键'
);

create table sys_act_role(
    id varchar(64) primary key,
    act_id varchar(64) comment '权限id',
    role_id varchar(64) comment '角色id'
);

create table sys_role_user(
    id varchar(64) primary key,
    role_id varchar(64) comment '角色id',
    user_id varchar(64) comment '用户id'
);