package cn.wolfcode.quartz_test.webTest;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonPropertyOrder(value = {"code", "msg", "desc", "data"})
public class GeneralResponse<T> implements Serializable {

    private static final long serialVersionUID = 6405629435684529060L;

    // 通用错误码-成功
    public static final String CODE_SUCCESS = "0000";

    private String code = CODE_SUCCESS;        //成功,默认0000

    private String msg;                                    //响应错误信息

    private String desc;                                   //响应错误友好描述信息

    private T data;                                   //执行成功后返回的结果

    public GeneralResponse() {
    }

    private GeneralResponse(T data) {
        this.data = data;
    }

    private GeneralResponse(String code, String msg, String desc) {
        this.code = code;
        this.msg = msg;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 成功返回
     *
     * @param data
     * @return
     */
    public static <T> GeneralResponse<T> success(T data) {
        return new GeneralResponse<T>(data);
    }

}
