package com.example.demo.wiremock;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.removeAllMappings;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;

import java.io.IOException;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;

/**
 * @Auther: Allen
 * @Date: 2018/12/18 09:17
 * @Description:
 */
public class MockServer {

    public static void main(String[] args) throws IOException {
        WireMock.configureFor(8088);
//        removeAllMappings();
//           mock("/options/Index/priceIndex/BTC_USDT", "1");
//        mock("/options/Index/priceIndex/BTC_USDT2", "2");
        mock("/api.huobipro.com/market/history/kline", "2");
        mock("/api.huobipro.com/market/history/kline?period=60min&size=30&symbol=btcusdt", "3");
        mock("/wanghonghui", "4");
    }

    private static void mock(String url, String file) throws IOException {
        ClassPathResource resource = new ClassPathResource("mock/response/" + file + ".txt");
        String content = StringUtils.join(FileUtils.readLines(resource.getFile(), "UTF-8").toArray(), "\n");
        stubFor(get(urlPathEqualTo(url)).willReturn(aResponse().withBody(content).withStatus(200)));
    }
}
