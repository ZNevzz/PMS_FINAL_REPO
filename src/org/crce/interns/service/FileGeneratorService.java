package org.crce.interns.service;

import java.util.LinkedList;
import java.util.List;

public interface FileGeneratorService {

	public String download();
	
	public String[] getParameters(Object bean);
	
	public void setType(String type);
		
	
}
