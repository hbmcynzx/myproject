package cn.hbmcynzx.base.mybatis.enums;

import java.util.Arrays;
import java.util.List;

/**
 * 修饰符枚举对象
 * @author hbmcynzx
 */
public enum ModifierEnum {

    /**
     * 等于查询
     */
    EQUAL("=", "eq", "equal"),

    /**
     * 不等于查询
     */
    NOT_EQUAL("!=", "ne", "neq", "notEqual"),

    /**
     * 模糊查询
     */
    LIKE("%", "like"),

    /**
     * 空值查询
     */
    NULL("null"),

    /**
     * 非空查询
     */
    NOT_NULL("!null", "notNull"),

    /**
     * in查询
     */
    IN("in"),

    /**
     * not in查询
     */
    NOT_IN("!in", "notIn"),

    /**
     * between查询
     */
    BETWEEN("bw", "between"),

    /**
     * 非between查询
     */
    NOT_BETWEEN("nbw", "notBetween"),

    /**
     * 大于查询
     */
    GT(">", "gt"),

    /**
     * 大于等于查询
     */
    GTE(">=", "gte", "ge"),

    /**
     * 小于查询
     */
    LT("<", "lt"),

    /**
     * 小于等于查询
     */
    LTE("<=", "lte", "le"),

    /**
     * 正序排序
     */
    ASC("asc"),

    /**
     * 倒序排序
     */
    DESC("desc");


    private final List<String> modifiers;
    ModifierEnum(String ...modifiers) {
        this.modifiers = Arrays.asList(modifiers);
    }

    /**
     * 相等判断
     * @param key
     * @return
     */
    public final boolean myEquals(String key) {
        return this.modifiers.contains(key);
    }

    /**
     * 字符串转枚举
     * @param key
     * @return
     */
    public static ModifierEnum from(String key) {
        ModifierEnum[] values = ModifierEnum.values();
        for (ModifierEnum value : values) {
            if(value.myEquals(key)) {
                return value;
            }
        }
        return null;
    }

}
