import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XmlParser {
 private DocumentBuilderFactory documentBuilderFactory;
 private DocumentBuilder documentBuilder;
 private Document document;
 private NodeList nodeList;

 public XmlParser(File file) {
  DomParser(file);
 }
 public void DomParser(File file){
   
    try {
     documentBuilderFactory = DocumentBuilderFactory.newInstance();
     documentBuilder = documentBuilderFactory.newDocumentBuilder();  
     document = documentBuilder.parse(file);
    } catch (ParserConfigurationException e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
    } catch (SAXException e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
    } catch (IOException e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
    }
 }
 
  public List<XmlDataVO> parse(String tagName){
    List<XmlDataVO> listOfData = new ArrayList<XmlDataVO>();
    nodeList = document.getElementsByTagName(tagName);
    for(int i = 0; i < nodeList.getLength() ; i ++){
     Element element = (Element) nodeList.item(i);
     String createDt = this.getTagValue("createDt", element);
     String deathCnt = this.getTagValue("deathCnt",element);
     String defCnt = this.getTagValue("defCnt",element);
     String gubun = this.getTagValue("gubun",element);
     String gubunCn = this.getTagValue("gubunCn",element);
     String gubunEn = this.getTagValue("gubunEn",element);
     String incDec = this.getTagValue("incDec",element);
     // String isolClearCnt = this.getTagValue("isolClearCnt",element); - 2022년 02월 23일까지만 존재하는 데이터
     String localOccCnt = this.getTagValue("localOccCnt",element);
     String overFlowCnt = this.getTagValue("overFlowCnt",element);
     String qurRate = this.getTagValue("qurRate",element);
     String seq = this.getTagValue("seq",element);
     String stdDay = this.getTagValue("stdDay",element);
     String updateDt = this.getTagValue("updateDt",element);
     
     listOfData.add(new XmlDataVO(createDt, deathCnt, defCnt, gubun,
    		 gubunCn, gubunEn, incDec, /* isolClearCnt,*/ localOccCnt, overFlowCnt,
    		 qurRate, seq, stdDay, updateDt));
    }
   
  return listOfData;
 }

 private String getTagValue(String tagName, Element element) {
  NodeList nodeList = element.getElementsByTagName(tagName).item(0).getChildNodes();
  Node node = nodeList.item(0);
  return node.getNodeValue();
 }

} 