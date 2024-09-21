package consts;

public enum FullExchangeNameEnum {

    NASDAQ_G5("NasdaqG5", "Nasdaq Fifth Generation Market Data System"),
    NYSE("NYSE", "New York Stock Exchange"),
    AMEX("AMEX", "American Stock Exchange"),

    LSE("LSE", "London Stock Exchange"),
    Euronext("Euronext", "Pan-European Stock Exchange"),
    SIX("SIX", "Swiss Exchange"),

    TSE("TSE", "Tokyo Stock Exchange"),
    HKEX("HKEX", "Hong Kong Exchange"),
    SSE("SSE", "Shanghai Stock Exchange"),
    BSE("BSE", "Bombay Stock Exchange"),

    ASX("ASX", "Australian Securities Exchange"),

    JSE("JSE", "Johannesburg Stock Exchange");

    private final String code;
    private final String description;

    FullExchangeNameEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return code + " (" + description + ")";
    }
}
