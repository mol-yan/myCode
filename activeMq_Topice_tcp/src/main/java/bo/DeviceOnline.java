package bo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 设备上线请求体
 */
@Data
public class DeviceOnline implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 网关MAC
     */
    @JsonProperty("MAC")
    @NotEmpty(message = "MAC is empty!")
    private String mac;

    /**
     * 网关SN
     */
    @JsonProperty("SN")
    private String sn;

    /**
     * 报文类型，即report
     */
    @JsonProperty("Type")
    @NotEmpty(message = "Type is empty!")
    private String type;

    /**
     * OSGI插件名称
     * 为空则表示预置插件DEFAULT
     */
    @JsonProperty("OsgiName")
    private String osgiName = "DEFAULT";

    /**
     * 插件名称
     * 即模块名称
     */
    @JsonProperty("PluginName")
    @NotEmpty(message = "PluginName is empty!")
    private String pluginName;

    /**
     * 命令类型
     */
    @JsonProperty("CmdType")
    private String cmdType;

    /**
     * 用户标识
     */
    @JsonProperty("UserId")
    private String userId;

    /**
     * 接口分类定义
     * 即Report
     */
    @JsonProperty("RPCMethod")
    @NotEmpty(message = "RPCMethod is empty!")
    private String rpcMethod;

    /**
     * 事务ID
     */
    @JsonProperty("ID")
    private String id;

    /**
     * 请求标识
     */
    @JsonProperty("SequenceId")
    private String sequenceId;

    /**
     * 请求参数
     */
    @Valid
    @JsonProperty(value = "Parameter")
    @NotNull(message = "Parameter is empty!")
    private Parameter parameter;

    /**
     * 请求参数
     */
    @Data
    public static class Parameter implements Serializable{

        private static final long serialVersionUID = 1L;

        /**
         * 网关MAC
         */
        @JsonProperty("MAC")
        private String mac;

        /**
         * 网关SN
         */
        @JsonProperty("SN")
        private String sn;

        /**
         * 设备名称
         */
        @JsonProperty("DeviceName")
        private String deviceName;

        /**
         * 设备主机名称
         */
        @JsonProperty("DhcpName")
        private String dhcpName;

        /**
         * 设备MAC
         */
        @JsonProperty("DeviceMAC")
        @NotEmpty(message = "DeviceMAC is empty!")
        private String deviceMac;

        /**
         * 上线时间
         */
        @JsonProperty("UpTime")
        @JsonFormat(pattern="yyyyMMddHHmmss")
        private Date upTime;

        /**
         * 设备IP
         */
        @JsonProperty("IP")
        private String ip;

        /**
         * 设备端口
         */
        @JsonProperty("Port")
        private String port;

        /**
         * 设备连接类型
         * 0：有线
         * 1：无线
         */
        @JsonProperty("ConnectType")
        private String connectType;

        /**
         * 设备通过无线方式连接时无线网络索引
         */
        @JsonProperty("SSIDIndex")
        private String ssidIndex;
    }
}
