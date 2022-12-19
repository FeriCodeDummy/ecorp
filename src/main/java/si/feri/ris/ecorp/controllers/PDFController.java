package si.feri.ris.ecorp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import si.feri.ris.ecorp.service.PDFGenerator;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PDFController {

    private final PDFGenerator pdfg;


    public PDFController(PDFGenerator pdfg) {
        this.pdfg = pdfg;
    }

    @GetMapping("/pdf/test")
    public void generatePDF(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        DateFormat sf = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String curDate = sf.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=test.pdf";
        response.setHeader(headerKey, headerValue);

        this.pdfg.Export(response);
    }
}
