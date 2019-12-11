package cn.itchao.edu.api.cms;

import cn.itchao.edu.framework.domain.cms.CmsPage;
import cn.itchao.edu.framework.domain.cms.request.QueryPageRequest;
import cn.itchao.edu.framework.domain.cms.response.CmsPageResult;
import cn.itchao.edu.framework.model.response.QueryResponseResult;
import cn.itchao.edu.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

@Api(value="cms页面管理接口",tags = "cms页面管理接口，提供页面的增、删、改、查")
public interface CmsPageControllerApi {
    /**
     * 页面查询
     * @param page
     * @param size
     * @param queryPageRequest
     * @return
     */
    @ApiOperation("分页查询页面列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value = "页码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录数",required=true,paramType="path",dataType="int")
    })
    QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);

    /**
     *  新增页面
     * @param cmsPage
     * @return
     */
    @ApiOperation("新增页面")
    CmsPageResult save(CmsPage cmsPage);

    /**
     * 根据页面id查询页面信息
     * @param id
     * @return
     */
    @ApiOperation("根据页面id查询页面信息")
    CmsPageResult findById(String id);

    /**
     * 根据页面id修改页面信息
     * @param id
     * @param cmsPage
     * @return
     */
    @ApiOperation("根据页面id修改页面信息")
    CmsPageResult updateById(String id,CmsPage cmsPage);

    /**
     * 根据页面id删除页面信息
     * @param id
     * @return
     */
    @ApiOperation("根据页面id删除页面信息")
    ResponseResult deleteById(String id);
}
