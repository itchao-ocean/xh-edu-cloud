package cn.itchao.edu.framework.exception;

import cn.itchao.edu.framework.model.response.ResultCode;

/**
 * @author jinchao
 * @description TODO
 * @date 2019/12/11 11:44
 */
public class ExceptionCast {

    public static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }
}
