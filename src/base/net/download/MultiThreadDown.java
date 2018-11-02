package base.net.download;

public class MultiThreadDown {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 初始化DownUtil对象
		final DownUtil downUtil = new DownUtil("http://image.baidu.com/search/down?tn=download&ipn=dwnl&word=download&ie=utf8&fr=result&url=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20170518%2F43682e26bfea484ea6e4141edcaedf85_th.jpg&thumburl=http%3A%2F%2Fimg0.imgtn.bdimg.com%2Fit%2Fu%3D2534296761%2C4066379203%26fm%3D26%26gp%3D0.jpg" + "5702edbd2b97e2de9227485e36c71530.jpg", "zju.png", 4);
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
