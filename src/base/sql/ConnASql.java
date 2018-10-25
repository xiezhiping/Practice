package base.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnASql {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
        // 通过反射加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 使用DriverManager获取数据库连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/xzp_db", "root", "xzp123456");
			// 使用Connection创建一个Statement对象
			Statement statement = conn.createStatement();
			// 执行SQL语句
			ResultSet rs = statement.executeQuery("");
			while(rs.next()) {
				System.out.println(rs.getString(0));
			}
		} catch (Exception e) {
			System.out.println("出错了：" + e);
		}
	}

}
