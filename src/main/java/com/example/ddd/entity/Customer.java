package com.example.ddd.entity;

// Cria baseado com a orientacao ao ORM
// Entity tem regras de NEGOCIO!!
// a entidade vai manipular o coracao da sua aplicacao, a entidade vai parar de ser algo com getters e setter e falar com o banco de dados
// para carregar as regras de negocios do sistema, PARA SER UMA MONDELAGEM DE DOMINIOS RICOS
// As Regras de negocios sao formas de mudar o COMPORTAMENTO DA ENTIDADE aplicando validacoes, formulas e qualquer coisa que faca o que o sistema esta pedindo
// O customer aqui e uma entidade anemica
// EXEMPLO DE ENTIDADE ANEMICA
public class Customer {
    String id; // entity se define com o ID pq ele e UNICO
    String name;
    String address;
    boolean active; // um set ou get active nao significa nada. 

    public Customer(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // ele esta aqui por esta, por ser uma classe anemica, esta mudando sem nenhuma
    // expressividade
    public void setName(String name) {
        this.name = name;
    }

    // pensa em uma regra especifica do negocio, e o motivo pelo qual o nome existe,
    // e motivo pelo qual o cliente preicsa de um nome,
    // motivo pelo qual o cliente pode ter cadastrado ERRADO
    // o resultado e o mesmo, mas nesse caso e um motivo de negocio
    void changeName(String name) {
        this.name = name;
    }

    // a diferenca e gritante pq aqui estamos tendo regra de negocio
    // modelagem do dominio rico expressa o negocio
    void activate() {
        this.active = true;
    }

    void deactivate() {
        this.active = false;
    }


}
