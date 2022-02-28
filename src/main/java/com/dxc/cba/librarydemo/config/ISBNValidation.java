package com.dxc.cba.librarydemo.config;

import java.lang.annotation.*;
import javax.validation.Constraint;
import javax.validation.Payload;
import static java.lang.annotation.ElementType.FIELD;


@Target( { FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ISBNValidator.class)
public @interface  ISBNValidation {
    //error message
    public String message() default "Invalid ISBN: Must have exactly 13 digits";
    //represents group of constraints
    public Class<?>[] groups() default {};
    //represents additional information about annotation
    public Class<? extends Payload>[] payload() default {};
}
