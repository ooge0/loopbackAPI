##  loopbackAPI

=============
Test framework for REST API back-end testing that is based on the Node.js

## Prerequisites
Java over 1.8.0_151	* Java over 1.8.0_151
Node.js (npm) over 6.1.0 (for launching back-end app)	* Node.js (npm) over 6.1.0 (for launching back-end app)


 ## Test launching
Before any test launching:
start command:
```bash npm start ``` , command from the related loopback project folder.
* Current framework is working with **"Student"** loopback project (and will execute Staffs.feature)
* Student project has simple UI view available on http://localhost:3000/index.html

## Test configuration

 * The launch of executing tests by jUnit configuration proceed by the key - **STAFF** or **RECORD**
- Before any test launching to start command: 'npm start', command for related loopback project.	##


*DataGenerator designing
    Program arguments: -c [count] -d [format] -f [fileName_Location]
    available value for [count]  - from 1 till ∞
    available value for [format]  - xml OR csv OR json
    EXAMPLE:
    -c 2 -d xml -f C:/PROJECT_LOCATION/src/test/resources/groups.xml

                             `. ___
                            __,' __`.                _..----....____
                __...--.'``;.   ,.   ;``--..__     .'    ,-._    _.-'
          _..-''-------'   `'   `'   `'     O ``-''._   (,;') _,'
        ,'________________                          \`-._`-','
         `._              ```````````------...___   '-.._'-:
            ```--.._      ,.                     ````--...__\-.
                    `.--. `-`                       ____    |  |`
                      `. `.                       ,'`````.  ;  ;`
                        `._`.        __________   `.      \'__/`
                           `-:._____/______/___/____`.     \  `
                                       |       `._    `.    \
                                       `._________`-.   `.   `.___
                                                     SSt  `------'`