package cn.hbmcynzx.base.attachment.controller;

import cn.hbmcynzx.base.attachment.entity.SysMime;
import cn.hbmcynzx.base.attachment.service.SysMimeService;
import cn.hbmcynzx.base.mybatis.service.BaseService;
import cn.hbmcynzx.base.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("attach/mime")
public class SysMimeController extends BaseController<SysMime> {

    @Autowired
    private SysMimeService sysMimeService;

    @Override
    public BaseService<SysMime> getService() {
        return sysMimeService;
    }
}
