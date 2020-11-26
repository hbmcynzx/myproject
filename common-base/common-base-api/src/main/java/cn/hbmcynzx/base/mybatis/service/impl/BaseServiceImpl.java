package cn.hbmcynzx.base.mybatis.service.impl;

import cn.hbmcynzx.base.mybatis.entity.BaseEntity;
import cn.hbmcynzx.base.mybatis.entity.PageList;
import cn.hbmcynzx.base.mybatis.service.BaseService;
import cn.hbmcynzx.base.mybatis.utils.QueryWrapperUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * BaseService实现
 * @author hbmcynzx
 */
@Transactional(readOnly = true, rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T extends BaseEntity, M extends BaseMapper<T>> implements BaseService<T> {

    @Autowired
    protected M baseMapper;

    @Override
    public BaseMapper<T> getMapper() {
        return baseMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(T t) {
        return getMapper().insert(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(T t) {
        return getMapper().updateById(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
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
    public PageList<T> selectPage(T t, Integer page, Integer rows) {
        QueryWrapper<T> queryWrapper = QueryWrapperUtil.getQueryWrapper(t);
        Page<T> pageInfo = new Page<>(page, rows);
        pageInfo = getMapper().selectPage(pageInfo, queryWrapper);
        PageList<T> pageList = new PageList<>(pageInfo.getTotal(), pageInfo.getRecords());
        return pageList;
    }

}
