package com.fc.demo1._jdk;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class Client {
    @Test
    public void  test(){
        //真实对象
        Parties parties = new Parties();
        
        //律师事务所
        LowOffice handler = new LowOffice(parties);

        //获取代理对象
        Lawsuit proxy = (Lawsuit) Proxy.newProxyInstance(parties.getClass().getClassLoader(),
                parties.getClass().getInterfaces(),
                handler);

        proxy.submit();
        proxy.defend();
    }
}
