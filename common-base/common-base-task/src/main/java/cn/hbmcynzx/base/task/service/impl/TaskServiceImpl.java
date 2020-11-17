package cn.hbmcynzx.base.task.service.impl;

import cn.hbmcynzx.base.mybatis.service.impl.BaseServiceImpl;
import cn.hbmcynzx.base.task.entity.TaskEntity;
import cn.hbmcynzx.base.task.mapper.TaskMapper;
import cn.hbmcynzx.base.task.service.TaskService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TaskService实现
 * @author hbmcynzx
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
@Slf4j
public class TaskServiceImpl extends BaseServiceImpl<TaskEntity> implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public BaseMapper<TaskEntity> getMapper() {
        return taskMapper;
    }
}
