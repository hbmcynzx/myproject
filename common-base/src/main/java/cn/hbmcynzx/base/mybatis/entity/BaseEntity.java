package cn.hbmcynzx.base.mybatis.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * 基础实体对象
 * @author hbmcynzx
 */
@Data
public class BaseEntity implements Serializable {

    /**
     * 统一查询封装注入对象
     */
    @TableField(exist = false)
    @JsonIgnore
    protected Map<String, QueryEntity> queryMap;

    @TableField(exist = false)
    @JsonIgnore
    protected String queryMapString;
}
