package org.zdd.bookstore.pay;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 类名：AlipayConfig
 * 功能：基础配置类
 * 详细：设置帐户有关信息及返回路径
 * 修改日期：2024-04-05
 * 说明：
 * 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 * 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */


@Component
@ConfigurationProperties(prefix = "my.ip")
@PropertySource(value = "classpath:zfbinfo.properties", encoding = "utf-8")
public class AlipayConfig {

    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓


    // 支付宝网关
    private String openApiDomain = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    private String appId = "9021000134685386";

    // 商户私钥，您的PKCS8格式RSA2私钥
    private String merchantPrivateKey = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCTUsb36Z3hSpgFyc4MMlSc/bQXsbL70wsP+EhF4yrgyVmdl7u1WmyzkM+PmUeSNVl2F5ubalpgVkMGvglAgigZJOpo4Xei+0Q9QYbpMnsg6dQk4ox0oXc8Bjda3mMDPOxsV1HlvsfKoLqUqu1OEEMGhmInHCI0e5WK9MbYVzAb3pc082pEaSY8Xt+E30LGrXXG9maBuixQ47COSwZuFSafFB6f85Vrg+rUcOOIzRlKTNjTYeAUz8H/jTIYApb9+emq1lW72XKsKMBoivdxb+Gya35lMx6QBvdHS+KJaG8IRbK9VUHx7iXgPWF9Y3R2LsHHasBtDBDmUTE7ZO0xnyNXAgMBAAECggEBAIPWV+gTUA4EyvajGZkgkUfMYhWyGBHzUrr/3O1t1TlD9sZouroYKZ6nwJco/DuDMoPTrJTwH+CGUYT/Gxh3YZrexkcFPiLD6NVIhoq5eiaCGi7H7hmRRTqZ9X+D8+c55fkuS0Pl7rUOEOpp6+Mn+lMkf0Gwk4uT7MdlNWz02UCWHbsjp3rNlc/jSG5FJVrOkR8A2YhXUPbtjv7Ro5/Ypi+2Xcm7DTnDzyg9mvo3Ct+wJc46OiERmrKtFF5q9viRYZxxq6PQmgBqBebobX7/E2REKMZ2YeHkzJb10odxTPqvd5Dn9fCLjeuXZaeKptiMX0bM0iRtmVE14QZmgk2yWkECgYEAyVabeRyN2fqjXSf49NIS807UvvUVQDX0vIK19zUyLEZ7XIYqTdVp9UtGrRoCpOFhLJeszuMSHC5eNO+mKCNRlGrxyLGgem3SWcInDPN3qf/RNP34F+1LohnWUzb9Y2zcVK8nKgL94+89udTlhP5IvrDm08frjyO7aaUxieV4h60CgYEAu1IHMfB8asDNYxFO1vuJGixYlOWVEBSnexADrQ4XOiTKSTThcu+qzdlJNS0qvg/lVAgqOQ8Meyku9UkMnelArip47S+sY/fH+ATJcdhkmXWrPGbHwLlmlogi7qGQxlfJY1yT9fQrhhv/Q+5C24PTv+M8DfQVKuszZlC2KTTxh5MCgYEAxabZMBchBnmwAFaqZyUH54VfAyu0NfoCDUHAgzPc0mxK1HT9eLVmtKC2fF7Jc7Wx4MXxppRyBepbH1qYYlTx1GL8g0olQasoUmdwUJ1+vwvdBEnCUTLqCfOVXNHiBMYsspHUP8D6H9aQYSsoOtwq69DcedGMZVPtuvOp4za7kW0CgYEAqznF/e43rFVk6MOvb3Ap2NTke+aIJVTb6u+ujIeuz6VFizldQ3S0ismt03/f7DAXjoKQJewNmp8An5IQiF/okcudEiJb0F10Ws/1W61T97rJtcK1oQNYNQ1n8P2amtMv8TV0woRZLJN2+J9YWdPcwTBzesW8e6jXKRVqDaypgyUCgYAA2d1D5Cnvl1eYp+SKazMzBzqbXFss4MQugcUQsfaiohuSFUOAEBBXUzYZw9CvSN+n2SVyFvKhB+7XciCpkvGajjoT5LuLOLkiEc4q//OyXYKzc7xfVpw1PJhb12CSXedTiCb2sw1NlJhN5URSFrwd/Dstsg7YbazA+zKBJe8acw==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.html 对应APPID下的支付宝公钥。
    private String alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAt4qCsS9U+9YF64+hPhEUF8C7+MFEPTsUAVi3oVD530btKEIDU2nwY2ss/xnwXe/a7t3+tfYJ1MWjOVnBJtEynS9Y3+icsys+e1scDo9BsvNqJTlwWWfRuiMoaQE9MJaz/+5wYxRMFPtSzbyevELBxgEupNetSuKLKIQSsSNzON84AiXSDcTIxTg6pBEyztPN66ChNztSLOB7xqRcAjtNTxkxN6aIFhpyMMDSFaZm5bSRdgnZK3WauhlNUR4y+I73o4ydqOZhVKnRZEYu9Pb5p18lkisNACz2KIsP+31ik1z0dSJKkg7n0u871GSZkpfYvIu3+4qBpcWbWlrYIUFMtQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    private String notifyUrl = "http://localhost:8088/order/list";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    private String returnUrl = "http://localhost:8088/order/list";

    // 签名方式
    private String signType  = "RSA2";

    // 字符编码格式
    private String charset  = "UTF-8";

    private String logPath;

    private String format  = "JSON";



//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */


    public void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(logPath + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getOpenApiDomain() {
        return openApiDomain;
    }

    public void setOpenApiDomain(String openApiDomain) {
        this.openApiDomain = openApiDomain;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMerchantPrivateKey() {
        return merchantPrivateKey;
    }

    public void setMerchantPrivateKey(String merchantPrivateKey) {
        this.merchantPrivateKey = merchantPrivateKey;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getLogPath() {
        return logPath;
    }

    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}

