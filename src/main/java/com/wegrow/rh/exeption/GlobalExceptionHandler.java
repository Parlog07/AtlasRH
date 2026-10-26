package com.wegrow.rh.exception;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.dao.DataIntegrityViolationException;
import java.util.*;
@RestControllerAdvice
public class GlobalExceptionHandler {
 @ExceptionHandler(NotFoundException.class) public ResponseEntity<Map<String,String>> notFound(NotFoundException e){return response(HttpStatus.NOT_FOUND,e.getMessage());}
 @ExceptionHandler(ConflictException.class) public ResponseEntity<Map<String,String>> conflict(ConflictException e){return response(HttpStatus.CONFLICT,e.getMessage());}
 @ExceptionHandler({IllegalArgumentException.class,HttpMessageNotReadableException.class}) public ResponseEntity<Map<String,String>> badRequest(Exception e){return response(HttpStatus.BAD_REQUEST,e.getMessage());}
 @ExceptionHandler(DataIntegrityViolationException.class) public ResponseEntity<Map<String,String>> integrity(DataIntegrityViolationException e){return response(HttpStatus.CONFLICT,"Database constraint violation");}
 @ExceptionHandler(MethodArgumentNotValidException.class) public ResponseEntity<Map<String,String>> validation(MethodArgumentNotValidException e){return response(HttpStatus.BAD_REQUEST,e.getBindingResult().getFieldErrors().stream().map(x->x.getField()+": "+x.getDefaultMessage()).findFirst().orElse("Invalid request"));}
 private ResponseEntity<Map<String,String>> response(HttpStatus status,String message){return ResponseEntity.status(status).body(Map.of("error",message==null?"Invalid request":message));}
}
