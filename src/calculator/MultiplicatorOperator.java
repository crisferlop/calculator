package calculator;

public class MultiplicatorOperator extends PlusOperator{
	@Override
	public PolynomialExpresion operateTemplate(PolynomialExpresion operand1, PolynomialExpresion operand2) {
		// TODO Auto-generated method stub
		PolynomialExpresion polinomialExpression = new PolynomialExpresion();
		for (PolynomialElement element:operand1.getPolynomialElements()){
			for (PolynomialElement element2:operand2.getPolynomialElements()){
				polinomialExpression.getPolynomialElements().add(operateElements(element,element2));
			}
		}
		return polinomialExpression;
	}
	private PolynomialElement operateElements(PolynomialElement operand1, PolynomialElement operand2){
		return new PolynomialElement(operand1.getNumericalCoefficient()*operand2.getNumericalCoefficient(), 
				operand1.getExponentOfX()+operand2.getExponentOfX(), operand1.getExponentOfY()+operand2.getExponentOfY());
	}
}
