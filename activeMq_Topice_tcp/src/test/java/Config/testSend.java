package Config;


import Config.Controller.Producer;
import bo.DeviceOnline;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class testSend {

    @Autowired
    Producer producer;

    @Test
    public void testLocale()
    {
        //①带有语言和国家/地区信息的本地化对象
        Locale locale1 = new Locale("zh","CN");

        //②只有语言信息的本地化对象
        Locale locale2 = new Locale("zh");

        //③等同于Locale("zh","CN")
        Locale locale3 = Locale.CHINA;

        //④等同于Locale("zh")
        Locale locale4 = Locale.CHINESE;

        //⑤获取本地系统默认的本地化对象
        Locale locale5= Locale.getDefault();

        Locale locale = new Locale("zh", "CN");
        NumberFormat currFmt = NumberFormat.getCurrencyInstance(locale);
        double amt = 123456.78;
        System.out.println(currFmt.format(amt));



    }


    @Test
    public void testSendtoBp() throws ParseException {
        DeviceOnline deviceOnline = new DeviceOnline();
        deviceOnline.setCmdType("REPORT_LAN_DEVICE_ONLINE");
        deviceOnline.setSequenceId("FFFFFFFF");
        deviceOnline.setPluginName("LanDeviceConfig");
        deviceOnline.setType("report");
        deviceOnline.setRpcMethod("Get");

        DeviceOnline.Parameter parameter = new DeviceOnline.Parameter();
        parameter.setDeviceMac("3233");
        parameter.setMac("2384");
        parameter.setDeviceName("abc");
        parameter.setDhcpName("aaa");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        parameter.setUpTime(sdf.parse("2014-07-26-13:23:55"));
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

