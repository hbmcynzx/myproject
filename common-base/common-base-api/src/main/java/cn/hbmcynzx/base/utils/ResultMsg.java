package cn.hbmcynzx.base.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hbmcynzx
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultMsg {
    private int code;
    private String msg;
    private Object data;

    public static ResultMsg build(int code, String msg, Object data) {
        return new ResultMsg(code, msg, data);
    }

    public static ResultMsg success(String msg) {
        return build(0, msg, null);
    }

    public static ResultMsg success(String msg, Object data) {
        return build(0, msg, data);
    }

    public static ResultMsg error(String msg) {
        return build(1, msg, null);
    }

    public static ResultMsg error(String msg, Object data) {
        return build(1, msg, data);
    }
}
