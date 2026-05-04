package monolit.book_assistant.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class UserBookPutDto {

    @Size(min = 4, message = "название книги должно состоять минимум из 4 букв")
    private String name;

    @Min(value = 1, message = "цена должна быть больше 0")
    private Integer price;

    UserBookPutDto() {}

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
