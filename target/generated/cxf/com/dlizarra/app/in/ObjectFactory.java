
package com.dlizarra.app.in;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.dlizarra.app.in package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SayHiRequest_QNAME = new QName("http://www.dlizarra.com/app/in", "SayHiRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.dlizarra.app.in
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SayHiRequest }
     * 
     */
    public SayHiRequest createSayHiRequest() {
        return new SayHiRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHiRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.dlizarra.com/app/in", name = "SayHiRequest")
    public JAXBElement<SayHiRequest> createSayHiRequest(SayHiRequest value) {
        return new JAXBElement<SayHiRequest>(_SayHiRequest_QNAME, SayHiRequest.class, null, value);
    }

}
