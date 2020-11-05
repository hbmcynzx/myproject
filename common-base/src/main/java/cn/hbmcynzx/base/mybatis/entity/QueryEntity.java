package cn.hbmcynzx.base.mybatis.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class QueryEntity implements Serializable {
    private String modifier;
    private List<String> query;
}
