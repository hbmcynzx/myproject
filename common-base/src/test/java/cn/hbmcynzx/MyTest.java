package cn.hbmcynzx;

import cn.hbmcynzx.base.dict.entity.DictCate;
import cn.hbmcynzx.base.dict.service.DictCateService;
import cn.hbmcynzx.base.mybatis.entity.PageList;
import cn.hbmcynzx.base.mybatis.entity.QueryEntity;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class MyTest {

    @Autowired
    private DictCateService dictCateService;

    @Test
    public void testInsert() {
        for(int i = 0; i < 10; i++) {
            DictCate dictCate = new DictCate();
            dictCate.setCateEname("test" + i);
            dictCate.setCateCname("测试" + i);
            dictCate.setCateRemark("测试" + i);
            dictCate.setCreateUser("hbmcynzx");
            dictCate.setCreateTime(new Date());
            dictCateService.insert(dictCate);
        }
    }

    @Test
    public void testUpdate() {
        DictCate dictCate = new DictCate();
        dictCate.setCateId("d18c7feb7fc50eaa199121cdd203a6e4");
        dictCate.setCateEname("test3");
        dictCate.setCateCname("测试3");
        dictCate.setCateRemark("测试3");
        dictCateService.update(dictCate);
    }

    @Test
    public void testDelete() {
        dictCateService.deleteById("f5ada9f1e0860c45f12326f39a7fa533");
    }

    @Test
    public void testSelectById() {
        DictCate dictCate = dictCateService.selectById("d18c7feb7fc50eaa199121cdd203a6e4");
        System.out.println(dictCate);
    }

    @Test
    public void testSelectOne() {
        DictCate dictCate = new DictCate();
        dictCate.setCateId("d18c7feb7fc50eaa199121cdd203a6e4");
        dictCate = dictCateService.selectOne(dictCate);
        System.out.println(dictCate);
    }

    @Test
    public void testSelectAll() {
        DictCate dictCate = new DictCate();
        dictCate.setCateEname("test2");
        List<DictCate> dictCates = dictCateService.selectList(dictCate);
        dictCates.forEach(System.out::println);
    }

    @Test
    public void testSelectPage() {
        PageList<DictCate> pageList = dictCateService.selectPage(null, 1, 2);
        List<DictCate> dictCates = pageList.getList();
        dictCates.forEach(System.out::println);
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

    @Test
    public void test4() {
        DictCate cate = new DictCate();
        Map<String, QueryEntity> queryMap = new HashMap<>();
        QueryEntity entity = new QueryEntity();
        entity.setModifier("desc");
        entity.setQuery(Arrays.asList("test"));
        queryMap.put("createTime", entity);
        cate.setQueryMap(queryMap);

        List list = dictCateService.selectList(cate);
        list.stream().forEach(System.out::println);
    }

    @Test
    public void test5() {
        String a = "{\"cateEname\":{\"modifier\":\"%\",\"query\":[\"test1\"]},\"cateCname\":{\"modifier\":\"%\",\"query\":[\"test1\"]}}";
        Map<String, QueryEntity> map = JSONUtil.toBean(a, Map.class);
        map.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });
    }

}
