package Exercise1;

import java.util.Objects;

public class Membro {
    private String nome;
    private int id;
    private String email;

    public Membro(String nome, int id, String email) {
        this.nome = nome;
        this.id = id;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Membro{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membro membro = (Membro) o;
        return id == membro.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}