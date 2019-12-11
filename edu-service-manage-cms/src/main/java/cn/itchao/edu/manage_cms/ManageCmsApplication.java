/**
 * Copyright (c) 2011-2030, author jinchao (370696614@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package cn.itchao.edu.manage_cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author jinchao
 * @description TODO
 * @date 2019/11/25 21:24
 */
@SpringBootApplication
@EntityScan("cn.itchao.edu.framework.domain.cms")//扫描实体类
@ComponentScan(basePackages={"cn.itchao.edu.api"})//扫描接口
@ComponentScan(basePackages={"cn.itchao.edu.manage_cms"})//扫描本项目下的所有类
public class ManageCmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManageCmsApplication.class,args);
    }
}
