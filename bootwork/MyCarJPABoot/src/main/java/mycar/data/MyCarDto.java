package mycar.data;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mycar")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyCarDto {
	
	@Id		// 각 엔터티를 구별할 수 있도록 식별 아이디를 갖도록 설계
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	
	@Column(name = "carname", length = 30)
	private String carname;
	
	private int carprice;
	
	@Column(length = 20)
	private String carcolor;
	
	@Column(length = 30)	// length 생략 시 255
	private String carguip;
	
	@Column(length = 100)
	private String carphoto;
	
	@Column(updatable = false)	// 수정 시 컬럼 제외
	@CreationTimestamp
	private Timestamp writeday;
	
	@Transient
	private int commentcount;
	
	@Transient
	private String message;
}
