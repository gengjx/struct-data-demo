package com.struct.mysqllearning;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MysqlLearningChecker {

    public static void main(String[] args) throws Exception {
        String host = envOrDefault("MYSQL_HOST", "localhost");
        String port = envOrDefault("MYSQL_PORT", "3306");
        String db = envOrDefault("MYSQL_DB", "mysql_learning");
        String user = envOrDefault("MYSQL_USER", "root");
        String password = envOrDefault("MYSQL_PASSWORD", "wgjx913886");

        String url = "jdbc:mysql://" + host + ":" + port + "/" + db + "?useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Shanghai";

        Path solutionsPath = resolveSolutionsPath(args);

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            conn.setAutoCommit(true);

            if (Files.exists(solutionsPath)) {
                System.out.println("Executing solutions file: " + solutionsPath.toAbsolutePath());
                executeSqlFile(conn, solutionsPath);
            } else {
                System.out.println("solutions.sql not found at: " + solutionsPath.toAbsolutePath());
                System.out.println("Tip: put it under exam/solutions.sql (module dir) or pass the path as program arg.");
            }

            List<String> failures = new ArrayList<>();

            assertLongEquals(conn, "SELECT COUNT(*) FROM users", 5L, failures, "users row count should be 4 (seed data)");
            assertLongEquals(conn, "SELECT COUNT(*) FROM products", 4L, failures, "products row count should be 4 (seed data)");
            assertLongEquals(conn, "SELECT COUNT(*) FROM orders", 4L, failures, "orders row count should be 4 (seed data)");
            assertLongEquals(conn, "SELECT COUNT(*) FROM orders WHERE status='PAID'", 2L, failures, "paid orders should be 2 (seed data)");
            assertLongEquals(conn, "SELECT SUM(quantity) FROM order_items WHERE order_id=1", 2L, failures, "order 1 total quantity should be 2");

            if (failures.isEmpty()) {
                System.out.println("CHECK PASSED");
            } else {
                System.out.println("CHECK FAILED");
                for (String f : failures) {
                    System.out.println("- " + f);
                }
                System.exit(2);
            }
        }
    }

    private static String envOrDefault(String key, String defaultValue) {
        String v = System.getenv(key);
        return (v == null || v.isBlank()) ? defaultValue : v;
    }

    private static Path resolveSolutionsPath(String[] args) {
        if (args.length > 0 && args[0] != null && !args[0].isBlank()) {
            return Path.of(args[0]);
        }

        Path defaultPath = Path.of("exam/solutions.sql");
        if (Files.exists(defaultPath)) {
            return defaultPath;
        }

        Path repoRootStylePath = Path.of("mysql-learning/exam/solutions.sql");
        if (Files.exists(repoRootStylePath)) {
            return repoRootStylePath;
        }

        return defaultPath;
    }

    private static void executeSqlFile(Connection conn, Path path) throws IOException, SQLException {
        String content = Files.readString(path, StandardCharsets.UTF_8);
        List<String> statements = splitSqlStatements(content);
        try (Statement st = conn.createStatement()) {
            for (String sql : statements) {
                String s = sql.trim();
                if (s.isEmpty()) {
                    continue;
                }
                st.execute(s);
            }
        }
    }

    private static List<String> splitSqlStatements(String sqlFileContent) {
        String normalized = sqlFileContent
                .replace("\\r\\n", "\\n")
                .replace("\\r", "\\n");

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inSingleQuote = false;
        boolean inDoubleQuote = false;
        boolean inLineComment = false;
        boolean inBlockComment = false;

        for (int i = 0; i < normalized.length(); i++) {
            char c = normalized.charAt(i);
            char next = (i + 1 < normalized.length()) ? normalized.charAt(i + 1) : '\0';

            if (inLineComment) {
                if (c == '\n') {
                    inLineComment = false;
                }
                sb.append(c);
                continue;
            }

            if (inBlockComment) {
                sb.append(c);
                if (c == '*' && next == '/') {
                    sb.append(next);
                    i++;
                    inBlockComment = false;
                }
                continue;
            }

            if (!inSingleQuote && !inDoubleQuote) {
                if (c == '-' && next == '-') {
                    inLineComment = true;
                    sb.append(c).append(next);
                    i++;
                    continue;
                }
                if (c == '/' && next == '*') {
                    inBlockComment = true;
                    sb.append(c).append(next);
                    i++;
                    continue;
                }
            }

            if (c == '\'' && !inDoubleQuote) {
                inSingleQuote = !inSingleQuote;
                sb.append(c);
                continue;
            }
            if (c == '"' && !inSingleQuote) {
                inDoubleQuote = !inDoubleQuote;
                sb.append(c);
                continue;
            }

            if (c == ';' && !inSingleQuote && !inDoubleQuote) {
                res.add(sb.toString());
                sb.setLength(0);
                continue;
            }

            sb.append(c);
        }

        if (!sb.isEmpty()) {
            res.add(sb.toString());
        }
        return res;
    }

    private static void assertLongEquals(Connection conn, String sql, long expected, List<String> failures, String message) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (!rs.next()) {
                failures.add(message + " (no result)");
                return;
            }
            long actual = rs.getLong(1);
            if (actual != expected) {
                failures.add(message + ": expected=" + expected + ", actual=" + actual + ", sql=" + sql);
            }
        }
    }
}
