package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class Calculator {
    private ArrayList<Currencies> currencyList = new ArrayList<Currencies>();

    Calculator(){
        parse();
    }

    public void parse(){
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("eurofxref-daily.xml");
            NodeList nodeList = document.getElementsByTagName("Cube");

            for (int i = 2; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Element element = (Element) node;

                String currency = element.getAttribute("currency");
                double rate = Double.parseDouble(element.getAttribute("rate"));
                Currencies singleCurrency = new Currencies(currency, rate);
                currencyList.add(singleCurrency);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public void exchange(double amount, String code){
        for ( Currencies currency : currencyList ) {
            if(currency.getCode().equals(code)){
                double result = amount * currency.getRate();
                System.out.println("Exchanged to: " + result + " " + code);
                return;
            }
        }
        System.out.println("There is no such currency to exchange");
    }
}