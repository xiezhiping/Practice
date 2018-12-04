package projects.DownUtil.DataLayer;

/**
 * 下载的目标资源类
 * @author XZP
 *
 */
public class DownloadTarget {
	private String id = null;
	private String url = null;
	private String name = null;
	private String savePath = null;
//	public DownloadTarget() {
//		this.url = url;
//		this.name = name;
//		this.savePath = savePath;
//		this.id = url + "#" + name + "@" + savePath;
//	}
	@Override
	public String toString() {
		return getClass().getSimpleName() + " [id:" + getId() + "]";
	}
	@Override
	public int hashCode() {
		return getId() != null ? getId().hashCode() : 0;
	}
	@Override
	public boolean equals(Object o) {
		// 比较引用
		if(this == o) return true;
		// 比较类型
		if (o == null || getClass() != o.getClass()) return false;
		// 在前面两个都不满足的基础上，需要比较内容
		DownloadTarget other = (DownloadTarget)o;
		// 首先确定id是否为空，然后判断id是否等于other的id
		if (getId() != null ? !getId().equals(other.getId()) : other.getId() != null) return false;
		return true;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String getId() {
		return url + "#" + name + "@" + savePath;
	}
	
}
