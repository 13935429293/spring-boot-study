package org.ywb.study.core;

import java.lang.reflect.Proxy;

/**
 * date: 2017/4/17 16:07
 * description:
 */
public class MessageSendExecutor {

    private RpcServerLoader loader = RpcServerLoader.getInstance();

    public MessageSendExecutor(String serverAddress) {
        loader.load(serverAddress);
    }

    public void stop(){
        loader.unLoad();
    }

    public static <T> T execute(Class<T> rpcInstance) {
        return (T) Proxy.newProxyInstance(rpcInstance.getClassLoader(),
                new Class<?>[]{rpcInstance},
                new MessageSendProxy<T>(rpcInstance));
    }

}
