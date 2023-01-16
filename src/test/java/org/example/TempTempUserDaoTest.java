package org.example;

import org.example.connector.ConnectionManager;
import org.example.connector.TempUser;
import org.example.connector.TempUserDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

public class TempTempUserDaoTest {
    @BeforeEach
    void setUp() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("db_schema.sql"));
        DatabasePopulatorUtils.execute(populator, ConnectionManager.getDataSource());
    }

    @Test
    void createTest() throws SQLException {
        TempUserDao tempUserDao = new TempUserDao();

        tempUserDao.create(new TempUser("wch18735", "password", "name", "email"));

        TempUser tempUser = tempUserDao.findByUserId("wch18735");

        assertThat(tempUser).isEqualTo(new TempUser("wch18735", "password", "name", "email"));
    }
}
