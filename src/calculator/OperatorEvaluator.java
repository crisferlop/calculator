package calculator;


public class OperatorEvaluator extends Operator{

	@Override
	public PolynomialExpresion operateTemplate(PolynomialExpresion operand1,
			PolynomialExpresion operand2) {
		// TODO Auto-generated method stub
		if (operand2.getPolynomialElements().size() != 1){
			System.out.println("warning: multiple evaluation detected!");
			System.exit(0);
		}
		else{
			PolynomialExpresion toReturn = new PolynomialExpresion();
			PolynomialElement element = new PolynomialElement(0, 0, 0);
			for (PolynomialElement current:operand1.getPolynomialElements()){
				element.setNumericalCoefficient((int) (element.getNumericalCoefficient() + 
						current.getNumericalCoefficient()*Math.pow(operand2.getPolynomialElements().get(0).getExponentOfX(),current.getExponentOfX())
						*Math.pow(operand2.getPolynomialElements().get(0).getExponentOfY(), current.getExponentOfY())));
			}
			toReturn.getPolynomialElements().add(element);
			return toReturn;
		}
		return null;
	}

}
