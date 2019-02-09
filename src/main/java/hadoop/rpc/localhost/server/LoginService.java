package hadoop.rpc.localhost.server;

public interface LoginService {

    public static final long versionID = 1L;
    public String login(String username,String password);
}
