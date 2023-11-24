package mini.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BoardAnswerDto {
	private int ansidx;
	private String ansname;
	private String ansid;
	private String ansphoto;
	private String ansmsg;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
	private Timestamp writeday;
}
