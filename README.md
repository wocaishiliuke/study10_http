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