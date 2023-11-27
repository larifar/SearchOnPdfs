package Models;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Pdf implements Texto{
    private String texto;
    private String nome;
    private int numeroPaginas;
    private PDDocument document;

    public String getTexto() {
        return texto;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public PDDocument getDocument() {
        return document;
    }

    public Pdf(String path) {
        File file = new File(path);
        if (file.exists() && file.isFile()){
            this.nome = FilenameUtils.getBaseName(new File(path).getName());
            try {
                PDDocument document = PDDocument.load(new File(path));
                System.out.println("Documento carregado");
                this.document = document;
                String texto = new PDFTextStripper().getText(document);
                System.out.println("Texto carregado");
                this.texto = texto;
                this.numeroPaginas = document.getNumberOfPages();
                System.out.println(this.numeroPaginas);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("O arquivo não é válido");
        }

    }

    //regex antiga: "\\s*(\\.\\s*\\.\\s*)"
    @Override
    public void pegarTexto(String palavra, PrintWriter writer) {
        if (this.texto != null && this.texto.contains(palavra)) {
            String[] linhas = this.texto.split("(?:[.!?]\\s*|^)\\s*([^.!?]*\\b"+palavra+"\\b[^.!?]*)[.!?]");
            writer.println(this.nome);
            // Itere linhas
            for (int i = 0; i < linhas.length; i++) {
                // Se a linha contiver a palavra desejada, escreva no arquivo
                if (linhas[i].contains(palavra)) {
                    writer.println(linhas[i]);
                    writer.println();  // Adicione uma linha em branco entre os parágrafos
                }
            }
            // Certifique-se de fechar o PDDocument
            if (this.document != null) {
                try {
                    this.document.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


