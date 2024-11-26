package murkeev.scrapper.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Books")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String price;
    private String availability;
    private String rating;
}
