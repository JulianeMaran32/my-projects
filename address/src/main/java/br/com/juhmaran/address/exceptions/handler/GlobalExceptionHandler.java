package br.com.juhmaran.address.exceptions.handler;

//import br.com.juhmaran.address.exceptions.dtos.ErrorMessages;
//import br.com.juhmaran.address.exceptions.dtos.ErrorResponse;
//import br.com.juhmaran.address.exceptions.dtos.ValidationErrorResponse;
//import jakarta.servlet.ServletException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.http.converter.HttpMessageNotWritableException;
//import org.springframework.web.HttpMediaTypeNotAcceptableException;
//import org.springframework.web.HttpMediaTypeNotSupportedException;
//import org.springframework.web.HttpRequestMethodNotSupportedException;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.MissingServletRequestParameterException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.servlet.NoHandlerFoundException;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestControllerAdvice
public class GlobalExceptionHandler {
//
//    // 400 Bad Request - Validation
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ValidationErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getFieldErrors().forEach(
//                error -> {
//                    String fieldName = error.getField();
//                    String errorMessage = error.getDefaultMessage();
//                    errors.put(fieldName, errorMessage);
//                });
//        var errorResponse = new ValidationErrorResponse(
//                HttpStatus.BAD_REQUEST.value(),
//                HttpStatus.BAD_REQUEST.getReasonPhrase(),
//                ErrorMessages.METHOD_ARGUMENT_NOT_VALID.getMessage(),
//                errors
//        );
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//    }
//
//    // 400 Bad Request - Custom
//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
//        var errorResponse = ErrorResponse.builder()
//                .code(HttpStatus.BAD_REQUEST.value())
//                .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
//                .message(ErrorMessages.ILLEGAL_ARGUMENT.getMessage())
//                .build();
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//    }
//
//    // 400 Bad Request - Custom
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
//        var errorResponse = ErrorResponse.builder()
//                .code(HttpStatus.BAD_REQUEST.value())
//                .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
//                .message(ErrorMessages.HTTP_MESSAGE_NOT_READABLE.getMessage())
//                .build();
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//    }
//
//    // 400 Bad Request - Custom
//    @ExceptionHandler(MissingServletRequestParameterException.class)
//    public ResponseEntity<ErrorResponse> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
//        var errorResponse = ErrorResponse.builder()
//                .code(HttpStatus.BAD_REQUEST.value())
//                .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
//                .message(ErrorMessages.MISSING_SERVLET_REQUEST_PARAMETER.getMessage())
//                .build();
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//    }
//
//    // 404 Not Found - Custom
//    @ExceptionHandler(NoHandlerFoundException.class)
//    public ResponseEntity<ErrorResponse> handleNoHandlerFoundException(NoHandlerFoundException ex) {
//        var errorResponse = ErrorResponse.builder()
//                .code(HttpStatus.NOT_FOUND.value())
//                .status(HttpStatus.NOT_FOUND.getReasonPhrase())
//                .message(ErrorMessages.NO_HANDLER_FOUND.getMessage())
//                .build();
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
//    }
//
//    // 405 Method Not Allowed - Custom
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    public ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
//        var errorResponse = ErrorResponse.builder()
//                .code(HttpStatus.METHOD_NOT_ALLOWED.value())
//                .status(HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase())
//                .message(ErrorMessages.HTTP_REQUEST_METHOD_NOT_SUPPORTED.getMessage())
//                .build();
//        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(errorResponse);
//    }
//
//    // 406 Not Acceptable - Custom
//    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
//    public ResponseEntity<ErrorResponse> handleHttpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException ex) {
//        var errorResponse = ErrorResponse.builder()
//                .code(HttpStatus.NOT_ACCEPTABLE.value())
//                .status(HttpStatus.NOT_ACCEPTABLE.getReasonPhrase())
//                .message(ErrorMessages.HTTP_MEDIA_TYPE_NOT_ACCEPTABLE.getMessage())
//                .build();
//        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errorResponse);
//    }
//
//    // 415 Unsupported Media Type - Custom
//    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
//    public ResponseEntity<ErrorResponse> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex) {
//        var errorResponse = ErrorResponse.builder()
//                .code(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value())
//                .status(HttpStatus.UNSUPPORTED_MEDIA_TYPE.getReasonPhrase())
//                .message(ErrorMessages.HTTP_MEDIA_TYPE_NOT_SUPPORTED.getMessage())
//                .build();
//        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(errorResponse);
//    }
//
//    // 500 Internal Server Error - Custom
//    @ExceptionHandler(HttpMessageNotWritableException.class)
//    public ResponseEntity<ErrorResponse> handleHttpMessageNotWritableException(HttpMessageNotWritableException ex) {
//        var errorResponse = ErrorResponse.builder()
//                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
//                .status(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
//                .message(ErrorMessages.HTTP_MESSAGE_NOT_WRITABLE.getMessage())
//                .build();
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
//    }
//
//    // 500 Internal Server Error - Custom
//    @ExceptionHandler(ServletException.class)
//    public ResponseEntity<ErrorResponse> handleServletException(ServletException ex) {
//        var errorResponse = ErrorResponse.builder()
//                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
//                .status(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
//                .message(ErrorMessages.INTERNAL_ERROR.getMessage())
//                .build();
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
//    }
//
//    // 500 Internal Server Error - Custom
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
//        var errorResponse = ErrorResponse.builder()
//                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
//                .status(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
//                .message(ErrorMessages.INTERNAL_ERROR.getMessage())
//                .build();
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
//    }

}
