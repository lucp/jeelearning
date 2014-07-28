package service;

public interface CounterBean {

	int getCurrent();
	
	int getNextAndUpdate();
	
	int getFromDB();

	void updateInDB(int counter);

}
