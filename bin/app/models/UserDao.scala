package models

import javax.inject.Inject
import org.mindrot.jbcrypt.BCrypt;

@javax.inject.Singleton
class UserDao @Inject()() {

    def lookupUser(u: User): Boolean = {
        //TODO query your database here
        val stored = BCrypt.hashpw(u.password, BCrypt.gensalt());
        val req = "pass";
        if (u.username == "user" && BCrypt.checkpw(req, stored)) true else false
    }

}
