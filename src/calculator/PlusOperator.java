package calculator;

public class PlusOperator extends Operator{
	protected int scalar = 1;
	
	
	public PolynomialExpresion operateTemplate(PolynomialExpresion operand1, PolynomialExpresion operand2) {
		// TODO Auto-generated method stub
		
		int isMatched = 0;
		PolynomialExpresion polinomialExpression = new PolynomialExpresion();
		for (PolynomialElement element:operand1.getPolynomialElements()){
			isMatched = matchPolynomialElement(element, operand2);
			if (isMatched ==-1){
				polinomialExpression.getPolynomialElements().addElement(element);
			}
			else{
				int numericalCoefficient = element.getNumericalCoefficient() + scalar*operand2.getPolynomialElements().get(isMatched).getNumericalCoefficient();
				operand2.getPolynomialElements().remove(isMatched);
				polinomialExpression.getPolynomialElements().addElement(new PolynomialElement(numericalCoefficient, element.getExponentOfX(), element.getExponentOfY()));
			}
		}
		for (PolynomialElement element:operand2.getPolynomialElements()){
			polinomialExpression.getPolynomialElements().add(element);
		}
		return polinomialExpression;
	}
	
	
	private int matchPolynomialElement(PolynomialElement pElement,PolynomialExpresion pExpresion){
		int toReturn = -1;
		int counter = 0;
		for (PolynomialElement element:pExpresion.getPolynomialElements()){
			if (element.canOperateWith(pElement)){
				toReturn = counter;
				break;
			}
			counter++;
		}
		return toReturn;
		
	}

}
