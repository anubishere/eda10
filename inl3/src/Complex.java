
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
	// abs av ett komplext tal = roten ur nedan, dvs nedan �r absolutbeloppet i kvadrat
	double absNbr = re*re + im*im;
	return  absNbr;
}
public void add(Complex c) {
	re += c.getRe();
	im += c.getIm();
}
void mul(Complex c) {
	
	// reell del i komplext tal �r reella - det imagin�ra
	double reell = getRe() * c.getRe() - getIm() * c.getIm();
	// det imagin�ra �r reella x det kokmplexa talets imagin�ra
	this.im = this.re * c.getIm() + this.im * c.getRe();
	re = reell;
}
public String toString() {
	if(this.im < 0){
		return this.re + " " + this.im + "i";
	}
	return this.re + " " + this.im + "i";
}

}
