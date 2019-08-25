/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsiranje;

 import java.io.File;  
import java.io.FileInputStream;
  import java.io.FileNotFoundException;  
  import javax.xml.parsers.DocumentBuilderFactory;  
  import javax.xml.xpath.XPath;  
  import javax.xml.xpath.XPathConstants;  
  import javax.xml.xpath.XPathExpression;  
  import javax.xml.xpath.XPathExpressionException;  
  import javax.xml.xpath.XPathFactory;  
  import org.w3c.dom.NodeList;  
import org.xml.sax.InputSource;

/**
 *
 * @author wedad
 */
public class Parsiranje {
File xml;
    /**
     * @param args the command line arguments
     * @throws javax.xml.xpath.XPathExpressionException
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws XPathExpressionException, FileNotFoundException {
       
      
        
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setIgnoringElementContentWhitespace(true);
            
            XPathFactory f = XPathFactory.newInstance();
            XPath p = f.newXPath();
            XPathExpression x = p.compile("//book[price>10 and translate(publish_date,'-','')>20050000]");
            
         File xml = new File("C:/Users/wedad/Documents/NetBeansProjects/Parsiranje/src/parsiranje/XMLDocument.xml");
           
             InputSource source = new InputSource(new FileInputStream(xml));
            Object r = x.evaluate(source, XPathConstants.NODESET);
            NodeList n = (NodeList)r;
            
            for (int i = 0; i < n.getLength(); i++) {
                System.out.print(n.item(i).getNodeName() + " ");
                System.out.println(n.item(i).getAttributes().item(0));
                System.out.println(" Autor knige: " + n.item(i).getFirstChild().getNextSibling().getTextContent());
                System.out.println(" Naziv knjige: " + n.item(i).getFirstChild().getNextSibling().
                        getNextSibling().getNextSibling().getTextContent());
                System.out.println(" Zanr : " + n.item(i).getFirstChild().getNextSibling().
                        getNextSibling().getNextSibling().getNextSibling().getNextSibling().getTextContent());
                System.out.println(" Cijena: " + n.item(i).getLastChild().getPreviousSibling().
                        getPreviousSibling().getPreviousSibling().getPreviousSibling().getPreviousSibling().getTextContent());
                System.out.println(" Datum objavljivanja: " + n.item(i).getLastChild().getPreviousSibling().
                        getPreviousSibling().getPreviousSibling().getTextContent());
                System.out.println(" Description: " + n.item(i).getLastChild().getPreviousSibling().getTextContent());
                System.out.print("\n");
            }
      
} 
        
        
    }
    

