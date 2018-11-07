package base.jvm;

public class ClassTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 访问、输出以上compileConstant类变量
		System.out.println(CompileTest.compileConstant);
	}

}
class CompileTest {
    static {
    	System.out.println("静态初始化块...");
    }
    static final String compileConstant = "我的final类变量测试程序";
}
