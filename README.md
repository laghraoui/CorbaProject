# CorbaProject
it's a simple project in which I showed how CORBA works and how to communicate between the server side and the client.

#Instructions

1. New Project
2. Create sysdist.idl file
3. Go to Run > ExternalTools > ExtarnalToolsConfig
    - Location : //set your idlj location (most of time : /usr/lib/jvm/java-8-oracle/bin/idlj for Linux OS)
    - Specify the working directory (Your folder project)
    - In argument add this : -fall -td src sysdist.idl
4. Create new classes HelloImpl, HelloServer and HelloClient
    - HelloImpl : it extends HelloPOA
    - HelloServer : contains the main function included the ORB configuration for the server side
    - HelloClient : contains the main function included the ORB configuration for the client side
5. Go to Run > ExternalTools > ExtarnalToolsConfig
    --> Location : //set your orbd location (most of time : /usr/lib/jvm/java-8-oracle/bin/idlj for Linux OS)
    --> Specify the working directory (Your folder project)
    --> In argument add this : -ORBInitialPort 1050 -ORBInitialHostlocalhost
6. By Running HelloServer you will obtain the naming service 
   By Running HelloClient you will get access to the object and its reference
   
N.B: If you're a Linux user go to : /usr/lib/jvm/java-8-oracle/bin/ and run 'orbd -ORBInitialPort 1050 -ORBInitialHostlocalhost'
as an administrator and run the main method in eclipse as a java application and will work.
