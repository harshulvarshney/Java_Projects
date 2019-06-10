package com.harsh.dp.proxy;

/**
 * A Proxy can also be defined as a surrogate. In the real work a cheque or credit card is a 
 * proxy for what is in our bank account.  It can be used in place of cash, which is what is 
 * needed, and provides a means of accessing that cash when required. And that's exactly what 
 * the Proxy pattern does - controls and manage access to the object they are "protecting".
 * 
 * A proxy Allows for object level access control by acting as a pass through entity or a 
 * placeholder object. 
 * 
 * This pattern is recommended when either of the following scenarios occur in your application:
 * 		The object being represented is external to the system.
 * 		Objects need to be created on demand. 
 * 		Access control for the original object is required
 * 		Added functionality is required when an object is accessed.
 * 
 * 
 * The proxy is also useful if you want to decouple actual implementation code from the access to 
 * a particular library. Proxy is also useful for access to large files, or graphics. By using a 
 * proxy, you can delay loading the resource until you really need the data inside. Without the 
 * concept of proxies, an application could be slow, and appear non-responsive. 
 * 
 * @author harshul.varshney
 *
 */
public interface _Image {
	public void displayImage();
}
