package app.library.utilities.results;

public class ErrorResult extends Result{

    ErrorResult() {
        super(false);
    }
    ErrorResult(String message) {
        super(false, message);
    }
}
