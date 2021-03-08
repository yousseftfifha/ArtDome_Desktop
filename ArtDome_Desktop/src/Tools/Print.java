package Tools;

import javafx.print.*;
import javafx.scene.Node;
import javafx.scene.transform.Scale;

import java.lang.reflect.InvocationTargetException;

/**
 * @author tfifha youssef
 */
public class Print {
    public static void printNode(final Node node) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Printer printer = Printer.getDefaultPrinter();
        PageLayout pageLayout
                = printer.createPageLayout(Paper.A3, PageOrientation.LANDSCAPE, Printer.MarginType.DEFAULT);
        PrinterAttributes attr = printer.getPrinterAttributes();
        PrinterJob job = PrinterJob.createPrinterJob();
        double scaleX
                = pageLayout.getPrintableWidth() / node.getBoundsInParent().getWidth();
        double scaleY
                = pageLayout.getPrintableHeight() / node.getBoundsInParent().getHeight();
        double scaleZ
                = pageLayout.getPrintableWidth()+pageLayout.getPrintableHeight() / node.getBoundsInParent().getDepth();

        Scale scale = new Scale(scaleX, scaleY, scaleZ);
        node.getTransforms().add(scale);

        if (job != null && job.showPrintDialog(node.getScene().getWindow())) {
            boolean success = job.printPage(pageLayout, node);
            if (success) {
                job.endJob();

            }
        }
        node.getTransforms().remove(scale);
    }
}
