package org.ywb.study.model;

import java.io.Serializable;
import lombok.Data;

/**
 * date: 2017/4/17 15:53
 * description: 响应消息结构
 */
@Data
public class MessageResponse implements Serializable {

    private static final long serialVersionUID = 7540909582189393668L;
    private String messageId;
    private String error;
    private Object result;
}
