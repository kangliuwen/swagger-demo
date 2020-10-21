package com.swagger.swagger.pojo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *@description:
 *@author: klw
 *@time: 2020-10-15 17:13
 *
 */
public class Test2 {


    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

       System.out.println(System.getProperty("java.class.path") );

/*
        C:\Program Files\Java\jdk1.8.0_152\jre\lib\charsets.jar;
        C:\Program Files\Java\jdk1.8.0_152\jre\lib\deploy.jar;
        C:\Program Files\Java\jdk1.8.0_152\jre\lib\ext\access-bridge-64.jar;
        C:\Program Files\Java\jdk1.8.0_152\jre\lib\ext\cldrdata.jar;
        C:\Program Files\Java\jdk1.8.0_152\jre\lib\ext\dnsns.jar;
        C:\Program Files\Java\jdk1.8.0_152\jre\lib\ext\jaccess.jar;
        C:\Program Files\Java\jdk1.8.0_152\jre\lib\ext\jfxrt.jar;
        C:\Program Files\Java\jdk1.8.0_152\jre\lib\ext\localedata.jar;
        C:\Program Files\Java\jdk1.8.0_152\jre\lib\ext\nashorn.jar;
        C:\Program Files\Java\jdk1.8.0_152\jre\lib\ext\sunec.jar;
        C:\Program Files\Java\jdk1.8.0_152\jre\lib\ext\sunjce_provider.jar;
        C:\Program Files\Java\jdk1.8.0_152\jre\lib\ext\sunmscapi.jar;
        C:\Program Files\Java\jdk1.8.0_152\jre\lib\ext\sunpkcs11.jar;
        C:\Program Files\Java\jdk1.8.0_152\jre\lib\ext\zipfs.jar;
        C:\Program Files\Java\jdk1.8.0_152\jre\lib\javaws.jar;
        C:\Program Files\Java\jdk1.8.0_152\jre\lib\jce.jar;
        C:\Program Files\Java\jdk1.8.0_152\jre\lib\jfr.jar;
        C:\Program Files\Java\jdk1.8.0_152\jre\lib\jfxswt.jar;
        C:\Program Files\Java\jdk1.8.0_152\jre\lib\jsse.jar;
        C:\Program Files\Java\jdk1.8.0_152\jre\lib\management-agent.jar;
        C:\Program Files\Java\jdk1.8.0_152\jre\lib\plugin.jar;
        C:\Program Files\Java\jdk1.8.0_152\jre\lib\resources.jar;
        C:\Program Files\Java\jdk1.8.0_152\jre\lib\rt.jar;
        D:\a-workspace-mobile\CodingHard\swagger\target\classes;
        D:\Maven\repository\org\springframework\boot\spring-boot-starter-web\2.2.0.RELEASE\spring-boot-starter-web-2.2.0.RELEASE.jar;
        D:\Maven\repository\org\springframework\boot\spring-boot-starter\2.2.0.RELEASE\spring-boot-starter-2.2.0.RELEASE.jar;
        D:\Maven\repository\org\springframework\boot\spring-boot-starter-logging\2.2.0.RELEASE\spring-boot-starter-logging-2.2.0.RELEASE.jar;
        D:\Maven\repository\ch\qos\logback\logback-classic\1.2.3\logback-classic-1.2.3.jar;D:\Maven\repository\ch\qos\logback\logback-core\1.2.3\logback-core-1.2.3.jar;D:\Maven\repository\org\apache\logging\log4j\log4j-to-slf4j\2.12.1\log4j-to-slf4j-2.12.1.jar;D:\Maven\repository\org\apache\logging\log4j\log4j-api\2.12.1\log4j-api-2.12.1.jar;D:\Maven\repository\org\slf4j\jul-to-slf4j\1.7.28\jul-to-slf4j-1.7.28.jar;D:\Maven\repository\jakarta\annotation\jakarta.annotation-api\1.3.5\jakarta.annotation-api-1.3.5.jar;D:\Maven\repository\org\yaml\snakeyaml\1.25\snakeyaml-1.25.jar;D:\Maven\repository\org\springframework\boot\spring-boot-starter-json\2.2.0.RELEASE\spring-boot-starter-json-2.2.0.RELEASE.jar;D:\Maven\repository\com\fasterxml\jackson\core\jackson-databind\2.10.0\jackson-databind-2.10.0.jar;D:\Maven\repository\com\fasterxml\jackson\core\jackson-core\2.10.0\jackson-core-2.10.0.jar;D:\Maven\repository\com\fasterxml\jackson\datatype\jackson-datatype-jdk8\2.10.0\jackson-datatype-jdk8-2.10.0.jar;D:\Maven\repository\com\fasterxml\jackson\datatype\jackson-datatype-jsr310\2.10.0\jackson-datatype-jsr310-2.10.0.jar;D:\Maven\repository\com\fasterxml\jackson\module\jackson-module-parameter-names\2.10.0\jackson-module-parameter-names-2.10.0.jar;D:\Maven\repository\org\springframework\boot\spring-boot-starter-tomcat\2.2.0.RELEASE\spring-boot-starter-tomcat-2.2.0.RELEASE.jar;D:\Maven\repository\org\apache\tomcat\embed\tomcat-embed-core\9.0.27\tomcat-embed-core-9.0.27.jar;D:\Maven\repository\org\apache\tomcat\embed\tomcat-embed-el\9.0.27\tomcat-embed-el-9.0.27.jar;D:\Maven\repository\org\apache\tomcat\embed\tomcat-embed-websocket\9.0.27\tomcat-embed-websocket-9.0.27.jar;D:\Maven\repository\org\springframework\boot\spring-boot-starter-validation\2.2.0.RELEASE\spring-boot-starter-validation-2.2.0.RELEASE.jar;D:\Maven\repository\jakarta\validation\jakarta.validation-api\2.0.1\jakarta.validation-api-2.0.1.jar;D:\Maven\repository\org\hibernate\validator\hibernate-validator\6.0.17.Final\hibernate-validator-6.0.17.Final.jar;D:\Maven\repository\org\jboss\logging\jboss-logging\3.4.1.Final\jboss-logging-3.4.1.Final.jar;D:\Maven\repository\org\springframework\spring-web\5.2.0.RELEASE\spring-web-5.2.0.RELEASE.jar;D:\Maven\repository\org\springframework\spring-beans\5.2.0.RELEASE\spring-beans-5.2.0.RELEASE.jar;D:\Maven\repository\org\springframework\spring-webmvc\5.2.0.RELEASE\spring-webmvc-5.2.0.RELEASE.jar;D:\Maven\repository\org\springframework\spring-aop\5.2.0.RELEASE\spring-aop-5.2.0.RELEASE.jar;D:\Maven\repository\org\springframework\spring-context\5.2.0.RELEASE\spring-context-5.2.0.RELEASE.jar;D:\Maven\repository\org\springframework\spring-expression\5.2.0.RELEASE\spring-expression-5.2.0.RELEASE.jar;D:\Maven\repository\org\springframework\boot\spring-boot-devtools\2.2.0.RELEASE\spring-boot-devtools-2.2.0.RELEASE.jar;D:\Maven\repository\org\springframework\boot\spring-boot\2.2.0.RELEASE\spring-boot-2.2.0.RELEASE.jar;D:\Maven\repository\org\springframework\boot\spring-boot-autoconfigure\2.2.0.RELEASE\spring-boot-autoconfigure-2.2.0.RELEASE.jar;D:\Maven\repository\org\springframework\boot\spring-boot-configuration-processor\2.2.0.RELEASE\spring-boot-configuration-processor-2.2.0.RELEASE.jar;D:\Maven\repository\org\projectlombok\lombok\1.18.10\lombok-1.18.10.jar;D:\Maven\repository\net\bytebuddy\byte-buddy\1.10.1\byte-buddy-1.10.1.jar;D:\Maven\repository\org\springframework\spring-core\5.2.0.RELEASE\spring-core-5.2.0.RELEASE.jar;D:\Maven\repository\org\springframework\spring-jcl\5.2.0.RELEASE\spring-jcl-5.2.0.RELEASE.jar;D:\Maven\repository\io\springfox\springfox-swagger2\2.9.2\springfox-swagger2-2.9.2.jar;D:\Maven\repository\io\swagger\swagger-annotations\1.5.20\swagger-annotations-1.5.20.jar;D:\Maven\repository\io\swagger\swagger-models\1.5.20\swagger-models-1.5.20.jar;D:\Maven\repository\com\fasterxml\jackson\core\jackson-annotations\2.10.0\jackson-annotations-2.10.0.jar;D:\Maven\repository\io\springfox\springfox-spi\2.9.2\springfox-spi-2.9.2.jar;D:\Maven\repository\io\springfox\springfox-core\2.9.2\springfox-core-2.9.2.jar;D:\Maven\repository\io\springfox\springfox-schema\2.9.2\springfox-schema-2.9.2.jar;D:\Maven\repository\io\springfox\springfox-swagger-common\2.9.2\springfox-swagger-common-2.9.2.jar;D:\Maven\repository\io\springfox\springfox-spring-web\2.9.2\springfox-spring-web-2.9.2.jar;D:\Maven\repository\com\google\guava\guava\20.0\guava-20.0.jar;D:\Maven\repository\com\fasterxml\classmate\1.5.0\classmate-1.5.0.jar;D:\Maven\repository\org\slf4j\slf4j-api\1.7.28\slf4j-api-1.7.28.jar;D:\Maven\repository\org\springframework\plugin\spring-plugin-core\1.2.0.RELEASE\spring-plugin-core-1.2.0.RELEASE.jar;D:\Maven\repository\org\springframework\plugin\spring-plugin-metadata\1.2.0.RELEASE\spring-plugin-metadata-1.2.0.RELEASE.jar;D:\Maven\repository\org\mapstruct\mapstruct\1.2.0.Final\mapstruct-1.2.0.Final.jar;D:\Maven\repository\io\springfox\springfox-swagger-ui\2.9.2\springfox-swagger-ui-2.9.2.jar;D:\IntelliJ IDEA 2020.1.1\lib\idea_rt.jar
*/

        //获取属性
        System.out.println("======================");
        Class c1 = Class.forName("com.swagger.swagger.pojo.User");
        Field[] fields = c1.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        //获取包含private的属性
        Field[] declaredFields = c1.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        //获取构造方法
        System.out.println("获取构造方法");
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        //获取构造方法 包含private
        System.out.println("获取构造方法 包含private");
        constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        Class superclass = c1.getSuperclass();
        superclass.getDeclaredClasses();
        c1.getInterfaces();
        //获取方法
        System.out.println("获取方法，包含父类");
        Method[] declaredMethods = c1.getMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        //获取方法 包含private
        System.out.println("获取方法 包含private");
        declaredMethods = c1.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
    }
}
