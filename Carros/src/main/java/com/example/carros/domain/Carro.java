package com.example.carros.domain;

import javax.persistence.*;

@Entity // caso os nomes da classe e do banco fossem diferentes bastava mapear com (name="nome_da_tabela")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column(name = "nome_da_coluna") - caso fosse necessário mapear uma coluna do banco
    private String nome;
    private String tipo;

    public Carro() {
    }

    public Carro(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
