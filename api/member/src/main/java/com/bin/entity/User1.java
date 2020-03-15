package com.bin.entity;

import lombok.Data;


import javax.persistence.*;

/**
 * ClassName: User1 <br/>
 * Description: <br/>
 * date: 2020/3/13 20:32<br/>
 *
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
@Data
@Entity
@Table(name="t_user")
public class User1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String sex;


}
