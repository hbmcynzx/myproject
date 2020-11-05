package cn.hbmcynzx.base.dict.controller;

import cn.hbmcynzx.base.dict.entity.DictItem;
import cn.hbmcynzx.base.dict.service.DictItemService;
import cn.hbmcynzx.base.mybatis.service.BaseService;
import cn.hbmcynzx.base.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dict/item")
public class DictItemController extends BaseController<DictItem> {

    @Autowired
    private DictItemService itemService;
    @Override
    public BaseService<DictItem> getService() {
        return itemService;
    }
}
