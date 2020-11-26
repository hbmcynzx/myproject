package cn.hbmcynzx.base.dict.service.impl;

import cn.hbmcynzx.base.dict.entity.DictCate;
import cn.hbmcynzx.base.dict.mapper.DictCateMapper;
import cn.hbmcynzx.base.dict.service.DictCateService;
import cn.hbmcynzx.base.mybatis.service.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * CateService实现
 * @author hbmcynzx
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
@Slf4j
public class DictCateServiceImpl extends BaseServiceImpl<DictCate, DictCateMapper> implements DictCateService {

}
