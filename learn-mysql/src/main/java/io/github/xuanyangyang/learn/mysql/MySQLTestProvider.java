package io.github.xuanyangyang.learn.mysql;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

/**
 * @author xuanyangyang
 * @since 2020/11/27 21:09
 */
public class MySQLTestProvider {
    public static final String SQL_FILE_PATH = "/Users/xuanyangyang/utils/mysql/user.sql";

    public static void main(String[] args) throws IOException {
        File file = new File(SQL_FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("DROP TABLE IF EXISTS `user`;\n" +
                "CREATE TABLE `user` (\n" +
                "  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" +
                "  `name` varchar(64) DEFAULT NULL,\n" +
                "  `password` varchar(64) DEFAULT NULL,\n" +
                "  `mail` varchar(128) DEFAULT NULL,\n" +
                "  `phone` varchar(11) DEFAULT NULL,\n" +
                "  `sex` tinyint(1) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=38414 DEFAULT CHARSET=utf8;\n");
        write(sqlBuilder);
        // 每次提交10w数据，做100次得1000w数据
        for (int i = 0; i < 100; i++) {
            write("BEGIN;\n");
            StringBuilder userData = makeUserData(10 * 10000);
            write(userData);
            write("COMMIT;\n");
        }
    }

    public static StringBuilder makeUserData(int count) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("insert into `user`(name,password,mail,phone,sex) values ");
        Random random = new Random();
        int last = count - 1;
        for (int i = 0; i < count; i++) {
            sqlBuilder.append("(");
            appendField(sqlBuilder, RandomStringUtils.randomAlphabetic(3 + random.nextInt(7)));
            sqlBuilder.append(",");
            appendField(sqlBuilder, RandomStringUtils.randomAlphanumeric(6 + random.nextInt(6)));
            sqlBuilder.append(",");
            appendField(sqlBuilder, RandomStringUtils.randomAlphanumeric(6 + random.nextInt(6)) + "@qq.com");
            sqlBuilder.append(",");
            appendField(sqlBuilder, RandomStringUtils.randomNumeric(11));
            sqlBuilder.append(",");
            appendField(sqlBuilder, random.nextBoolean() ? 1 : 0);
            sqlBuilder.append(")");
            if (i == last) {
                sqlBuilder.append(";");
            } else {
                sqlBuilder.append(",");
            }
        }
        sqlBuilder.append("\n");
        return sqlBuilder;
    }

    public static void appendField(StringBuilder builder, Object field) {
        builder.append("'");
        builder.append(field);
        builder.append("'");
    }

    public static void write(String content) {
        Path path = Paths.get(SQL_FILE_PATH);
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
            bufferedWriter.append(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(StringBuilder builder) {
        write(builder.toString());
    }

    private class User {
        private String username;
        private String password;
        private String mail;
        private String phone;
        private byte sex;

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

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public byte getSex() {
            return sex;
        }

        public void setSex(byte sex) {
            this.sex = sex;
        }

    }
}
