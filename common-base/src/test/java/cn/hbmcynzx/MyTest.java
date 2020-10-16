package cn.hbmcynzx;

import cn.hbmcynzx.dict.entity.DictCate;
import cn.hbmcynzx.dict.mapper.DictCateMapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

    @Autowired
    private DictCateMapper dictCateMapper;

    @Test
    public void test1() {
        DictCate dictCate = new DictCate();
        dictCate.setCateEname("test2");
        dictCate.setCateCname("测试2");
        dictCate.setCateRemark("测试2");
        dictCate.setCreateUser("hbmcynzx");
        dictCate.setCreateTime(new Date());
        dictCateMapper.insert(dictCate);


    }

    @Test
    public void test2() {
        List<DictCate> dictCates = dictCateMapper.mySelectAll();
        dictCates.forEach(cate -> System.out.println(cate));
    }

    @Test
    public void test3() {
        DictCate dictCate = new DictCate();
        dictCate.setCateEname("test");
        LambdaQueryWrapper<DictCate> query = Wrappers.lambdaQuery();
        query.eq(DictCate::getCateCname, "test")
                .or(false).eq(DictCate::getCateCname, "测试");


        System.out.println(query.getCustomSqlSegment());
        System.out.println(query.getParamNameValuePairs());


        LambdaQueryWrapper<DictCate> query2 = Wrappers.lambdaQuery();
        query2.eq(DictCate::getCateCname, "test")
                .or().eq(DictCate::getCateCname, "测试");


        System.out.println(query2.getCustomSqlSegment());
        System.out.println(query2.getParamNameValuePairs());

        LambdaQueryWrapper<DictCate> query3 = Wrappers.lambdaQuery();
        query3.eq(DictCate::getCateCname, "test")
                .or((c) -> {
                    c.eq(DictCate::getCreateUser,"hbmcynzx")
                            .eq(DictCate::getCateEname, "test");
                })
                .and(c -> {
                    c.eq(DictCate::getCateId,"111")
                            .eq(DictCate::getCateRemark, "remark");
                });


        System.out.println(query3.getCustomSqlSegment());
        System.out.println(query3.getParamNameValuePairs());
    }
}
