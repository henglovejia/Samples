# Samples
该项目主要用于记录自己学习Android，代码全部由Kotlin语言完成

## app模块
该模式主要用于支持上层应用

## framework模块
该模块主要用于支持基础架构

### db
SqlLite数据库存储模块

### card
基础卡片模块

### demo
各模块demo样例

### network
网络请求模块 OkHttp3.0/Retrofit

### report
埋点模块

### sp
SharePreference存储模块

### utils
工具类模块

#### StringUtils
字符串工具类

#### TimeUtil
时间工具类

## router
界面跳转模块 使用APT技术

### 匹配规则
SRouter现只支持全路径匹配
1. 支持sample://A/B，不支持sample://A*/B
2. queryMap参数将自动放如Bundle中