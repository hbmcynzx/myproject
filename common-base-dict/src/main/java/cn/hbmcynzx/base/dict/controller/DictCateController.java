package cn.hbmcynzx.base.dict.controller;

import cn.hbmcynzx.base.web.controller.BaseController;
import cn.hbmcynzx.base.dict.entity.DictCate;
import cn.hbmcynzx.base.dict.service.DictCateService;
import cn.hbmcynzx.base.mybatis.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据字典Cate控制层
 * @author hbmcynzx
 */
@RestController
@RequestMapping("dict/cate")
public class DictCateController extends BaseController<DictCate> {

    @Autowired
    private DictCateService cateService;

    @Override
    public BaseService<DictCate> getService() {
        return cateService;
    }
}
