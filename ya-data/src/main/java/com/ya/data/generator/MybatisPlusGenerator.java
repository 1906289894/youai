package com.ya.data.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Column;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author wb
 * @description MybatisPlus代码生成器
 * @date 2022-05-09 10:18
 */
public class MybatisPlusGenerator {

    /**
     * 初始化数据源配置
     */
    @lombok.SneakyThrows
    private static Map<String, String> initDataSource(){
        Resource resource = new ClassPathResource("generator.properties");
        InputStream is = resource.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String data;
        Map<String, String> mapDataSource = new HashMap<>();
        while ((data =br.readLine()) != null){
            String[] split = data.split("=");
            mapDataSource.put(split[0],split[1]);
        }
        return mapDataSource;
    }
    public static void main(String[] args) {
        Map<String, String> dataSourceMap = initDataSource();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入作者名称");
        String author = scanner.nextLine();
        System.out.println("请选择你要生成的模块");
        String modelPageName = scanner.nextLine();
        System.out.println("请输入你要生成的数据库");
        String dataName = scanner.nextLine();
        String dataSourceUrl = dataSourceMap.get("url")+dataName+"?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai"; //数据库地址
        boolean flag = true;
        List<String> tables = new ArrayList<>();
        while (flag){
            System.out.println("请选择你要生成的表名, 输入 *** 表示结束");
            String tableName = scanner.nextLine();
            flag = !"***".equals(tableName);
            if (flag){
                tables.add(tableName);
            }
        }
        String modelName = "/ya-"+modelPageName; //模块名称 请注意和包名做区分
        FastAutoGenerator
                // 数据源配置 DataSourceConfig
                .create(dataSourceUrl, dataSourceMap.get("username"), dataSourceMap.get("password"))
                // 全局配置 jdbc:mysql://mysql-server:3306
                .globalConfig(builder -> {
                    builder.author(author) // 设置作者
                            .outputDir(System.getProperty("user.dir") +modelName+ "/src/main/java") // 指定输出目录
                            .commentDate("yyyy-MM-dd")   //注释日期
                            .disableOpenDir();   //禁止打开输出目录，默认:true
                })
                // 包配置
                .packageConfig(builder -> {builder.parent(dataSourceMap.get("baseDir")) // 设置父包名
                            .moduleName(modelPageName) // 设置模块名
                            .entity("entity") // 实体类包名
                            .other("utils") // 自定义文件包名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir")+modelName+"/src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                // 策略配置
                .strategyConfig(builder -> {
                    builder.addInclude(tables) // 设置需要生成的表名
                            .addTablePrefix("t_") // 设置过滤表前缀
                            // entity 策略配置
                            .entityBuilder()
                            .enableLombok()
                            .logicDeleteColumnName("deleted") //逻辑删除字段名
                            .naming(NamingStrategy.underline_to_camel)  //数据库表映射到实体的命名策略：下划线转驼峰命
                            .columnNaming(NamingStrategy.underline_to_camel)    //数据库表字段映射到实体的命名策略：下划线转驼峰命
                            .addTableFills(
                                    new Column("create_time", FieldFill.INSERT),
                                    new Column("modify_time", FieldFill.INSERT_UPDATE)
                            )   //添加表字段填充，"create_time"字段自动填充为插入时间，"modify_time"字段自动填充为插入修改时间
                            .enableTableFieldAnnotation()       // 开启生成实体时生成字段注解

                            // mapper 策略配置
                            .mapperBuilder()
                            .superClass(BaseMapper.class)   //设置父类
                            .formatMapperFileName("%sMapper")   //格式化 mapper 文件名称
                            .enableMapperAnnotation()       //开启 @Mapper 注解
                            .formatXmlFileName("%s") //格式化 Xml 文件名称 如 UserXml

                            // service 策略配置
                            .serviceBuilder()
                            .formatServiceFileName("%sService") // 如:UserService
                            .formatServiceImplFileName("%sServiceImpl") // 如:UserServiceImpl

                            // controller 策略配置
                            .controllerBuilder()
                            .formatFileName("%sController") // 如 UserController
                            .enableRestStyle();  //开启生成 @RestController 控制器

                })
                // 模板配置
                // .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                // 执行
                .execute();
    }

}
