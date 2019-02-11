package com.example.JPA.Repository;

import com.example.JPA.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    // 메소드에 대한 코드를 작성하지 않아도 Spring-Data-JPA가 자동으로 해당 DB의 username에 대한 객체를 반환한다.
    Optional<Account> findByUsername(String username);
    // Spring-Data-JPA에서 제공하는 메소드의 반환 객체를 Optional 클래스로 받을 수 있다.

    // @Query 어노테이션을 통해 SQL 쿼리를 작성하여 메소드와 매핑할 수 있다.
    @Query(nativeQuery = true, value = "SELECT * FROM ACCOUNT WHERE PASSWORD")
    Account findByPassword(String password);
}
