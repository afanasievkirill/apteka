package ru.stqa.pft.rest.tests.wms;

import org.testng.annotations.Test;
import ru.stqa.pft.rest.tests.ApiTestBase;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.TransformerException;
import java.io.IOException;


public class WsExchangeWithWMSTestSoap extends ApiTestBase {


    public String strEndpoint = "http://test_api:123456@192.168.85.73/dubinin_test/ws/ExchangeWithWMS.1cws";

    @Test
    public void testSoap() throws IOException, SOAPException, TransformerException {
        SOAPMessage message = api.soap().getMessage("src/test/resources/rest/soap/validCard.xml");
        SOAPMessage soapResponse = api.soap().getResponse(message, strEndpoint);
        api.soap().validate(soapResponse);
    }

}
