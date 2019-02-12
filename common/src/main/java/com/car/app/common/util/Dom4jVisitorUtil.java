package com.car.app.common.util;
import org.dom4j.Attribute;
import org.dom4j.Element;
public class Dom4jVisitorUtil {
	 public void visit(Element element){
	        System.out.println(element.getName());
	    }
	    
	    public void visit(Attribute attr){
	        System.out.println(attr.getName());
	    } 

}
