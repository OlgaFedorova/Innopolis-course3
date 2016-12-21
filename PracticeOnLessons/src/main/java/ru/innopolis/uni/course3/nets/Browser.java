package ru.innopolis.uni.course3.nets;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.Scanner;

/**
 * Created by Olga on 21.12.2016.
 */
public class Browser {

    public static void main(String[] args) throws IOException {

        System.out.println("Input URL:");
        Scanner scanner = new Scanner(System.in);
        String urlAdress = scanner.next();
        scanner.close();

        System.out.println();
        System.out.println("URL:");

        URL.setURLStreamHandlerFactory(new URLStreamHandlerFactory() {
            @Override
            public URLStreamHandler createURLStreamHandler(String protocol) {
                if ("file".equals(protocol)) {
                    return new sun.net.www.protocol.file.Handler();
                } else if ("http".equals(protocol)) {
                    return new sun.net.www.protocol.http.Handler();
                } else if ("d".equals(protocol)) {
                    return new sun.net.www.protocol.file.Handler();
                } else if ("classpath".equals(protocol)) {
                    return new URLStreamHandler() {
                        @Override
                        protected URLConnection openConnection(URL u) throws IOException {
                            return new URLConnection(u) {
                                @Override
                                public void connect() throws IOException {
                                }

                                @Override
                                public InputStream getInputStream() throws IOException {
                                    // получаю строку classpath
                                    final String classPath = System.getProperty("java.class.path", ".");

                                    // получаю папки из classpath
                                    final String[] classPathElements = classPath.split(System.getProperty("path.separator"));

                                    // имя файла, который будем искать
                                    String fileName = getURL().getFile();

                                    // пробегаю каждую папку и ищу файл
                                    for (final String path : classPathElements) {
                                        File file = new File(path, fileName);
                                        // первый найденный файл возвращаю
                                        if (file.exists())
                                            return new FileInputStream(file);
                                    }

                                    // в classpath такой файл не найден
                                    return null;
                                }
                            };
                        }

                    };
                };
                return null;
            }
        });

        URL url = new URL(urlAdress);
        try (BufferedReader readerURL = new BufferedReader(new InputStreamReader(url.openStream()));) {
            String stringRead = "";
            while (stringRead != null) {
                stringRead = readerURL.readLine();
                System.out.println(stringRead);
            }
        }
    }

}
