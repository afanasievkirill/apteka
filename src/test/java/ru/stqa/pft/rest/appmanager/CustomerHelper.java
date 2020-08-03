package ru.stqa.pft.rest.appmanager;

import ru.stqa.pft.rest.model.CustomerData;

public class CustomerHelper {


    public String create() {
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?><request xmlns=\"http://www.eapteka.ru/clients\">\n" +
                "  <clients>   \n" +
                "  <client>         \n" +
                "  <name>ТестТест</name>     \n" +
                "  <isCompany>false</isCompany>            \n" +
                "  <companyProperties>       \n" +
                "  <isStateCompany>false</isStateCompany>        \n" +
                "  <fullName></fullName>       \n" +
                "  <registrationAddress></registrationAddress>       \n" +
                "  <postalAddress></postalAddress>        \n" +
                "  <phoneNumbers>99256006617</phoneNumbers>                \n" +
                "  <OGRN></OGRN>        \n" +
                "  <OKPO></OKPO>      \n" +
                "  </companyProperties> \n" +
                "  <registrationDate>0001-01-01</registrationDate>     \n" +
                "  <phones>  \n" +
                "  <phone>      \n" +
                "  <phoneNumber>+79153913432</phoneNumber>       \n" +
                "  </phone>  \n" +
                "  </phones>      \n" +
                "  <addresses>        \n" +
                "  <address>        \n" +
                "  <regionName></regionName>     \n" +
                "  <district></district>      \n" +
                "  <cityName>Москва</cityName>         \n" +
                "  <metroStationName></metroStationName>      \n" +
                "  <street>Мира</street>      \n" +
                "  <house>28</house>     \n" +
                "  <building>1</building>     \n" +
                "  <entrance>5</entrance>     \n" +
                "  <entranceCode>123456</entranceCode>      \n" +
                "  <doorPhone>654321</doorPhone>      \n" +
                "  <floor>7</floor>     \n" +
                "  <flat>67</flat>      \n" +
                "  <comments></comments>      \n" +
                "  <addressView>Москва, Мира 28</addressView>      \n" +
                "  <addressDate>2012-12-13T12:12:12</addressDate>     \n" +
                "  <fieldValues></fieldValues>     \n" +
                "  <coordinates>       \n" +
                "  <lon>3.14159</lon>       \n" +
                "  <lat>3.14159</lat>      \n" +
                "  </coordinates>     \n" +
                "  <fias>str1234</fias>   \n" +
                "  </address>     \n" +
                "  </addresses>     \n" +
                "  <emails>       \n" +
                "  <email>                 \n" +
                "  <email>test@a.ru</email>        \n" +
                "  </email>      \n" +
                "  </emails>     \n" +
                "  <comments></comments>      \n" +
                "  <clientpropertiess></clientpropertiess>     \n" +
                "  <birthDate>0001-01-01</birthDate>    \n" +
                "  </client> \n" +
                "  </clients>\n" +
                "  </request>";
    }

    public String contactsWithData(CustomerData customerData) {
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<request xmlns=\"http://www.eapteka.ru/clients\">\n" +
                "\n" +
                "<customers>\n" +
                "<customer>\n" +
                "<type>PRIVATE</type>\n" +
                "<name>" + customerData.getName() + "</name>\n" +
                "<phone>" + customerData.getPhone() + "</phone>\n" +
                "<address>\n" +
                "<customerAddress>\n" +
                "\n" +
                "<date_time>2019-02-28 22:22:22</date_time>\n" +
                "<coordinates>\n" +
                "<lon>" + customerData.getLon() + "</lon>\n" +
                "<lat>" + customerData.getLat() + "</lat>\n" +
                "</coordinates>\n" +
                "<address>" + customerData.getAdress() + "</address>\n" +
                "<city>" + customerData.getCity() + "</city>\n" +
                "<street>" + customerData.getStreet() + "</street>\n" +
                "<house>" + customerData.getHouse() + "</house>\n" +
                "<apartment>" + customerData.getAppartment() + "</apartment>\n" +
                "<floor>" + customerData.getFloor() + "</floor>\n" +
                "<building>" + customerData.getBuilding() + "</building>\n" +
                "<entrance>" + customerData.getEntrance() + "</entrance>\n" +
                "<keycode>" + customerData.getKeycode() + "</keycode>\n" +
                "<fias>...</fias>\n" +
                "\n" +
                "</customerAddress>\n" +
                "</address>\n" +
                "</customer>\n" +
                "</customers>\n" +
                "</request>";
    }

    public String createEntity(){
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?><request xmlns=\"http://www.eapteka.ru/clients\">\n" +
                "    <clients>\n" +
                "        <client>\n" +
                "            <name>str1234</name>\n" +
                "            <isCompany>true</isCompany>\n" +
                "            <companyProperties>\n" +
                "                <isStateCompany>true</isStateCompany>\n" +
                "                <fullName>str12348888888</fullName>\n" +
                "                <registrationAddress>str1234</registrationAddress>\n" +
                "                <postalAddress>str1234</postalAddress>\n" +
                "                <phoneNumbers>99256006617</phoneNumbers>\n" +
                "                <OGRN>str1234</OGRN>\n" +
                "                <OKPO>str1234</OKPO>\n" +
                "            </companyProperties>\n" +
                "            <registrationDate>0001-01-01</registrationDate>\n" +
                "            <phones>\n" +
                "                <phone>\n" +
                "                    <phoneNumber>+79511455165</phoneNumber>\n" +
                "                </phone>\n" +
                "            </phones>\n" +
                "            <addresses>\n" +
                "                <address>\n" +
                "                    <regionName></regionName>\n" +
                "                    <district></district>\n" +
                "                    <cityName>Москва</cityName>\n" +
                "                    <metroStationName></metroStationName>\n" +
                "                    <street>Мира</street>\n" +
                "                    <house>28</house>\n" +
                "                    <building>1</building>\n" +
                "                    <entrance>5</entrance>\n" +
                "                    <entranceCode>123456</entranceCode>\n" +
                "                    <doorPhone>654321</doorPhone>\n" +
                "                    <floor>7</floor>\n" +
                "                    <flat>67</flat>\n" +
                "                    <comments></comments>\n" +
                "                    <addressView>Москва, Мира 28</addressView>\n" +
                "                    <addressDate>2012-12-13T12:12:12</addressDate>\n" +
                "                    <fieldValues></fieldValues>\n" +
                "                    <coordinates>\n" +
                "                        <lon>3.14159</lon>\n" +
                "                        <lat>3.14159</lat>\n" +
                "                    </coordinates>\n" +
                "                    <fias>str1234</fias>\n" +
                "                </address>\n" +
                "            </addresses>\n" +
                "            <emails>\n" +
                "                <email>\n" +
                "                    <email>aaaa@a.ru</email>\n" +
                "                </email>\n" +
                "            </emails>\n" +
                "            <comments></comments>\n" +
                "            <clientpropertiess></clientpropertiess>\n" +
                "            <birthDate>0001-01-01</birthDate>\n" +
                "        </client>\n" +
                "    </clients>\n" +
                "</request>";
    }
}
