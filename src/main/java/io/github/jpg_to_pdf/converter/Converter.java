package io.github.jpg_to_pdf.converter;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Converter {
    public static void main(String... args) throws IOException, DocumentException {
        Document document = new Document();
        // Создаем writer для записи в pdf
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("pdf.pdf"));
        // Открываем для чтения html страничку
        document.open();
        // Парсим её и записываем в PDF
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream("index.html"));
        document.close();

        System.out.println( "Ваш PDF файл - Создан!" );
    }
}
