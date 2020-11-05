package cn.hbmcynzx.base.mybatis.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class BaseEntity implements Serializable {
    @TableField(exist = false)
    protected Map<String, QueryEntity> queryMap;
}
