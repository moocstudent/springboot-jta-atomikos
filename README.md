# SpringBoot 分布式事物处理 :zzz:

> 小生不足之处，还望各位前辈不吝赐教。<br>

## 项目环境

> **JDK:** 1.8 + 

> **Spring Boot:**  2.0.6 

> **MySQL:** 5.7.21 

> **IDEA:** InteIIij IDEA 

## 组织架构
```
jta-atomikos
+
+--+ api    接口模块
|  +---+ aop               全局日志
|  +---+ config            数据源配置
|  +---+ controller        接口
|  +---+ service           业务逻辑事物控制
|  +---+ util              工具包
|
+--+ dao    持久层模块
   +---+ mybatis           mybatis-generator 自定义工具     
   +---+ one               db_one 数据源 
   |   +---+ entity        
   |   +---+ mapper        
   |   +---+ repository     
   +---+ two               db_two 数据源
       +---+ entity        
       +---+ mapper        
       +---+ repository    

```







## 技术交流
:feet: <a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=dcdd3d66762ab211689194912f87f082e1416c4a95313d48caf179871150fdd8">Hello World</a> &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;   :point_left:



