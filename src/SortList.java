import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SortList {
	
	public static void main(String args[]) {
		
		List<DecisionTreeDomain> decisionTreeDomainList = new ArrayList<>();
		
	
		DecisionTreeDomain decisionTreeDomain = new DecisionTreeDomain();
		decisionTreeDomain.setLeNm("BNY_MELLON_LONDON");
		decisionTreeDomain.setCleId("100");
		decisionTreeDomain.setName("BNY");
		
		DecisionTreeDomain decisionTreeDomain1 = new DecisionTreeDomain();
		decisionTreeDomain1.setLeNm("BNY_MELLON_MILAN");
		decisionTreeDomain1.setCleId("200");
		decisionTreeDomain1.setName("BNY");
		
		DecisionTreeDomain decisionTreeDomain2 = new DecisionTreeDomain();
		decisionTreeDomain2.setLeNm("BNY_MELLON_SINGAPORE");
		decisionTreeDomain2.setCleId("300");
		decisionTreeDomain2.setName("BNY");
		
		DecisionTreeDomain decisionTreeDomain3 = new DecisionTreeDomain();
		decisionTreeDomain3.setLeNm("BNY_MELLON_LONDON");
		decisionTreeDomain3.setCleId("400");
		decisionTreeDomain3.setName("BNY");
		
		DecisionTreeDomain decisionTreeDomain4 = new DecisionTreeDomain();
		decisionTreeDomain4.setLeNm("BNY_MELLON_SINGAPORE");
		decisionTreeDomain4.setCleId("500");
		decisionTreeDomain4.setName("BNY");
		
		DecisionTreeDomain decisionTreeDomain5 = new DecisionTreeDomain();
		decisionTreeDomain5.setLeNm("BNY_MELLON_PARIS");
		decisionTreeDomain5.setCleId("600");
		decisionTreeDomain5.setName("BNY");
		
		
		decisionTreeDomainList.add(decisionTreeDomain);
		decisionTreeDomainList.add(decisionTreeDomain1);
		decisionTreeDomainList.add(decisionTreeDomain2);
		decisionTreeDomainList.add(decisionTreeDomain3);
		decisionTreeDomainList.add(decisionTreeDomain4);
		decisionTreeDomainList.add(decisionTreeDomain5);
		
		//constructJsonResponse1(decisionTreeDomainList);
		
		SortList sortList = new SortList();
		sortList.constructJsonResponse1(decisionTreeDomainList);	
	}

	private DecisionTreeProductDetails constructJsonResponse1(List<DecisionTreeDomain> decisionTreeDomainList) {
		
		// sort by leNm
		decisionTreeDomainList.sort(Comparator.comparing(DecisionTreeDomain::getLeNm));
		Map<String, List<DecisionTreeDomain>> map = buildLegalEntityMap(decisionTreeDomainList);

		DecisionTreeProductDetails decisionTreeProductDetails = new DecisionTreeProductDetails();
		List<DecisionTreeChildEntity> decisionTreeChildEntityList = new ArrayList<>();
		DecisionTreeDomain decisionTreeDomain = new DecisionTreeDomain();

		for (Map.Entry<String, List<DecisionTreeDomain>> hm : map.entrySet()) {

			List<DecisionTreeDomain> decisionTreeDomainListLocal1 = new ArrayList<>();
			decisionTreeDomainListLocal1 = hm.getValue();
			decisionTreeDomain = decisionTreeDomainListLocal1.get(0);

			DecisionTreeChildEntity decisionTreeChildEntity = new DecisionTreeChildEntity();
			decisionTreeChildEntity.setName(decisionTreeDomain.getLeNm());
			decisionTreeChildEntity.setDisplayName(decisionTreeDomain.getLeNm());
			decisionTreeChildEntity.setCode(decisionTreeDomain.getCleId());
			decisionTreeChildEntity.setRtngclrNm(decisionTreeDomain.getRtngClrNm());

			List<DecisionTreeChildDriverData> decisionTreeChildDriverDataList = new ArrayList<>();
			decisionTreeDomainListLocal1.forEach(decisionChildDriver -> decisionTreeChildDriverDataList
					.add(setDecisionTreeChildDriverElement(decisionChildDriver)));
			decisionTreeChildEntity.setDecisionTreeChildDriverDataList(decisionTreeChildDriverDataList);
			decisionTreeChildEntityList.add(decisionTreeChildEntity);
		}
		
		decisionTreeProductDetails.setName(decisionTreeDomain.getProductName());
		decisionTreeProductDetails.setDisplayName(decisionTreeDomain.getProductName());
		decisionTreeProductDetails.setCode(decisionTreeDomain.getProductCode());
		decisionTreeProductDetails.setLevel(decisionTreeDomain.getRtngClrNm());
		decisionTreeProductDetails.setDecisionTreeChildEntity(decisionTreeChildEntityList);

		//return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(decisionTreeProductDetails);
		return decisionTreeProductDetails;
	}

	private  Map<String, List<DecisionTreeDomain>> buildLegalEntityMap(
			List<DecisionTreeDomain> decisionTreeDomainList) {

		Map<String, List<DecisionTreeDomain>> map = new HashMap<>();

		Iterator<DecisionTreeDomain> itr = decisionTreeDomainList.iterator();
		List<DecisionTreeDomain> tempList;
		while (itr.hasNext()) {

			DecisionTreeDomain decisionTreeDomainLocal = itr.next();

			tempList = map.get(decisionTreeDomainLocal.getLeNm());

			if (tempList != null && !tempList.isEmpty()) {

				tempList.add(decisionTreeDomainLocal);
				map.put(decisionTreeDomainLocal.getLeNm(), tempList);

			} else {
				tempList = new ArrayList<>();
				tempList.add(decisionTreeDomainLocal);
				map.put(decisionTreeDomainLocal.getLeNm(), tempList);

			}

		}

		return map;

	}

	private  DecisionTreeChildDriverData setDecisionTreeChildDriverElement(DecisionTreeDomain decisionTreeDomain) {
		
		DecisionTreeChildDriverData decisionTreeChildDriverData = new DecisionTreeChildDriverData();
		
		decisionTreeChildDriverData.setName(decisionTreeDomain.getDriverName());
		decisionTreeChildDriverData.setDisplayName(decisionTreeDomain.getDriverName());
		decisionTreeChildDriverData.setCode(decisionTreeDomain.getDriverID());
		decisionTreeChildDriverData.setLevel(decisionTreeDomain.getRtngClrNm());
		decisionTreeChildDriverData.setDetails(decisionTreeDomain.getDriverNote());
		
		return decisionTreeChildDriverData;
	}

}
