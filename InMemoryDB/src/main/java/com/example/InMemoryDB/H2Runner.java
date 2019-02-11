package com.example.InMemoryDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class H2Runner implements ApplicationRunner {

    // dataSource에 의존성을 주입받아(H2 dataSource 구현체) H2에 접속하여 SQL문을 수행할 수 있다.
    @Autowired
    DataSource dataSource;

    // jdbcTemplate에 의존성을 주입받아 SQL문을 간편하게 사용할 수 있다.
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        try (Connection connection = dataSource.getConnection())
        {
            System.out.println(connection);

            String URL = connection.getMetaData().getURL();
            System.out.println(URL);

            String User = connection.getMetaData().getUserName();
            System.out.println(User);

            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE USER(ID INTEGER NOT NULL, NAME VARCHAR(255), PRIMARY KEY (ID))";
            statement.executeUpdate(sql);
        }

        jdbcTemplate.execute("INSERT INTO USER VALUES(1, 'Johnny')");

        // 프로그램을 다시 실행해도 인메모리 기반 DB 특성으로 기존 데이터가 유실되기 때문에 SQL 구문은 충돌 오류가 발생하지 않고 실행된다.
    }
}
