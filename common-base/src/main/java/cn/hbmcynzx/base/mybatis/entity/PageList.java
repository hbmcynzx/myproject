package cn.hbmcynzx.base.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页返回封装对象
 * @author hbmcynzx
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageList<T extends BaseEntity> {
    private Long total;
    private List<T> list;
}
