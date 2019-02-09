# hadoop01

### HDFS
* NN名为hadoop01
* linux环境下用户名为hadoop，因此windows环境下运行时要修改运行环境角色
  * Run->Edit Configurations 找到对应方法的VM options,增加配置 -DHADOOP_USER_NAME=hadoop
  * 方法中设置 System.setProperty("HADOOP_USER_NAME","hadoop");
  
### RPC
* 服务器发布在hostname为hadoop01的linux服务器上
* 客户端在本地
* 服务端创建了一个org.apache.hadoop.ipc.RPC的内部类Builder的实例(构造方法Builder(Configuration config))，然后用这个实例设置一些必须的属性(socket通信的服务端设置的属性)，有ip地址、端口号、协议(这里的协议指的就是接口)、接口实例(即接口实现类对象)。最后，调用Builder实例的build()方法得到org.apache.hadoop.ipc.RPC.Server对象，调动该Server对象的start()方法即启动了服务
* 客户端利用org.apache.hadoop.ipc.RPC的getProxy(Class<T> protocol,long clientVersion,InetSocketAddress addr, Configuration conf)方法(此方法里的protocol也就是接口，clientVersion也就是接口代码中配置的versionID的值，InetSocketAddress实例可以通过InetSocketAddress(String hostname, int port)构造器new出来。)获得接口对象(其实是个代理对象)，然后调用此对象的业务方法的效果就等同于直接调服务端业务方法的效果一样。
* 使用RPC需保证客户端与服务器实现相同的接口，且接口代码与类路径需完全一致，不然会报【org.apache.hadoop.ipc.RpcServerException): Unknown protocol: hadoop.rpc.Server.LoginService】的错误
