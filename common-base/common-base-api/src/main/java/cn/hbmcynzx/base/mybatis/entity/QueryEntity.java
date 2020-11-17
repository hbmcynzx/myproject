package cn.hbmcynzx.base.mybatis.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 查询修饰对象
 * @author hbmcynzx
 */
@Data
public class QueryEntity implements Serializable {
    /**
     * 修饰符
     */
    private String modifier;

    /**
     * 参数集合
     */
    private List<Object> query;
}
