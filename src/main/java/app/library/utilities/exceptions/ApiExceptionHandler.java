package app.library.utilities.exceptions;

import app.library.utilities.results.DataResult;
import app.library.utilities.results.ErrorDataResult;
import app.library.utilities.results.ErrorResult;
import app.library.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = UsernameAlreadyExist.class)
    public ResponseEntity<Result> handleApiRequest(Exception exception){
        return new ResponseEntity<>(
                new ErrorResult(exception.getMessage()+". Caused from class: "+exception.getClass().getName()),
                HttpStatus.BAD_REQUEST
        );
    }
}
