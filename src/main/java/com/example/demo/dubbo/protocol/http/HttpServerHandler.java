package com.example.demo.dubbo.protocol.http;

import com.example.demo.dubbo.framework.Invocation;
import com.example.demo.dubbo.framework.URL;
import com.example.demo.dubbo.registry.Register;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HttpServerHandler extends HttpServlet {

    public void handler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NoSuchMethodException {

        try {
            InputStream inputStream = req.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            Invocation invocation = (Invocation) ois.readObject();

            //找接口对应接口
            String interfaceName = invocation.getInterfaceName();
            URL url = new URL("localhost", 8080);
            Class implClass = Register.get(url, interfaceName);
            Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());
            String result = (String) method.invoke(implClass.newInstance(), invocation.getParams());

            OutputStream outputStream = resp.getOutputStream();
            IOUtils.write(result, outputStream);
        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
