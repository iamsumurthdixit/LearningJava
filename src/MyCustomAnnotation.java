import java.lang.annotation.*;

@Inherited  // MyCustomAnnotation will be applied to child class also
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyCustomAnnotation {
}
