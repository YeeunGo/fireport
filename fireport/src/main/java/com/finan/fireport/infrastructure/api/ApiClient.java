package com.finan.fireport.infrastructure.api;

import com.finan.fireport.exception.BadRequestException;
import com.finan.fireport.exception.ErrorCode;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ApiClient {
    private static final String PATH_REQUIRED_MESSAGE = "PATH 파라미터는 필수값입니다";
    private static final String CLIENT_ERROR_MESSAGE = "클라이언트 에러입니다.";
    private static final String SERVER_ERROR_MESSAGE = "서버 에러입니다.";
    private static final String SETTLEMENT_PATH = "/open-api/settlement/queries";

    private static final Integer BUFFER_MAX_SIZE = 10 * 1024 * 1024; // 10M

    private final WebClient webClient;

    @Value("${open-api.base-url.http}")
    private String OPEN_API_BASE_URL;

    public ApiClient() {
        webClient = WebClient.builder().build();
    }


//    private ResponseSpec createGetRequest(String path) {
//        if (StringUtil.isNullOrEmpty(path)) {
//            throw new BadRequestException(ErrorCode.BAD_REQUEST, PATH_REQUIRED_MESSAGE);
//        }
//        return webClient
//                .get()
//                .uri(OPEN_API_BASE_URL + path)
//                .retrieve()
//                .onStatus(HttpStatus::is4xxClientError, response -> {
//                    throw new BadRequestException(ErrorCode.BAD_REQUEST, CLIENT_ERROR_MESSAGE);
//                })
//                .onStatus(HttpStatus::is5xxServerError, response -> {
//                    throw new BadRequestException(ErrorCode.BAD_REQUEST, SERVER_ERROR_MESSAGE);
//                });
//    }

//    public Boolean checkSettlementRegistered(SettlementCheckRequestDto settlementCheckRequestDto) {
//        SettlementCheckResponseDto settlementResponse = createPostRequest(SETTLEMENT_PATH, settlementCheckRequestDto)
//                .bodyToMono(settlementCheckResponseDto.class)
//                .block();
//        return settlementResponse.registered();
//    }
}