
public class Complex {
	private double re;
	private double im;
	
public Complex(double re, double im) {
	this.re = re;
	this.im = im;
}
public double getRe() {
	return re;
}
public double getIm() {
	return im;
}
public double getAbs2() {
	double absNbr = re*re + im*im;
	return  absNbr;
}
public void add(Complex c) {
	re += c.getRe();
	im += c.getIm();
}
void mul(Complex c) {
	double reell = getRe() * c.getRe() - getIm() * c.getIm();
	im = getRe() * c.getIm() + getIm() * c.getRe();
	re = reell;
}
}
