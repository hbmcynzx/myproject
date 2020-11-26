package cn.hbmcynzx.base.attachment.service.impl;

import cn.hbmcynzx.base.attachment.entity.SysMime;
import cn.hbmcynzx.base.attachment.mapper.SysMimeMapper;
import cn.hbmcynzx.base.attachment.service.SysMimeService;
import cn.hbmcynzx.base.mybatis.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysMimeServiceImpl extends BaseServiceImpl<SysMime, SysMimeMapper> implements SysMimeService {

}
