# Common

MADANA Common inherits multiple modules which provide different functionality which is utilized in different products.
All modules are linked with Maven. When the Common project is packaged, all submodules will also be built.

Apache Maven (https://maven.apache.org/)  is a software project management and comprehension tool. Based on the concept of a project object model (POM), Maven can manage a project's build, reporting and documentation from a central piece of information.

## install

mvn install


## content

### Database

The database module inherits Handler and classes to connect and communication with different dbms in an OOP manner.

### Datastructures

The datastrucutures module inherits pojo for objects who are used by different products

### Restclient

The Restclient is an always up to data client which inherits all functionality to communicate with the REST Interface of the official MADANA API

### Security

The security module inherits different functionality related to crypographic functions and related implementations

### Utils

Inherits miscellaneous functionality which don't fit into the other modules.

