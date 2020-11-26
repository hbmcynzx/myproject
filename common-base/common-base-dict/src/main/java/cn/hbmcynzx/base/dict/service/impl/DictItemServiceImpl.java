package cn.hbmcynzx.base.dict.service.impl;

import cn.hbmcynzx.base.dict.entity.DictItem;
import cn.hbmcynzx.base.dict.mapper.DictItemMapper;
import cn.hbmcynzx.base.dict.service.DictItemService;
import cn.hbmcynzx.base.mybatis.service.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ItemService实现
 * @author hbmcynzx
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
@Slf4j
public class DictItemServiceImpl extends BaseServiceImpl<DictItem, DictItemMapper> implements DictItemService {

}
