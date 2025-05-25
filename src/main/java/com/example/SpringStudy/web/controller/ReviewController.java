package com.example.SpringStudy.web.controller;

import com.example.SpringStudy.apiPayload.ApiResponse;
import com.example.SpringStudy.converter.ReviewConverter;
import com.example.SpringStudy.domain.Review;
import com.example.SpringStudy.service.ReviewService.ReviewQueryService;
import com.example.SpringStudy.service.ReviewService.ReviewService;
import com.example.SpringStudy.service.StoreService.StoreQueryService;
import com.example.SpringStudy.validation.annotation.ExistMember;
import com.example.SpringStudy.validation.annotation.ExistStore;
import com.example.SpringStudy.validation.annotation.ValidPage;
import com.example.SpringStudy.web.dto.request.ReviewRequestDTO;
import com.example.SpringStudy.web.dto.response.ReviewResponseDTO;
import com.example.SpringStudy.web.dto.response.StoreReviewResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
@Validated
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewQueryService reviewQueryService;
    private final ReviewConverter reviewConverter;

    // storeId로 리뷰 조회
    @GetMapping("/{storeId}")
    @Operation(summary="특정 가게의 리뷰 목록 조회 API",description = "특정 가기의 리뷰 목록들을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistStore @PathVariable(name="storeId") Long storeId, @RequestParam(name = "page") Integer page) {
        Page<Review> reviewList =  reviewQueryService.getReviewList(storeId,page);

        return ApiResponse.onSuccess(reviewConverter.toReviewPreViewListDTO(reviewList));
    }

    // 리뷰 작성
    @PostMapping("/create")
    public ApiResponse<ReviewResponseDTO.CreateResultDTO> createReview(@RequestBody @Valid ReviewRequestDTO.CreateDTO request) {
        Review review = reviewService.createReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toCreateResultDTO(review));
    }

    // memberId와 page를 쿼리 파라미터로 받는 리뷰 조회
    @GetMapping("")
    @Operation(summary="특정 회원이 작성한 리뷰 목록 조회 API", description = "특정 회원이 작성한 리뷰 목록들을 조회하는 API, query string으로 page번호와 memberId 주세요")
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getReviewsByUser(@ValidPage @RequestParam(name = "page") Integer page, @ExistMember @RequestParam(name="memberId") Long memberId){
        Page<Review> reviewList =  reviewQueryService.getReviewsByUser(memberId,page);
        return ApiResponse.onSuccess(reviewConverter.toReviewPreViewListDTO(reviewList));
    }
}
