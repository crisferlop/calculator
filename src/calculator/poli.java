package calculator;



public class poli {
	
	static public String resolve(String op1, String op2, String operatorS){
		OperandParser op = new OperandParser();
		PolynomialExpresion operand1 =  op.parse(op1);
		PolynomialExpresion operand2;
		if (operatorS.equalsIgnoreCase("e")){
			operand2 =  op.parseEvaluation(op2);
		}
		else operand2 =  op.parse(op2);
		Operator operator = OperatorFabric.create(operatorS);
		if (operand1 != null && operand2 != null && operator !=null){
			return operator.operate(operand1, operand2).toString();
		}
		System.out.println("No ha ingresado polinomio(s) valido(s). Verifique y corriga su entrada");
		return null;
	}
	
	
	public static void main(String[] args) {
		if (args.length == 3){
			String result = poli.resolve(args[0], args[2], args[1]);
			if (result != null){
				System.out.println(result);
			}
		}
		else{
			System.out.println("Debe colocar solamente tres argumentos");
		}
	}
}
