package edu.pnu.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.micrometer.common.lang.NonNull;

@Configuration
public class CustomConfig implements WebMvcConfigurer{
	@Override
	public void addCorsMappings(@NonNull CorsRegistry registry) {
		// 기본 형태
		registry.addMapping("/**")					// 모든 주소에 대해서
			.allowedMethods(CorsConfiguration.ALL)  // 모든 Method에 대해서
			.allowedOrigins(CorsConfiguration.ALL); // 모든 Origin에 대해서
		
//		// 확장 형태
//		registry.addMapping("/board/**")		// board 하위 주소에 대해서
//			.allowedMethods(HttpMethod.GET.name(), // GET, POST Method에 대해서
//							HttpMethod.POST.name())
//			.allowedOrigins("http://localhost:3000", "http://127.0.0.1:3000");
//		
//		registry.addMapping("/member/**")		// member 하위 주소에 대해서
//		.allowedMethods(HttpMethod.GET.name(), // GET, PUT Method에 대해서
//						HttpMethod.PUT.name())
//		.allowedOrigins("http://localhost:3000");
		
//		//Authorization 필요한 경우
//		registry.addMapping("/**")
//		.allowCredentials(true)						// 클라이언트가 자격증명(쿠키/인증헤더)을 포함하도록 허용
//		.allowedHeaders(HttpHeaders.AUTHORIZATION)  // 클라이언트 요청 시 사용할 수 있는 헤더 지정
//		.exposedHeaders(HttpHeaders.AUTHORIZATION)  // 클라이언트가 응답에 접근할 수 있는 헤더 지정
//		.allowedMethods(HttpMethod.GET.name(),		// 클라이언트가 요청 시 사용할 수 있는 method지정
//						HttpMethod.POST.name(),
//						HttpMethod.PUT.name(),
//						HttpMethod.DELETE.name())
//		.allowedOrigins("http://localhost:3000",	// CORS요청을 허용할 출처 지정
//						"http://127.0.0.1:3000");
						
	}
	
}
