package projects.DownUtil.DataLayer;

/**
 * ���ص�Ŀ����Դ��
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
		// �Ƚ�����
		if(this == o) return true;
		// �Ƚ�����
		if (o == null || getClass() != o.getClass()) return false;
		// ��ǰ��������������Ļ����ϣ���Ҫ�Ƚ�����
		DownloadTarget other = (DownloadTarget)o;
		// ����ȷ��id�Ƿ�Ϊ�գ�Ȼ���ж�id�Ƿ����other��id
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
