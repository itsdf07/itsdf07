package com.itsdf07.bean;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Description:
 * @Auther: itsdf07
 * @Date: 2019/11/26 16:12
 **/
@ApiModel(value = "对Client端请求新增ping结果的接收类")
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
        @ApiModelProperty(name = "iccid", value = "8986061910003732056H", notes = "卡号", dataType = "String", required = true)
        private String iccid;
        @ApiModelProperty(name = "imei", value = "860588043009813", notes = "设备表示", dataType = "String", required = true)
        private String imei;
        @ApiModelProperty(name = "provider", value = "Android", notes = "使用的系统平台", dataType = "String", required = true)
        private String provider;
        @ApiModelProperty(name = "os", value = "8.0", notes = "系统版本", dataType = "String", required = true)
        private String os;
        @ApiModelProperty(name = "netType", value = "4G", notes = "使用的网络", dataType = "String", required = true)
        private String netType;
        @ApiModelProperty(name = "host", value = "tts.baidu.com", notes = "目标主机", dataType = "String", required = true)
        private String host;
        @ApiModelProperty(name = "nextHost", value = "tts.n.shifen.com", notes = "目标主机", dataType = "String", required = true)
        private String nextHost;
        @ApiModelProperty(name = "ip", value = "115.239.211.61", notes = "ping出来的目标主机IP地址", dataType = "String", required = true)
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

        public String getProvider() {
            return provider;
        }

        public void setProvider(String provider) {
            this.provider = provider;
        }

        public String getOs() {
            return os;
        }

        public void setOs(String os) {
            this.os = os;
        }

        public String getNetType() {
            return netType;
        }

        public void setNetType(String netType) {
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
            return "iccid:" + iccid + ",imei:" + imei + ",provider:" + provider + ",os:" + os + ",netType:" + netType + ",host:" + host + ",nextHost:" + nextHost + ",ip:" + ip;
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
