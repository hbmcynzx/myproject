package cn.hbmcynzx.base.attachment.controller;

import cn.hbmcynzx.base.attachment.entity.SysMime;
import cn.hbmcynzx.base.attachment.service.SysMimeService;
import cn.hbmcynzx.base.web.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("attach/mime")
public class SysMimeController extends BaseController<SysMime, SysMimeService> {

}
