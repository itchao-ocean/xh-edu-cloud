package cn.itchao.edu.framework.domain.cms.ext;

import cn.itchao.edu.framework.domain.cms.CmsPage;
import lombok.Data;
import lombok.ToString;

/**
 * @author jinchao
 */
@Data
@ToString
public class CmsPageExt extends CmsPage {
    private String htmlValue;

}
