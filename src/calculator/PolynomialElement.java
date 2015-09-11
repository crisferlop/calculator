package calculator;

public class PolynomialElement {
	private int _numericalCoefficient, _exponentOfX,_exponentOfY;
	private boolean _solved;
	
	public PolynomialElement(int pNumericalCoeficient,int pExponentOfX,int pExponentOfY){
		setNumericalCoefficient(pNumericalCoeficient);
		setExponentOfX(pExponentOfX);
		_exponentOfY = pExponentOfY;
	}

	public int getNumericalCoefficient() {
		return _numericalCoefficient;
	}

	public void setNumericalCoefficient(int _numericalCoefficient) {
		this._numericalCoefficient = _numericalCoefficient;
	}

	public int getExponentOfX() {
		return _exponentOfX;
	}

	public int getExponentOfY() {
		return _exponentOfY;
	}

	public void setExponentOfY(int _exponentOfY) {
		this._exponentOfY = _exponentOfY;
	}

	public void setExponentOfX(int _exponentOfX) {
		this._exponentOfX = _exponentOfX;
	}
	public boolean canOperateWith(PolynomialElement element){
		if (element == null) return false;
		return element.getExponentOfX() == _exponentOfX && element.getExponentOfY()==_exponentOfY;
	}

	boolean isSolved() {
		return _solved;
	}

	void setSolved(boolean _solved) {
		this._solved = _solved;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if (isSolved()){
			return "" + _numericalCoefficient;
		}
		return _numericalCoefficient + " " + _exponentOfX + " " + _exponentOfY;
	}
}
