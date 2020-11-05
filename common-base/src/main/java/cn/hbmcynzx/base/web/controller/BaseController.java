package cn.hbmcynzx.base.web.controller;

import cn.hbmcynzx.base.mybatis.entity.BaseEntity;
import cn.hbmcynzx.base.mybatis.service.BaseService;
import cn.hbmcynzx.base.utils.ResultMsg;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

public abstract class BaseController<T extends BaseEntity> {

    public abstract BaseService<T> getService();

    @PostMapping("insert")
    public Object insert(@RequestBody T t) {
        int count = getService().insert(t);
        if(count == 1) {
            return ResultMsg.success("新增成功", t);
        }
        return ResultMsg.error("新增失败");
    }

    @PostMapping("update")
    public Object update(@RequestBody T t) {
        int count = getService().update(t);
        if(count == 1) {
            return ResultMsg.success("修改成功", t);
        }
        return ResultMsg.error("修改失败");
    }

    @PostMapping("delete/{id}")
    public Object deleteById(@PathVariable Serializable id) {
        int count = getService().deleteById(id);
        if(count == 1) {
            return ResultMsg.success("删除成功");
        }
        return ResultMsg.error("删除失败");
    }

    @GetMapping("select/{id}")
    public Object selectById(@PathVariable Serializable id) {
        T t = getService().selectById(id);
        if(t != null) {
            return ResultMsg.success("查询成功", t);
        }
        return ResultMsg.error("查询失败");
    }

    @GetMapping("selectOne")
    public Object selectOne(T t) {
        t = getService().selectOne(t);
        if(t != null) {
            return ResultMsg.success("查询成功", t);
        }
        return ResultMsg.error("查询失败");
    }

    @GetMapping("selectAll")
    public Object selectAll(T t) {
        List<T> list = getService().selectList(t);
        if(list != null) {
            return ResultMsg.success("查询成功", list);
        }
        return ResultMsg.error("查询失败");
    }

    @GetMapping("selectPage")
    public Object selectPage(T t, @RequestParam Integer page,@RequestParam Integer rows) {
        Page<T> pageInfo = getService().selectPage(t, page, rows);
        if(pageInfo != null) {
            return ResultMsg.success("查询成功", pageInfo);
        }
        return ResultMsg.error("查询失败");
    }
}
