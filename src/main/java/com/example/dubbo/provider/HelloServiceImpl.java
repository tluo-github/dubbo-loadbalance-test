package com.example.dubbo.provider;

import com.example.dubbo.common.HelloService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;

/**
 * 发布到 Dubbo，并在返回里包含本服务监听的端口。
 */
@DubboService(version = "1.0.0", loadbalance = "ema")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        // 从 RpcContext 拿到本地地址（host:port）
        int port = RpcContext.getContext()
                .getLocalAddress()
                .getPort();
        return String.format("Hello, %s (from EMA provider on port %d)", name, port);
    }
}