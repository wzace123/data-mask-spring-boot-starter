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
    <groupId>org.wz</groupId>
    <artifactId>data-mask-spring-boot-starter</artifactId>
    <version>1.0.0-SNAPSHOT</version>
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
* 使用`@MaskedField`标记接口数据脱敏字段，并定义字段需要的脱敏处理策略FieldType
```java
public class User implements Serializable {

    @MaskedField(value = FieldType.USER_NAME)
    private String name;

    @MaskedField(value = FieldType.ID_CARD)
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
* 接口方法添加`@Masked`如下所示，将自动对返回参数进行脱敏处理
```java
@Masked // look here
public User userInfo() {
    //...
}
```

* 嵌套对象使用`@Masked`如下所示，会对UserGroupWrapper.userGroup.userList数据进行脱敏处理
```java
@Masked
public UserGroupWrapper userGroupWrapper() {
    //...
}

public class UserGroupWrapper implements Serializable {

    @Masked // look here
    private UserGroup userGroup;

}

public class UserGroup implements Serializable {

    @Masked // look here
    private List<User> userList;

}
```

* 外部依赖的嵌套对象使用`@Masked`，指定需要脱敏处理的数据的位置
```java
@Masked(value="data.content") // look here
public ResultWrapper<PageWrapper<User>> userPageList() {
    //...
}

// third class file we can not add @Masked on the data field
public class ResultWrapper<T> implements Serializable {

    private int code;

    private String message;

    private T data;

    private boolean sucess;
}

// third class file we can not add @Masked on the content field
public class PageWrapper<T> implements Serializable {

    private List<T> content;

    private int total;
}

```
* 分组脱敏，指定分组名称`@Masked(group={xxx,xxx})`后，只会对属于指定分组的字段进行脱敏处理
```java
@Masked(groups = {"myGroup1"}) // add group
public User userInfo() {
    //...
}

public class User implements Serializable {

    @MaskedField(value = FieldType.USER_NAME, groups = {"myGroup1"}) // will be masked
    private String name;

    @MaskedField(value = FieldType.ID_CARD, groups = {"myGroup2"}) // not same group,do not mask
    private String idCard;
}
```

### 如何使用`@MaskedField`
* 使用`@MaskedField`指定需要脱敏字段
```java
public class User implements Serializable {

    @MaskedField(value = FieldType.USER_NAME)
    private String name;

    @MaskedField(value = FieldType.ID_CARD)
    private String idCard;
}
```

* value=FieldType.xxx用于指定脱敏处理策略，目前支持的脱敏策略如下

| value                   | 待脱敏数据              | 默认脱敏处理结果                  |
|-------------------------|--------------------|---------------------------|
| FieldType.USER_NAME    | 李大刀                | 李**                       |
| FieldType.ID_CARD      | 426587966548523658 | 4****************8        |
| FieldType.FIXED_PHONE  | 81818989           | 8181**89                  |
| FieldType.MOBILE_PHONE | 18879546582        | 188****6582               |
| FieldType.ADDRESS      | 湖北省武汉市黄鹤楼一栋101     | 湖北省武汉*********            |
| FieldType.EMAIL        | testab@Gmail.com   | t*****@Gmail.com          |
| FieldType.PASSWORD     | Wlsfk#$123         | **********                |
| FieldType.CAR_LICENSE  | 京AD88888           | 京AD****8                  |
| FieldType.BANK_CARD    | 6845987565214587   | 6845********4587          |
| FieldType.IPV4         | 192.169.31.12      | 192.\*.\*.\*              |
| FieldType.IPV6         | 2001:470:c:1818::2 | 2001:\*:\*:\*:\*:\*:\*:\* |


### 自定义脱敏处理策略
* 自定义DataMaskHandler,并注入spring容器
```java
@Component
public class MyUserNameMaskHandler implements DataMaskHandler {

    @Override
    public String doMask(String name) {
        // doMask
    }

    @Override
    public String getFieldType() {
        // 不只是现有的FieldType类型，也可以自定义
        return FieldType.USER_NAME;
    }

    @Override
    public String getId() {
        return "myid";
    }
}
```
* 指定脱敏字段，使用自己的DataMaskHandler
```java
public class User implements Serializable {

    @MaskedField(value = FieldType.USER_NAME, id = "myid") // look here
    private String name;
}
```