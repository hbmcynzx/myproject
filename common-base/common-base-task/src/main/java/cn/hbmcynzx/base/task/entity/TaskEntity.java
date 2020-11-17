package cn.hbmcynzx.base.task.entity;

import cn.hbmcynzx.base.mybatis.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("sys_task")
@Data
public class TaskEntity extends BaseEntity {
    @TableId(type = IdType.ASSIGN_UUID)
    private String taskId;//任务名称（唯一）
    private String cron;//cron表达式
    private String className;//类全限定名称
    private Boolean autoStart;//任务是否自启动
    private String description;//描述
    @TableField(exist = false)
    private boolean start;//当前状态;
    private String taskType;//任务类型
    private Integer period;//周期
    private String timeUnit;//时间单位
}
