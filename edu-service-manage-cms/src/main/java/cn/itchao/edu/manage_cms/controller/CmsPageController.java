package cn.itchao.edu.manage_cms.controller;

import cn.itchao.edu.api.cms.CmsPageControllerApi;
import cn.itchao.edu.framework.domain.cms.CmsPage;
import cn.itchao.edu.framework.domain.cms.request.QueryPageRequest;
import cn.itchao.edu.framework.domain.cms.response.CmsPageResult;
import cn.itchao.edu.framework.model.response.QueryResponseResult;
import cn.itchao.edu.framework.model.response.ResponseResult;
import cn.itchao.edu.manage_cms.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @version 1.0
 * @create 2018-09-12 17:24
 **/
@RestController
@RequestMapping("/cms/page")
public class CmsPageController implements CmsPageControllerApi {

    @Autowired
    PageService pageService;

    @Override
    @GetMapping(value = "/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, QueryPageRequest queryPageRequest) {

        return pageService.findList(page,size,queryPageRequest);
    }

    @Override
    @PostMapping(value = "/save")
    public CmsPageResult save(@RequestBody CmsPage cmsPage){
        return pageService.save(cmsPage);
    }

    @Override
    @GetMapping(value = "/{id}")
    public CmsPageResult findById(@PathVariable("id") String id) {
        return pageService.findById(id);
    }

    @Override
    @PutMapping(value = "/{id}")
    public CmsPageResult updateById(@PathVariable("id") String id, @RequestBody CmsPage cmsPage) {
        return pageService.updateById(id,cmsPage);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseResult deleteById(String id) {
        return pageService.deleteById(id);
    }


}
