
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
```
~~~~~ begin of mmap ~~~~~
[D][2017-12-05 +8.0 14:45:16.398][7066, 1*][MainActivity][, , 0][onCreate
~~~~~ end of mmap ~~~~~[9178,9178][2017-12-05 +0800 14:47:53]
~~~~~ begin of mmap ~~~~~
^^^^^^^^^^Oct 12 2017^^^18:37:46^^^^^^^^^^[9178,9178][2017-12-05 +0800 14:47:53]
del time out files time: 1
get mmap time: 14
MARS_URL:
MARS_PATH: master
MARS_REVISION: f685e74
MARS_BUILD_TIME: 2017-10-12 18:37:30
MARS_BUILD_JOB: mars_xlog_sdk/mars_libs
log appender mode:0, use mmap:1
[D][2017-12-05 +8.0 14:47:53.334][9178, 1*][MainActivity][, , 0][onCreate
~~~~~ end of mmap ~~~~~[15829,15829][2017-12-05 +0800 14:56:12]
```
- 網絡檢測無法單獨調用
- 清理日志時間在c文件中設置，需重新編譯
- SDT was designed to assist STN, so we did not make the interface of SDT visible.
If you just want to use SDT alone to detect network, using SDT alone costs a bit much because we have little documet about it.
- 解密比较麻烦 [安装链接工具](https://github.com/Tencent/mars/wiki/Xlog-%E5%8A%A0%E5%AF%86%E4%BD%BF%E7%94%A8%E6%8C%87%E5%BC%95)
```
// 安装完成后，调用
python  mars-master/mars/log/crypt/decode_mars_nocrypt_log_file.py  ~/Downloads/log/MarsSample_20161230.xlog
```

- [x] 资料
- [微信 Mars Android Sample 源码分析](http://cfanr.cn/2017/07/18/wechat-mars-android-sample-source-code-analyze/)
- [微信mars 的高性能日志模块 xlog](https://dev.qq.com/topic/581c2c46bef1702a2db3ae53)
- [Tencent/mars](https://github.com/Tencent/mars)
- [ndk The Build Environment](https://docs.gradle.org/2.4/userguide/build_environment.html)
- [NDK 入门指南](https://developer.android.com/ndk/guides/index.html)
- [protobuf-gradle-plugin](https://github.com/google/protobuf-gradle-plugin#default-outputs)
- [微信客户端怎样应对弱网络](https://github.com/WeMobileDev/article/blob/master/%E5%BE%AE%E4%BF%A1%E5%AE%A2%E6%88%B7%E7%AB%AF%E6%80%8E%E6%A0%B7%E5%BA%94%E5%AF%B9%E5%BC%B1%E7%BD%91%E7%BB%9C.pdf)