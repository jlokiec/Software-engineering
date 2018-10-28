package dao;

public class NickTakenException extends DaoException {
    public NickTakenException() {
    }

    public NickTakenException(String message) {
        super(message);
    }

    public NickTakenException(String message, Throwable cause) {
        super(message, cause);
    }

    public NickTakenException(Throwable cause) {
        super(cause);
    }

    public NickTakenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
