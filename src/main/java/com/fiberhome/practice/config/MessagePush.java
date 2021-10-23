package com.fiberhome.practice.config;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Collection;

@Configuration
@EnableScheduling
public class MessagePush {

    @Autowired
    private SocketIOServer socketIOServer;

    @Scheduled(fixedRate=3000)
    public void configureTasks() {
        Collection<SocketIOClient>  socketIOClients=socketIOServer.getAllClients();
        System.out.println(socketIOClients.size());

        for(SocketIOClient client:socketIOClients){
            System.out.println(client.getSessionId());
            if(client.isChannelOpen()){
                System.out.println(1111111);
                client.sendEvent("messageevent", "我是服务器都安发送的信息");
            }


        }
    }


    @OnEvent(value = "messageevent")
    public void onEvent(SocketIOClient client, AckRequest request, Object data) {
       System.out.println("发来消息：" + data);
    }
}
