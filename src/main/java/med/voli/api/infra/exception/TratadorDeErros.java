package med.voli.api.infra.exception;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {


    @ExceptionHandler(EntityNotFoundException.class)// mostra para o spring que se no projeto for lançado qualquer exceção EntityNotFoundException sabe que e pra chamar este metodo
    public ResponseEntity tratarErro404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)//exceção do methodo 400
    public ResponseEntity tratarErro400(MethodArgumentNotValidException exception){//Recebe objeto para pegar os erros que aconteceram no binValidation
        var erros = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList());
    }














}
