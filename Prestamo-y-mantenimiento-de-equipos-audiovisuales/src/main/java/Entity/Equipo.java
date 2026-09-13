package Entity;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "equipos")
@Getter
@Setter
@NoArgsConstructor
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_inventario", nullable = false, unique = true)
    private String codigoInventario;

    @Column(nullable = false)
    private String tipo;

    private String marca;

    private String modelo;

    @Column(nullable = false)
    private String estado;

    private String ubicacion;
}
