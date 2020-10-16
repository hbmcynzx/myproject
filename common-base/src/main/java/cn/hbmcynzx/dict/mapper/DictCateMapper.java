package cn.hbmcynzx.dict.mapper;

import cn.hbmcynzx.dict.entity.DictCate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface DictCateMapper extends BaseMapper<DictCate> {

    List<DictCate> mySelectAll();
}
