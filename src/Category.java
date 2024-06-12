import java.lang.annotation.Repeatable;

@Repeatable(Categories.class)
public @interface Category {
    String name(); // it looks like a method, but is actually a key-value, name is key
}
