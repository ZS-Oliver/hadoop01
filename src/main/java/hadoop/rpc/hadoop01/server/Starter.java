package hadoop.rpc.hadoop01.server;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;

public class Starter {

    public static void main(String[] args) throws IOException {

        RPC.Builder builder = new RPC.Builder(new Configuration());

        builder.setBindAddress("hadoop01").setPort(10000).setProtocol(LoginService.class).setInstance(new LoginServiceImpl());

        RPC.Server server = builder.build();

        server.start();
    }
}
