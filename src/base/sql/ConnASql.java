package base.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnASql {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
        // ͨ�������������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// ʹ��DriverManager��ȡ���ݿ�����
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/xzp_db", "root", "xzp123456");
			// ʹ��Connection����һ��Statement����
			Statement statement = conn.createStatement();
			// ִ��SQL���
			ResultSet rs = statement.executeQuery("");
			while(rs.next()) {
				System.out.println(rs.getString(0));
			}
		} catch (Exception e) {
			System.out.println("�����ˣ�" + e);
		}
	}

}
