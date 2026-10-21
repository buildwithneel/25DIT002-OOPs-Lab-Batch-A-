import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {
    String message() default "Field cannot be blank";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
    String message() default "Field exceeds maximum length";
}

class SignupForm {
    @NotBlank(message = "Username cannot be empty")
    @MaxLength(value = 10, message = "Username cannot exceed 10 characters")
    private String username;

    @NotBlank(message = "Password cannot be empty")
    private String password;

    public SignupForm(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

class FormValidator {
    public static List<String> validate(Object obj) {
        List<String> errors = new ArrayList<>();
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object valueObj = field.get(obj);
                String value = (valueObj == null) ? "" : valueObj.toString().trim();

                if (field.isAnnotationPresent(NotBlank.class)) {
                    if (value.isEmpty()) {
                        NotBlank annotation = field.getAnnotation(NotBlank.class);
                        errors.add(field.getName() + ": " + annotation.message());
                    }
                }

                if (field.isAnnotationPresent(MaxLength.class)) {
                    MaxLength annotation = field.getAnnotation(MaxLength.class);

                    if (value.length() > annotation.value()) {
                        errors.add(field.getName() + ": " + annotation.message());
                    }
                }
            } catch (IllegalAccessException e) {
                errors.add("Access denied to field: " + field.getName());
            }
        }

        return errors;
    }
}

public class FormValidationDemo {
    public static void main(String[] args) {
        SignupForm myForm = new SignupForm("Neel85", "neel_234");

        System.out.println("--- Starting Form Validation ---");

        List<String> errors = FormValidator.validate(myForm);

        if (errors.isEmpty()) {
            System.out.println("Success! All fields are valid.");
        } else {
            System.out.println("Validation Failed! Errors found:");

            for (String error : errors) {
                System.out.println("-> " + error);
            }
        }
    }
}
