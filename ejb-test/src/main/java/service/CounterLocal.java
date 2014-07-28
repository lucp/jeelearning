package service;

public interface CounterLocal {

	int getCurrent();
	
	int getNextAndUpdate();
	
	int getFromDB();

	void updateInDB(int counter);

}
