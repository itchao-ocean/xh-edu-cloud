package cn.itchao.edu.framework.domain.cms.response;


import cn.itchao.edu.framework.model.response.ResponseResult;
import cn.itchao.edu.framework.model.response.ResultCode;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 */
@Data
public class GenerateHtmlResult extends ResponseResult {
    String html;
    public GenerateHtmlResult(ResultCode resultCode, String html) {
        super(resultCode);
        this.html = html;
    }
}
