package kr.co.domain;

public class CommandAction {
	private boolean isReDirect;
	private String where;
	
	public CommandAction() {
		
	}

	public CommandAction(boolean isReDirect, String where) {
		super();
		this.isReDirect = isReDirect;
		this.where = where;
	}

	public boolean isReDirect() {
		return isReDirect;
	}

	public void setReDirect(boolean isReDirect) {
		this.isReDirect = isReDirect;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}
	
	
}
