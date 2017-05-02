package org.ywb.study.model;

import java.io.Serializable;
import lombok.Data;

/**
 * date: 2017/4/17 15:48
 * description: 消息请求
 */
@Data
public class MessageRequest implements Serializable {

    private static final long serialVersionUID = 7852446409250964642L;
    private String messageId;
    private String className;
    private String methodName;
    private Class<?>[] typeParameters;
    private Object[] parameters;

}
