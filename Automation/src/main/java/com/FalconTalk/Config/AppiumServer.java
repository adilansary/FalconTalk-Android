package com.FalconTalk.Config;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.HashMap;

public class AppiumServer {

    static AppiumDriverLocalService server;

    public static void Start(){
        if(isPortAvailable(4723)){
            getInstance().start();
            System.out.println("Server started from here!");
        }else
            System.out.println("Server already running!");
    }

    static AppiumDriverLocalService getInstance(){
        if(server == null){
            setInstance();
            server.clearOutPutStreams(); //stop printing appium logs to console
        }
        return server;
    }

    static void setInstance(){
        HashMap<String, String> environment = new HashMap<String, String>();
        //path to carthage
        environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));

        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder
                .withAppiumJS(new File("C:\\Users\\User\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
                //.usingAnyFreePort()
                //.withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withEnvironment(environment)
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                //.withArgument(GeneralServerFlag.LOG_LEVEL, "WARN")
                .withLogFile(new File("AppiumLog.txt"));

        server = AppiumDriverLocalService.buildService(builder);
    }

    /*boolean checkIfServerIsRunning(int port) {
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }*/

    public static boolean isPortAvailable(int port) {
        //applicable for tcp ports
        try (ServerSocket serverSocket = new ServerSocket()) {
            // setReuseAddress(false) is required only on OSX,
            // otherwise the code will not work correctly on that platform
            serverSocket.setReuseAddress(false);
            serverSocket.bind(new InetSocketAddress(InetAddress.getByName("localhost"), port), 1);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }


    public static void Stop(){
        if(server != null){
            getInstance().stop();
            System.out.println("Appium server stopped!");
        }
        /*Runtime runtime = Runtime.getRuntime();
        try {
            //runtime.exec("taskkill /F /IM node");
            String[] command={"/usr/bin/killall", "-9", "node" };
            runtime.exec(command);
            //runtime.exec("/usr/bin/killall node");
            System.out.println("Server stopped!");
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }

    public static void main(String[] args) throws InterruptedException {
        AppiumServer.Start();
        Thread.sleep(2000);
        AppiumServer.Stop();
    }

}