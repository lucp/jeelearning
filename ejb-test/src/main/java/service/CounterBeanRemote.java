package service;

import javax.ejb.Remote;

@Remote(CounterBeanRemote.class)
public interface CounterBeanRemote {

	int getState();
	int increment();
	void resetState();
	int setState(int state);

}
