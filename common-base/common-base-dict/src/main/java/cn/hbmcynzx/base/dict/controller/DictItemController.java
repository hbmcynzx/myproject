package cn.hbmcynzx.base.dict.controller;

import cn.hbmcynzx.base.dict.entity.DictItem;
import cn.hbmcynzx.base.dict.service.DictItemService;
import cn.hbmcynzx.base.web.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据字典Item控制层
 * @author hbmcynzx
 */
@RestController
@RequestMapping("dict/item")
public class DictItemController extends BaseController<DictItem, DictItemService> {

}
