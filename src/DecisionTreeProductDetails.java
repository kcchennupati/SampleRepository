import java.util.List;

public class DecisionTreeProductDetails {
	
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
	public List<DecisionTreeChildEntity> getDecisionTreeChildEntity() {
		return decisionTreeChildEntity;
	}
	public void setDecisionTreeChildEntity(List<DecisionTreeChildEntity> decisionTreeChildEntity) {
		this.decisionTreeChildEntity = decisionTreeChildEntity;
	}
	private String name;
	private String displayName;
	private String code;
	private String level;
	private List<DecisionTreeChildEntity> decisionTreeChildEntity;

}
