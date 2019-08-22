package Config;


import Config.Controller.Producer;
import bo.DeviceOnline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class testSend {

    @Autowired
    Producer producer;
    @Test
    public void send()
    {
        DeviceOnline deviceOnline = new DeviceOnline();
        deviceOnline.setCmdType("SET_WIFI_SSID_ONOFF");
        deviceOnline.setPluginName("WifiConfig");
        deviceOnline.setType("Report");
        deviceOnline.setRpcMethod("Set");

        DeviceOnline.Parameter parameter = new DeviceOnline.Parameter();
        parameter.setDeviceMac("333");
        parameter.setMac("234");
        parameter.setDeviceName("abc");
        parameter.setDhcpName("aaa");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        parameter.setUpTime(sdf.parse("2014-07-26-13:23:55"));
        parameter.setIp("192.168.1.1");
        parameter.setConnectType("link");
        parameter.setPort("8080");
        parameter.setSsidIndex("88");
        parameter.setSn("sn");
        deviceOnline.setParameter(parameter);
        deviceOnline.setMac("F0983861FBAE");
        deviceOnline.setSn("HWTC61FBAE89");
        deviceOnline.setUserId("9669951750223");
        producer.sendDeviceOnlineMessage(deviceOnline);
//        producer.sendTextMessage("aaaa");




    }
}

