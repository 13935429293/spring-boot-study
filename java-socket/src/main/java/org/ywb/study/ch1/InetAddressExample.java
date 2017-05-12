package org.ywb.study.ch1;

import java.net.*;
import java.util.Enumeration;

/**
 * User: yangwenbiao
 * Date: 2017/3/13
 * Time: 15:02
 */
public class InetAddressExample {

    public static void main(String[] args) {
        try {
            // 静态方法getNetworkInterfaces()返回一个列表，其中包含了该主机每一个接口所对应的NetworkInterface类实例。
            Enumeration<NetworkInterface> interfaceList = NetworkInterface.getNetworkInterfaces();

            if (interfaceList == null) {
                System.out.println("--No interfaces found--");
            } else {
                while (interfaceList.hasMoreElements()) {
                    NetworkInterface iface = interfaceList.nextElement();
                    System.out.println("Interface " + iface.getName() + ":");
                    Enumeration<InetAddress> addrList = iface.getInetAddresses();
                    if (addrList.hasMoreElements()) {
                        InetAddress address = addrList.nextElement();
                        System.out.print("\tAddress " + ((address instanceof Inet4Address ? "(v4)" : (address instanceof Inet6Address ? "(v6)" : "(?)"))));
                        System.out.println(": " + address.getHostAddress());
                    }
                }
            }

        } catch (SocketException se) {
            System.out.println("Error getting network interfaces:" + se.getMessage());
        }

        for (String host : args) {
            try {
                System.out.println(host + ":");
                InetAddress[] addressList = InetAddress.getAllByName(host);
                for (InetAddress address : addressList) {
                    System.out.println("\t" + address.getHostName() + "/" + address.getHostAddress());
                }
            } catch (UnknownHostException e) {
                System.out.println("\tUnable to find address for " + host);
            }
        }
    }
}
