package dao;

public class DiscountCodeExistsException extends DaoException {
    public DiscountCodeExistsException() {
    }

    public DiscountCodeExistsException(String message) {
        super(message);
    }

    public DiscountCodeExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public DiscountCodeExistsException(Throwable cause) {
        super(cause);
    }

    public DiscountCodeExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
