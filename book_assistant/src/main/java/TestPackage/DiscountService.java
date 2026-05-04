package TestPackage;

public class DiscountService {
    private final DiscountRepository repository;

    public DiscountService(DiscountRepository repository) {
        this.repository = repository;
    }

    public double calculateTotal(double price, String customerType) {
        // Получаем скидку из репозитория (который идет в базу)
        int discount = repository.getDiscountForType(customerType);

        return price * (1 - discount / 100.0);
    }
}


