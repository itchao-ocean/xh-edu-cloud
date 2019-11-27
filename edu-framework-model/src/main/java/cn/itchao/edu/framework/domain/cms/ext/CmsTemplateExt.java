package cn.itchao.edu.framework.domain.cms.ext;

import cn.itchao.edu.framework.domain.cms.CmsTemplate;
import lombok.Data;
import lombok.ToString;

/**
 * @author jinchao
 */
@Data
@ToString
public class CmsTemplateExt extends CmsTemplate {

    //模版内容
    private String templateValue;

}
