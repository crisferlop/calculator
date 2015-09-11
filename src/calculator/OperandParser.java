package calculator;

import java.util.regex.Pattern;

public class OperandParser {

	private Pattern _polyStructure;

	public OperandParser() {
		// TODO Auto-generated constructor stub
		_polyStructure = Pattern.compile("(-)?\\d+( +(-)?\\d+){2}(( )*\\|( )*(-)?\\d+( +(-)?\\d+){2}){0,}");
	}
	
	private String quitWhiteSpace(String data){
		return data!=null? data.replaceAll("( )+", " ").replaceAll("( )*\\|( )*", "|"):"";
	}


	public PolynomialExpresion parse(String operand){
		if (_polyStructure.matcher(operand).matches()){
			PolynomialExpresion toReturn = new PolynomialExpresion();
			String []  operands = quitWhiteSpace(operand).split("\\|");
			PolynomialElement parsedElement;
			for(String element:operands){
				parsedElement = parseElement(element);
				if (parsedElement != null) toReturn.getPolynomialElements().add(parsedElement);
				else return null;
			}
			return toReturn;
		}
		return null;
	}
	
	
	public PolynomialExpresion parseEvaluation(String operand){
		Pattern eval = Pattern.compile("(-)?\\d+( +(-)?\\d+){1}");
		if (eval.matcher(operand).matches()){
			PolynomialExpresion toReturn = new PolynomialExpresion();
			toReturn.getPolynomialElements().add(parseElementEvaluation(operand));
			return toReturn;
		}
		return null;
	}
	
	
	protected PolynomialElement parseElementEvaluation(String element){
		String []coefficients = element.split(" ");
		return new PolynomialElement(0,Integer.parseInt(coefficients[0]),Integer.parseInt(coefficients[1]));
	}
	
	
	protected PolynomialElement parseElement(String element){
		String []coefficients = element.split(" ");
		return new PolynomialElement(Integer.parseInt(coefficients[0]),Integer.parseInt(coefficients[1]),Integer.parseInt(coefficients[2]));
	}
}
