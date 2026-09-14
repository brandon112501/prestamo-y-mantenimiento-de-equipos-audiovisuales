package Entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name="rol")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nombre_Rol", nullable = false, length = 50)
    private String nombreRol;

    @Column( length = 255)
    private String descripcion;

}
