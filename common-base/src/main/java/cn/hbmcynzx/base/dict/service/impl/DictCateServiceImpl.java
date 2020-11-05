package cn.hbmcynzx.base.dict.service.impl;

import cn.hbmcynzx.base.dict.entity.DictCate;
import cn.hbmcynzx.base.dict.mapper.DictCateMapper;
import cn.hbmcynzx.base.dict.service.DictCateService;
import cn.hbmcynzx.base.mybatis.service.impl.BaseServiceImpl;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
@Slf4j
public class DictCateServiceImpl extends BaseServiceImpl<DictCate> implements DictCateService {

    @Autowired
    private DictCateMapper dictCateMapper;

    @Override
    public BaseMapper getMapper() {
        return dictCateMapper;
    }
}
