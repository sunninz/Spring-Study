package com.example.SpringStudy;

import com.example.SpringStudy.service.MemberService.MemberService;
import com.example.SpringStudy.service.MissionService.MissionQueryService;
import com.example.SpringStudy.service.StoreService.StoreQueryService;
import com.example.SpringStudy.web.dto.HomeReponseDto;
import com.example.SpringStudy.web.dto.MemberInfoDto;
import com.example.SpringStudy.web.dto.MyMissionResponseDto;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class SpringStudyApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.load();

		System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
		System.setProperty("DB_NAME", dotenv.get("DB_NAME"));

		SpringApplication.run(SpringStudyApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			StoreQueryService storeQueryService = context.getBean(StoreQueryService.class);

			/**
			 *  store 조회
			 */
			// 파라미터 값 설정
			String name = "요아정";
			Float score = 4.0f;

			// 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
			System.out.println("Executing findStoresByNameAndScore with parameters:");
			System.out.println("name = " + name);
			System.out.println("score = " + score);

			storeQueryService.findStoresByNameAndScore(name, score)
					.forEach(System.out::println);

			/**
			 * mission no.4 meber info 조회
			 */
			// member 조회
			MemberService memberService = context.getBean(MemberService.class);

			Long memberId = 1L;

			System.out.println("Executing getMemberInfo with parameter:");
			System.out.println("memberId = " + memberId);

			MemberInfoDto dto = memberService.getMemberInfo(memberId);
			System.out.println(dto != null ? dto : "No member found.");

			/**
			 * mission no.3 홈 내역 조회
			 */
			MissionQueryService missionQueryService = context.getBean(MissionQueryService.class);
			Long targetMemberId = 4L;

			HomeReponseDto home = missionQueryService.getHomeMissionByMemberId(targetMemberId);

			System.out.println("===== HOME INFO =====");
			System.out.println("Region: " + home.getRegionName());
			System.out.println("Point: " + home.getPoint());
			System.out.println("Completed Missions: " + home.getCompletedMissionCount());

			System.out.println("----- My Missions -----");
			home.getMissions().forEach(System.out::println);


		};
	}
}
