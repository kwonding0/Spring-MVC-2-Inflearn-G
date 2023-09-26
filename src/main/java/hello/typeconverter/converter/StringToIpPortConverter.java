package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class StringToIpPortConverter implements Converter<String, IpPort> {
    @Override
    public IpPort convert(String source) {
        log.info("convert source={}", source);
        //127.0.0.1:8080
        String[] ipPort = source.split(":");
        String ip = ipPort[0];
        int port = Integer.parseInt(ipPort[1]);
        return new IpPort(ip, port);
    }
}
