package hello.typeconverter.formatter;

import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

import static org.assertj.core.api.Assertions.*;

public class FormattingConversionServiceTest {
    @Test
    void formattingConversionService() {
        // 포맷터와 컨버터 둘 다 등록 가능
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();

        // 컨버터 등록
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        // 포맷터 등록
        conversionService.addFormatter(new MyNumberFormatter());

        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));

        String numberToString = conversionService.convert(1000, String.class);
        assertThat(numberToString).isEqualTo("1,000");

        Integer stringToNumber = conversionService.convert("1,000", Integer.class);
        assertThat(stringToNumber).isEqualTo(1000);

        Integer stringToNumber2 = conversionService.convert("1000", Integer.class);
        assertThat(stringToNumber2).isEqualTo(1000);
    }
}
