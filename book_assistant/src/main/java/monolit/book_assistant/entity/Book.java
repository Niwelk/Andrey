package monolit.book_assistant.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", length = 100)
    private String name;

    @Column(name = "price")
    private int price;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Reservation reservation;


    public Book() {
        this.reservation = Reservation.UNKNOWN; //я решил сделать так чтобы Jackson не null писал а это. Нормальная идея или лучше вернуть как было без логики?
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public Reservation getReservation() {
        return reservation;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
