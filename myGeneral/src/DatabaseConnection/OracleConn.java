package DatabaseConnection;

import Files.Error_Dynamic;
import OptionPane.MsgThread;
import static OriginalClasses.ComboWithIMAGES.comboWithImage;
import Table_List_Property.AllProperty;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class OracleConn {

    public static Connection con = null;
    public static PreparedStatement stat = null;
    public static ResultSet rs = null;
    private static String user_Global = "hr",
            password_Global = "hr",
            driver = "jdbc:oracle:thin:@localhost:1521:";
    public static String sql;
    public static int stop = 0;
    static short i = 0;

    public static void openConn() {
        try {

            // if (con.isClosed()) 
            con = DriverManager.getConnection(driver + "XE", user_Global, password_Global);

        } catch (SQLException ex) {
            Error_Dynamic.getERRORS(OracleConn.class.getName(), "NO Internal Just open Connection", ex);
        }
    }

    public static void openConn(String user, String password, String DataBaseName) {
        try {

            con = DriverManager.getConnection(driver + DataBaseName, user, password);
            user_Global = user;
            password_Global = password;

        } catch (SQLException ex) {

            Error_Dynamic.getERRORS(OracleConn.class.getName() + "  >> Oppen Connection Method", "No Internal Jus Open Connection", ex);
            try {
                con.close();
                stat.clearParameters();
                stat.close();
                rs.close();
            } catch (java.lang.NullPointerException e) {
                Error_Dynamic.getERRORS("begin.oppenConn>>When Closed", e);
            } catch (SQLException ex1) {
                Error_Dynamic.getERRORS("begin.oppenConn>>When Closed", "No Internal Closed Connection", ex);
            }
        }
    }

    public static Connection OpenConn(String user, String password, String DataBaseName) {
        try {

            con = DriverManager.getConnection(driver + DataBaseName, user, password);

        } catch (SQLException ex) {

            Error_Dynamic.getERRORS(OracleConn.class.getName() + "  >> Oppen Connection Method", "No Internal Jus Open Connection", ex);
            try {
                con.close();
                stat.clearParameters();
                stat.close();
                rs.close();
            } catch (java.lang.NullPointerException e) {
                Error_Dynamic.getERRORS("begin.oppenConn>>When Closed", e);
            } catch (SQLException ex1) {
                Error_Dynamic.getERRORS("begin.oppenConn>>When Closed", "No Internal Closed Connection", ex);
            }
        }
        return con;
    }

    public static Connection GetConn() {
        return con;
    }

    public static void openRemoteConn(String IP_SERVER, String DataBaseName, int PortNumber, String user, String password) {

        try {

            con = DriverManager.getConnection("jdbc:oracle:thin:@" + IP_SERVER + ":" + PortNumber + ":" + DataBaseName, user, password);

        } catch (SQLException ex) {

            Error_Dynamic.getERRORS("begin.oppenConn RemotlyMethod", "No internal", ex);
            try {
                con.close();
                stat.clearParameters();
                stat.close();
                rs.close();
            } catch (SQLException ex1) {
                Error_Dynamic.getERRORS("begin.oppenConn RemotlyMethod>>When Closed", "Closed Connection", ex);
            }
        }
    }

    public static boolean openRemoteConn(String IP_SERVER, String DataBaseName, String PortNumber, String user, String password) {

        try {

            con = DriverManager.getConnection("jdbc:oracle:thin:@" + IP_SERVER + ":" + PortNumber + ":" + DataBaseName, user, password);
            return true;

        } catch (SQLException ex) {

            Error_Dynamic.getERRORS("begin.oppenConn RemotlyMethod", "No internal", ex);

            return false;

        }
    }

    public static boolean executeDML_SQL(String sql) {

        try {
            stat = con.prepareStatement(sql);
            stat.executeUpdate();
            System.err.println(sql);
            return true;
        } catch (SQLException ex) {
            Error_Dynamic.getERRORS(OracleConn.class.getName() + "  >>executeDML_SQL(String sql) Method", sql, ex);
            //JOptionPane.showMessageDialog(null, ex.getErrorCode()+"-"+ex.getLocalizedMessage()+"\n Please Contact with System Admin","Error",0);
            return false;
        }
    }

    public static boolean executeDML_SQL(String sql, boolean msgShowAuto) {

        try {
            System.err.println(sql);
            stat = con.prepareStatement(sql);
            stat.executeUpdate();

            if (sql.startsWith("begin load_file(0")) {
                OptionPane.MsgThread.msg_Success('i');
            } else if (sql.startsWith("begin load_file(1")) {
                OptionPane.MsgThread.msg_Success('u');
            }

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            Error_Dynamic.getERRORS(OracleConn.class.getName() + "  >>executeDML_SQL(String sql,boolean msgShowAuto) Method", sql, ex);
            //JOptionPane.showMessageDialog(null, ex.getErrorCode()+"-"+ex.getLocalizedMessage()+"\n Please Contact with System Admin","Error",0);
            return false;
        }
    }

    public static int executeDML_returnNumberRowsAffected(String sql) {

        try {
            stat = con.prepareStatement(sql);
            return stat.executeUpdate();

        } catch (SQLException ex) {
            Error_Dynamic.getERRORS(OracleConn.class.getName() + "  >>executeDML_returnNumberRowsAffected Method", sql, ex);
            //JOptionPane.showMessageDialog(null, ex.getErrorCode()+"-"+ex.getLocalizedMessage()+"\n Please Contact with System Admin","Error",0);
            return -1;
        }
    }

    public static ResultSet executeQuery(String sql) {
        try {
            stat = con.prepareStatement(sql);
            rs = stat.executeQuery(sql);

            return rs;

        } catch (SQLException ex) {
            Error_Dynamic.getERRORS(OracleConn.class.getName() + "  >>executeQuert(String SQL) Method", sql, ex);
            //JOptionPane.showMessageDialog(null, ex.getErrorCode()+"-"+ex.getLocalizedMessage()+"\n Please Contact with System Admin","Error",0);
            return null;
        }
    }

    public static int eXecuteQuery(String sql) {
        int k = 0;
        try {
            stat = con.prepareStatement(sql);
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                k++;
            }

        } catch (SQLException ex) {
            Error_Dynamic.getERRORS(OracleConn.class.getName() + "  >>executeQuert(String SQL) Method", sql, ex);
            //JOptionPane.showMessageDialog(null, ex.getErrorCode()+"-"+ex.getLocalizedMessage()+"\n Please Contact with System Admin","Error",0);
        }
        return k;
    }

    public static Vector executeQuerY(String sql) {
        try {

            stat = con.prepareStatement(sql);
            rs = stat.executeQuery(sql);

            Vector val = new Vector();

            while (rs.next()) {
                val.addElement(rs.getObject(1));
            }
            return val;

        } catch (SQLException ex) {
            Error_Dynamic.getERRORS(OracleConn.class.getName() + "  >>executeQuert(String SQL) Method", sql, ex);
            // JOptionPane.showMessageDialog(null, ex.getErrorCode()+"-"+ex.getLocalizedMessage()+"\n Please Contact with System Admin","Error",0);
            return null;
        }
    }

    public static void FullCombo(JComboBox<String> ComboBox, String Table, String Column) {

        try {
            String top = ComboBox.getItemAt(0);
            ComboBox.removeAllItems();
            ComboBox.addItem(top);
            executeQuery("select " + Column + " from " + Table);
            while (rs.next()) {
                ComboBox.addItem(rs.getString(1));
            }

        } catch (SQLException ex) {
            Error_Dynamic.getERRORS(OracleConn.class.getName(), "select " + Column + " from " + Table, ex);
            // JOptionPane.showMessageDialog(null, ex.getErrorCode()+"-"+ex.getLocalizedMessage()+"\n Please Contact with System Admin","Error",0);
        }

    }

    public static void FullCombo(JComboBox<String> ComboBox, String Table, String Column, String Where) {

        try {
            String top = ComboBox.getItemAt(0);
            ComboBox.removeAllItems();
            ComboBox.addItem(top);
            executeQuery("select " + Column + " from " + Table + " where " + Where);
            while (rs.next()) {
                ComboBox.addItem(rs.getString(1));
            }

        } catch (SQLException ex) {
            Error_Dynamic.getERRORS(OracleConn.class.getName(), "select " + Column + " from " + Table + " where " + Where, ex);
            // JOptionPane.showMessageDialog(null, ex.getErrorCode()+"-"+ex.getLocalizedMessage()+"\n Please Contact with System Admin","Error",0);
        }

    }

    public static String username, Pass;
    public static int[] array = new int[5];

    public static void validation(String ClassName) {

        try {
            sql = "SELECT    adding,"
                    + "edite,"
                    + "remove,"
                    + "viewdata,"
                    + "showform "
                    + "FROM users JOIN VALIDATIONS on VALIDATIONS.USER_ID = users.USER_ID "
                    + " where USERName ='" + username + "' and password='" + Pass + "' and FormID='" + ClassName + "'";
            System.err.println(username);
            executeQuery(sql);
            int k = 0;

            while (rs.next()) {
                for (int H = 1; H <= array.length; H++) {
                    array[k++] = (rs.getInt(H));
                }
            }

            if (array[4] == 0) {
                JOptionPane.showMessageDialog(null, "You Don't Have Privilage To Open This Form\nContact with System Admin", "Authorization", JOptionPane.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, "Username/Password Not Correct","Failed",JOptionPane.ERROR_MESSAGE);
                return;
            }

        } catch (SQLException ex) {
            Logger.getLogger(OracleConn.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ;

 
public static void fullComboBox(String[] sql, int NumberOfColumns, String prefix, String postfix, String ColumnSperator, JComboBox... combobox) {
        try {
            int counter = -1;
            String c = "";
            counter++;
            for (JComboBox j2 : combobox) {
                for (int i = counter; i < sql.length; i++) {

                    if (sql[counter].equals("") || sql[counter].equals(" ") || sql[counter] == null)
                   ; else {
                        stat = con.prepareStatement(sql[counter]);
                        rs = stat.executeQuery(sql[counter]);

                        while (rs.next()) {
                            {
                                for (int j = 1; j <= NumberOfColumns; j++) {
                                    c = c + rs.getObject(j) + ColumnSperator;
                                }
                                j2.addItem(prefix + c.substring(0, (c.length() - 1)) + postfix);
                                c = "";

                            }
                        }
                    }
                    break;
                }
            }

        } catch (SQLException ex) {
            for (String s : sql) {
                Error_Dynamic.getERRORS(OracleConn.class.getName() + "  >>fullComboBox(String[] sql,int NumberOfColumns,String prefix,String postfix,String ColumnSperator,JComboBox... combobox) Method", s, ex);
            }
            //  JOptionPane.showMessageDialog(null, ex.getErrorCode()+"-"+ex.getLocalizedMessage()+"\n Please Contact with System Admin","Error",0);

        }
    }

    public static void executeQueryinLIST(String[] sql, int NumberOfColumns, String prefix, String postfix, String ColumnSperator, java.awt.List... List) {
        try {
            int counter = -1;
            String c = "";
            counter++;
            for (java.awt.List j2 : List) {
                for (int i = counter; i < sql.length; i++) {

                    if (sql[counter].equals("") || sql[counter].equals(" ") || sql[counter] == null)
                   ; else {
                        stat = con.prepareStatement(sql[counter]);
                        rs = stat.executeQuery(sql[counter]);

                        while (rs.next()) {
                            {
                                for (int j = 1; j <= NumberOfColumns; j++) {
                                    c = c + rs.getObject(j) + ColumnSperator;
                                }
                                j2.add(prefix + c.substring(0, (c.length() - 1)) + postfix);
                                c = "";

                            }
                        }
                    }
                    break;
                }
            }

        } catch (SQLException ex) {
            for (int j = 0; j < sql.length; j++) {
                Error_Dynamic.getERRORS(OracleConn.class.getName() + "  >>executeQueryinLIST(String[] sql,int NumberOfColumns,String prefix,String postfix,String ColumnSperator,java.awt.List... List)Method", sql[j], ex);
            }
            //  JOptionPane.showMessageDialog(null, ex.getErrorCode()+"-"+ex.getLocalizedMessage()+"\n Please Contact with System Admin","Error",0);

        }
    }

    public static void executeQueryinTABLE(String sql, String[] Columns1, JTable... table) {
        try {

            int counter = -1;
            String c = "";
            counter++;

            for (JTable j2 : table) {
                DefaultTableModel mod = (DefaultTableModel) j2.getModel();

                int columns = 0, co = 0, data = 1, s = 0;
                for (columns = 0; columns < Columns1.length; columns++) {
                    mod.addColumn(Columns1[columns]);
                }

                stat = con.prepareStatement(sql);
                rs = stat.executeQuery(sql);
                while (rs.next()) {
                    mod.addRow(new Object[]{});
                }

                for (int g = 0; g < mod.getColumnCount(); g++) {

                    if (sql.equals("")) {
                        return;
                    }

                    stat = con.prepareStatement(sql);
                    rs = stat.executeQuery(sql);

                    while (rs.next()) {
                        mod.setValueAt(rs.getObject(data), s++, co);

                    }
                    data++;
                    co++;
                    s = 0;
                }

            }

        } catch (SQLException ex) {
            Error_Dynamic.getERRORS(OracleConn.class.getName() + "  >> executeQueryinTABLE(String sql,String[]Columns1,JTable... table) Method", sql, ex);
            // JOptionPane.showMessageDialog(null, ex.getErrorCode()+"-"+ex.getLocalizedMessage()+"\n Please Contact with System Admin","Error",0);
        }
    }

    public static void QueryinTABLE(String sql, JTable table, String... Columns1) {
        short s = 0, k = 0, m = -1;
        try {
            DefaultTableModel mod = (DefaultTableModel) table.getModel();

            for (String col : Columns1) {
                mod.addColumn(col);
                s++;
            }
            stat = con.prepareStatement(sql);
            rs = stat.executeQuery(sql);

            while (rs.next()) {
                mod.addRow(new Object[]{});
                for (int j = 1; j <= s; j++) {
                    mod.setValueAt(rs.getObject(j), k, ++m);
                }
                k++;
                m = -1;
            }

        } catch (SQLException ex) {
            Error_Dynamic.getERRORS(OracleConn.class.getName() + "  >> QueryinTABLE(String sql,JTable table,String ... Columns1) Method", sql, ex);
            // JOptionPane.showMessageDialog(null, ex.getErrorCode()+"-"+ex.getLocalizedMessage()+"\n Please Contact with System Admin","Error",0);
        }

    }

    public static void QueryinTABLE(String sql, JTable table) {
        AllProperty.clearRows(table);
        short k = 0, m = -1;
        try {
            DefaultTableModel mod = (DefaultTableModel) table.getModel();

            stat = con.prepareStatement(sql);
            //****************************    
            stat.setMaxRows(50);//********
            //****************************

            rs = stat.executeQuery(sql);

            while (rs.next()) {
                mod.addRow(new Object[]{});
                for (int j = 1; j <= table.getColumnCount(); j++) {
                    mod.setValueAt(rs.getObject(j), k, ++m);
                }
                k++;
                m = -1;
            }

            stat.setMaxRows(0);

            k = 0;
            m = -1;

        } catch (java.lang.NullPointerException r) {
            Error_Dynamic.getERRORS(OracleConn.class.getName() + "  >> QueryinTABLE(String sql,JTable table ) Method", r);
        } catch (SQLException ex) {
            Error_Dynamic.getERRORS(OracleConn.class.getName() + "  >> QueryinTABLE(String sql,JTable table ) Method", sql, ex);
            // JOptionPane.showMessageDialog(null, ex.getErrorCode()+"-"+ex.getLocalizedMessage()+"\n Please Contact with System Admin","Error",0);
        }

    }

    public static String loopAtTable(JTable Table, int Column, String Sperator, String Qotation) {
        String s = "";
        for (int i = 0; i < Table.getRowCount(); i++) {
            s = s + Qotation + Table.getValueAt(i, Column) + Qotation + Sperator;
        }

        s = s.substring(0, (s.length() - 1));
        System.err.println(s);
        return s;
    }

    public static void executeQueryinCOMBOBOXwitIMAGE(String sql, JComboBox combobox) {
        String[] s1 = new String[10];
        String[] s2 = new String[10];
        int k = 0;

        //for(JComboBox c : combobox)
        {
            try {
                stop = 0;
                executeQuery(sql);
                while (rs.next()) {
                    s1[k] = rs.getObject(1) + "";
                    s2[k] = rs.getObject(2) + "";
                    k++;
                    stop++;
                }

//           for (int i = 0; i < stop; i++) {
//               System.err.println(s2[i]+"  content");
//           }
                comboWithImage(combobox, s1, s2);

            } catch (SQLException ex) {
                Error_Dynamic.getERRORS(OracleConn.class.getName() + "  >> executeQueryinCOMBOBOXwitIMAGE(String  sql,JComboBox combobox) Method", sql, ex);
                // JOptionPane.showMessageDialog(null, ex.getErrorCode()+"-"+ex.getLocalizedMessage()+"\n Please Contact with System Admin","Error",0);
            }
        }

    }

    public static void insertSQL(String TableName, Object... Values) {
        String val = "";
        for (Object Value : Values) {
            val = val + "(" + Value + "),";
        }

        val = val.substring(0, val.length() - 2) + ")";

        sql = "insert into " + TableName + " values(" + val + ")";
        System.out.println(sql);

        if (executeDML_SQL(sql)) {
            MsgThread.msg_Success('i');
        }

    }

    public static void insertSQL(String FullSQL) {

        System.out.println(FullSQL);
        if (executeDML_SQL(FullSQL)) {
            MsgThread.msg_Success('i');
        }
    }

    public static void Save(String FullSQL) {

        System.out.println(FullSQL);
        if (executeDML_SQL(FullSQL)) {
            MsgThread.msg_Success(" Data Saved  ", 3);
        }
    }

    public static void updateSQL(String TableName, String[] ColumnUpdate, String ColumnCondition, Object... Values) {

        String val = "";
        for (Object Value : Values) {
            val = val + " " + ColumnUpdate[i++] + " =(" + Value + "),";
        }

        val = val.substring(0, val.length() - 2) + ")";

        sql = "update  " + TableName + " set " + val + " where " + ColumnCondition;
        System.out.println(sql);
        if (executeDML_SQL(sql)) {
            MsgThread.msg_Success('u');
        }

        i = 0;
    }

    public static void updateSQL(String TableName, String[] ColumnUpdate, String[] ColumnConditions, String... Values) {

        String val = "", con = "";
        for (String Value : Values) {
            val = val + " " + ColumnUpdate[i] + " =(" + Value + "),";
            con = con + ColumnConditions[i++] + " AND ";
        }

        val = val.substring(0, val.length() - 2) + ")";
        con = con.substring(0, (con.length() - 4));

        sql = "update  " + TableName + " set " + val + " where " + con;
        System.out.println(sql);
        if (executeDML_SQL(sql)) {
            MsgThread.msg_Success('u');
        }
        i = 0;

    }

    public static void updateSQL(String FullSQL) {

        System.out.println(FullSQL);
        if (executeDML_SQL(FullSQL)) {
            MsgThread.msg_Success('u');
        }

    }

    public static void deleteSQL(String TableName, String[] ColumnConditions, String... ValuesConditions) {
        String val = "", con = "";
        for (String Value : ValuesConditions) {
            val = val + " " + ColumnConditions[i++] + " = " + Value + " AND ";

        }

        val = val.substring(0, val.length() - 4);

        sql = "delete from " + TableName + " WHERE  = " + val;
        System.out.println(sql);
        if (executeDML_SQL(sql)) {
            MsgThread.msg_Success('d');
        }
        i = 0;
    }

    public static void deleteSQL(String TableName, String Where) {

        sql = "delete from " + TableName + " WHERE " + Where;

        System.out.println(sql);
        if (executeDML_SQL(sql)) {
            MsgThread.msg_Success('d');
        }

    }

    public static void deleteSQL(String FullSQL) {

        System.out.println(FullSQL);
        if (executeDML_SQL(FullSQL)) {
            MsgThread.msg_Success('d');
        }

    }

    public static void ImageLabel(String TabelName, String ImageColumn, String WhereCluse, JLabel label) {
        try {
            sql = "select " + ImageColumn + " from " + TabelName + " where " + WhereCluse;
            rs = stat.executeQuery(sql);

            if (rs.next()) {

                java.sql.Blob blob = rs.getBlob(ImageColumn);
                if (blob == (null)) {

                    return;
                }

                InputStream in = blob.getBinaryStream();
                BufferedImage image = ImageIO.read(in);
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_AREA_AVERAGING));
                label.setText("");
                label.setIcon(imageIcon);
            }

        } catch (SQLException ex) {
            Files.Error_Dynamic.getERRORS("Oracle Connection Class", sql, ex);
            //   JOptionPane.showMessageDialog(null, ex.getErrorCode()+"-"+ex.getLocalizedMessage()+"\n Please Contact with System Admin","Error",0);
        } catch (IOException ex) {
            Files.Error_Dynamic.getERRORS("Oracle Connection Class", ex);
            //  JOptionPane.showMessageDialog(null, ex.getLocalizedMessage()+"\n Please Contact with System Admin","Error",0);
        }

    }

    public static Object ret_value(String sql) {
        try {
            executeQuery(sql);
            while (rs.next()) {
                return rs.getObject(1);
            }

        } catch (SQLException ex) {
            Error_Dynamic.getERRORS(OracleConn.class.getName() + "  >>ret_value(String sql) Method", sql, ex);
            //JOptionPane.showMessageDialog(null, ex.getErrorCode()+"-"+ex.getLocalizedMessage()+"\n Please Contact with System Admin","Error",0);
        }
        return null;
    }

    public static void PLSQL_Silent(String SQLS) {

        try {
            System.err.println(SQLS);
            stat = con.prepareStatement("begin " + SQLS + " END;");
            stat.executeUpdate();

        } catch (SQLException ex) {
            Error_Dynamic.getERRORS(OracleConn.class.getName() + "  >> Method PLSQL_Silent", SQLS, ex);
        }

    }

    public static void PLSQL_Declare(String SQLS) {

        try {
            System.err.println(SQLS);
            stat = con.prepareStatement(SQLS);
            stat.executeUpdate();

        } catch (SQLException ex) {
            Error_Dynamic.getERRORS(OracleConn.class.getName() + "  >> Method PLSQL_Silent", SQLS, ex);
        }

    }

    public static Boolean Close_Connection() {

        try {
            con.close();
            //stat.close();
            //rs.close();
            return true;
        } catch (SQLException ex) {
            Error_Dynamic.getERRORS(OracleConn.class.getName() + "  >> Method PLSQL_Silent", "CLOSED FUNCTION", ex);
            return false;
        }

    }

    public static Boolean Restart_Connection() {

        try {
            con.close();
            //   stat.close();
            //   rs.close();

            openConn();

            return true;
        } catch (SQLException ex) {
            Error_Dynamic.getERRORS(OracleConn.class.getName() + "  >> Method PLSQL_Silent", "CLOSED FUNCTION", ex);
            return false;
        }

    }

}
