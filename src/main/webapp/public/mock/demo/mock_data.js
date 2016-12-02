/**
* 功能描述：配置Mockjs需要拦截的请求
* 用法参考官方API
* 
* 创建人: liangjifei
* 依赖文件：mock.js
**/
Mock.mock(/\/my/, {
    'list|1-10': [{
        'id|+1': 1,
        'email': '@EMAIL'
    }]
});

Mock.mock(/my.json/, {
    'list|1-10': [{
        'id|+1': 1,
        'email': '@EMAIL'
    }]
});