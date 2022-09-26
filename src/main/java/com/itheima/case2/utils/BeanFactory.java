package com.itheima.case2.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    private final static String DEFAULT_BEAN_FILE = "bean.properties";
    private final static Logger log = LoggerFactory.getLogger(BeanFactory.class);
    private static Map<String, Object> beanMap = new HashMap<>();

    static{
        Properties properties = new Properties();
        InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream(DEFAULT_BEAN_FILE);
        if(in != null){
            try{
                properties.load(in);
                for(Map.Entry<Object, Object> entry : properties.entrySet()){
                    Object obj = Class.forName(entry.getValue().toString()).newInstance();
                    beanMap.put(entry.getKey().toString(), obj);
                }
            }catch (Exception ex){
                log.debug("BeanFactory:{}", ex);
            }
        }
    }


    public static Object getBean(String beanName){
        log.info("get {}", beanName);
        return beanMap.get(beanName);
    }
}
