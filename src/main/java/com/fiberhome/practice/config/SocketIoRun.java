package com.fiberhome.practice.config;

import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author 10973
 * @Version 1.0.0
 * @Date 2020/7/29 11:26
 */

@Component
@Order(value = 1)
public class SocketIoRun implements CommandLineRunner {
    @Autowired
    private SocketIOServer socketIOServer;

    @Override
    public void run(String... args) throws Exception {
        socketIOServer.start();
        System.out.println("socket.io启动成功！");
    }
}
