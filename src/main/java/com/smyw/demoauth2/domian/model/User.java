package com.smyw.demoauth2.domian.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户实体
 *asdfasdf
 * @author luojuan
 * @create 2017-11-20 11:35
 **/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_user")
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "f_id")
    private Long id;
    @Column(name = "f_name")
    private String name;
    @Column(name = "f_age")
    private Integer age;
    @Column(name = "f_password")
    private String password;

    public User(String name , Integer age){
        this.name = name;
        this.age = age;
    }
}
