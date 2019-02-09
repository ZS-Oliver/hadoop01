package hadoop.rpc.hadoop01.server;

public class LoginServiceImpl implements LoginService {

    @Override
    public String login(String username, String password) {
        return username + " logged in success !";
    }
}
