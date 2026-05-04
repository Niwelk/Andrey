package monolit.book_assistant.dto;

import jakarta.validation.constraints.*;

public class UserBookCreateDto {
    @NotBlank(message = "название книги не может быть непроинициализировано")
    @Size(min = 4, message = "название книги должно состоять минимум из 4 букв")
    private String name;

    @Positive(message = "цена не может быть меньше или равно 0")
    @Min(value = 1, message = "цена должна быть больше 0")
    private Integer price;

    public UserBookCreateDto() {}

    public String getName() {
        return this.name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
