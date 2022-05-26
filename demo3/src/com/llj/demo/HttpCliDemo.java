package com.llj.demo;

import java.io.IOException;
import java.net.Authenticator;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpConnectTimeoutException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

/**
 * @author llj
 * @date 2022/05/05
 */
public class HttpCliDemo {
  public static void main(String[] args) throws IOException, InterruptedException {
//    创建新的HttpClient
//    返回具有默认设置的HttpClient（实际返回HttpClient的子类）
      HttpClient client = HttpClient.newHttpClient();
//    返回新的HttpClient（HttpClient.Builder为HttpClient的接口，返回其实现类）
      HttpClient.Builder builder = HttpClient.newBuilder();
      HttpClient build = HttpClient.newBuilder()
                                   .version(HttpClient.Version.HTTP_1_1)
                                   .followRedirects(HttpClient.Redirect.NORMAL)
                                   .connectTimeout(Duration.ofSeconds(20))
//                                   .proxy(ProxySelector.of()) //代理地址和端口
                                   .authenticator(Authenticator.getDefault())
                                   .build();

    /*
       创建请求，可以发送多个请求
     */
    HttpRequest request =  HttpRequest.newBuilder().uri(URI.create("https://www.baidu.com")).build();
    HttpRequest request2 =  HttpRequest.newBuilder().uri(URI.create("https://www.bilibili.com"))
      .timeout(Duration.ofSeconds(20)).header("Content-type","application/json")
      .POST(HttpRequest.BodyPublishers.ofFile(Paths.get("data.json"))).build();

//    发出同步请求，接收响应
//    BodyHandler确定如何响应主体
    HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
    System.out.println(response.body());

//    发送异步请求
   client.sendAsync(request2, HttpResponse.BodyHandlers.ofString())
            .thenApply(HttpResponse::body).thenAccept(System.out::println).join();


  }
}
