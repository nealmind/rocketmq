package org.apache.rocketmq;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.rocketmq.common.namesrv.NamesrvConfig;
import org.apache.rocketmq.namesrv.NamesrvController;
import org.apache.rocketmq.remoting.netty.NettyServerConfig;

/**
 * 2020/12/19 : 16:48
 */
public class NameServerInstanceDemo {

    public static void main(String[] args) throws Exception {
        final NamesrvConfig config = new NamesrvConfig();
        final NettyServerConfig nettyServerConfig = new NettyServerConfig();
        nettyServerConfig.setListenPort(9876);
        NamesrvController namesrvController = new NamesrvController(config, nettyServerConfig);
        namesrvController.initialize();
        namesrvController.start();
        Thread.sleep(DateUtils.MILLIS_PER_DAY);
    }
}
