package fun.angrybeard.exception;

import org.springframework.http.HttpStatus;

public class SpiritClientException extends SpiritException {

    private static final long serialVersionUID = 3085285512947095704L;

    public SpiritClientException() {
        super(HttpStatus.UNPROCESSABLE_ENTITY.value(), 1005, "您的操作有误，重新试试吧");
    }

    public SpiritClientException(Throwable cause) {
        super(HttpStatus.UNPROCESSABLE_ENTITY.value(), 1005, "您的操作有误，重新试试吧", cause);
    }

    public SpiritClientException(int httpStatus) {
        super(httpStatus, 1005, "您的操作有误，重新试试吧");
    }

    public SpiritClientException(int httpStatus, int code, String message) {
        super(httpStatus, code, message);
    }

    public SpiritClientException(int httpStatus, int code, String message, Throwable cause) {
        super(httpStatus, code, message, cause);
    }

    public SpiritClientException(int code, String message) {
        super(HttpStatus.UNPROCESSABLE_ENTITY.value(), code, message);
    }

    public SpiritClientException(int code, String message, ErrorLevel errorLevel) {
        super(HttpStatus.UNPROCESSABLE_ENTITY.value(), code, message, errorLevel);
    }

    public SpiritClientException(int code, String message, String developerMessage) {
        super(HttpStatus.UNPROCESSABLE_ENTITY.value(), code, message, developerMessage);
    }

    public SpiritClientException(int code, String message, Throwable cause) {
        super(HttpStatus.UNPROCESSABLE_ENTITY.value(), code, message, cause);
    }

    public SpiritClientException(int code, String message, ErrorLevel errorLevel, Throwable cause) {
        super(HttpStatus.UNPROCESSABLE_ENTITY.value(), code, message, errorLevel, cause);
    }

    public SpiritClientException(int code, String message, String developerMessage, Throwable cause) {
        super(HttpStatus.UNPROCESSABLE_ENTITY.value(), code, message, developerMessage, cause);
    }

    public SpiritClientException(int code, String message, String developerMessage, ErrorLevel errorLevel) {
        super(HttpStatus.UNPROCESSABLE_ENTITY.value(), code, message, developerMessage, errorLevel);
    }

    public SpiritClientException(int code, String message, String developerMessage, ErrorLevel errorLevel, Throwable cause) {
        super(HttpStatus.UNPROCESSABLE_ENTITY.value(), code, message, developerMessage, errorLevel, cause);
    }
}
