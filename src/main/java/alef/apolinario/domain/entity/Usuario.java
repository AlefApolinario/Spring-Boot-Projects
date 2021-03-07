package alef.apolinario.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "{campo.login.obrigatorio}")
    @Column(length = 100)
    private String login;
    @NotEmpty(message = "{campo.senha.obrigatorio}")
    @Column
    private String senha;
    @Column(name = "administrador")
    private boolean admin;

}
