package model;

import java.io.IOException;

public class TesteRepositorios {
    public static void main(String[] args) {
        // Teste do repositório de pessoas físicas
        try {
            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
            repo1.inserir(new PessoaFisica(1, "Mauricio Campos", "123.456.789-00", 46));
            repo1.inserir(new PessoaFisica(2, "Fatima Dantas", "111.222.333-50", 47));

            String arquivoPessoasFisicas = "pessoas_fisicas.dat";
            repo1.persistir(arquivoPessoasFisicas);

            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            repo2.recuperar(arquivoPessoasFisicas);

            System.out.println("Pessoas Físicas Recuperadas:");
            for (PessoaFisica pessoa : repo2.obterTodos()) {
                pessoa.exibir();
                System.out.println("-----------------------------");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao manipular o repositório de pessoas físicas: " + e.getMessage());
        }

        // Teste do repositório de pessoas jurídicas
        try {
            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
            repo3.inserir(new PessoaJuridica(1, "Nome_empresa 1", "12.345.678/0001-00"));
            repo3.inserir(new PessoaJuridica(2, "Nome_empresa 2", "11.222.333/0001-00"));

            String arquivoPessoasJuridicas = "pessoas_juridicas.dat";
            repo3.persistir(arquivoPessoasJuridicas);

            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
            repo4.recuperar(arquivoPessoasJuridicas);

            System.out.println("\nPessoas Jurídicas Recuperadas:");
            for (PessoaJuridica pessoa : repo4.obterTodos()) {
                pessoa.exibir();
                System.out.println("-----------------------------");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao manipular o repositório de pessoas jurídicas: " + e.getMessage());
        }
    }
}
