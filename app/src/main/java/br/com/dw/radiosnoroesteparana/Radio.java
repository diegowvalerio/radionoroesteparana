package br.com.dw.radiosnoroesteparana;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class Radio {

    public  Integer id;
    public  String nome;
    public  String endereco;
    public  String cidadeuf;
    public Bitmap imagem;

    public Radio() {
    }

    public Radio(Integer id, String nome, String endereco, String cidadeuf, Bitmap imagem) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cidadeuf = cidadeuf;
        this.imagem = imagem;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidadeuf() {
        return cidadeuf;
    }

    public void setCidadeuf(String cidadeuf) {
        this.cidadeuf = cidadeuf;
    }

    public Bitmap getImagem() {
        return imagem;
    }

    public void setImagem(Bitmap imagem) {
        this.imagem = imagem;
    }
}
