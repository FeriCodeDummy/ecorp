package si.feri.ris.ecorp.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class PDFGenerator {

    public void Export(HttpServletResponse response) throws IOException {
        Document doc = new Document(PageSize.A4);
        PdfWriter.getInstance(doc, response.getOutputStream());

        doc.open();
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA);
        titleFont.setSize(18);

        Paragraph p = new Paragraph("Naslov", titleFont);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        Font pFont = FontFactory.getFont(FontFactory.HELVETICA);
        titleFont.setSize(14);

        Paragraph p2 = new Paragraph("Par", pFont);
        p.setAlignment(Paragraph.ALIGN_LEFT);

        doc.add(p);
        doc.add(p2);
        doc.close();
    }
}
