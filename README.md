# Common
![Build Status](https://intranet.madana.io/bamboo/plugins/servlet/wittified/build-status/MAD-MADC)

MADANA Common inherits multiple modules which provide different functionality which is utilized in different products.
All modules are linked with Maven. When the Common project is packaged, all submodules will also be built.

Apache Maven (https://maven.apache.org/)  is a software project management and comprehension tool. Based on the concept of a project object model (POM), Maven can manage a project's build, reporting and documentation from a central piece of information.

## install
```
git clone
git submodule update --init --recursive
mvn install
```

## content

### madana-common-database
![Build Status](https://intranet.madana.io/bamboo/plugins/servlet/wittified/build-status/MC-MCDB)
The database module inherits Handler and classes to connect and communication with different dbms in an OOP manner.

### madana-common-datastructures
![Build Status](https://intranet.madana.io/bamboo/plugins/servlet/wittified/build-status/MC-MCDS)
The datastrucutures module inherits pojo for objects who are used by different products

### madana-common-restlcient
![Build Status](https://intranet.madana.io/bamboo/plugins/servlet/wittified/build-status/MC-MCR)
The Restclient is an always up to data client which inherits all functionality to communicate with the REST Interface of the official MADANA API

### madana-common-security
![Build Status](https://intranet.madana.io/bamboo/plugins/servlet/wittified/build-status/MC-MCS)
The security module inherits different functionality related to crypographic functions and related implementations

### madana-common-utils
https://intranet.madana.io/bamboo/plugins/servlet/wittified/build-status/MC-MCU
Inherits miscellaneous functionality which don't fit into the other modules.

