package com.java.thread.countdownlatch.sampleApp;

import java.util.concurrent.CountDownLatch;

/**
 * Abstract Base Class. Should be implements by Application specific health 
 * checker clases.
 * 
 * @author harshul.varshney
 *
 */
public abstract class BaseHealthCheckerTask implements Runnable {

	private CountDownLatch _latch;
    private String _serviceName;
    private boolean _serviceUp;
    
    public BaseHealthCheckerTask(String serviceName, CountDownLatch latch) {
		this._serviceName = serviceName;
		this._latch = latch;
		this._serviceUp = false;
	}

	@Override
	public void run() {
		try {
			verifyService();
			_serviceUp = true;
		}
		catch(Exception ie) {
			ie.printStackTrace();
		}
		finally {
			if(_latch != null)
				_latch.countDown();
		}
	}
	
	public String getServiceName() {
        return _serviceName;
    }
 
    public boolean isServiceUp() {
        return _serviceUp;
    }
    //This methos needs to be implemented by all specific service checker
    public abstract void verifyService();

}
