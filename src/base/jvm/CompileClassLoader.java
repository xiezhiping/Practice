package base.jvm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class CompileClassLoader extends ClassLoader {
	// ��ȡһ���ļ�������
	private byte[] getBytes(String fileName) throws IOException {
		java.io.File file = new java.io.File(fileName);
		long len = file.length();
		byte[] raw = new byte[(int) len];
		try {
			FileInputStream fin = new FileInputStream(file);
			// һ���Զ�ȡclass�ļ���ȫ������������
			int r = fin.read(raw);
			if (r != len) {
				throw new IOException("�޷���ȡȫ���ļ�");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return raw;
	}
	// �������ָ��java�ļ��ķ���
	private boolean compile(String javaFile) throws IOException {
		System.out.println("CompileClassLoader:���ڱ���" + javaFile + "...");
		// ����ϵͳ��javac����
		Process p = Runtime.getRuntime().exec("javac " + javaFile);
		try {
			// �����̶߳��ȴ�����߳����
			p.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ��ȡjavac�̵߳��˳�ֵ
		int ret = p.exitValue();
		// ���ر����Ƿ�ɹ�
		return ret == 0;
	}
	// ��дClassLoader��findClass����������Ϊɶ����дloadClass������
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class clazz = null;
		// ����·���еĵ��滻��б��/
		String fileStub = name.replace(".", "/");
		String javaFileName = fileStub + ".java";
		String classFileName = fileStub + ".class";
		File javaFile = new File(javaFileName);
		File classFile = new File(classFileName);
		// ��ָ��javaԴ�ļ�������class�ļ������ڻ���javaԴ�ļ����޸�ʱ���class���޸�ʱ�����ʱ�����±���
		if (javaFile.exists() && (!classFile.exists()) || javaFile.lastModified() > classFile.lastModified()) {
			try {
				// �������ʧ�ܻ��߸��ļ�������
				if (!compile(javaFileName) || !classFile.exists()) {
					throw new ClassNotFoundException("ClassNotFoundException:" + javaFileName);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// ���Class�ļ����ڣ�ϵͳ���𽫸��ļ�ת����Class�Ķ���
		if (classFile.exists()) {
			try {
				// ��Class�ļ��Ķ��������ݶ�������
				byte[] raw = getBytes(classFileName);
				// ����ClassLoader��defineClass����������������ת����Class����
				clazz = defineClass(name, raw, 0, raw.length);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// ���clazzΪ�ձ�������ʧ�ܣ��׳��쳣
		if (clazz == null) {
			throw new ClassNotFoundException(name);
		}
		return clazz;
	}
	// ����һ��main����
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// ������иó���û�в�������û��Ŀ����
		if (args.length < 1) {
			System.out.println("ȱ��Ŀ���࣬�밴�����¸�ʽ����javaԴ�ļ�");
			System.out.println("java CompileClassLoader [your class name]");
		}
		// ��һ����������Ҫ���е���
		String progClass = args[0];
		// ʣ�µĲ�������Ϊ����Ŀ����ʱ�Ĳ���������Щ�������Ƶ�һ����������
		String [] progArgs = new String[args.length - 1];
		System.arraycopy(args, 1, progArgs, 0, progArgs.length);
		CompileClassLoader ccl = new CompileClassLoader();
		// ������Ҫ���е���
		Class<?> clazz = ccl.loadClass(progClass);
		// ��ȡ��Ҫ�������main����
		java.lang.reflect.Method main = clazz.getMethod("main", (new String[0]).getClass());
		Object argsArray[] = (progArgs);
		main.invoke(null, argsArray);
		
	}

}
