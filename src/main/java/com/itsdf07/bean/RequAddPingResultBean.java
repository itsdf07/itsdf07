package com.itsdf07.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date: 2019/11/26
 **/
@ApiModel(value = "目标主机IP结果接收类")
public class RequAddPingResultBean {
    @ApiModelProperty(name = "datas", value = "", notes = "集合", dataType = "List", required = true)
    private List<DatasBean> datas;

    public List<DatasBean> getDatas() {
        return datas;
    }

    public void setDatas(List<DatasBean> datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        @ApiModelProperty(name = "iccid", value = "SIM卡卡号", notes = "卡号", dataType = "String", required = true, example = "8986061910003732056H")
        private String iccid;
        @ApiModelProperty(name = "imei", value = "设备IMEI", notes = "设备IMEI", dataType = "String", required = true, example = "860588043009813")
        private String imei;
        @ApiModelProperty(name = "os", value = "客户端系统<br>1-Android<br>2-IOS", notes = "系统，如1-Android,2-IOS", dataType = "Int", required = true, example = "1")
        private int os;
        @ApiModelProperty(name = "osVersion", value = "系统版本,如8.0", notes = "系统版本", dataType = "String", required = true, example = "8.0")
        private String osVersion;
        @ApiModelProperty(name = "provider", value = "运营商<br>1-移动<br>2-联通<br>3-电信", notes = "运营商:1-移动，2-联通，3-电信", dataType = "Int", required = true, example = "1")
        private int provider;
        @ApiModelProperty(name = "netType", value = "网络<br>0-未知<br>1-wifi<br>2-2G<br>3-3G<br>4-4G", notes = "网络:0-未知，1-wifi，2-2G，3-3G，4-4G", dataType = "Int", required = true, example = "4")
        private int netType;
        @ApiModelProperty(name = "host", value = "目标主机<br>tts.baidu.com", notes = "目标主机", dataType = "String", required = true, example = "tts.baidu.com")
        private String host;
        @ApiModelProperty(name = "nextHost", value = "目标主机<br>tts.n.shifen.com", notes = "目标主机", dataType = "String", required = true, example = "tts.n.shifen.com")
        private String nextHost;
        @ApiModelProperty(name = "ip", value = "ping出来的目标主机IP地址", notes = "ping出来的目标主机IP地址", dataType = "String", required = true, example = "115.239.211.61")
        private String ip;

        public String getIccid() {
            return iccid;
        }

        public void setIccid(String iccid) {
            this.iccid = iccid;
        }

        public String getImei() {
            return imei;
        }

        public void setImei(String imei) {
            this.imei = imei;
        }

        public int getOs() {
            return os;
        }

        public void setOs(int os) {
            this.os = os;
        }

        public String getOsVersion() {
            return osVersion;
        }

        public void setOsVersion(String osVersion) {
            this.osVersion = osVersion;
        }

        public int getProvider() {
            return provider;
        }

        public void setProvider(int provider) {
            this.provider = provider;
        }

        public int getNetType() {
            return netType;
        }

        public void setNetType(int netType) {
            this.netType = netType;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getNextHost() {
            return nextHost;
        }

        public void setNextHost(String nextHost) {
            this.nextHost = nextHost;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        @Override
        public String toString() {
            return "iccid:" + iccid + ",imei:" + imei + ",os:" + os + ",osVersion:" + osVersion + ",provider:" + provider + ",netType:" + netType + ",host:" + host + ",nextHost:" + nextHost + ",ip:" + ip;
        }
    }

    @Override
    public String toString() {
        if (datas == null || datas.isEmpty()) {
            return "";
        }
        String result = "";
        for (DatasBean bean :
                datas) {
            result += bean.toString() + "\n";
        }
        return result;
    }
}
