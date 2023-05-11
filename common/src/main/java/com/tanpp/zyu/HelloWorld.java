package com.tanpp.zyu;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

/**
 * Author: shaoff
 * Date: 2022/3/14 22:11
 * Description:
 */
public class HelloWorld {
    public static void main(String[] args) {
        InputStream in = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("redis.yaml");
        //Scanner scanner = new Scanner(in);

        /*String ip=scanner.nextLine();
        int port=scanner.nextInt();
        Jedis jedis=new Jedis(ip,port);*/

        Map<String,Object> res= new Yaml().load(in);
        Map<String,Object> params= (Map<String, Object>) res.get("jedis");
        String ip=String.valueOf(params.get("ip"));
        System.out.println(ip);
    }
}
