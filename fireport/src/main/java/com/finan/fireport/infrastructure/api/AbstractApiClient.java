package com.finan.fireport.infrastructure.api;

import com.finan.fireport.exception.BadRequestException;
import com.finan.fireport.exception.ErrorCode;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.ConsumptionProbe;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import reactor.netty.http.client.HttpClient;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;

import java.time.Duration;

@Slf4j
public abstract class AbstractApiClient {

    private static final String PATH_REQUIRED_MESSAGE = "PATH 파라미터는 필수값입니다";
    private static final String CLIENT_ERROR_MESSAGE = "클라이언트 에러입니다.";
    private static final String SERVER_ERROR_MESSAGE = "서버 에러입니다.";
    private static final String RATE_LIMIT_MESSAGE = "API 호출 한도를 초과했습니다.";
    private final WebClient webClient;
    private final Bucket bucket;

    @Value("${open-api.base-url}")
    private String OPEN_API_BASE_URL;

    public AbstractApiClient() {
        HttpClient httpClient = HttpClient.create()
                .responseTimeout(Duration.ofSeconds(10));

        this.webClient = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();

        this.bucket = Bucket.builder()
                .addLimit(Bandwidth.simple(10000, Duration.ofDays(1)))
                .build();
    }

    protected ResponseSpec createGetRequest(String path, String param) {

        ConsumptionProbe probe = bucket.tryConsumeAndReturnRemaining(1);

        if (!probe.isConsumed()) {
            throw new BadRequestException(ErrorCode.BAD_REQUEST, RATE_LIMIT_MESSAGE);
        }

        if (StringUtil.isNullOrEmpty(path)) {
            throw new BadRequestException(ErrorCode.BAD_REQUEST, PATH_REQUIRED_MESSAGE);
        }
        return webClient
                .get()
                .uri(OPEN_API_BASE_URL + path +param)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> {
                    throw new BadRequestException(ErrorCode.BAD_REQUEST, CLIENT_ERROR_MESSAGE);
                })
                .onStatus(HttpStatusCode::is5xxServerError, response -> {
                    throw new BadRequestException(ErrorCode.BAD_REQUEST, SERVER_ERROR_MESSAGE);
                });
    }
}
