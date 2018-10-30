package com.ibm.acc;

import com.ibm.broker.javacompute.MbJavaComputeNode;
import com.ibm.broker.plugin.MbElement;
import com.ibm.broker.plugin.MbException;
import com.ibm.broker.plugin.MbGlobalMap;
import com.ibm.broker.plugin.MbMessage;
import com.ibm.broker.plugin.MbMessageAssembly;
import com.ibm.broker.plugin.MbOutputTerminal;
import com.ibm.broker.plugin.MbUserException;

public class AccessGlobalMap_fetchGM extends MbJavaComputeNode {

	public void evaluate(MbMessageAssembly inAssembly) throws MbException {
		MbOutputTerminal out = getOutputTerminal("out");
		MbOutputTerminal alt = getOutputTerminal("alternate");

		MbMessage inMessage = inAssembly.getMessage();
		MbMessageAssembly outAssembly = null;
		try {
			// create new message as a copy of the input
			MbMessage outMessage = new MbMessage(inMessage);
			outAssembly = new MbMessageAssembly(inAssembly, outMessage);
			// ----------------------------------------------------------
			// Add user code below

			String a;
			boolean b;
	//		a = loginSample();
			String c;
			
	    
			
			MbElement root = outMessage.getRootElement();
			MbElement document = root.getLastChild().getFirstChild();
			MbElement chapter2 = document.createElementAsLastChild(MbElement.TYPE_NAME,"Chapter",null);

			// add title attribute
			
			c = getValue("Salesforlogin","FirojLogin");
			
			MbElement title5 = chapter2.createElementAsFirstChild(MbElement.TYPE_NAME_VALUE, 
					"title",	c);
			// End of user code
			// ----------------------------------------------------------
		} catch (MbException e) {
			// Re-throw to allow Broker handling of MbException
			throw e;
		} catch (RuntimeException e) {
			// Re-throw to allow Broker handling of RuntimeException
			throw e;
		} catch (Exception e) {
			// Consider replacing Exception with type(s) thrown by user code
			// Example handling ensures all exceptions are re-thrown to be handled in the flow
			throw new MbUserException(this, "evaluate()", "", "", e.toString(),
					null);
		}
		// The following should only be changed
		// if not propagating message to the 'out' terminal
		out.propagate(outAssembly);

	}
	 public static String getValue(String strMapName, String strKey) {
		    
		    String strValue = null;
		    MbGlobalMap globalMap = null;
		    
		    try
		    {
		      globalMap = MbGlobalMap.getGlobalMap(strMapName);
		      strValue = (String) globalMap.get(strKey);
		    }
		    catch(MbException mbe)
		    {
		      System.out.println(mbe.getMessage());
		      mbe.printStackTrace();
		    }
		    
		    return strValue;
		  }
}
