package Models;

import Exceptions.PdfExceptions;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private  static final Scanner sc = new Scanner(System.in);
    private static final List<Pdf> listaPdf = new ArrayList<>();

    static public void mostrarMenu() {
        int op;
        do{
            System.out.println("Escolha uma opção: ");
            System.out.println("0 - Sair");
            System.out.println("1 - Escolher novo pdf");
            System.out.println("2 - Mostrar resultado");
            op = Integer.parseInt(sc.nextLine());
            try {
                if (op> 3 || op<0){
                    throw new PdfExceptions("Digite um número válido!");
                }
                switch (op) {
                    case 0 -> option0();
                    case 1 -> option1();
                    case 2 -> option2(listaPdf);
                }
            } catch (PdfExceptions exceptions){
                System.out.println(exceptions.getMessage());
            }
        } while (op!=0);
    }

    static public void option0(){
        System.out.println("Parando programa....");
        System.exit(0);
    }

    static public void option1() throws PdfExceptions {
        System.out.println("Digite o local do arquivo.pdf: ");
        String caminho = sc.nextLine();
        if (caminho == null || caminho.isEmpty()){
            throw new PdfExceptions("Caminho inválido!");
        }
        Pdf pdf = new Pdf(caminho);
        if(pdf.getDocument() != null){
            listaPdf.add(pdf);
            System.out.println("Pdf adicionado com sucesso!");
        } else {
            throw new PdfExceptions("Erro ao adicionar pdf!");
        }
    }

    static public void option2(List<Pdf> lista) throws PdfExceptions {
        try{
            if (lista!=null && !lista.isEmpty()){
                System.out.println("Digite a palavra ou frase que quer buscar: ");
                String palavra = sc.nextLine();
                if (palavra == null){
                    throw new PdfExceptions("A palavra não pode ser nula!");
                }
                System.out.println("Digite o local do novo arquivo: ");
                String caminho = sc.nextLine();
                if (caminho==null || caminho.isEmpty()){
                    throw new PdfExceptions("Erro ao tentar encontrar caminho!");
                }
                try{
                    PrintWriter writer = new PrintWriter(caminho + "/resumo.txt");
                    if(writer.checkError()){
                        System.out.println("Erro ao tentar encontrar o caminho!");
                    } else{
                        for (Pdf pdf:lista) {
                            if(pdf != null){
                                pdf.pegarTexto(palavra, writer);
                            }
                        }
                        System.out.println("Arquivo no local: " + caminho);
                    }
                    writer.close();
                } catch (FileNotFoundException e) {
                    throw new PdfExceptions("Erro ao criar o arquivo: " + e.getMessage());
                }
            } else{
                System.out.println("Sem pdfs adicionados, adicione um novo!");
            }
        } catch (PdfExceptions e){
            throw new PdfExceptions(e.getMessage());
        }
    }
}
