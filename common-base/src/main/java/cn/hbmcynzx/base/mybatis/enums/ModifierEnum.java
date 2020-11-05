package cn.hbmcynzx.base.mybatis.enums;

import java.util.Arrays;
import java.util.List;

public enum ModifierEnum {

    EQUAL("=", "eq", "equal"),

    NOT_EQUAL("!=", "ne", "neq", "notEqual"),

    LIKE("%", "like"),

    NULL("null"),

    NOT_NULL("!null", "notNull"),

    IN("in"),

    NOT_IN("!in", "notIn"),

    BETWEEN("bw", "between"),

    NOT_BETWEEN("nbw", "notBetween"),

    GT(">", "gt"),

    GTE(">=", "gte", "ge"),

    LT("<", "lt"),

    LTE("<=", "lte", "le"),

    ASC("asc"),

    DESC("desc");


    private final List<String> modifiers;
    ModifierEnum(String ...modifiers) {
        this.modifiers = Arrays.asList(modifiers);
    }

    public final boolean equals(String key) {
        return this.modifiers.contains(key);
    }

    public static ModifierEnum from(String key) {
        ModifierEnum[] values = ModifierEnum.values();
        for (ModifierEnum value : values) {
            if(value.equals(key)) {
                return value;
            }
        }
        return null;
    }

}
