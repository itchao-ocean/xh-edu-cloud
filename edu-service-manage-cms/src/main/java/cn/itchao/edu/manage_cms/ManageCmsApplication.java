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
