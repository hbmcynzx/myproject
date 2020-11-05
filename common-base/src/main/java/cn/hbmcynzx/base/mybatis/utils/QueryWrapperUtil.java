package cn.hbmcynzx.base.mybatis.utils;

import cn.hbmcynzx.base.mybatis.entity.BaseEntity;
import cn.hbmcynzx.base.mybatis.entity.QueryEntity;
import cn.hbmcynzx.base.mybatis.enums.ModifierEnum;
import cn.hbmcynzx.base.utils.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.List;
import java.util.Map;

public class QueryWrapperUtil {
    private QueryWrapperUtil() {}

    public static QueryWrapper getQueryWrapper(BaseEntity entity) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if(entity == null) {
            return queryWrapper;
        }
        queryWrapper.setEntity(entity);

        Map<String, QueryEntity> queryMap = entity.getQueryMap();
        if (queryMap != null && !queryMap.isEmpty()) {
            queryMap.forEach((key, value) -> {
                insertValue(key, value, queryWrapper);
            });
        }
        return queryWrapper;
    }

    private static void insertValue(String key, QueryEntity entity, QueryWrapper queryWrapper) {
        //字段
        String column = StringUtils.humpToLine2(key);
        //修饰符
        String modifier = entity.getModifier();
        //参数列表
        List<String> queryList = entity.getQuery();

        ModifierEnum modifierEnum = ModifierEnum.from(modifier);
        if(modifierEnum == null) {
            return;
        }
        switch (modifierEnum) {
            case EQUAL:
                queryWrapper.eq(column, queryList.get(0));
                break;
            case NOT_EQUAL:
                queryWrapper.ne(column, queryList.get(0));
                break;
            case LIKE:
                queryWrapper.like(column, queryList.get(0));
                break;
            case NULL:
                queryWrapper.isNull(column);
                break;
            case NOT_NULL:
                queryWrapper.isNotNull(column);
                break;
            case IN:
                queryWrapper.in(column, queryList);
                break;
            case NOT_IN:
                queryWrapper.notIn(column, queryList);
                break;
            case BETWEEN:
                queryWrapper.between(column, queryList.get(0), queryList.get(1));
                break;
            case NOT_BETWEEN:
                queryWrapper.notBetween(column, queryList.get(0), queryList.get(1));
                break;
            case GT:
                queryWrapper.gt(column, queryList.get(0));
                break;
            case GTE:
                queryWrapper.ge(column, queryList.get(0));
                break;
            case LT:
                queryWrapper.lt(column, queryList.get(0));
                break;
            case LTE:
                queryWrapper.le(column, queryList.get(0));
                break;
            case ASC:
                queryWrapper.orderByAsc(column);
                break;
            case DESC:
                queryWrapper.orderByDesc(column);
                break;
            default:
                break;
        }
    }

}
