package com.example.JPA.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity // DB 테이블과 매핑하는 객체이다. 이 객체들은 DB상에서는 Table로 나타낸다.
public class Account {

    @Id // 엔티티의 기본 키를 지정한다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키의 값을 자동 생성한다.
    private Long id;

    private String username;

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
        {
            return true;
        }
        if(obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        Account account = (Account) obj;

        return Objects.equals(id, account.id) && Objects.equals(username, account.username) && Objects.equals(password, account.password);
    }
}
