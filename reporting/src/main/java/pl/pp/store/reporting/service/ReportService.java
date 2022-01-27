package pl.pp.store.reporting.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.pp.store.reporting.dto.*;
import pl.pp.store.reporting.feign.OrderFeignClientImpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReportService {

    private final OrderFeignClientImpl orderFeignClient;

    public ByteArrayInputStream generateMyStoreStoredProductsReport(StoreKeeperCredentialsDto storeKeeperCredentialsDto) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(60);
            table.setWidths(new int[]{2, 3, 1});

            Font headFont = FontFactory.getFont(FontFactory.TIMES_ROMAN);

            StoredProductsListDto listing = orderFeignClient.getMyStoreStoredProducts(storeKeeperCredentialsDto);

            Paragraph storeInfo = new Paragraph();
            storeInfo.add(new Paragraph("Store products report", new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD)));
            storeInfo.add(new Paragraph(" "));
            storeInfo.add(new Paragraph("Store: " + listing.getStore().getName()));
            storeInfo.add(new Paragraph("Code: " + listing.getStore().getCode()));
            storeInfo.add(new Paragraph("Localization: " + listing.getStore().getLocalization()));

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Code", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Product name", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Quantity", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            for (StoredProductDto storedProduct : listing.getProducts()) {

                PdfPCell cell;

                cell = new PdfPCell(new Phrase(storedProduct.getCode()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(storedProduct.getName()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(String.valueOf(storedProduct.getQuantity())));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setPaddingRight(5);
                table.addCell(cell);
            }
            table.setHeaderRows(1);

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(storeInfo);
            document.add(table);
            document.close();

        } catch (DocumentException ex) {

            log.error("Error occurred: {0}", ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    public ByteArrayInputStream generateAllReport(StoreKeeperCredentialsDto storeKeeperCredentialsDto) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Font headFont = FontFactory.getFont(FontFactory.TIMES_ROMAN);

            AllStoresStoredProductsListDto listing = orderFeignClient.getAllStoredProducts(storeKeeperCredentialsDto);

            Paragraph storeInfo = new Paragraph();
            storeInfo.add(new Paragraph("Store products report", new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD)));

            document.add(storeInfo);

            Font chapterFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.NORMAL);

            int chapterNumber = 1;
            for (StoredProductsListDto storedProductsListDto : listing.getStoresStoredProductsLists()) {

                Anchor anchor = new Anchor("Store: " + storedProductsListDto.getStore().getName(), chapterFont);
                anchor.setName("Store: " + storedProductsListDto.getStore().getName());

                Chapter store = new Chapter(new Paragraph(anchor), chapterNumber);

                store.add(new Paragraph(" "));
                store.add(new Paragraph("Store: " + storedProductsListDto.getStore().getName()));
                store.add(new Paragraph("Code: " + storedProductsListDto.getStore().getCode()));
                store.add(new Paragraph("Localization: " + storedProductsListDto.getStore().getLocalization()));

                PdfPTable table = new PdfPTable(3);
                table.setWidthPercentage(60);
                table.setWidths(new int[]{2, 3, 1});

                PdfPCell hcell;
                hcell = new PdfPCell(new Phrase("Code", headFont));
                hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(hcell);

                hcell = new PdfPCell(new Phrase("Product name", headFont));
                hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(hcell);

                hcell = new PdfPCell(new Phrase("Quantity", headFont));
                hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(hcell);

                for (StoredProductDto storedProduct : storedProductsListDto.getProducts()) {

                    PdfPCell cell;

                    cell = new PdfPCell(new Phrase(storedProduct.getCode()));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);

                    cell = new PdfPCell(new Phrase(storedProduct.getName()));
                    cell.setPaddingLeft(5);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    table.addCell(cell);

                    cell = new PdfPCell(new Phrase(String.valueOf(storedProduct.getQuantity())));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    cell.setPaddingRight(5);
                    table.addCell(cell);
                }
                table.setHeaderRows(1);
                store.add(table);
                document.add(store);
            }

            document.close();

        } catch (DocumentException ex) {

            log.error("Error occurred: {0}", ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    public ByteArrayInputStream generateProductReport(String code, StoreKeeperCredentialsDto storeKeeperCredentialsDto) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Font headFont = FontFactory.getFont(FontFactory.TIMES_ROMAN);

            StoredProductStoresListDto listing = orderFeignClient.getOneStoredProductFromAllStores(code, storeKeeperCredentialsDto);

            Paragraph storeInfo = new Paragraph();
            storeInfo.add(new Paragraph("Product in all stores report", new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD)));

            document.add(storeInfo);

            Font chapterFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.NORMAL);

            Anchor anchor = new Anchor("Product: " + listing.getName(), chapterFont);
            anchor.setName("Product: " + listing.getName());

            Chapter product = new Chapter(new Paragraph(anchor), 1);

            product.add(new Paragraph(" "));
            product.add(new Paragraph("Product: " + listing.getName()));
            product.add(new Paragraph("Code: " + listing.getCode()));
            product.add(new Paragraph("Category: " + listing.getCategory()));

            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(60);
            table.setWidths(new int[]{2, 3, 1});

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Code", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Store name", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Quantity", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            for (StoreProductsQuantityDto storedProduct : listing.getStoreProductsQuantityList()) {

                PdfPCell cell;

                cell = new PdfPCell(new Phrase(storedProduct.getStoreCode()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(storedProduct.getStoreName()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(String.valueOf(storedProduct.getQuantity())));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setPaddingRight(5);
                table.addCell(cell);
            }
            table.setHeaderRows(1);
            product.add(table);
            document.add(product);

            document.close();

        } catch (DocumentException ex) {

            log.error("Error occurred: {0}", ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
