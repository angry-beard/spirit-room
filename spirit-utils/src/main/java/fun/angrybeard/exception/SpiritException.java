package fun.angrybeard.exception;

public class SpiritException extends RuntimeException {

    private static final long serialVersionUID = -1814878190103898946L;
    private int httpStatus;
    private int code;
    private String developerMessage;
    private String errorLevel;

    SpiritException(int httpStatus, int code, String message) {
        super(message);
        this.errorLevel = SpiritException.ErrorLevel.FATAL.getValue();
        this.httpStatus = httpStatus;
        this.code = code;
    }

    SpiritException(int httpStatus, int code, String message, SpiritException.ErrorLevel errorLevel) {
        super(message);
        this.errorLevel = SpiritException.ErrorLevel.FATAL.getValue();
        this.httpStatus = httpStatus;
        this.code = code;
        this.errorLevel = errorLevel.getValue();
    }

    SpiritException(int httpStatus, int code, String message, String developerMessage) {
        super(message);
        this.errorLevel = SpiritException.ErrorLevel.FATAL.getValue();
        this.httpStatus = httpStatus;
        this.code = code;
        this.developerMessage = developerMessage;
    }

    SpiritException(int httpStatus, int code, String message, Throwable cause) {
        super(message, cause);
        this.errorLevel = SpiritException.ErrorLevel.FATAL.getValue();
        this.httpStatus = httpStatus;
        this.code = code;
    }

    SpiritException(int httpStatus, int code, String message, SpiritException.ErrorLevel errorLevel, Throwable cause) {
        super(message, cause);
        this.errorLevel = SpiritException.ErrorLevel.FATAL.getValue();
        this.httpStatus = httpStatus;
        this.code = code;
        this.errorLevel = errorLevel.getValue();
    }

    SpiritException(int httpStatus, int code, String message, String developerMessage, Throwable cause) {
        super(message, cause);
        this.errorLevel = SpiritException.ErrorLevel.FATAL.getValue();
        this.httpStatus = httpStatus;
        this.code = code;
        this.developerMessage = developerMessage;
    }

    SpiritException(int httpStatus, int code, String message, String developerMessage, SpiritException.ErrorLevel errorLevel) {
        super(message);
        this.errorLevel = SpiritException.ErrorLevel.FATAL.getValue();
        this.httpStatus = httpStatus;
        this.code = code;
        this.developerMessage = developerMessage;
        this.errorLevel = errorLevel.getValue();
    }

    SpiritException(int httpStatus, int code, String message, String developerMessage, SpiritException.ErrorLevel errorLevel, Throwable cause) {
        super(message, cause);
        this.errorLevel = SpiritException.ErrorLevel.FATAL.getValue();
        this.httpStatus = httpStatus;
        this.code = code;
        this.developerMessage = developerMessage;
        this.errorLevel = errorLevel.getValue();
    }

    public int getCode() {
        return this.code;
    }

    public int getHttpStatus() {
        return this.httpStatus;
    }

    public String getDeveloperMessage() {
        return this.developerMessage;
    }

    public String getErrorLevel() {
        return this.errorLevel;
    }

    public static enum ErrorLevel {
        WEAK("-1"),
        NORMAL("0"),
        FATAL("1");

        private String value;

        private ErrorLevel(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }
}
