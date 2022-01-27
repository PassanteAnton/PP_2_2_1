package hiber.model;
import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    private int serial;

    public Car(String model, int serial) {
        this.model = model;
        this.serial = serial;
    }
    public Car() {

    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Car{\n" +
                "id=" + id +
                ", \nmodel='" + model + '\'' +
                ", \nserial=" + serial +
                '}';
    }
}