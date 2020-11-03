package com.example.demo.dubbo.registry;

import com.example.demo.dubbo.framework.URL;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Register {

    private static Map<String,Map<URL,Class>> REGISTER = new HashMap<String,Map<URL,Class>>();
    public static void register(URL url,String interfaceName,Class implClass){
      Map<URL,Class> map = new HashMap<URL,Class>();
      map.put(url,implClass);
      REGISTER.put(interfaceName,map);
      saveFile();
    }

    private static void saveFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("D://register.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(REGISTER);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Class get(URL url ,String interfaceName){
        REGISTER = getFile();
        return REGISTER.get(interfaceName).get(url);
    }

    private static Map<String,Map<URL,Class>> getFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("D://register.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Map<String, Map<URL, Class>>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static URL get(String interfaceName){
      return null;
    }

    public static URL random(String interfaceName){
        REGISTER = getFile();
        return REGISTER.get(interfaceName).keySet().iterator().next();
    }
}
