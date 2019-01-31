package com.johnny.study.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Component
// @ConfigurationProperties는 application.properties에 위치하는 값들을 읽음
@ConfigurationProperties("holo") // 인자로 prefix 지정자를 받는다.
@Validated // 외부 설정 값에 대한 검증을 자동적으로 수행할 수 있는데, 이를 이용해 properties 파일의 값들을 검증할 수 있다.
public class HolomanProperties {

    // properties 파일의 값들을 읽어들일 때 클래스에서 선언한 변수 타입에 맞춰 타입 변환(Type Conversion)이 일어난다.

    /*
    @NotEmpty // null 값을 허용하지 않는 어노테이션이다. @Validated 어노테이션과 함께 사용할 수 있다.
    private String name;
    */

    private String name; // prefix 지정자 때문에 holo.name을 프로퍼티 파일에서 읽어온다.

    private int howLong; // holo.how-long

    private String fullName; // holo.full-name

    // 자동 타입 변환 중 DurationUnit을 통한 타입 변환이다.
    // Properties에 시간과 관련된 설정값을 입력할 경우 자동적으로 DurationUnit에 지정한 시간 단위로 변환해준다.
    @DurationUnit(ChronoUnit.SECONDS)
    private Duration sessionTimeout = Duration.ofSeconds(30); // properties에서 값을 읽어오지 못하면 30초로 초기화한다.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHowLong() {
        return howLong;
    }

    public void setHowLong(int howLong) {
        this.howLong = howLong;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
