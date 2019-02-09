# hadoop01

### HDFS
* NN名为hadoop01
* linux环境下用户名为hadoop，因此windows环境下运行时要修改运行环境角色
  * Run->Edit Configurations 找到对应方法的VM options,增加配置 -DHADOOP_USER_NAME=hadoop
  * 方法中设置 System.setProperty("HADOOP_USER_NAME","hadoop");
  
### RPC
* 服务器发布在hostname为hadoop01的linux服务器上
* 客户端在本地
* 使用RPC需保证客户端与服务器实现相同的接口，且接口代码与类路径需完全一致，不然会报【org.apache.hadoop.ipc.RpcServerException): Unknown protocol: hadoop.rpc.Server.LoginService】的错误
