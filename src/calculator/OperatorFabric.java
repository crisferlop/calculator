package calculator;

public class OperatorFabric {

	
	static public Operator create(String operatorSymbol){
		if ("+".equals(operatorSymbol)){
			return new PlusOperator();
		}
		else if ("-".equals(operatorSymbol)){
			return new MinumOperator();
		}
		else if ("*".equalsIgnoreCase(operatorSymbol) || "x".equalsIgnoreCase(operatorSymbol)){
			return new MultiplicatorOperator();
		}
		else if ("e".equals(operatorSymbol)){
			return new OperatorEvaluator();
		}else{
			System.out.println("fail: operand dont exist!");
			return null;
		}
	}
}
