package com.hua.People;
/**
 * 	¼ÇÂ¼²¡ÈËÖ¢×´±í
 * @author Éòshuohua
 *
 */
public class RecordHealthy {
	private int id;
	private int IdentityId;
	private int symptomId;
	/**
	 * 
	 * @param id
	 * @param identityId
	 * @param name
	 * @param symptomId
	 * @param sysptomDesc
	 */
	public RecordHealthy(int id, int identityId, int symptomId) {
		super();
		this.id = id;
		IdentityId = identityId;
		this.symptomId = symptomId;
	}
	public RecordHealthy(int symptomId) {
		super();
		this.symptomId = symptomId;
	}
	public int getIdentityId() {
		return IdentityId;
	}
	public void setIdentityId(int identityId) {
		IdentityId = identityId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSymptomId() {
		return symptomId;
	}
	public void setSymptomId(int symptomId) {
		this.symptomId = symptomId;
	}
	
	
	
}
