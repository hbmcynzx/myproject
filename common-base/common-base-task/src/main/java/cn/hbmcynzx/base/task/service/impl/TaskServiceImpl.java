package cn.hbmcynzx.base.task.service.impl;

import cn.hbmcynzx.base.mybatis.service.impl.BaseServiceImpl;
import cn.hbmcynzx.base.task.entity.TaskEntity;
import cn.hbmcynzx.base.task.mapper.TaskMapper;
import cn.hbmcynzx.base.task.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TaskService实现
 * @author hbmcynzx
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
@Slf4j
public class TaskServiceImpl extends BaseServiceImpl<TaskEntity, TaskMapper> implements TaskService {

}
