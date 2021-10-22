package com.fiberhome.practice.config;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
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

    @Scheduled(fixedRate=2000)
    public void configureTasks() {
        Collection<SocketIOClient>  socketIOClients=socketIOServer.getAllClients();
        for(SocketIOClient socketIOClient:socketIOClients){
            socketIOClient.sendEvent("connected", "hello");
        }
    }
}
