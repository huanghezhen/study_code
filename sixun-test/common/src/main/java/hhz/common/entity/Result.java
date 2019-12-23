package hhz.common.entity;

import lombok.Data;

/**
 * @ClassName: Reslut
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/23 14:16
 */
@Data
public class Result {
    private boolean state;
    private Integer code;
    private String message;
    private Object data;

    public Result(Object data) {
        this.state = true;
        this.data = data;
    }

    public Result(ResultEnum resultEnum) {
        this.state = resultEnum.state;
        this.code = resultEnum.code;
        this.message = resultEnum.message;
    }
}
