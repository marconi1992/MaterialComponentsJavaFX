package materialcomponents;

import javafx.scene.shape.SVGPath;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by Felipe on 07/09/2015.
 */
public class SVGFactory {

    static public SVGPath createSVG(File file) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        String pathStr = "";
        try {
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            Document doc = dbBuilder.parse(file);
            doc.normalizeDocument();
            System.out.println(doc.getDocumentElement().getNodeName());
            NodeList paths = doc.getElementsByTagName("path");
            for (int i = 0; i < paths.getLength(); i++) {
                Node node = paths.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element path = (Element) node;

                    if(!path.getAttribute("fill").equals("none")){
                        pathStr += path.getAttribute("d");
                    }
                }

            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        SVGPath svg = new SVGPath();
        svg.getStyleClass().add("icon-svg");
        svg.setContent(pathStr);
        return svg;
    }
}
