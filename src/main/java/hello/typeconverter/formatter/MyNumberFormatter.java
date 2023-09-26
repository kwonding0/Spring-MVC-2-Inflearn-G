package hello.typeconverter.formatter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Slf4j
public class MyNumberFormatter implements Formatter<Number> {
    @Override
    //Number 타입은 Integer , Long 과 같은 숫자 타입의 부모 클래스
    public Number parse(String text, Locale locale) throws ParseException {
        log.info("text={}, locale={}", text, locale);
        //"1,000" -> 1000
        //자바가 기본으로 제공하는 NumberFormat 객체를 사용하면 된다.
        //이 객체는 Locale 정보를 활용해서 나라별로 다른 숫자 포맷을 만들어준다.
        NumberFormat format = NumberFormat.getInstance(locale);
        //parse() 를 사용해서 문자를 숫자로 변환
        return format.parse(text);
    }

    @Override
    public String print(Number object, Locale locale) {
        log.info("object={}, locale={}", object, locale);
        //1000 -> "1,000"
        return NumberFormat.getInstance(locale).format(object);
    }
}
