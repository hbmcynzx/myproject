package cn.hbmcynzx.base.attachment.service.impl;

import cn.hbmcynzx.base.attachment.entity.AttachFile;
import cn.hbmcynzx.base.attachment.mapper.AttachFileMapper;
import cn.hbmcynzx.base.attachment.service.AttachFileService;
import cn.hbmcynzx.base.mybatis.service.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
@Slf4j
public class AttachFileServiceImpl extends BaseServiceImpl<AttachFile, AttachFileMapper> implements AttachFileService {

}
