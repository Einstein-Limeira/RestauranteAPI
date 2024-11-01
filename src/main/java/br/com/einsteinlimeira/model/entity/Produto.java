package br.com.einsteinlimeira.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "produto", schema = "public")
public class Produto {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 40)
    @Column(name = "descricao", length = 40, nullable = false)
    private String descricao;

    @NotNull
    @Column(name = "preco", precision = 11, scale = 2, nullable = false)
    private BigDecimal preco;

    @NotNull
    @Size(max = 40)
    @Column(name = "categoria", length = 40, nullable = false)
    private String categoria;
}