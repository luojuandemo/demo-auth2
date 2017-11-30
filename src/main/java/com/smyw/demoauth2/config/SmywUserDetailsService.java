package com.smyw.demoauth2.config;

import com.smyw.demoauth2.domian.model.User;
import com.smyw.demoauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author luojuan
 * @create 2017-11-21 8:42
 **/
public class SmywUserDetailsService implements UserDetailsService {

        @Autowired
        private UserService userService;

//        @Autowired
//        private UserRoleService userRoleService;
        /**
         * 根据用户名获取登录用户信息
         * @param username
         * @return
         * @throws UsernameNotFoundException
         */
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            User user = userService.findUserByName(username);
            if(user == null){
                throw new UsernameNotFoundException("用户名："+ username + "不存在！");
            }
            Collection<SimpleGrantedAuthority> collection = new HashSet<>();
            collection.add(new SimpleGrantedAuthority("admin"));

//            Iterator<String> iterator =  userRoleService.findRoles(user.getId()).iterator();
//            while (iterator.hasNext()){
//                collection.add(new SimpleGrantedAuthority(iterator.next()));
//            }

            return new org.springframework.security.core.userdetails.User(username,user.getPassword(),collection);
        }


}
