import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/18/21(星期五) 14:18
 * request：逆向工程
 */

public class GetCodeTest {
    //  数据库配置
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder(
            "jdbc:mysql://localhost:3306/wy_db?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai"
            , "root"
            , "root"
    );

    //  全局配置
    private static GlobalConfig.Builder globalConfig() {
        return new GlobalConfig.Builder()
                //输出目录
                .outputDir("/src/main/java")
                //作者
                .author("嘟小嘴")
                //使用Swagger接口文档
                .enableSwagger()
                //使用基于jvm新的编程语言Kotlin
                .enableKotlin()
                //时间使用的类型
                .dateType(DateType.TIME_PACK)
                .commentDate("yyyy-MM-dd");
    }

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                .globalConfig((builder) -> {
                    builder.author("嘟小嘴")
                            .enableSwagger()
                            .outputDir(projectPath + "/wuye-web/src/main/java");
                })
                .packageConfig((builder) -> {
                    builder.parent("com.dxz.web.fee");
                })
                .strategyConfig((scanner, builder) -> {
                    builder.addInclude(scanner.apply("请输入表名,多个表用,隔开"))
                            .addTablePrefix("")
                            .entityBuilder()
                            .enableLombok()
                            .mapperBuilder()
                            .enableBaseColumnList()
                            .enableBaseResultMap()
                            .controllerBuilder()
                            .enableRestStyle();
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    //    包配置
    private PackageConfig.Builder packageConfig() {
        return new PackageConfig.Builder()
                .parent("com.dxz.web.fee")
                .entity("po")
                .service("service")
                .serviceImpl("service.impl")
                .mapper("mapper")
                .controller("controller");
    }

    //    模板配置
    private TemplateConfig.Builder templateConfig() {
        return new TemplateConfig.Builder();
    }
}
