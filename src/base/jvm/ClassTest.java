package base.jvm;

public class ClassTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // ���ʡ��������compileConstant�����
		System.out.println(CompileTest.compileConstant);
	}

}
class CompileTest {
    static {
    	System.out.println("��̬��ʼ����...");
    }
    static final String compileConstant = "�ҵ�final��������Գ���";
}
