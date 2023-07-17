package app.library.utilities.results;

public class Result {
    private boolean success;
    private String message;
    Result(boolean success){
        this.success = success;
    }
    Result(boolean success, String message){
        this(success);
        this.message = message;
    }
    public boolean isSuccess(){
        return this.success;
    }
    public String getMessage(){
        return this.message;
    }
}
