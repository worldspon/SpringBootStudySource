package com.example.JPA;

import com.example.JPA.Entity.Account;
import com.example.JPA.Repository.AccountRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest // 슬라이싱 테스트를 진행할 경우 인메모리 데이터 베이스가 사용되며, 인메모리 데이터 베이스(H2)를 필수로 사용해야한다.
//@SpringBootTest // 모든 스프링 빈을 스프링 컨테이너에 등록할 경우 실제 데이터 베이스(PostgreSQL)에 테스트 코드가 수행된다.
public class JpaApplicationTests {

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	AccountRepository accountRepository; // JpaRepository 인터페이스를 상속받아 다양한 메소드들을 지원한다. 관계형 데이터 베이스 정보를 자바 객체 다루듯 추상화한다.

	@Test
	public void di() throws SQLException {
		try (Connection connection = dataSource.getConnection())
		{
			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println(metaData.getURL());
			System.out.println(metaData.getDriverName());
			System.out.println(metaData.getUserName());
		}
	}

	/*
	findByUsername의 반환 객체를 Optional로 받지 않는 경우의 테스트 케이스
	@Test
	public void accountTest() throws SQLException {
		Account account = new Account();
		account.setUsername("jamong");
		account.setPassword("1234");

		Account newAccount = accountRepository.save(account);

		Assertions.assertThat(newAccount).isNotNull();

		Account nonExistingAccount = accountRepository.findByUsername("Ronaldo");
		Assertions.assertThat(nonExistingAccount).isNull();
	}
	*/

	@Test
	public void accountTestWithOptional() throws SQLException {
		Account account = new Account();
		account.setUsername("jamong");
		account.setPassword("1234");

		Account newAccount = accountRepository.save(account);
		Assertions.assertThat(newAccount).isNotNull();

		Optional<Account> existingAccount = accountRepository.findByUsername(newAccount.getUsername());
		Assertions.assertThat(existingAccount).isNotEmpty();

		Optional<Account> nonExistingAccount = accountRepository.findByUsername("Ronaldo");
		Assertions.assertThat(nonExistingAccount).isEmpty();

		// Optional은 NULL을 반환하지 않는다.
	}

}

