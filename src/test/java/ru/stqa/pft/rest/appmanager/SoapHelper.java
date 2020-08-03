package ru.stqa.pft.rest.appmanager;

import javax.xml.soap.*;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class SoapHelper {

    public SOAPMessage getMessage(String pathname) throws SOAPException, IOException {
        FileInputStream fis = new FileInputStream(new File(pathname));
        MessageFactory factory = MessageFactory.newInstance();
        return factory.createMessage(new MimeHeaders(), fis);
    }

    public SOAPMessage getResponse(SOAPMessage message, String strEndpoint) throws SOAPException {
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();
        SOAPMessage soapResponse = soapConnection.call(message, strEndpoint);
        System.out.println(soapResponse);
        return soapResponse;
    }

    public void validate(SOAPMessage soapResponse) throws SOAPException, TransformerException {
        SOAPBody soapBody = soapResponse.getSOAPBody();
        DOMSource source = new DOMSource(soapBody);
        StringWriter stringResult = new StringWriter();
        TransformerFactory.newInstance().newTransformer().transform(source, new StreamResult(stringResult));
        String test = stringResult.toString();
        assertThat(test, containsString("ТребоватьРецепт"));
        System.out.println(test);
    }
}
