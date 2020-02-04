package com.example.ajaxpropertest.ajaxpropertest.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PasswordContraintValidator implements ConstraintValidator<ValidPassword,String> {
    @Override
    public void initialize(ValidPassword constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        Pattern uppercaseRegex=Pattern.compile(".*[A-Z].*");
        Pattern lowercaseRegex=Pattern.compile(".*[a-z].*");
        Pattern digitRegex=Pattern.compile(".*\\d.*");

        if(s.length()<6)
            return false;
        if(uppercaseRegex.matcher(s).matches()  &&
                lowercaseRegex.matcher(s).matches()  &&
                digitRegex.matcher(s).matches()){
            return true;
        }else {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("Not a valid password. Refer to password policy.").addConstraintViolation();
            return false;
        }
    }
}
