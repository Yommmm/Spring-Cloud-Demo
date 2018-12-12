
<a name="paths"></a>
## 资源

<a name="config-controller_resource"></a>
### Config-controller
Config Controller


<a name="getconfigusingget"></a>
#### getConfig
```
GET /boot/v2/config/hahahahah
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|object|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/boot/v2/config/hahahahah
```


##### HTTP响应示例

###### 响应 200
```
json :
"object"
```


<a name="doc-controller_resource"></a>
### Doc-controller
Doc Controller


<a name="generateasciidocsusingget"></a>
#### generateAsciiDocs
```
GET /boot/v2/docs/generateAscii
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/boot/v2/docs/generateAscii
```


<a name="generateasciidocstofileusingget"></a>
#### generateAsciiDocsToFile
```
GET /boot/v2/docs/generateAsciiToFile
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/boot/v2/docs/generateAsciiToFile
```


<a name="generatemarkdowndocsusingget"></a>
#### generateMarkdownDocs
```
GET /boot/v2/docs/generateMarkdown
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/boot/v2/docs/generateMarkdown
```


<a name="generatemarkdowndocstofileusingget"></a>
#### generateMarkdownDocsToFile
```
GET /boot/v2/docs/generateMarkdownToFile
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/boot/v2/docs/generateMarkdownToFile
```


<a name="emp-controller_resource"></a>
### Emp-controller
Emp Controller


<a name="saveusingpost"></a>
#### save
```
POST /boot/v2/emp
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**emp**  <br>*必填*|emp|[Emp](#emp)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/boot/v2/emp
```


###### 请求 body
```
json :
{
  "active" : "string",
  "createTime" : "string",
  "empAddr" : "string",
  "empCode" : "string",
  "empId" : "string",
  "empIdCard" : "string",
  "empName" : "string",
  "salar" : 0.0,
  "status" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "data" : "object",
  "resultCode" : "string",
  "resultMsg" : "string"
}
```


<a name="updateusingput"></a>
#### update
```
PUT /boot/v2/emp
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**emp**  <br>*必填*|emp|[Emp](#emp)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/boot/v2/emp
```


###### 请求 body
```
json :
{
  "active" : "string",
  "createTime" : "string",
  "empAddr" : "string",
  "empCode" : "string",
  "empId" : "string",
  "empIdCard" : "string",
  "empName" : "string",
  "salar" : 0.0,
  "status" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "data" : "object",
  "resultCode" : "string",
  "resultMsg" : "string"
}
```


<a name="listusingget"></a>
#### list
```
GET /boot/v2/emp/list
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/boot/v2/emp/list
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "data" : "object",
  "resultCode" : "string",
  "resultMsg" : "string"
}
```


<a name="queryusingget"></a>
#### query
```
GET /boot/v2/emp/{empId}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**empId**  <br>*必填*|empId|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/boot/v2/emp/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "data" : "object",
  "resultCode" : "string",
  "resultMsg" : "string"
}
```


<a name="deleteusingdelete"></a>
#### delete
```
DELETE /boot/v2/emp/{empId}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**empId**  <br>*必填*|empId|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**204**|No Content|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/boot/v2/emp/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "data" : "object",
  "resultCode" : "string",
  "resultMsg" : "string"
}
```


<a name="feign-controller_resource"></a>
### Feign-controller
Feign Controller


<a name="testusingget"></a>
#### test
```
GET /boot/v2/feign
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/boot/v2/feign
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "data" : "object",
  "resultCode" : "string",
  "resultMsg" : "string"
}
```


<a name="mail-controller_resource"></a>
### Mail-controller
Mail Controller


<a name="sendmailusingpost"></a>
#### 发送邮件
```
POST /boot/v2/mail
```


##### 说明
发送邮件API


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**mail**  <br>*必填*|mail|[Mail](#mail)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|object|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`
* `application/json`


##### HTTP请求示例

###### 请求 path
```
/boot/v2/mail
```


###### 请求 body
```
json :
{
  "content" : "string",
  "receiverAddr" : "string",
  "senderAddr" : "string",
  "subject" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"object"
```



