package Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private double preco;
    private int estoque;
    private LocalDate dataCadastro;

    public Produto(){    }

    public Produto(Integer id,String nome, double preco, int estoque, LocalDate dataCadastro){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.dataCadastro = dataCadastro;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public  String toString(){
        return "Produto{" +
                "id= " + id +
                ", nome= " + nome +
                ", preço= " + preco +
                ", estoque= " + estoque +
                ", data cadastro= " + dataCadastro + "}";



    }
}
