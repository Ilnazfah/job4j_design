package ru.job4j.jdbc;

import junit.framework.TestCase;
import org.junit.*;
import org.junit.Assert;
import org.postgresql.util.PSQLException;

import java.io.*;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

public class TableEditorTest extends TestCase {
    private TableEditor tableEditor;

    @Before
    public void setUp() throws Exception {
        String path = Objects.requireNonNull(ConnectionDemo.class.getClassLoader().getResource("app.properties")).getPath();
        Reader reader = new FileReader(path);
        Properties properties = new Properties();
        properties.load(reader);
        tableEditor = new TableEditor(properties);
        tableEditor.createTable("Table_1");
        tableEditor.createTable("Table_2");
        tableEditor.createTable("Table_3");
    }

    @After
    public void tearDown() throws SQLException {
        tableEditor.dropTable("Table_1");
        tableEditor.dropTable("Table_2");
        tableEditor.dropTable("Table_3");
    }

    @Test
    public void testAddColumn() throws Exception {
        tableEditor.addColumn("Table_1", "new_column", "int");
        String table = TableEditor.getTableScheme(tableEditor.getConnection(), "Table_1");
        assertTrue(table.contains("new_column"));
    }

    @Test
    public void testDropColumn() throws Exception {
        tableEditor.dropColumn("Table_2", "id");
        String table = TableEditor.getTableScheme(tableEditor.getConnection(), "Table_2");
        assertFalse(table.contains("id"));
    }

    @Test
    public void testRenameColumn() throws Exception {
        tableEditor.renameColumn("Table_2", "name", "renamed_column");
        String table = TableEditor.getTableScheme(tableEditor.getConnection(), "Table_2");
        assertTrue(table.contains("renamed_column"));
    }

    @Test
    public void testDropTable() throws Exception {
        tableEditor.dropTable("Table_3");
        try {
            TableEditor.getTableScheme(tableEditor.getConnection(), "Table_3");
            Assert.fail("Expected PSQLException");
        } catch (PSQLException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }
}