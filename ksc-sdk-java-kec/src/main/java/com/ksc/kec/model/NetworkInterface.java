package com.ksc.kec.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Created by pengtong on 2021/4/12 10:28.
 */
@Data
@ToString
public class NetworkInterface {

    /**
     * VPC环境下的子网ID，绑定到辅网卡
     * 类型: String
     * 有效值：标准UUID格式，形如^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$
     * 是否可缺省: 否，创建辅网卡时必填
     */
    private String SubnetId;

    /**
     * 辅网卡绑定的安全组ID
     * 类型: String
     * 有效值：标准UUID格式，形如^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$
     * 是否可缺省: 是，此参数和SecurityGroupIds必须传一个，若传此参数，则SecurityGroupIds参数无效
     */
    private String SecurityGroupId;

    /**
     * 辅网卡的私有IP地址，指定子网IP地址范围内的任意有效值，代表实例的辅IP地址，只能选择一个，绑定到对应辅网卡；如果未指定该参数，系统自动从有效地址池中随机选取一个
     * 类型: String
     * 有效值：标准IP地址格式
     * 是否可缺省: 是
     */
    private String PrivateIpAddress;

    /**
     * 辅网卡绑定的多个安全组ID
     * 类型: 列表
     * 有效值：标准UUID格式，形如^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$
     * 是否可缺省: 是，此参数和SecurityGroupId必须传一个
     */
    private List<String> SecurityGroupIds;

    public NetworkInterface withSecurityGroupIds(
            String... sgs) {
        if (this.SecurityGroupIds == null) {
            setSecurityGroupIds(new com.ksc.internal.SdkInternalList<String>());
        }
        for (String s : sgs) {
            SecurityGroupIds.add(s);
        }
        return this;
    }
}

