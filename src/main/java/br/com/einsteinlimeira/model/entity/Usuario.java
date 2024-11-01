package br.com.einsteinlimeira.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "usuario", schema = "public")
public class Usuario {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 30)
    @Column(name = "nome", length = 30, nullable = false)
    private String nome;

    @NotNull
    @Email
    @Size(max = 50)
    @Column(name = "email", length = 50, unique = true, nullable = false)
    private String email;

    @NotNull
    @Size(max = 40)
    @Column(name = "senha", length = 40, nullable = false)
    private String senha;
}