
package repositories.interfaces;

import USER.User;

public interface IRecordRepository {
    boolean insert(int point);

    User saveUser(User user);
}
