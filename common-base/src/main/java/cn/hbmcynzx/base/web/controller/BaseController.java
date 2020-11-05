package cn.hbmcynzx.base.web.controller;

import cn.hbmcynzx.base.mybatis.entity.BaseEntity;
import cn.hbmcynzx.base.mybatis.entity.PageList;
import cn.hbmcynzx.base.mybatis.service.BaseService;
import cn.hbmcynzx.base.utils.ResultMsg;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 基础Controller
 * @author hbmcynzx
 * @param <T>
 */
public abstract class BaseController<T extends BaseEntity> {

    @InitBinder("baseEntity")
    public void init(WebDataBinder binder) {
        Object target = binder.getTarget();
        if(target != null && target instanceof BaseEntity) {
            System.out.println(binder);
            ConversionService conversionService = binder.getConversionService();
            System.out.println(conversionService);
        }
    }


    /**
     * 获取service
     * @return
     */
    public abstract BaseService<T> getService();

    /**
     * 新增接口
     * @param t
     * @return
     */
    @PostMapping("insert")
    public Object insert(@RequestBody T t) {
        int count = getService().insert(t);
        if(count == 1) {
            return ResultMsg.success("新增成功", t);
        }
        return ResultMsg.error("新增失败");
    }

    /**
     * 修改接口
     * @param t
     * @return
     */
    @PostMapping("update")
    public Object update(@RequestBody T t) {
        int count = getService().update(t);
        if(count == 1) {
            return ResultMsg.success("修改成功", t);
        }
        return ResultMsg.error("修改失败");
    }

    /**
     * 根据主键删除接口
     * @param id
     * @return
     */
    @PostMapping("delete/{id}")
    public Object deleteById(@PathVariable Serializable id) {
        int count = getService().deleteById(id);
        if(count == 1) {
            return ResultMsg.success("删除成功");
        }
        return ResultMsg.error("删除失败");
    }

    /**
     * 根据主键查询接口
     * @param id
     * @return
     */
    @GetMapping("select/{id}")
    public Object selectById(@PathVariable Serializable id) {
        T t = getService().selectById(id);
        if(t != null) {
            return ResultMsg.success("查询成功", t);
        }
        return ResultMsg.error("查询失败");
    }

    /**
     * 根据条件查询一条数据接口
     * @param t
     * @return
     */
    @GetMapping("selectOne")
    public Object selectOne(T t) {
        t = getService().selectOne(t);
        if(t != null) {
            return ResultMsg.success("查询成功", t);
        }
        return ResultMsg.error("查询失败");
    }

    /**
     * 条件查询所有数据接口
     * @param t
     * @return
     */
    @GetMapping("selectAll")
    public Object selectAll(T t) {
        List<T> list = getService().selectList(t);
        if(list != null) {
            return ResultMsg.success("查询成功", list);
        }
        return ResultMsg.error("查询失败");
    }

    /**
     * 条件分页查询接口
     * @param t
     * @param page
     * @param rows
     * @return
     */
    @GetMapping("selectPage")
    public Object selectPage(@ModelAttribute("baseEntity") T t, @RequestParam Integer page,@RequestParam Integer rows) {
        PageList<T> pageList = getService().selectPage(t, page, rows);
        if(pageList != null) {
            return ResultMsg.success("查询成功", pageList);
        }
        return ResultMsg.error("查询失败");
    }
}
