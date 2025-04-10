package com.finan.fireport.infrastructure.api;

import com.finan.fireport.dto.response.FinancialSummaryResponseDto;
import com.finan.fireport.exception.BadRequestException;
import com.finan.fireport.exception.ErrorCode;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Slf4j
@Service
public class ApiClient_backup {
    private static final String PATH_REQUIRED_MESSAGE = "PATH 파라미터는 필수값입니다";
    private static final String CLIENT_ERROR_MESSAGE = "클라이언트 에러입니다.";
    private static final String SERVER_ERROR_MESSAGE = "서버 에러입니다.";
    //private static final String SETTLEMENT_PATH = "/open-api/settlement/queries";

    // 요약재무제표
    private static final String FI_SUMMARY_PATH = "/GetFinaStatInfoService_V2/getSummFinaStat_V2";
    // 종목정보
    private static final String STOCK_INFO_PATH = "/GetKrxListedInfoService/getItemInfo";
    // 주식발행내역조회
    private static final String STOCK_ISSUE_PATH = "/GetStocIssuInfoService_V2/getStocIssuInfo_V2";
    // 주식 시세
    private static final String STOCK_MARKET_INFO_PATH = "/GetStockSecuritiesInfoService/getStockPriceInfo";

    //private static final Integer BUFFER_MAX_SIZE = 10 * 1024 * 1024; // 10M

    private final WebClient webClient;
    private final Bucket bucket;

    @Value("${open-api.base-url}")
    private String OPEN_API_BASE_URL;

    public ApiClient_backup() {

        // TIMEOUT : 10초로 제약
        HttpClient httpClient = HttpClient.create()
                .responseTimeout(Duration.ofSeconds(10));

        webClient = WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();

        // 하루 10,000회 호출 제한
        this.bucket = Bucket.builder()
                .addLimit(Bandwidth.simple(10000, Duration.ofDays(1)))  // 1일 10,000회
                .build();
    }

    private ResponseSpec createGetRequest(String path) {

        if (StringUtil.isNullOrEmpty(path)) {
            throw new BadRequestException(ErrorCode.BAD_REQUEST, PATH_REQUIRED_MESSAGE);
        }
        return webClient
                .get()
                .uri(OPEN_API_BASE_URL + path)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> {
                    throw new BadRequestException(ErrorCode.BAD_REQUEST, CLIENT_ERROR_MESSAGE);
                })
                .onStatus(HttpStatusCode::is5xxServerError, response -> {
                    throw new BadRequestException(ErrorCode.BAD_REQUEST, SERVER_ERROR_MESSAGE);
                });
                }

//        public Boolean checkSettlementRegistered(SettlementCheckRequestDto settlementCheckRequestDto) {
//            SettlementCheckResponseDto settlementResponse = createPostRequest(SETTLEMENT_PATH, settlementCheckRequestDto)
//                    .bodyToMono(settlementCheckResponseDto.class)
//                .block();
//        return settlementResponse.registered();
//    }

//    // 요약재무제표
//    public Mono<FinancialSummaryResponseDto> getFinancialSummary {
//        return mo
//    }
    // 종목정보

    // 주식발행내역조회

    // 주식 시세


}