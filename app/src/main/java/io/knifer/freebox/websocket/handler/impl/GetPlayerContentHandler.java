package io.knifer.freebox.websocket.handler.impl;

import com.google.gson.reflect.TypeToken;

import io.knifer.freebox.constant.MessageCodes;
import io.knifer.freebox.model.common.Message;
import io.knifer.freebox.model.s2c.GetPlayerContentDTO;
import io.knifer.freebox.util.GsonUtil;
import io.knifer.freebox.websocket.handler.TopicSendBackHandler;
import io.knifer.freebox.websocket.service.WSService;

public class GetPlayerContentHandler extends TopicSendBackHandler<GetPlayerContentDTO> {

    public GetPlayerContentHandler(WSService service) {
        super(service);
    }

    @Override
    public boolean support(Message<?> message) {
        return message.getCode() == MessageCodes.GET_PLAYER_CONTENT;
    }

    @Override
    public Message<GetPlayerContentDTO> resolve(String messageString) {
        return GsonUtil.fromJson(
                messageString, new TypeToken<Message<GetPlayerContentDTO>>(){}
        );
    }

    @Override
    public void handle(Message<GetPlayerContentDTO> message) {
        service.sendPlayerContent(message.getTopicId(), message.getData());
    }
}
