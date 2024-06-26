#include "dec.h"

chainFraction::chainFraction(Fraction x)
{
	this->Size = 1;
	this->capacity = 10;
	this->frac = new Fraction[capacity];
	frac[0] = x;
}

chainFraction::chainFraction()
{
	this->Size = 0;
	this->capacity = 10;
	this->frac = new Fraction[capacity];
}	// constructor without parameters
void chainFraction::appendElem(Fraction elem)
{
	if (Size >= capacity) addMemory();
	frac[Size++] = elem;
}

int chainFraction::getSize()
{
	return this->Size;
}

chainFraction::chainFraction(const chainFraction &obj): Size(obj.Size)
{
	frac = new Fraction[Size];
	std::copy(obj.frac, obj.frac + Size, frac);
}	// copy
Fraction &chainFraction::getElem(int index)
{
	return this->frac[index];
}	// geter
chainFraction::~chainFraction()
{
	delete[](frac);
}	// destructor
void chainFraction::addMemory()
{
	capacity *= 2;
	Fraction *tmp = frac;
	frac = new Fraction[capacity];
	for (int i = 0; i < Size; i++)
	{
		frac[i] = tmp[i];
	}

	delete[] tmp;
}

Fraction chainFraction::getValue()
{
	Fraction res = frac[Size - 1];
	for (int i = Size - 2; i >= 0; i--)
	{
		res = Fraction::sum(frac[i], Fraction(res.b, res.a));
	}

	return res;
}

Fraction chainFraction::getValuen(int n0)
{
	Fraction res = frac[Size - 1];
	for (int i = Size - 2;
		((i >= 0) && (n0 > 0)); i--)
	{
		n0--;
		res = Fraction::sum(frac[i], Fraction(res.b, res.a));
	}

	return res;
}

Fraction::Fraction(int a, int b)
{
	this->a = a;
	this->b = b;
	simplify();
}

Fraction::Fraction()
{
	this->a = 1;
	this->b = 1;
}

void Fraction::simplify()
{
	int t = gcd(a, b);
	this->a = a / t;
	this->b = b / t;
}

int Fraction::gcd(int a, int b)
{
	return b ? gcd(b, a % b) : a;
}

Fraction Fraction::sum(Fraction a, Fraction b)
{
	int a1 = a.a, a2 = a.b, b1 = b.a, b2 = b.b;
	int y = (a2 *b2) / gcd(a2, b2);
	a1 *= y / a2;
	b1 *= y / b2;
	int x = a1 + b1;
	return Fraction(x, y);
}

pol::pol()
{
	this->n = 0;
	this->p = new int[10];
}

void pol::add(int a, int b)
{
	this->p[a] = b;
	this->n++;
}

int pol::getSize()
{
	return this->n;
}

int &pol::getElem(int index)
{
	return this->p[index];
}

int pol::getval(int x)
{
	int res = 0;
	for (int i = 0; i < this->n; i++)
	{
		res = res *10 + x *this->p[i];
	}

	return res;
}

int pol::sum(pol k, int x)
{
	pol res;
	for (int i = 0; i < min(k.n, this->n); i++) res.add(i, this->p[i] + k.p[i]);
	if (k.n < this->n)
	{
		for (int i = 0; i < this->n; i++) res.add(i, this->p[i]);
	}

	if (k.n > this->n)
	{
		for (int i = 0; i < k.n; i++) res.add(i, k.p[i]);
	}

	return res.getval(x);
}
