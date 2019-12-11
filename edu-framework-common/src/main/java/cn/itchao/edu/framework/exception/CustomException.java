package cn.itchao.edu.framework.exception;

import cn.itchao.edu.framework.model.response.ResultCode;
import lombok.Getter;

/**
 * @author jinchao
 * @description TODO
 * @date 2019/12/11 11:41
 */
public class CustomException extends RuntimeException {

    /**
     * 错误代码
     */
    @Getter
    private ResultCode resultCode;

    public CustomException(ResultCode resultCode){
        this.resultCode = resultCode;
    }
}
