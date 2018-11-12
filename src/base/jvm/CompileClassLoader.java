package base.jvm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class CompileClassLoader extends ClassLoader {
	// 读取一个文件的内容
	private byte[] getBytes(String fileName) throws IOException {
		java.io.File file = new java.io.File(fileName);
		long len = file.length();
		byte[] raw = new byte[(int) len];
		try {
			FileInputStream fin = new FileInputStream(file);
			// 一次性读取class文件的全部二进制数据
			int r = fin.read(raw);
			if (r != len) {
				throw new IOException("无法读取全部文件");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return raw;
	}
	// 定义编译指定java文件的方法
	private boolean compile(String javaFile) throws IOException {
		System.out.println("CompileClassLoader:正在编译" + javaFile + "...");
		// 调用系统的javac命令
		Process p = Runtime.getRuntime().exec("javac " + javaFile);
		try {
			// 其他线程都等待这个线程完毕
			p.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 获取javac线程的退出值
		int ret = p.exitValue();
		// 返回编译是否成功
		return ret == 0;
	}
	// 重写ClassLoader的findClass方法：至于为啥吧重写loadClass方法？
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class clazz = null;
		// 将包路径中的点替换成斜杠/
		String fileStub = name.replace(".", "/");
		String javaFileName = fileStub + ".java";
		String classFileName = fileStub + ".class";
		File javaFile = new File(javaFileName);
		File classFile = new File(classFileName);
		// 当指定java源文件存在且class文件不存在或者java源文件的修改时间比class的修改时间更晚时，重新编译
		if (javaFile.exists() && (!classFile.exists()) || javaFile.lastModified() > classFile.lastModified()) {
			try {
				// 如果编译失败或者该文件不存在
				if (!compile(javaFileName) || !classFile.exists()) {
					throw new ClassNotFoundException("ClassNotFoundException:" + javaFileName);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 如果Class文件存在，系统负责将该文件转换成Class的对象
		if (classFile.exists()) {
			try {
				// 将Class文件的二进制数据读入数组
				byte[] raw = getBytes(classFileName);
				// 调用ClassLoader的defineClass方法将二进制数据转换成Class对象
				clazz = defineClass(name, raw, 0, raw.length);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 如果clazz为空表明加载失败，抛出异常
		if (clazz == null) {
			throw new ClassNotFoundException(name);
		}
		return clazz;
	}
	// 定义一个main方法
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// 如果运行该程序没有参数，即没有目标类
		if (args.length < 1) {
			System.out.println("缺少目标类，请按照以下格式运行java源文件");
			System.out.println("java CompileClassLoader [your class name]");
		}
		// 第一个参数是需要运行的类
		String progClass = args[0];
		// 剩下的参数将作为运行目标类时的参数，将这些参数复制到一个新数组中
		String [] progArgs = new String[args.length - 1];
		System.arraycopy(args, 1, progArgs, 0, progArgs.length);
		CompileClassLoader ccl = new CompileClassLoader();
		// 加载需要运行的类
		Class<?> clazz = ccl.loadClass(progClass);
		// 获取需要运行类的main方法
		java.lang.reflect.Method main = clazz.getMethod("main", (new String[0]).getClass());
		Object argsArray[] = (progArgs);
		main.invoke(null, argsArray);
		
	}

}
