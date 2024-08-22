package io.knifer.freebox.websocket.handler.impl;

import com.github.tvbox.osc.bean.SourceBean;
import com.google.gson.reflect.TypeToken;

import io.knifer.freebox.constant.MessageCodes;
import io.knifer.freebox.model.common.Message;
import io.knifer.freebox.util.GsonUtil;
import io.knifer.freebox.websocket.handler.TopicSendBackHandler;
import io.knifer.freebox.websocket.service.WSService;

public class GetHomeContentHandler extends TopicSendBackHandler<SourceBean> {

    public GetHomeContentHandler(WSService service) {
        super(service);
    }

    @Override
    public boolean support(Message<?> message) {
        return message.getCode() == MessageCodes.GET_HOME_CONTENT;
    }

    @Override
    public Message<SourceBean> resolve(String messageString) {
        return GsonUtil.fromJson(messageString, new TypeToken<Message<SourceBean>>(){});
    }

    @Override
    public void handle(Message<SourceBean> message) {
        service.sendHomeContent(message.getTopicId(), message.getData());
    }
}
