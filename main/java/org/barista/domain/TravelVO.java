package org.barista.domain;

import lombok.Data;

@Data
public class TravelVO {

	private Long no; // 게시판 번호(PK)
	private String region; // 권역
	private String title; // 제목(관광지명)
	private String description; // 설명(관광지 설명)
	private String address; // 주소
	private String phone; // 전화번호
}

/*

@Data

- @Getter, @Setter, @RequiredArgsConstructor,
 	@ToString, @EqualsAndHashCode를 한꺼번에 설정

*/