Zuul

|类型|顺序|过滤器|功能|
| ------ | ------ | ------ | ------ |
|pre	|-3	|ServletDetectionFilter	|标记处理Servlet的类型|
|pre	|-2	|Servlet30WrapperFilter	|包装HttpServletRequest请求|
|pre	|-1	|FormBodyWrapperFilter	|包装请求体|
|route	|1	|DebugFilter	|标记调试标志|
|route	|5	|PreDecorationFilter	|处理请求上下文供后续使用|
|route	|10	|RibbonRoutingFilter	|serviceId请求转发|
|route	|100	|SimpleHostRoutingFilter	|url请求转发|
|route	|500	|SendForwardFilter	|forward请求转发|
|post	|0	|SendErrorFilter	|处理有错误的请求响应|
|post	|1000	|SendResponseFilter	|处理正常的请求响应|