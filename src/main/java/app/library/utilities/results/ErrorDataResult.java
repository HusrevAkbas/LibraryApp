package app.library.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {
    ErrorDataResult(T data, String message) {
        super(data, false, message);
    }
    ErrorDataResult(T data) {
        super(data, false);
    }
    ErrorDataResult(String message) {
        super(null, false, message);
    }
    ErrorDataResult() {
        super(null, false);
    }
}
