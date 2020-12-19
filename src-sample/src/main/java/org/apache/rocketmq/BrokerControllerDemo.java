package org.apache.rocketmq;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.rocketmq.broker.BrokerController;
import org.apache.rocketmq.common.BrokerConfig;
import org.apache.rocketmq.common.MQVersion;
import org.apache.rocketmq.remoting.netty.NettyClientConfig;
import org.apache.rocketmq.remoting.netty.NettyServerConfig;
import org.apache.rocketmq.remoting.protocol.RemotingCommand;
import org.apache.rocketmq.store.config.FlushDiskType;
import org.apache.rocketmq.store.config.MessageStoreConfig;

/**
 * 2020/12/19 : 17:00
 */
public class BrokerControllerDemo {

    public static void main(String[] args) throws Exception {
        System.setProperty(RemotingCommand.REMOTING_VERSION_KEY,
                Integer.toString(MQVersion.CURRENT_VERSION));
        final NettyServerConfig nettyServerConfig = new NettyServerConfig();
        nettyServerConfig.setListenPort(10911);
        
        final BrokerConfig brokerConfig = new BrokerConfig();
        brokerConfig.setBrokerName("broker-a");
        brokerConfig.setNamesrvAddr("127.0.0.1:9876");
        
        final MessageStoreConfig messageStoreConfig = new MessageStoreConfig();
        messageStoreConfig.setDeleteWhen("04");
        messageStoreConfig.setFileReservedTime(48);
        messageStoreConfig.setFlushDiskType(FlushDiskType.ASYNC_FLUSH);
        messageStoreConfig.setDuplicationEnable(false);

        BrokerController brokerController = new BrokerController(
                brokerConfig,
                nettyServerConfig,
                new NettyClientConfig(),
                messageStoreConfig
        );
        brokerController.initialize();
        brokerController.start();
        System.err.println("Hello");
        Thread.sleep(DateUtils.MILLIS_PER_DAY);
        
    }
}
