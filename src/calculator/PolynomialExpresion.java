package calculator;

import java.util.Iterator;
import java.util.Vector;

public class PolynomialExpresion {
	private Vector<PolynomialElement> _elements;
	
	
	public PolynomialExpresion(){
		_elements = new Vector<PolynomialElement>();
	}
	
	
	public String getResult(){
		return null;
	}
	
	public Vector<PolynomialElement> getPolynomialElements(){return _elements;}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String toReturn = "";
		Iterator<PolynomialElement> iter = _elements.iterator();
		PolynomialElement current;
		for (int x =0; x < _elements.size(); x++) {
			current = iter.next();
			toReturn += iter.hasNext()? current.toString() + "|":current.toString();
		}
		return toReturn;
	}
}
