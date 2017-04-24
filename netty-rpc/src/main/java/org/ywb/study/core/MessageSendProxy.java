package org.ywb.study.core;

import org.ywb.study.model.MessageRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * date: 2017/4/17 16:14
 * description: Rpc客户端消息处理
 */
public class MessageSendProxy<T> implements InvocationHandler {

    private Class<T> cls;

    public MessageSendProxy(Class<T> cls) {
        this.cls = cls;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        MessageRequest request = new MessageRequest();
        request.setMessageId(UUID.randomUUID().toString());
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setTypeParameters(method.getParameterTypes());
        request.setParameters(args);

        MessageSendHandler handler = RpcServerLoader.getInstance().getMessageSendHandler();
        MessageCallBack callBack = handler.sentRequest(request);
        return callBack.start();
    }
}
