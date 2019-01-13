$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("dishes.feature");
formatter.feature({
  "line": 1,
  "name": "Create Dish records and modify them",
  "description": "",
  "id": "create-dish-records-and-modify-them",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "I create, delete several items and invoke parameters and work with them.",
  "description": "",
  "id": "create-dish-records-and-modify-them;i-create,-delete-several-items-and-invoke-parameters-and-work-with-them.",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I check existing of the Dishes list",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I check that it has StatusCode 200 and contentType: application/json",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "I print information about Dishes list",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I DELETE all dishes from the list and it contains 0 item",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "I check the response and statusCode is 200",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I ADD one item as juce, 3, RUB",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I check that dish list contains 1 items",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I ADD 4 dishes",
  "rows": [
    {
      "cells": [
        "name",
        "price",
        "currency"
      ],
      "line": 12
    },
    {
      "cells": [
        "plum",
        "1",
        "EU"
      ],
      "line": 13
    },
    {
      "cells": [
        "tea",
        "2",
        "USD"
      ],
      "line": 14
    },
    {
      "cells": [
        "meat",
        "3",
        "UAH"
      ],
      "line": 15
    },
    {
      "cells": [
        "banana",
        "2",
        "USD"
      ],
      "line": 16
    },
    {
      "cells": [
        "plum",
        "1",
        "EU"
      ],
      "line": 17
    },
    {
      "cells": [
        "meat",
        "3",
        "UAH"
      ],
      "line": 18
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "I check list after adding a new items and it contains 7 items",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "I check response of the statusCode is 200",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "I check that 1st item has name, price and currency",
  "rows": [
    {
      "cells": [
        "name",
        "price",
        "currency"
      ],
      "line": 23
    },
    {
      "cells": [
        "juce",
        "3",
        "RUB"
      ],
      "line": 24
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "I delete 3 and 4 item from the list",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "I check that the list contains 5 items",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "I ADD one new dish",
  "rows": [
    {
      "cells": [
        "name",
        "price",
        "currency"
      ],
      "line": 28
    },
    {
      "cells": [
        "bean",
        "3",
        "UAH"
      ],
      "line": 29
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "I check that final list contains 6 items",
  "keyword": "And "
});
formatter.match({
  "location": "DishesSteps.i_check_existing_of_Dishes_list()"
});
formatter.result({
  "duration": 2711280149,
  "error_message": "java.net.MalformedURLException: no protocol: \"http://localhost:3000/api/dishes\"\r\n\tat java.net.URL.\u003cinit\u003e(URL.java:593)\r\n\tat java.net.URL.\u003cinit\u003e(URL.java:490)\r\n\tat java.net.URL.\u003cinit\u003e(URL.java:439)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.codehaus.groovy.reflection.CachedConstructor.invoke(CachedConstructor.java:83)\r\n\tat org.codehaus.groovy.runtime.callsite.ConstructorSite$ConstructorSiteNoUnwrapNoCoerce.callConstructor(ConstructorSite.java:105)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallConstructor(CallSiteArray.java:59)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:238)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:250)\r\n\tat io.restassured.internal.RequestSpecificationImpl.getTargetURI(RequestSpecificationImpl.groovy:1636)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.codehaus.groovy.reflection.CachedMethod.invoke(CachedMethod.java:98)\r\n\tat groovy.lang.MetaMethod.doMethodInvoke(MetaMethod.java:325)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1225)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1034)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:822)\r\n\tat io.restassured.internal.RequestSpecificationImpl.invokeMethod(RequestSpecificationImpl.groovy)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoInterceptableSite.call(PogoInterceptableSite.java:47)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoInterceptableSite.callCurrent(PogoInterceptableSite.java:57)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallCurrent(CallSiteArray.java:51)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:157)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:169)\r\n\tat io.restassured.internal.RequestSpecificationImpl.partiallyApplyPathParams(RequestSpecificationImpl.groovy:1772)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.codehaus.groovy.reflection.CachedMethod.invoke(CachedMethod.java:98)\r\n\tat groovy.lang.MetaMethod.doMethodInvoke(MetaMethod.java:325)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1225)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1034)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:822)\r\n\tat io.restassured.internal.RequestSpecificationImpl.invokeMethod(RequestSpecificationImpl.groovy)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoInterceptableSite.call(PogoInterceptableSite.java:47)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoInterceptableSite.callCurrent(PogoInterceptableSite.java:57)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallCurrent(CallSiteArray.java:51)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:157)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:185)\r\n\tat io.restassured.internal.RequestSpecificationImpl.newFilterContext(RequestSpecificationImpl.groovy:1156)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.codehaus.groovy.reflection.CachedMethod.invoke(CachedMethod.java:98)\r\n\tat groovy.lang.MetaMethod.doMethodInvoke(MetaMethod.java:325)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1225)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1034)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:822)\r\n\tat io.restassured.internal.RequestSpecificationImpl.invokeMethod(RequestSpecificationImpl.groovy)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoInterceptableSite.call(PogoInterceptableSite.java:47)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoInterceptableSite.callCurrent(PogoInterceptableSite.java:57)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallCurrent(CallSiteArray.java:51)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:157)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:185)\r\n\tat io.restassured.internal.RequestSpecificationImpl.applyPathParamsAndSendRequest(RequestSpecificationImpl.groovy:1742)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.codehaus.groovy.reflection.CachedMethod.invoke(CachedMethod.java:98)\r\n\tat groovy.lang.MetaMethod.doMethodInvoke(MetaMethod.java:325)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1225)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1034)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:822)\r\n\tat io.restassured.internal.RequestSpecificationImpl.invokeMethod(RequestSpecificationImpl.groovy)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoInterceptableSite.call(PogoInterceptableSite.java:47)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoInterceptableSite.callCurrent(PogoInterceptableSite.java:57)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallCurrent(CallSiteArray.java:51)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:157)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:185)\r\n\tat io.restassured.internal.RequestSpecificationImpl.applyPathParamsAndSendRequest(RequestSpecificationImpl.groovy:1750)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.codehaus.groovy.reflection.CachedMethod.invoke(CachedMethod.java:98)\r\n\tat groovy.lang.MetaMethod.doMethodInvoke(MetaMethod.java:325)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1225)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1034)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:822)\r\n\tat io.restassured.internal.RequestSpecificationImpl.invokeMethod(RequestSpecificationImpl.groovy)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoInterceptableSite.call(PogoInterceptableSite.java:47)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoInterceptableSite.callCurrent(PogoInterceptableSite.java:57)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallCurrent(CallSiteArray.java:51)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:157)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:185)\r\n\tat io.restassured.internal.RequestSpecificationImpl.get(RequestSpecificationImpl.groovy:171)\r\n\tat io.restassured.internal.RequestSpecificationImpl.get(RequestSpecificationImpl.groovy)\r\n\tat api.steps.DishesSteps.i_check_existing_of_Dishes_list(DishesSteps.java:40)\r\n\tat ✽.Given I check existing of the Dishes list(dishes.feature:4)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 31
    },
    {
      "val": "application/json",
      "offset": 52
    }
  ],
  "location": "DishesSteps.i_check_existing_of_Dishes_list(int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "DishesSteps.get_prettyPrint_of_dishes(Response)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "0",
      "offset": 50
    }
  ],
  "location": "DishesSteps.delete_all_dishes_by_ID(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 39
    }
  ],
  "location": "DishesSteps.iCheckResponseOfStatusCodeIs(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "juce",
      "offset": 18
    },
    {
      "val": "3",
      "offset": 24
    },
    {
      "val": "RUB",
      "offset": 27
    }
  ],
  "location": "DishesSteps.iAddOneItemAsCucumberEU(String,int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 32
    }
  ],
  "location": "DishesSteps.i_check_dish_list_size(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "DishesSteps.i_add_next_items(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "7",
      "offset": 54
    }
  ],
  "location": "DishesSteps.iCheckThelistAndItContainsItems(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 38
    }
  ],
  "location": "DishesSteps.i_check_response_of_the_status_code_is(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 13
    }
  ],
  "location": "DishesSteps.i_check_that_this_item_has_name_price_and_currency(int,DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 9
    },
    {
      "val": "4",
      "offset": 15
    }
  ],
  "location": "DishesSteps.iDeleteAndItemFromlist(int,int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 31
    }
  ],
  "location": "DishesSteps.iCheckThatlistContainsItem(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "DishesSteps.iAddNewDishes(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "6",
      "offset": 33
    }
  ],
  "location": "DishesSteps.iCheckThatFinalListContainsItems(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("staffs.feature");
