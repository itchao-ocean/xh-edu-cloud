package cn.itchao.edu.manage_cms.service;

import cn.itchao.edu.framework.domain.cms.CmsPage;
import cn.itchao.edu.framework.domain.cms.request.QueryPageRequest;
import cn.itchao.edu.framework.model.response.CommonCode;
import cn.itchao.edu.framework.model.response.QueryResponseResult;
import cn.itchao.edu.framework.model.response.QueryResult;
import cn.itchao.edu.manage_cms.repository.CmsPageRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

        //分页参数
        if(page <=0){
            page = 1;
        }
        page = page -1;
        if(size<=0){
            size = 10;
        }
        Pageable pageable = PageRequest.of(page,size);
        Page<CmsPage> pages = cmsPageRepository.findAll(pageable);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(pages.getContent());
        queryResult.setTotal(pages.getTotalElements());
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;
    }
}
