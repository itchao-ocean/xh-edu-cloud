package cn.itchao.edu.framework.domain.filesystem.response;

import cn.itchao.edu.framework.domain.filesystem.FileSystem;
import cn.itchao.edu.framework.model.response.ResponseResult;
import cn.itchao.edu.framework.model.response.ResultCode;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author jinchao
 */
@Data
@ToString
public class UploadFileResult extends ResponseResult {
    @ApiModelProperty(value = "文件信息", example = "true", required = true)
    FileSystem fileSystem;
    public UploadFileResult(ResultCode resultCode, FileSystem fileSystem) {
        super(resultCode);
        this.fileSystem = fileSystem;
    }

}
