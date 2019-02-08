# hadoop01

### HDFS
* NN名为hadoop01
* linux环境下用户名为hadoop，因此windows环境下运行时要修改运行环境角色
  * Run->Edit Configurations 找到对应方法的VM options,增加配置 -DHADOOP_USER_NAME=hadoop
  * 方法中设置 System.setProperty("HADOOP_USER_NAME","hadoop");

