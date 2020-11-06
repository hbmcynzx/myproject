package cn.hbmcynzx.base.mybatis.entity;


import cn.hbmcynzx.base.exception.BusinessException;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.net.URLDecoder;
import java.util.HashMap;
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
    protected String query;

    public Map<String, QueryEntity> getQueryMap() {
        if(this.queryMap != null) {
            return this.queryMap;
        }
        if(!StringUtils.isEmpty(this.query)) {
            try {
                this.query = URLDecoder.decode(this.query, "UTF-8");
                Map<String, JSONObject> map = JSONUtil.toBean(this.query, Map.class);
                this.queryMap = new HashMap<>();
                map.forEach((key, value) -> {
                    QueryEntity queryEntity = new QueryEntity();
                    queryEntity.setModifier(value.getStr("modifier"));
                    JSONArray query = value.getJSONArray("query");
                    queryEntity.setQuery(query);
                    this.queryMap.put(key, queryEntity);
                });
            } catch (Exception e) {
                throw new BusinessException("自定义查询参数异常", e);
            }
        }
        return this.queryMap;
    }
}
