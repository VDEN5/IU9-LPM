#include "imple.cpp"

int main()
{
	pol po;
	po.add(0, 1);
	po.add(1, 2);
	po.add(2, 1);
	pol po1;
	po1.add(0, 1);
	po1.add(1, 2);
	po1.add(2, 1);
	cout << po.getval(5) << endl << po.sum(po, 5);
	int n, n0;
	cin >> n;
	cin >> n0;
	Fraction x;
	chainFraction s;
	for (int i = 0; i < n; i++)
	{
		cin >> x.a;
		cin >> x.b;
		s.appendElem(x);
	}

	for (int i = 0; i < n; i++)
	{
		cout << s.getElem(i).a << "/" << s.getElem(i).b << " ";
	}

	cout << endl;
	cout << endl;
	cout << s.getValue().a << "/" << s.getValue().b << endl;
	cout << s.getValuen(n0).a << "/" << s.getValuen(n0).b;
	return 0;
}
