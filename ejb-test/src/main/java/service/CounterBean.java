package service;

import javax.ejb.Stateless;

@Stateless
public class CounterBean implements CounterBeanRemote {

	private int counter = 0;

	@Override
	public int getState() {
		return this.counter;
	}

	@Override
	public int increment() {
		this.counter++;
		return this.counter;
	}

	@Override
	public int setState(int state) {
		return this.counter = state;
	}

	@Override
	public void resetState() {
		this.counter = 0;		
	}

}
