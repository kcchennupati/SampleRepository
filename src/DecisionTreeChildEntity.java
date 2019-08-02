import java.util.List;

public class DecisionTreeChildEntity {
	
	private String name;
	private String rtngclrNm;
	public String getRtngclrNm() {
		return rtngclrNm;
	}
	public void setRtngclrNm(String rtngclrNm) {
		this.rtngclrNm = rtngclrNm;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	private String displayName;
	private String code;
	private String level;
	private List<DecisionTreeChildDriverData> decisionTreeChildDriverDataList;
	public List<DecisionTreeChildDriverData> getDecisionTreeChildDriverDataList() {
		return decisionTreeChildDriverDataList;
	}
	public void setDecisionTreeChildDriverDataList(List<DecisionTreeChildDriverData> decisionTreeChildDriverDataList) {
		this.decisionTreeChildDriverDataList = decisionTreeChildDriverDataList;
	}

}
