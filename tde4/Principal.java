package view;

import controller.CursoController;
import model.*;

import java.util.Scanner;

public class Principal {
    private static CursoController controller = new CursoController();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean executando = true;

        while (executando) {
            System.out.println("=== Sistema de Gestão de Cursos Online ===");
            System.out.println("1. Cadastrar curso");
            System.out.println("2. Listar cursos");
            System.out.println("3. Buscar curso por nome");
            System.out.println("4. Remover curso");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            try {
                switch (opcao) {
                    case "1":
                        cadastrarCurso();
                        break;
                    case "2":
                        listarCursos();
                        break;
                    case "3":
                        buscarCurso();
                        break;
                    case "4":
                        removerCurso();
                        break;
                    case "5":
                        executando = false;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void cadastrarCurso() throws CampoObrigatorioException {
        System.out.print("Título do curso: ");
        String titulo = scanner.nextLine();

        System.out.print("Nome do instrutor: ");
        String nomeInstrutor = scanner.nextLine();

        System.out.print("Email do instrutor: ");
        String emailInstrutor = scanner.nextLine();

        Instrutor instrutor = new Instrutor(nomeInstrutor, emailInstrutor);
        Curso curso = new Curso(titulo, instrutor);

        // Adicionar aulas
        boolean adicionandoAulas = true;
        while (adicionandoAulas) {
            System.out.print("Adicionar aula? (s/n): ");
            String resp = scanner.nextLine();
            if (resp.equalsIgnoreCase("s")) {
                System.out.print("Título da aula: ");
                String tituloAula = scanner.nextLine();

                System.out.print("Duração da aula (minutos): ");
                int duracao = Integer.parseInt(scanner.nextLine());

                Aula aula = new Aula(tituloAula, duracao);
                curso.adicionarAula(aula);
            } else {
                adicionandoAulas = false;
            }
        }

        controller.cadastrarCurso(curso);
        System.out.println("Curso cadastrado com sucesso!");
    }

    private static void listarCursos() {
        if (controller.listarCursos().isEmpty()) {
            System.out.println("Nenhum curso cadastrado.");
            return;
        }
        for (Curso c : controller.listarCursos()) {
            c.exibir();
        }
    }

    private static void buscarCurso() {
        System.out.print("Digite o nome do curso para buscar: ");
        String nome = scanner.nextLine();
        try {
            Curso curso = controller.buscarCursoPorNome(nome);
            curso.exibir();
        } catch (CursoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void removerCurso() {
        System.out.print("Digite o nome do curso para remover: ");
        String nome = scanner.nextLine();
        try {
            controller.removerCurso(nome);
            System.out.println("Curso removido com sucesso.");
        } catch (CursoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }
}