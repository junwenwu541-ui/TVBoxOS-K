package io.knifer.freebox.websocket.handler;

import io.knifer.freebox.websocket.service.WSService;

/**
 * 用于处理topic请求的消息处理器
 * @author knifer
 */
public abstract class TopicSendBackHandler<T> implements WebSocketMessageHandler<T> {

    protected final WSService service;

    public TopicSendBackHandler(WSService service) {
        this.service = service;
    }
}
