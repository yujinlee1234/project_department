package com.dgit.department.setting;

public class InitSettingService extends SettingService {
	private static final InitSettingService instance = new InitSettingService();
	
	/**
	 * @return the instance
	 */
	public static InitSettingService getInstance() {
		return instance;
	}

	private InitSettingService() {

	}



	@Override
	public void doSetting() {
		// TODO Auto-generated method stub

	}

}
