## SOA架构的思想
```
SOA：Service Oriented Architecture面向服务的架构。
也就是把工程拆分成服务层、表现层两个工程。

服务层中包含业务逻辑，只需要对外提供服务即可。

表现层只需要处理和页面的交互，业务逻辑都是调用服务层的服务来实现。
```

## SOA的架构具体展现

![Eclipse中一个模块的结构](https://upload-images.jianshu.io/upload_images/7505161-dcbcbb6a159a85bd.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 父工程的依赖,引入上层工具类模块的依赖.

包类型是pom类型.

![](https://upload-images.jianshu.io/upload_images/7505161-337e1cff8378e53f.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

他主要管理负责的子模块.并且导入工具类的模块的依赖.

### 接口模块主要依赖上层的POJO模块

![](https://upload-images.jianshu.io/upload_images/7505161-b358ef20dcbb3aba.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 服务层依赖上面的接口模块,和mybatis负责的DAO层的模块
![](https://upload-images.jianshu.io/upload_images/7505161-67130eccc0c5fb2c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

包类型是war类型

下一层要使用上一层的依赖,上一次必须进行maven安装共服务.

### web层引入外层服务

表现层的包类型是war包.

![](https://upload-images.jianshu.io/upload_images/7505161-e3109c8f7d65f5a4.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

```
mvn clean //清理模块
mvn installl//安装模块
```
![Eclipse中一个模块的结构](https://upload-images.jianshu.io/upload_images/7505161-dcbcbb6a159a85bd.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 父工程的依赖,引入上层工具类模块的依赖.
![](https://upload-images.jianshu.io/upload_images/7505161-337e1cff8378e53f.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

他需要管理负责的子模块.并且导入工具类的模块的依赖.

### 接口模块主要依赖上层的POJO模块
![](https://upload-images.jianshu.io/upload_images/7505161-b358ef20dcbb3aba.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 实现类模块依赖上面的接口模块,和mybatis负责的DAO层的模块
![](https://upload-images.jianshu.io/upload_images/7505161-67130eccc0c5fb2c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

下一层要使用上一层的依赖,上一次必须进行maven安装共服务.

dubbo服务使用方法,安装模块.java7 是最稳定的版本.
```
mvn clean //清理模块
mvn install//安装模块
```
## Dubbo原理

图示:

![](https://upload-images.jianshu.io/upload_images/7505161-186be395802fe44b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


**节点角色说明：**

1. Provider: 暴露服务的服务提供方。
2. Consumer: 调用远程服务的服务消费方。
3. Registry: 服务注册与发现的注册中心。
4. Monitor: 统计服务的调用次调和调用时间的监控中心。
5. Container: 服务运行容器。

**调用关系说明：**

0. 服务容器负责启动，加载，运行服务提供者。
1. 服务提供者在启动时，向注册中心注册自己提供的服务。
2. 服务消费者在启动时，向注册中心订阅自己所需的服务。
3. 注册中心返回服务提供者地址列表给消费者，如果有变更，注册中心将基于长连接推送变更数据给消费者。
4. 服务消费者，从提供者地址列表中，基于软负载均衡算法，选一台提供者进行调用，如果调用失败，再选另一台调用。
5. 服务消费者和提供者，在内存中累计调用次数和调用时间，定时每分钟发送一次统计数据到监控中心。

dubbo基于Sock而协议进行通信[Socket协议](https://github.com/lovemoganna/interview/wiki/05-Socket协议)
## zookeeper的了解

注册中心负责服务地址的注册与查找，相当于目录服务，服务提供者和消费者只在启动时与注册中心交互，注册中心不转发请求，压力较小。

zookeeper的作用:

1. 可以作为集群的管理工具使用。
2. 可以集中管理配置文件。



### 操作环境

centos6.7: java7 tomcat7 dubbo-admin.war zookeeper3.4.5

win7: idea maven java9 springboot2.0

maven install的时候老出现java1.5,1.7已过期,需要在pom依赖加入:

```
 <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.9</maven.compiler.source>
        <maven.compiler.target>1.9</maven.compiler.target>
    </properties>
``` 
## IDEA来实现dubbo服务层和表现层之间的通信

实现基于SSO的架构.

下面启动zookeeper,端口号是`192.168.25.220:2181`

启动dubbo的监测中心,dubbo监测中心是一个war包,放进tomcat的wabapps目录下面,解压后修改其中的properties,改一下zookeeper注册中心的url,就可以访问了.

启动方式是`192.168.25.220:8070/dubbo-admini/`就可以了.

要改下tomcat的端口,很有几率冲突.

首页展示:

![](https://upload-images.jianshu.io/upload_images/7505161-447995d289b782ae.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 项目搭建

![](https://upload-images.jianshu.io/upload_images/7505161-9e27d35e96d51f0d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

基本思想:就是服务层发布服务,表现层调用服务.二者之间采用dubbo通信.采用的注册中心是zookeeper.

如果你想看主干目录,我建议你在google浏览器上装一个可以全局预览的github插件,这样就可以看到全部文件了.支持搜索和跳转.打开简书,搜索github插件就可以了.

## 项目思路

服务层写一个带有实体的接口和实现类.

服务层调用服务,以JSON格式返回服务中的对象.

如果项目拆的更细的话,interface和domain都是一个单独的jar工程.

## 项目的配置文件和注释类解释

### 几个常用的注解
1. @RestController =  @Controller + @ResponseBody

![](https://upload-images.jianshu.io/upload_images/7505161-bd9759fe0fd67231.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

2. @RequestParam -- 获取请求参数的值

3. @GetMapping -- @RequestMapping(method= RequestMethod.GET的缩写)

4. @PathVariable -- 获取url中数据

5. @RequestParam与@PathVariable的区别:

前者是请求中的参数,像`get?id=1`.

后者是请求路径中的变量,像`get/id=1`.


### 核心类

```androiddatabinding
@SpringBootApplication
// 导入 consumers.xml 配置；
@ImportResource(value = { "classpath:consumers.xml" })
public class DubboConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboConsumerApplication.class, args);
	}
}
```
@SpringBootApplication的解释:

![](https://upload-images.jianshu.io/upload_images/7505161-2bf36eebb3080ffb.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


## 观察后台页面

查看生产者的名字:

![](https://upload-images.jianshu.io/upload_images/7505161-250d6cdf98e845b5.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

查看方法名:

![image.png](https://upload-images.jianshu.io/upload_images/7505161-06187424410dfc23.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

查看消费者的名字

![image.png](https://upload-images.jianshu.io/upload_images/7505161-83b50404fcaa681d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

查看消费者消费的方法

![](https://upload-images.jianshu.io/upload_images/7505161-11a12b4bdd1646ae.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 测试结果

我们的目的重在测试dubbo的使用.

所以发送一个GET请求,得到的就是一个json数组.
如下:

![](https://upload-images.jianshu.io/upload_images/7505161-9472d56c791c2634.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)









