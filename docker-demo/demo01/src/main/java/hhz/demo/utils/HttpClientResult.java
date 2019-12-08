package hhz.demo.utils;

/**
 * @ClassName: HttpClientResult
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/7 11:05
 */
public class HttpClientResult {


    public HttpClientResult(int code) {
        this.code = code;
    }

    public HttpClientResult(int code, String content) {
        this.code = code;
        this.content = content;
    }

    public HttpClientResult() {
    }

    /**
     * 响应状态码
     */
    private int code;

    /**
     * 响应数据
     */
    private String content;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
