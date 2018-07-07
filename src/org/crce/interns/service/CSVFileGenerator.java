package org.crce.interns.service;

import java.util.LinkedList;
import java.util.List;

import org.crce.interns.beans.FileReader;
import org.crce.interns.beans.UserCompanyBean;

public interface CSVFileGenerator extends FileGeneratorService{
	
	final public String type="CSV";
	
	@Override
	public String download();
	
	@Override
	public String[] getParameters(Object bean);
	
	@Override
	public void setType(String type);
		
	
	public void generateCSV( Object bean,List<List<String>> result
			,List<UserCompanyBean> list);

}