formatter.feature({
  "line": 1,
  "name": "Create Staff records and modify them",
  "description": "",
  "id": "create-staff-records-and-modify-them",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "I create, delete several items and invoke parameters and work with them.",
  "description": "",
  "id": "create-staff-records-and-modify-them;i-create,-delete-several-items-and-invoke-parameters-and-work-with-them.",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I ADD one staff item in background_first",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "I check existing of the Staff list",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I check response and it has StatusCode 200 and contentType: application/json",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I print the Staff list",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I delete all records from the Staff list",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "I check that staff list and it contains 0 item",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I check the Staff list and statusCode is 200",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I ADD one staff record as Tony, Stark, hero",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I ADD one staff item in background",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I ADD 3 staffs items",
  "rows": [
    {
      "cells": [
        "first_name",
        "last_name",
        "staff_position"
      ],
      "line": 14
    },
    {
      "cells": [
        "Wonder",
        "Woman",
        "hero"
      ],
      "line": 15
    },
    {
      "cells": [
        "Boba",
        "Fett",
        "actor"
      ],
      "line": 16
    },
    {
      "cells": [
        "Luke",
        "Skywalker",
        "actor"
      ],
      "line": 17
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "I ADD one staff item in background_second",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I check that list contains 6 items",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "I check that last request has statusCode: 200",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "I check that 3 record has name and it has next positon",
  "rows": [
    {
      "cells": [
        "first_name",
        "last_name",
        "staff_position"
      ],
      "line": 22
    },
    {
      "cells": [
        "Wonder",
        "Woman",
        "hero"
      ],
      "line": 23
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "I print the Staff list",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "I delete 1 and 2 item from DB",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "I check that staff list contains 4 item",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "I check that last item has name and position",
  "rows": [
    {
      "cells": [
        "first_name",
        "last_name",
        "staff_position"
      ],
      "line": 28
    },
    {
      "cells": [
        "Wonder",
        "Woman",
        "hero"
      ],
      "line": 29
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "StaffsSteps.iADDOneStaffItemInBackground_first$()"
});
formatter.result({
  "duration": 4040261307,
  "error_message": "java.net.ConnectException: Connection refused: connect\r\n\tat java.net.DualStackPlainSocketImpl.connect0(Native Method)\r\n\tat java.net.DualStackPlainSocketImpl.socketConnect(DualStackPlainSocketImpl.java:79)\r\n\tat java.net.AbstractPlainSocketImpl.doConnect(AbstractPlainSocketImpl.java:350)\r\n\tat java.net.AbstractPlainSocketImpl.connectToAddress(AbstractPlainSocketImpl.java:206)\r\n\tat java.net.AbstractPlainSocketImpl.connect(AbstractPlainSocketImpl.java:188)\r\n\tat java.net.PlainSocketImpl.connect(PlainSocketImpl.java:172)\r\n\tat java.net.SocksSocketImpl.connect(SocksSocketImpl.java:392)\r\n\tat java.net.Socket.connect(Socket.java:589)\r\n\tat org.apache.http.conn.scheme.PlainSocketFactory.connectSocket(PlainSocketFactory.java:121)\r\n\tat org.apache.http.impl.conn.DefaultClientConnectionOperator.openConnection(DefaultClientConnectionOperator.java:180)\r\n\tat org.apache.http.impl.conn.ManagedClientConnectionImpl.open(ManagedClientConnectionImpl.java:326)\r\n\tat org.apache.http.impl.client.DefaultRequestDirector.tryConnect(DefaultRequestDirector.java:610)\r\n\tat org.apache.http.impl.client.DefaultRequestDirector.execute(DefaultRequestDirector.java:445)\r\n\tat org.apache.http.impl.client.AbstractHttpClient.doExecute(AbstractHttpClient.java:835)\r\n\tat org.apache.http.impl.client.CloseableHttpClient.execute(CloseableHttpClient.java:83)\r\n\tat org.apache.http.impl.client.CloseableHttpClient.execute(CloseableHttpClient.java:56)\r\n\tat org.apache.http.client.HttpClient$execute$0.call(Unknown Source)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:47)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:116)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:136)\r\n\tat io.restassured.internal.RequestSpecificationImpl$RestAssuredHttpBuilder.doRequest(RequestSpecificationImpl.groovy:2141)\r\n\tat io.restassured.internal.http.HTTPBuilder.post(HTTPBuilder.java:349)\r\n\tat io.restassured.internal.http.HTTPBuilder$post$2.call(Unknown Source)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:47)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:116)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:136)\r\n\tat io.restassured.internal.RequestSpecificationImpl.sendRequest(RequestSpecificationImpl.groovy:1274)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.codehaus.groovy.reflection.CachedMethod.invoke(CachedMethod.java:98)\r\n\tat groovy.lang.MetaMethod.doMethodInvoke(MetaMethod.java:325)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1225)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1034)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:822)\r\n\tat io.restassured.internal.RequestSpecificationImpl.invokeMethod(RequestSpecificationImpl.groovy)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoInterceptableSite.call(PogoInterceptableSite.java:47)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:47)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:116)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:152)\r\n\tat io.restassured.internal.filter.SendRequestFilter.filter(SendRequestFilter.groovy:30)\r\n\tat io.restassured.filter.Filter$filter$0.call(Unknown Source)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:47)\r\n\tat io.restassured.filter.Filter$filter.call(Unknown Source)\r\n\tat io.restassured.internal.filter.FilterContextImpl.next(FilterContextImpl.groovy:72)\r\n\tat io.restassured.filter.time.TimingFilter.filter(TimingFilter.java:56)\r\n\tat io.restassured.filter.Filter$filter.call(Unknown Source)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:47)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:116)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:144)\r\n\tat io.restassured.internal.filter.FilterContextImpl.next(FilterContextImpl.groovy:72)\r\n\tat io.restassured.filter.FilterContext$next.call(Unknown Source)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:47)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:116)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:136)\r\n\tat io.restassured.internal.RequestSpecificationImpl.applyPathParamsAndSendRequest(RequestSpecificationImpl.groovy:1744)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.codehaus.groovy.reflection.CachedMethod.invoke(CachedMethod.java:98)\r\n\tat groovy.lang.MetaMethod.doMethodInvoke(MetaMethod.java:325)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1225)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1034)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:822)\r\n\tat io.restassured.internal.RequestSpecificationImpl.invokeMethod(RequestSpecificationImpl.groovy)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoInterceptableSite.call(PogoInterceptableSite.java:47)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoInterceptableSite.callCurrent(PogoInterceptableSite.java:57)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:185)\r\n\tat io.restassured.internal.RequestSpecificationImpl.applyPathParamsAndSendRequest(RequestSpecificationImpl.groovy:1750)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.codehaus.groovy.reflection.CachedMethod.invoke(CachedMethod.java:98)\r\n\tat groovy.lang.MetaMethod.doMethodInvoke(MetaMethod.java:325)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1225)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1034)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:822)\r\n\tat io.restassured.internal.RequestSpecificationImpl.invokeMethod(RequestSpecificationImpl.groovy)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoInterceptableSite.call(PogoInterceptableSite.java:47)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoInterceptableSite.callCurrent(PogoInterceptableSite.java:57)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallCurrent(CallSiteArray.java:51)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:157)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:185)\r\n\tat io.restassured.internal.RequestSpecificationImpl.post(RequestSpecificationImpl.groovy:175)\r\n\tat io.restassured.internal.RequestSpecificationImpl.post(RequestSpecificationImpl.groovy)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.codehaus.groovy.reflection.CachedMethod.invoke(CachedMethod.java:98)\r\n\tat groovy.lang.MetaMethod.doMethodInvoke(MetaMethod.java:325)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1225)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1034)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:822)\r\n\tat io.restassured.internal.RequestSpecificationImpl.invokeMethod(RequestSpecificationImpl.groovy)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoInterceptableSite.call(PogoInterceptableSite.java:47)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoInterceptableSite.callCurrent(PogoInterceptableSite.java:57)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallCurrent(CallSiteArray.java:51)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:157)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:169)\r\n\tat io.restassured.internal.RequestSpecificationImpl.post(RequestSpecificationImpl.groovy:259)\r\n\tat io.restassured.internal.RequestSpecificationImpl.post(RequestSpecificationImpl.groovy)\r\n\tat api.steps.StaffsSteps.iADDOneStaffItemInBackground_first$(StaffsSteps.java:44)\r\n\tat ✽.When I ADD one staff item in background_first(staffs.feature:4)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "StaffsSteps.i_check_existing_of_the_staff_list()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 39
    },
    {
      "val": "application/json",
      "offset": 60
    }
  ],
  "location": "StaffsSteps.iCheckRessponseAndItHasStatusCodeAndContentTypeApplicationJson(int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "StaffsSteps.iPrintStaffList()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "StaffsSteps.i_delete_all_records_from_staff_list()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "0",
      "offset": 40
    }
  ],
  "location": "StaffsSteps.i_check_staff_list_and_it_contains_0_items(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 41
    }
  ],
  "location": "StaffsSteps.i_Check_staff_list_Response_Of_StatusCode_Is(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Tony",
      "offset": 26
    },
    {
      "val": "Stark",
      "offset": 32
    },
    {
      "val": "hero",
      "offset": 39
    }
  ],
  "location": "StaffsSteps.I_add_new_one_staff_record(String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "StaffsSteps.iADDOneStaffItemInBackground()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "StaffsSteps.iAddNextItems(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "StaffsSteps.iADDOneStaffItemInBackground_second$()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "6",
      "offset": 27
    }
  ],
  "location": "StaffsSteps.I_check_that_list_contains_items_and_statusCode_is(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 42
    }
  ],
  "location": "StaffsSteps.i_check_response_of_the_status_code_is(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 13
    }
  ],
  "location": "StaffsSteps.iCheckThatHeroHasNameAndItHasPositon(int,DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "StaffsSteps.iPrintStaffList()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 9
    },
    {
      "val": "2",
      "offset": 15
    }
  ],
  "location": "StaffsSteps.iDeleteAndItemFromDB(int,int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "4",
      "offset": 33
    }
  ],
  "location": "StaffsSteps.iCheckThatDBContainsOnlyItem(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "StaffsSteps.thisItemHasNameAndPosition(DataTable)"
});
formatter.result({
  "status": "skipped"
});
});