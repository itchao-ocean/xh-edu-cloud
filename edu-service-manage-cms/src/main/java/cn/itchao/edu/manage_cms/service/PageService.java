package cn.itchao.edu.manage_cms.service;

import cn.itchao.edu.framework.domain.cms.CmsPage;
import cn.itchao.edu.framework.domain.cms.request.QueryPageRequest;
import cn.itchao.edu.framework.domain.cms.response.CmsCode;
import cn.itchao.edu.framework.domain.cms.response.CmsPageResult;
import cn.itchao.edu.framework.exception.CustomException;
import cn.itchao.edu.framework.exception.ExceptionCast;
import cn.itchao.edu.framework.model.response.CommonCode;
import cn.itchao.edu.framework.model.response.QueryResponseResult;
import cn.itchao.edu.framework.model.response.QueryResult;
import cn.itchao.edu.framework.model.response.ResponseResult;
import cn.itchao.edu.manage_cms.repository.CmsPageRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author jinchao
 * @description TODO
 * @date 2019/11/25 21:26
 */
@Service
public class PageService {

    @Resource
    CmsPageRepository cmsPageRepository;


    /**
     * 页面查询方法
     * @param page 页码，从1开始记数
     * @param size 每页记录数
     * @param queryPageRequest 查询条件
     * @return
     */
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest){
        if(queryPageRequest == null){
            queryPageRequest = new QueryPageRequest();
        }
        //自定义条件查询
        //定义条件匹配器
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());
        //条件值对象
        CmsPage cmsPage = new CmsPage();
        //设置条件值（站点id）
        if(StringUtils.isNotEmpty(queryPageRequest.getSiteId())){
            cmsPage.setSiteId(queryPageRequest.getSiteId());
        }
        //设置模板id作为查询条件
        if(StringUtils.isNotEmpty(queryPageRequest.getTemplateId())){
            cmsPage.setTemplateId(queryPageRequest.getTemplateId());
        }
        //设置页面别名作为查询条件
        if(StringUtils.isNotEmpty(queryPageRequest.getPageAliase())){
            cmsPage.setPageAliase(queryPageRequest.getPageAliase());
        }
        //定义条件对象Example
        Example<CmsPage> example = Example.of(cmsPage,exampleMatcher);
        //分页参数
        if(page <=0){
            page = 1;
        }
        page = page -1;
        if(size<=0){
            size = 10;
        }
        Pageable pageable = PageRequest.of(page,size);
        //实现自定义条件查询并且分页查询
        Page<CmsPage> all = cmsPageRepository.findAll(example,pageable);
        QueryResult queryResult = new QueryResult();
        //数据列表
        queryResult.setList(all.getContent());
        //数据总记录数
        queryResult.setTotal(all.getTotalElements());
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;
    }

    /**
     * 新增页面
     * @param cmsPage
     * @return
     */
    public CmsPageResult save(CmsPage cmsPage) {
        if(cmsPage==null){
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        //校验页面名称、站点Id、页面webpath的唯一性
        //根据页面名称、站点Id、页面webpath去cms_page集合，如果查到说明此页面已经存在，如果查询不到再继续添加
        CmsPage cmsPageResult = cmsPageRepository.findByPageNameAndSiteIdAndPageWebPath(cmsPage.getPageName(),cmsPage.getSiteId(),cmsPage.getPageWebPath());
        if(cmsPageResult!=null){
            //页面已存在
            ExceptionCast.cast(CmsCode.CMS_ADDPAGE_EXISTSNAME);
        }
        cmsPage.setPageId(null);
        cmsPageRepository.save(cmsPage);
        return new CmsPageResult(CommonCode.SUCCESS,cmsPage);
    }

    /**
     * 根据页面id查询页面信息
     * @param id
     * @return
     */
    public CmsPageResult findById(String id) {
        CmsPage cmsPage = this.findByPageId(id);
        return new CmsPageResult(CommonCode.SUCCESS,cmsPage);
    }

    /**
     * 根据页面id修改页面信息
     * @param id
     * @param cmsPage
     * @return
     */
    public CmsPageResult updateById(String id, CmsPage cmsPage) {
        //根据id从数据库查询页面信息
        CmsPage one = this.findByPageId(id);
        if(one!=null){
            one.setTemplateId(cmsPage.getTemplateId());
            //更新所属站点
            one.setSiteId(cmsPage.getSiteId());
            //更新页面别名
            one.setPageAliase(cmsPage.getPageAliase());
            //更新页面名称
            one.setPageName(cmsPage.getPageName());
            //更新访问路径
            one.setPageWebPath(cmsPage.getPageWebPath());
            //更新物理路径
            one.setPagePhysicalPath(cmsPage.getPagePhysicalPath());
            //提交修改
            cmsPageRepository.save(one);
            return new CmsPageResult(CommonCode.SUCCESS,one);
        }
        return new CmsPageResult(CommonCode.FAIL,null);
    }

    /**
     * 根据页面id删除页面
     * @param id
     * @return
     */
    public ResponseResult deleteById(String id) {
        //根据id从数据库查询页面信息
        CmsPage one = this.findByPageId(id);
        if(one!=null){
            cmsPageRepository.deleteById(id);
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
    }


    /**
     * 私有方法 查询页面信息
     * @param id
     * @return
     */
    private CmsPage findByPageId(String id){
        if(StringUtils.isBlank(id)){
            ExceptionCast.cast(CmsCode.CMS_QUERY_PAGE_ID_IS_NULL);
        }
        Optional<CmsPage> optionalCmsPage = cmsPageRepository.findById(id);
        if(optionalCmsPage.isPresent()){
            return optionalCmsPage.get();
        }
        return null;
    }

}
