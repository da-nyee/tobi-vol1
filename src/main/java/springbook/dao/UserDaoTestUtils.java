package springbook.dao;

import springbook.domain.User;

import java.sql.SQLException;

public class UserDaoTestUtils {
    public static void insertAndSelect(UserDao dao, String id, String name, String password)
            throws ClassNotFoundException, SQLException {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());

        if (!user.getName().equals(user2.getName())) {
            System.out.println("테스트 실패 (name)");
            return;
        }
        if (!user.getPassword().equals(user2.getPassword())) {
            System.out.println("테스트 실패 (password)");
            return;
        }
        System.out.println("조회 테스트 성공");
    }
}
