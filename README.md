level1:最原始的透過tcp/ip使用RPC。
level2:Client端利用代理將與網路通訊的程式碼做封裝。
level3:若增加接口則必須再到stub進行相關修改，stub提供動態代理則更彈性。
level4:補強增加TeacherService API，實際調用實作的方法。
level5:可以隨意暴露和變動接口。
level6:加入調用類型增加接口方法。
level7:擴展接口調用更彈性，優化實作服務註解發現。
level8:序列化和反序列化
java.io.serializable只支持Java語言
