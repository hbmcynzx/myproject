package cn.hbmcynzx.base.mybatis.service;

import cn.hbmcynzx.base.exception.BusinessException;
import cn.hbmcynzx.base.mybatis.entity.BaseEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;
import java.util.List;

/**
 * BaseService
 * 基础Service
 * @author hbmcynzx
 * @param <T>
 */
public interface BaseService<T extends BaseEntity> {
    /**
     * 新增方法
     * @param t
     * @return
     */
    default int insert(T t) {
        throw new BusinessException("新增方法未重写");
    }

    /**
     * 修改方法
     * @param t
     * @return
     */
    default int update(T t) {
        throw new BusinessException("修改方法未重写");
    }

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    default int deleteById(Serializable id) {
        throw new BusinessException("根据主键删除方法未重写");
    }

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    default T selectById(Serializable id) {
        throw new BusinessException("根据主键查询方法未重写");
    }

    /**
     * 条件查询单个记录
     * @param t
     * @return
     */
    default T selectOne(T t) {
        throw new BusinessException("条件查询方法未重写");
    }

    /**
     * 列表查询
     * @param t
     * @return
     */
    default List<T> selectList(T t) {
        throw new BusinessException("列表查询方法未重写");
    }

    /**
     * 分页查询
     * @param t
     * @param page
     * @param rows
     * @return
     */
    default Page<T> selectPage(T t, Integer page, Integer rows) {
        throw new BusinessException("分页查询方法未重写");
    }

    /**
     * 获取mapper对象
     * @return
     */
    BaseMapper<T> getMapper();

}
