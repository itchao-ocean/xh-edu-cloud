package cn.itchao.edu.framework.domain.cms.response;

import cn.itchao.edu.framework.domain.cms.CmsPage;
import cn.itchao.edu.framework.model.response.ResponseResult;
import cn.itchao.edu.framework.model.response.ResultCode;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 */
@Data
public class CmsPageResult extends ResponseResult {
    CmsPage cmsPage;
    public CmsPageResult(ResultCode resultCode, CmsPage cmsPage) {
        super(resultCode);
        this.cmsPage = cmsPage;
    }
}
