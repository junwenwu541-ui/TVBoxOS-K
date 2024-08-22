package io.knifer.freebox.websocket;

import com.google.common.collect.ImmutableList;
import com.google.gson.reflect.TypeToken;

import java.net.URI;
import java.nio.ByteBuffer;
import java.util.List;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import io.knifer.freebox.model.common.Message;
import io.knifer.freebox.util.CastUtil;
import io.knifer.freebox.util.GsonUtil;
import io.knifer.freebox.websocket.handler.WebSocketMessageHandler;
import io.knifer.freebox.websocket.handler.impl.GetHomeContentHandler;
import io.knifer.freebox.websocket.handler.impl.GetSourceBeanListHandler;
import io.knifer.freebox.websocket.service.WSService;

public class WSClient extends WebSocketClient {

    private final WSService service = new WSService(this.getConnection());

    private final List<WebSocketMessageHandler<?>> handlers;

    public WSClient(URI serverURI) {
        super(serverURI);
        handlers = ImmutableList.of(
                new GetSourceBeanListHandler(service),
                new GetHomeContentHandler(service)
        );
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        service.register();
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("closed with exit code " + code + " additional info: " + reason);
    }

    @Override
    public void onMessage(String message) {
        Message<Object> msgUnResolved = GsonUtil.fromJson(
                message, new TypeToken<Message<Object>>(){}
        );

        for (WebSocketMessageHandler<?> handler : handlers) {
            if (handler.support(msgUnResolved)) {
                handler.handle(CastUtil.cast(handler.resolve(message)));
            }
        }
    }

    @Override
    public void onMessage(ByteBuffer message) {
        System.out.println("received ByteBuffer");
    }

    @Override
    public void onError(Exception ex) {
        System.err.println("an error occurred:" + ex);
    }
}