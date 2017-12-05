
编译库
1. 下载python2.7，并设置环境变量 C:\Python27（别的版本存在问题）
2. 下载android-ndk-r11c-windows-x86_64，并设置环境变量（别的版本存在问题）
3. 启动服务
4. 修改客户端
4.1 从github下载mars源码、修改gradle-wrapper.properties、build.gradle（尽量用mac编译）
```
// gradle-wrapper.properties
distributionUrl=https\://services.gradle.org/distributions/gradle-3.3-all.zip

// project目录下的build.gradle
classpath 'com.android.tools.build:gradle:2.3.3'
```
4.2 修改地址、ip、build.gradle
```
// MarsServiceStub.java
@Override
public String[] onNewDns(String host) {
    // No default new dns support
//        return null;

    return new String[]{
    // 返回本機服務器的ip地址 日志搜索 task end callback 會顯示此ip
    // 注意要在对应ip的设备上启动服务
            "192.168.1.12"
    };
}

// 全局搜索marsopen.cn，修改替换为localhost（避免手工搜索、替换）

// 修改 app/build.gradle
        useLocalMarsWrapper = true
```

https://github.com/Tencent/mars/issues/281


- [x] 缺陷
- mars日志格式無法變更
- 網絡檢測無法單獨調用
- 清理日志時間在c文件中設置，需重新編譯
- SDT was designed to assist STN, so we did not make the interface of SDT visible.
If you just want to use SDT alone to detect network, using SDT alone costs a bit much because we have little documet about it.

- [微信 Mars Android Sample 源码分析](http://cfanr.cn/2017/07/18/wechat-mars-android-sample-source-code-analyze/)
- [微信mars 的高性能日志模块 xlog](https://dev.qq.com/topic/581c2c46bef1702a2db3ae53)
- [Tencent/mars](https://github.com/Tencent/mars)
- [ndk The Build Environment](https://docs.gradle.org/2.4/userguide/build_environment.html)
- [NDK 入门指南](https://developer.android.com/ndk/guides/index.html)
- [protobuf-gradle-plugin](https://github.com/google/protobuf-gradle-plugin#default-outputs)