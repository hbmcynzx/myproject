package cn.hbmcynzx.base.attachment.controller;

import cn.hbmcynzx.base.attachment.entity.AttachFile;
import cn.hbmcynzx.base.attachment.service.AttachFileService;
import cn.hbmcynzx.base.mybatis.service.BaseService;
import cn.hbmcynzx.base.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("attach/file")
public class AttachFileController extends BaseController<AttachFile> {

    @Autowired
    private AttachFileService attachFileService;

    @Override
    public BaseService<AttachFile> getService() {
        return attachFileService;
    }
}
