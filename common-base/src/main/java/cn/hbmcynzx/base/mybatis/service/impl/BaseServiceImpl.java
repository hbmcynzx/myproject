package cn.hbmcynzx.base.mybatis.service.impl;

import cn.hbmcynzx.base.mybatis.entity.BaseEntity;
import cn.hbmcynzx.base.mybatis.service.BaseService;
import cn.hbmcynzx.base.mybatis.utils.QueryWrapperUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * BaseService实现
 * @author hbmcynzx
 * @param <T>
 */
@Transactional(readOnly = true, rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    @Override
    @Transactional
    public int insert(T t) {
        return getMapper().insert(t);
    }

    @Override
    @Transactional
    public int update(T t) {
        return getMapper().updateById(t);
    }

    @Override
    @Transactional
    public int deleteById(Serializable id) {
        return getMapper().deleteById(id);
    }

    @Override
    public T selectById(Serializable id) {
        return getMapper().selectById(id);
    }

    @Override
    public T selectOne(T t) {
        QueryWrapper<T> queryWrapper = QueryWrapperUtil.getQueryWrapper(t);
        return getMapper().selectOne(queryWrapper);
    }

    @Override
    public List selectList(T t) {
        QueryWrapper<T> queryWrapper = QueryWrapperUtil.getQueryWrapper(t);
        return getMapper().selectList(queryWrapper);
    }

    @Override
    public Page<T> selectPage(T t, Integer page, Integer rows) {
        QueryWrapper<T> queryWrapper = QueryWrapperUtil.getQueryWrapper(t);
        Page<T> pageInfo = new Page<>(page, rows);
        return getMapper().selectPage(pageInfo, queryWrapper);
    }

}
