package com.sky.utils;

import java.io.IOException;
import java.net.URI;
import java.time.Duration;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Web client utils class.
 */
@Slf4j
public class WebClientUtil {

    static final int TIMEOUT_MSEC = 5 * 1000;

    /**
     * Send GET request.
     *
     * @param url      the url
     * @param paramMap the paramMap
     * @return response Body
     */
    public static <T> T doGet(final String url, final Map<String, String> paramMap, final Class<T> clazz) {
        // create web client
        final WebClient webClient = WebClient.create();

        T result = null;
        final ResponseEntity<T> responseEntity;

        try {
            final URIBuilder builder = new URIBuilder(url);
            if (paramMap != null) {
                for (final String key : paramMap.keySet()) {
                    builder.addParameter(key, paramMap.get(key));
                }
            }
            final URI uri = builder.build();

            // send request
            responseEntity = webClient.get()
                .uri(uri)
                .retrieve()
                .toEntity(clazz)
                .block();

            // validate response status
            if (HttpStatus.OK.equals(responseEntity.getStatusCode())) {
                result = responseEntity.getBody();
            }
        } catch (final Exception e) {
            log.error("Error doGet: {}", e.getMessage(), e);
        }

        return result;
    }

    /**
     * Send POST request.
     *
     * @param url
     * @param paramMap
     * @return
     * @throws IOException
     */
    public static String doPost(final String url, final Map<String, String> paramMap, final Object body) throws IOException {
        // create http client
        final WebClient webClient = WebClient.create();

        ResponseEntity<String> responseEntity = null;
        String resultString = null;

        try {
            // create http post request
            responseEntity = webClient.post()
                .uri(url)
                .headers(httpHeaders -> paramMap.forEach(httpHeaders::set))
                .bodyValue(body)
                .exchangeToMono(response ->
                    response.toEntity(String.class))
                .timeout(Duration.ofSeconds(TIMEOUT_MSEC))
                .block();

            resultString = responseEntity.getBody();
        } catch (final Exception e) {
            log.error("Error doPost: {}", e.getMessage(), e);
        }

        return resultString;
    }

    /**
     * 发送POST方式请求
     *
     * @param url
     * @param paramMap
     * @return
     * @throws IOException
     */
    public static String doPost4Json(final String url, final Map<String, String> paramMap) throws IOException {
        // 创建Httpclient对象
        final CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";

        try {
            // 创建Http Post请求
            final HttpPost httpPost = new HttpPost(url);

            if (paramMap != null) {
                //构造json格式数据
                final JSONObject jsonObject = new JSONObject();
                for (final Map.Entry<String, String> param : paramMap.entrySet()) {
                    jsonObject.put(param.getKey(), param.getValue());
                }
                final StringEntity entity = new StringEntity(jsonObject.toString(), "utf-8");
                //设置请求编码
                entity.setContentEncoding("utf-8");
                //设置数据类型
                entity.setContentType("application/json");
                httpPost.setEntity(entity);
            }

            httpPost.setConfig(builderRequestConfig());

            // 执行http请求
            response = httpClient.execute(httpPost);

            resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (final Exception e) {
            throw e;
        } finally {
            try {
                response.close();
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }

        return resultString;
    }

    private static RequestConfig builderRequestConfig() {
        return RequestConfig.custom()
            .setConnectTimeout(TIMEOUT_MSEC)
            .setConnectionRequestTimeout(TIMEOUT_MSEC)
            .setSocketTimeout(TIMEOUT_MSEC).build();
    }

}
