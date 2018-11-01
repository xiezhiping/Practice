package base.net.download;

public class MultiThreadDown {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 初始化DownUtil对象
		final DownUtil downUtil = new DownUtil("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E6%B5%99%E6%B1%9F%E5%A4%A7%E5%AD%A6&step_word=&hs=0&pn=1&spn=0&di=158650567570&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=2&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=-1&cs=2792581588%2C3892117021&os=4077487077%2C2620861574&simid=3533791172%2C129699780&adpicid=0&lpn=0&ln=1806&fr=&fmq=1541078043462_R&fm=result&ic=0&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20170609%2F9e60b00a2a15442fb373c1cebb2e2a2a_th.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bf5i7_z%26e3Bv54AzdH3FwAzdH3F8909mcdld_llbl80ab&gsm=0&rpstart=0&rpnum=0&islist=&querylist=", "zju.png", 4);
        downUtil.download(); // 开始下载
        new Thread(() -> {
        	while (downUtil.getCompleteRate() < 1) {
        		System.out.println("已完成:" + downUtil.getCompleteRate());
        		try {
        			Thread.sleep(1000);
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
        	}
        }).start();
	}

}
