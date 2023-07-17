package app.library.utilities.results;

public class SuccessResult extends Result{
    SuccessResult(String message) {
        super(true, message);
    }
    SuccessResult() {
        super(true);
    }
}
