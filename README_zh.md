data-mask-spring-boot-starter
===================================
## 介绍
* 基于spring-boot的数据脱敏扩展，支持通过注解形式对接口数据进行脱敏处理，支持自定义字段脱敏策略
* 示例demo：[https://github.com/wzace123/data-mask-spring-boot-starter-demo](https://github.com/wzace123/data-mask-spring-boot-starter-demo)

## 快速开始

### 数据脱敏开启

* 添加依赖:
```xml
<dependency>
    <groupId>com.wz</groupId>
    <artifactId>data-mask-spring-boot-starter</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

* 在Spring Boot Application的上添加`@EnableDataMask`
```java
@EnableDataMask
@SpringBootApplication
public class DataMaskApplication {
    //...
}
```

### 如何进行数据脱敏
* 使用`@Masked`标记需脱敏处理的接口
```java
@Masked
public User userInfo() {
    //...
}
```
* 使用`@MaskedField`标记接口数据脱敏字段，并定义字段需要的脱敏处理策略MaskedType
```java
public class User implements Serializable {
    
    @MaskedField(value = MaskedType.USER_NAME)
    private String name;
    
    @MaskedField(value = MaskedType.ID_CARD)
    private String idCard;
}
```
* 最终接口返回数据如下
```json
{
  "name": "李**",
  "idCard": "4****************8"
}
```

### 如何使用`@Masked`
* 待完善

### 如何使用`@MaskedField`
* 待完善

### 自定义脱敏处理策略
* 待完善
