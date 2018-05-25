This is a Simple of  Spring security  X.509 (B2B)authentication for tomcat,
 there is a MakeFile in the resources directory, with keytool Commands for generating Self Signed certificate,
  Clients and Servers  KeyStore and and TrustStore files (keystore.jks , truststore.jks )
  and clientname.p12 file which can be used on client side for creating secure connection 

in tomcat you have to enable ssl connector like this , in server.xml add this 
   
 
    
   < Connector port="8443" protocol="HTTP/1.1" SSLEnabled="true" scheme="https" secure="true"
               clientAuth="true" sslProtocol="TLS"
               keystoreFile="${catalina.home}/conf/cert/keystore.jks"
               keystoreType="JKS" keystorePass="Defender1"
               truststoreFile="${catalina.home}/conf/cert/truststore.jks"
               truststoreType="JKS" truststorePass="Defender1"/>
               </cd>
   
   
    
  
