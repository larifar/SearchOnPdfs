# Project Search On PDF

## Description

- This project aims to simplify keyword searches across multiple PDF documents. It provides a summary containing sentences that include the searched word, along with the corresponding PDF file name.


## Descrição

- Esse projeto busca facilitar a busca por palavras-chaves em multiplos PDFs. Ele devolve um resumo com as frases que contém a palavra buscada, assim como o nome do PDF correspondente. 

## Features

- Search for keywords in multiple PDFs.
- Receive a summary with sentences containing the searched word.
- Identify the PDF file name associated with each sentence.

## Technologies
For this project, I used:
- [Java 17](https://www.oracle.com/br/java/technologies/downloads/)
- IDE: [IntelliJ](https://www.jetbrains.com/idea/)
- Libraries: [PDFBox](https://pdfbox.apache.org/) and [Apache Commons IO](https://commons.apache.org/proper/commons-io/download_io.cgi)

## Usage 
**This project uses Java 17, please verify if your Java is updated.**
### SetUp
a) Using cmd:
- Clone the repository
```bash
git clone https://github.com/larifar/SearchOnPdfs.git
```
**Or** 

b) Download:
- Download the zip-> click the botton < Code >
- Extract SearchOnPdfs-main.zip with Winrar (or another tool of your preference)

### How to use
1) Open the command prompt and navigate to the project directory.
```bash
cd C:/Users/you/Downloads/SearchOnPdfs
```
(By right-clicking directly on the project folder and selecting 'Properties,' you can find the directory location.)
2) Execute the project
```bash
java -jar SearchOnPdf.jar
```

### Understanding the options:
0) Quit the program.
1) Add a new PDF. Provide the file location.
2) Show the results. Provide the keyword and the location for the result.