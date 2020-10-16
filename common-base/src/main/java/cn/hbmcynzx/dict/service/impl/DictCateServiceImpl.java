package cn.hbmcynzx.dict.service.impl;

import cn.hbmcynzx.dict.service.DictCateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@Slf4j
public class DictCateServiceImpl implements DictCateService {
}
