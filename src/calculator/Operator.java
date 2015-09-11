package calculator;

public abstract class Operator {
	
	
	public PolynomialExpresion operate(PolynomialExpresion operand1, PolynomialExpresion operand2){
		return this.compact(operateTemplate(operand1, operand2));
	}
	public abstract PolynomialExpresion operateTemplate(PolynomialExpresion operand1, PolynomialExpresion operand2);
	
	
	protected PolynomialExpresion compact(PolynomialExpresion operand){
		PolynomialExpresion toReturn = new PolynomialExpresion();
		PolynomialElement current,tmp;
		int initial_lenght = operand.getPolynomialElements().size();
		while (operand.getPolynomialElements().size() != 0){
				current = operand.getPolynomialElements().get(0);
				operand.getPolynomialElements().remove(0);
				for (int x = operand.getPolynomialElements().size()-1; x > -1; x--){
					tmp = operand.getPolynomialElements().get(x);
					if (current.canOperateWith(tmp)){
						operand.getPolynomialElements().remove(x);
						int numericalCoefficient = current.getNumericalCoefficient() + tmp.getNumericalCoefficient();
						current.setNumericalCoefficient(numericalCoefficient);
					}
				}
				if (current.getNumericalCoefficient() != 0 || initial_lenght == 1)
				toReturn.getPolynomialElements().add(current);
		}
		return toReturn;
	}
}
