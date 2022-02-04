package server;

public class DBAuthServise implements AuthService {
    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        return SQLBase.getNicknameByLoginAndPassword(login, password);
    }

    @Override
    public boolean registration(String login, String password, String nickname) {
        return SQLBase.registration(login, password, nickname);
    }


    @Override
    public boolean changeNick(String oldNickname, String newNickname) {
        return SQLBase.changeNick(oldNickname, newNickname);
    }
}
