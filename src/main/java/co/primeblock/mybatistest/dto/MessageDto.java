package co.primeblock.mybatistest.dto;

import java.sql.Timestamp;
// import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor // 자동으로 모든 매개변수를 받는 생성자를 생성
@Getter // Getter 생성
@Setter // Setter 생성
public class MessageDto {
    private int id;
    private String text;
    private Timestamp createdDate;

    public MessageDto() {}

    public MessageDto(String text) {
        this.text = text;
        this.createdDate = new Timestamp(System.currentTimeMillis());
    }
}
