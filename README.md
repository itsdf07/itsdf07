# itsdf07
数据管理系统：SpringBoot + MySql + mybatis
一、创建项目
1、File - New - Project - Spring Initializr - Next - A -Next - B - Next - C - Finish

A->     Group:com.itsdf07
A->     Artifact:itsdf07
A->     Package:com.itsdf07
   
B->     Web:                Spring Web 
B->     Template Engines:   Thymeleaf
B->     SQL:                MySQL Dirver\JDBC API\MyBatis Framework 

C->     Project name:itsdf07

二、启动
1、运行项目启动类，程序入口:Itsdf07Application.java
备注:运行时，会报以下异常:
    Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
    2019-11-22 16:37:04.302 ERROR 13712 --- [           main] o.s.b.d.LoggingFailureAnalysisReporter   : 
    
    ***************************
    APPLICATION FAILED TO START
    ***************************
    
    Description:
    
    Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
    
    Reason: Failed to determine a suitable driver class
    
    
    Action:
    
    Consider the following:
    	If you want an embedded database (H2, HSQL or Derby), please put it on the classpath.
    	If you have database settings to be loaded from a particular profile you may need to activate it (no profiles are currently active).
    
    
    Process finished with exit code 1
    
异常原因:因为我们创建Spring Boot项目时，在选择组件时添加了mysql、mybatis，但现在还没有配置数据库，导致项目启动报错。
解决方案:
    1、在application.properties中进行配置
    2、不采用1的方式，而采用更简洁的application.yml，配置如下:
    server:
      port: 8087
     
    spring:
        datasource:
            name: test
            url: jdbc:mysql://localhost:3306/itsdf07
            username: root
            password: 
            driver-class-name: com.mysql.jdbc.Driver


    其中因为mysql默认是实用最新的，所以当前最新的是mysql是8.0.x,对应的驱动是
    所以运行时会报以下异常：
    Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
    解决方案：
        2.1、降低数据库版本，即在pom.xml中对应的mysql降低版本
        2.2、数据库的相关配置（driver-class-name），把com.mysql.jdbc.Driver替换成com.mysql.cj.jdbc.Driver

    