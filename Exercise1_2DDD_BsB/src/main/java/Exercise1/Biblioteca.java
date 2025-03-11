package Exercise1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Membro> membros = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public List<Livro> getLivros() {
        return Collections.unmodifiableList(livros);
    }

    public List<Membro> getMembros() {
        return Collections.unmodifiableList(membros);
    }

    public List<Emprestimo> getEmprestimos() {
        return Collections.unmodifiableList(emprestimos);
    }

    public void adicionarLivro(Livro livro) {
        if (livro != null && !livros.contains(livro)) {
            livros.add(livro);
            System.out.println("Livro adicionado: " + livro);
        } else {
            System.out.println("Livro inválido ou já existe.");
        }
    }

    public void removerLivro(Livro livro) {
        if (livros.remove(livro)) {
            System.out.println("Livro removido: " + livro);
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    public void registrarMembro(Membro membro) {
        if (membro != null && !membros.contains(membro)) {
            membros.add(membro);
            System.out.println("Membro registrado: " + membro);
        } else {
            System.out.println("Membro inválido ou já registrado.");
        }
    }

    public void registrarEmprestimo(Livro livro, Membro membro) {
        if (livros.contains(livro) && membros.contains(membro)) {
            Emprestimo emprestimo = new Emprestimo(livro, membro, new Date());
            emprestimos.add(emprestimo);
            System.out.println("Empréstimo registrado: " + emprestimo);
        } else {
            System.out.println("Livro ou membro não encontrado para empréstimo.");
        }
    }

    public void devolverLivro(Emprestimo emprestimo) {
        if (emprestimos.remove(emprestimo)) {
            System.out.println("Livro devolvido: " + emprestimo);
        } else {
            System.out.println("Empréstimo não encontrado.");
        }
    }

    public void salvarDadosEmArquivo(String nomeArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Livro livro : livros) {
                writer.write("Livro:" + livro + "\n");
            }
            for (Membro membro : membros) {
                writer.write("Membro:" + membro + "\n");
            }
            for (Emprestimo emprestimo : emprestimos) {
                writer.write("Emprestimo:" + emprestimo + "\n");
            }
            System.out.println("Dados salvos em " + nomeArquivo);
        }
    }

    public void carregarDadosDeArquivo(String nomeArquivo) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        }
    }
}