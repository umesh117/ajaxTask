package com.example.ajaxpropertest.ajaxpropertest.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordContraintValidator.class)
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {

    String message() default "Password should be at least 6 character, at least one capital letter and one digit. ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
