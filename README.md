# study10_http

## 要点
### http协议
- http超文本传输协议，是应用层的协议，基于TCP；UDP和TCP是传输层协议
- http1.0每次请求都要创建和关闭TCP连接，建立和关闭连接耗时更长；1.1协议一次连接中进行多次请求和响应
- http默认端口80

### request
- http请求方法8种，常用GET、POST和PUT等
- GET和POST区别：
> - 1.get请求没有请求体(请求行和请求头)，post有(请求行、请求头和请求体)
> - 2.get请求参数拼接在URL后面，post请求则是在请求体中；post请求相对安全
> - 3.get请求路径长度有限制，post理论上没有

### response
- get和post的请求的响应都有：响应行、响应头和响应体

### 其他
- 每次请求都会创建新的request和response对象，响应结束后销毁

### 掌握
- http协议、get和post的比较、请求和响应的组成
- 请求行、请求体和请求参数(get拼在URL，post在请求体)获取的API
- get和post请求的乱码原因(tomcat7及以前)，和各自的几种解决方式
> - 在Tomcat7和之前的版本，默认编码是ISO-8859-1；Tomcat8及之后的版本默认为UTF-8
> - 当页面编码是U8，提交参数时，先用U8编码传递给tomcat，tomcat使用ISO-8859-1再**解码**放入request中
> - 此时从request中取出的参数就已经是乱码了；Tomcat8当然不存在这样的问题
> - 解决方式1：修改Tomcat的默认编码集：server.xml中的connector元素增加URIEncoding="UTF-8"属性，来覆盖默认
> - 解决方式2：先用ISO-8859-1编码，再用U8解码(具体有两种书写方式，get/post都适用，但一次只能针对一个参数)
> - 解决方式3：只适用post请求(有请求体)，对请求体有效，底层做了先编码后解码，但对请求体中的参数都有效