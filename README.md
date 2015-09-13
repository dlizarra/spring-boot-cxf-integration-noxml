# Spring Boot and CXF Integration with zero XML configuration

Sample project showing how we can integrate Spring Boot and CXF when creating a JAX-WS SOAP web service with eclusively Java Configuration.

**How to run:**
```
mvn spring-boot:run
```
**Web service will be deployed at:**
```
http://localhost:8080/soap/app?wsdl
```
The web service is implemented following the contract-first/wsdl-first/code-last (pick whatever name you prefer) methodology, but the configuration (except for the wsdl2java maven plugin) would be absolutely the same for a code-first web service.

The logic and the project itself is very simple and it does not have a business or web layer. Since its intent is to show the minimum parts needed to have a deployed SOAP web service working correctly we tried to keep it as simple as possible but following best practices.

## Steps followed to create the web service
### Create the XSD files
Think about the data the web service will be receiving and sending back and design the xsd files. 

I find it very clean to have one xsd for the 'in' parameters, one for the 'out' and another one that imports these two. Those can even be split in more files if the data is very complex, but the idea is to modularize it in a way that will make it easier for us in the future to make changes and to keep control of the xsd files versions. It will also help us define different namespaces for the data types, which by default indicate the package structure of the generated classes.

### Create the WSDL file
In most cases you are going to create a document/literal style web service such as the [one](src/main/resources/wsdl/app1.0.wsdl) in this sample project. Just try to follow the [WS-I Basic Profile specifications](http://ws-i.org/Profiles/BasicProfile-1.2-2010-11-09.html) (most IDE's will warn you if your wsdl is not BP compliant).

### Generate the Service and JAXB classes
Add the `cxf-codegen-plugin` in your [pom.xml](pom.xml) and run the generate-sources maven phase to generate the JAXB classes corresponding to the xsd files, the web service endpoint interface (`@Webservice`) and by default CXF will also generate the client service class (`@WebServiceClient`) although a client can also be implemented with the SEI.

Then you just need to create your web service class with implements the generated web service interface and add the logic to the corresponding method (wsdl operation).

### Configuration
For a full Java Configuration we will only need [three](src/main/java/com/dlizarra/app/config/Application.java) beans:
- A `ServletRegistrationBean` to register the CXF servlet with the url mapping of our choice.
- A `SpringBus` bean explicitly named 'cxf' to instantiate the CXF Bus.
- An `Endpoint` bean representing the web service endpoint and where we can access it.

### Deploying and accessing the web service
Just run `mvn spring-boot:run` as usuall with a Spring Boot webapp and access the web service at `http://localhost:8080/cxf-servlet-url/endpoint-url`.

And that's all there is to develop a contract-first JAX-WS SOAP web service with Spring Boot and CXF with absolutely no XML configuration.
