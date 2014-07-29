package service;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(CounterLocal.class)
public class CounterBean implements CounterLocal {

	private int counter = 0;
	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	@Override
	public int getCurrent() {
		System.out.println("DUPA11");
		return this.counter;
	}

	@Override
	public int getNextAndUpdate() {
		this.counter = this.getFromDB();
		this.counter++;
		this.updateInDB(counter);
		return this.counter;
	}

	@Override
	public void updateInDB(int counter) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getFromDB() {
		return this.counter;
	}

}
