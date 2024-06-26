#include <iostream>
using namespace std;
class pol
{
	public:
		int *p;
	int n;
	int getval(int x);
	int &getElem(int a);
	int getSize();
	pol();
	void add(int a, int b);
	int sum(pol k, int x);
};

class Fraction
{
	private:
		void simplify();

	public:
		int a, b;
	Fraction();
	Fraction(int a, int b);
	static Fraction sum(Fraction a, Fraction b);
	static Fraction oneDivision(Fraction a);
	static int gcd(int a, int b);
};

class chainFraction
{
	private:
		int Size;
	int capacity;
	Fraction * frac;

	public:
		chainFraction();
	chainFraction(Fraction x);
	int getSize();
	Fraction &getElem(int index);
	void appendElem(Fraction elem);
	Fraction getValue();
	Fraction getValuen(int n0);
	Fraction &operator[](int i);
	void addMemory();
	virtual~chainFraction();
	chainFraction(const chainFraction &obj);
};
#ifndef DEC_H_INCLUDED
#define DEC_H_INCLUDED
#endif	// DEC_H_INCLUDED
