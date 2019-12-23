package com.nut.ledger;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: han jianguo
 * @Date: 2019/12/23 10:23
 * @Description:
 **/
public class AutoMybatis {

    public static void main(String[] args) throws Exception {


        List<String> list = new ArrayList<>();
        File config = new File(System.getProperty("user.dir") + "/src/main/resources/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(list);
        Configuration configuration = cp.parseConfiguration(config);
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, callback, list);
        myBatisGenerator.generate(null);
        System.out.println("ok");
    }
}
