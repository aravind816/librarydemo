package com.dxc.cba.librarydemo.config;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ISBNValidator  implements ConstraintValidator<ISBNValidation, Long>{

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        int length = String.valueOf(value).length();
        return length==13?true:false;
    }
    
}
