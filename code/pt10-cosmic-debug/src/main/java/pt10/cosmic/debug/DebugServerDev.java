package pt10.cosmic.debug;

import kd.bos.config.client.util.ConfigUtils;
import kd.bos.service.bootstrap.Booter;

/**
 * 启动类
 *
 * @date 2025/1/14
 */
@SuppressWarnings("all")
public class DebugServerDev {

    public static void main(String[] args) throws Exception {

        //个人标识 每个人各自修改
        String name = "LICHAO";

        System.setProperty(ConfigUtils.APP_NAME_KEY, "mservice-" + name);

        //设置集群环境名称和配置服务器地址
        //集群地址
        System.setProperty(ConfigUtils.CLUSTER_NAME_KEY, "ierp-cluster");
        //租户地址
        System.setProperty("domain.tenantCode", "ierp-tenant");
        System.setProperty("env.type", "test");
        //服务启动地址
        System.setProperty("domain.contextUrl", "127.0.0.1:8080/ierp");
        //服务启动端口
        System.setProperty("JETTY_WEB_PORT", "8080");
        //mc服务器地址
        System.setProperty("mc.server.url", "http://192.168.31.20:8090/mc");
        // zookeeper地址
        System.setProperty(ConfigUtils.CONFIG_URL_KEY, "192.168.31.20:2181?user=zookeeper&password=d@f*g:SGVsbG8==8S/efRX0EtJa3d5P88i0tDsxRdGlh6nIJ7kL3nBJv1u1a2RwYXNzd29yZA==");

        //苍穹静态服务地址，不同环境需要换不同地址
        System.setProperty("JETTY_WEBRES_PATH", "D:/project/ziyuan/static-file-service");
        //文件，图片，附件服务器 todo
        System.setProperty("fileserver", "192.168.31.20:8100/fileserver/");
        System.setProperty("imageServer.url", "192.168.31.20:8100/fileserver/");
        System.setProperty("attachmentServer.url", "192.168.31.20:8100/fileserver/");

        //XDB 支持垂直分表
        System.setProperty("xdb.enable", "false");

        // MQ标识，可修改
        System.setProperty("mq.debug.queue.tag", name);
        System.setProperty("mq.consumer.register", "true");

        //是否输出SQL,
        System.setProperty("db.sql.out", "true");
        //sql是否输出参数
        System.setProperty("db.sql.out.withParameter", "false");

        //元数据导出路径配置 , 应用
        String path2 = System.getProperty("user.dir");
        path2 += "/datamodel";
        System.setProperty("git.export", path2);


        //----------------------------------可不修改-------------------------------
        System.setProperty("configAppName", "mservice,web");
        System.setProperty("webmserviceinone", "true");
        System.setProperty("MONITOR_HTTP_PORT", "9998");
        System.setProperty("JMX_HTTP_PORT", "9091");
        System.setProperty("dubbo.consumer.url", "dubbo://localhost:20880");
        System.setProperty("dubbo.consumer.url.qing", "dubbo://localhost:30880");
        System.setProperty("dubbo.registry.register", "false");
        System.setProperty("dubbo.service.lookup.local", "true");
        System.setProperty("appSplit", "false");
        System.setProperty("script.debug.enable", "true");
        System.setProperty("tenant.code.type", "config");
        System.setProperty("file.encoding", "utf-8");
        //是否开启轻量级环境配置，true是轻量级；fasle 是非轻量级，用共用redis、mq组件
        System.setProperty("lightweightdeploy", "false");
        System.setProperty("lightweightdeploy", "false");
        System.setProperty ("bos.app.special.deployalone.ids", true ? " " : "qing");
        Booter.main(null);
    }
}
