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
    Address address;
    boolean active; // um set ou get active nao significa nada.
    private int rewardPoints = 0;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
        this.validate();
    }

    private void validate() {
        if (this.name.isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
        if (this.id.isEmpty()) {
            throw new IllegalArgumentException("ID is required");
        }
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
    public void activate() {
        if (this.address == null) {
            throw new IllegalArgumentException("Address is mandatory to active the user");
        }
        this.active = true;
    }

    // a entidade sempre vai ter que representar o estado correto e atual daquele
    // elemento
    // modelagem de dominio rico tem que garantir que os dados estao consistentes
    // 100% das vezes tem que estar consistente, nem mesmo o id tem representacao no
    // banco de dados
    void deactivate() {
        this.active = false;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isActive() {
        return this.active;
    }

    public void addRewardPoints(int points) {
        this.rewardPoints += points;
    }

    public int getRewardPoints() {
        return this.rewardPoints;
    }

    public String getId() {
        return this.id;
    }

}
