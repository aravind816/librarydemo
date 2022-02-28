package com.dxc.cba.librarydemo.config;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

public class ISBNValidator  implements ConstraintValidator<ISBNValidation, Long>{

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if(StringUtils.isNumeric(String.valueOf(value))){
            int length = String.valueOf(value).length();
            return length==13?true:false;
        }else{
            return false;
        }
    }
    
}
