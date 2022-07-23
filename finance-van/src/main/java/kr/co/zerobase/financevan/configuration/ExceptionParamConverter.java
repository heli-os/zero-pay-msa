package kr.co.zerobase.financevan.configuration;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author Heli
 */
public class ExceptionParamConverter {

    public static String convert(Map<String, Object> param) {
        return param.keySet().stream()
                .map((key) -> String.format("%s=%s", key, param.get(key)))
                .collect(Collectors.joining(","));
    }
}
