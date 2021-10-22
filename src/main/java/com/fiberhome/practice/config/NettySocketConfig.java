package com.fiberhome.practice.config;

import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author 10973
 * @Version 1.0.0
 * @Date 2020/7/29 11:25
 */

@Configuration
public class NettySocketConfig {

    @Value("${socketIo.host}")
    private String host;

    @Value("${socketIo.port}")
    private  int port;

    @Value("${socketIo.maxFramePayloadLength}")
    private int maxFramePayloadLength;

    @Value("${socketIo.maxHttpContentLength}")
    private int maxHttpContentLength;

    @Value("${socketIo.bossCount}")
    private int bossCount;

    @Value("${socketIo.workCount}")
    private int workCount;

    @Value("${socketIo.allowCustomRequests}")
    private boolean allowCustomRequests;

    @Value("${socketIo.upgradeTimeout}")
    private int upgradeTimeout;

    @Value("${socketIo.pingTimeout}")
    private int pingTimeout;

    @Value("${socketIo.pingInterval}")
    private int pingInterval;

    @Bean
    public SocketIOServer socketIOServer() throws Exception {
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        config.setHostname(host);
        config.setPort(port);
        config.setMaxFramePayloadLength(maxFramePayloadLength);
        config.setMaxHttpContentLength(maxHttpContentLength);
        config.setBossThreads(bossCount);
        config.setWorkerThreads(workCount);
        config.setAllowCustomRequests(allowCustomRequests);
        config.setUpgradeTimeout(upgradeTimeout);
        config.setPingTimeout(pingTimeout);
        config.setPingInterval(pingInterval);

        SocketConfig socketConfig = new SocketConfig();
        socketConfig.setReuseAddress(true);
        socketConfig.setSoLinger(0);

        config.setSocketConfig(socketConfig);
        //该处进行身份验证
        config.setAuthorizationListener(handshakeData -> {
            String clientId = handshakeData.getSingleUrlParam("clientid");
            if(StringUtils.isBlank(clientId)){
                return false;
            }
            return true;
        });
        final SocketIOServer server = new SocketIOServer(config);

        return server;
    }

    //开启注解
    @Bean
    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer socketServer) {
        return new SpringAnnotationScanner(socketServer);
    }
}
