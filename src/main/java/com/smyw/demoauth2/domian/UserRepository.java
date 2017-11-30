package com.smyw.demoauth2.domian;

import com.smyw.demoauth2.domian.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 用户数据访问接口
 *
 * @author luojuan
 * @create 2017-11-20 11:33
 **/
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);
    User findById(Long id);
    User findByNameAndAge(String name, Integer age);
    @Query("select u from User u where u.name=:name")
    User findUser(@Param("name") String name);





}
