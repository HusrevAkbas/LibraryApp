package app.library.utilities.results;

public class SuccessDataResult<T> extends DataResult<T> {
    SuccessDataResult(T data) {
        super(data, true);
    }
    SuccessDataResult(T data, String message) {
        super(data, true, message);
    }
    SuccessDataResult(String message) {
        super(null, true, message);
    }
    SuccessDataResult() {
        super(null, true);
    }
}
