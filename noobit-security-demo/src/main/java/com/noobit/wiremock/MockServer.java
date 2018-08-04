package com.noobit.wiremock;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;


public class MockServer {
    public static void main(String[] args) {
        configureFor(8062);
        removeAllMappings();

        mock("/order/1", "order.txt");
        mock("/user/2", "user.txt");
    }

    private static void mock(String url, String filename) {
        ClassPathResource resource = new ClassPathResource("/mock/response/" + filename);
        String fileString = null;
        try {
            fileString = FileUtils.readFileToString(resource.getFile(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        stubFor(get(urlPathEqualTo(url)).willReturn(aResponse().withBody(fileString).withStatus(200)));
    }
}
