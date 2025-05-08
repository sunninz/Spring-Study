package com.example.SpringStudy;

import com.example.SpringStudy.service.MemberService.MemberService;
import com.example.SpringStudy.service.StoreService.StoreQueryService;
import com.example.SpringStudy.web.dto.MemberInfoDto;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

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

			// 파라미터 값 설정
			String name = "요아정";
			Float score = 4.0f;

			// 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
			System.out.println("Executing findStoresByNameAndScore with parameters:");
			System.out.println("name = " + name);
			System.out.println("score = " + score);

			storeQueryService.findStoresByNameAndScore(name, score)
					.forEach(System.out::println);

			// member 조회
			MemberService memberService = context.getBean(MemberService.class);

			Long memberId = 1L;

			System.out.println("Executing getMemberInfo with parameter:");
			System.out.println("memberId = " + memberId);

			MemberInfoDto dto = memberService.getMemberInfo(memberId);
			System.out.println(dto != null ? dto : "No member found.");
		};
	}
}
