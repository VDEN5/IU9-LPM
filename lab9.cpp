#include <iostream>
#include <vector>

template < typename T, typename N>
	class Parcel
	{
		private:
			std::vector<std::pair<bool, T>> terminalSymbols;
		std::vector<std::pair<bool, N>> nonTerminalSymbols;
		public:
			Parcel() {}

		Parcel<T, N> operator+(const Parcel<T, N> &other)
		{
			Parcel<T, N> result = *this;
			for (const auto &symbol: other.terminalSymbols)
			{
				result.terminalSymbols.push_back(symbol);
			}

			for (const auto &symbol: other.nonTerminalSymbols)
			{
				result.nonTerminalSymbols.push_back(symbol);
			}

			return result;
		}

		void operator+=(const Parcel<T, N> &other)
		{
			for (const auto &symbol: other.terminalSymbols)
			{
				terminalSymbols.push_back(symbol);
			}

			for (const auto &symbol: other.nonTerminalSymbols)
			{
				nonTerminalSymbols.push_back(symbol);
			}
		}

		void operator+=(const T &terminalSymbol)
		{
			terminalSymbols.push_back({ true, terminalSymbol });
		}

		void operator+=(const N &nonTerminalSymbol)
		{
			nonTerminalSymbols.push_back({ false, nonTerminalSymbol });
		}

		Parcel<T, N> operator()(const N &x, const Parcel<T, N> &p)
		{
			Parcel<T, N> result = *this;
			for (auto &symbol: result.nonTerminalSymbols)
			{
				if (symbol.second == x)
				{
					symbol = { false, N()
					};

					for (const auto &newSymbol: p.nonTerminalSymbols)
					{
						result.nonTerminalSymbols.push_back(newSymbol);
					}

					for (const auto &newSymbol: p.terminalSymbols)
					{
						result.terminalSymbols.push_back(newSymbol);
					}

					break;
				}
			}

			return result;
		}

		void print() const
		{
			for (const auto &symbol: terminalSymbols)
			{
				if (symbol.first)
				{
					std::cout << symbol.second << "";
				}
			}

			for (const auto &symbol: nonTerminalSymbols)
			{
				if (!symbol.first)
				{
					std::cout << symbol.second << "";
				}
			}

			std::cout << std::endl;
		}
	};

int main()
{
	Parcel<char, std::string > parcel1;
	parcel1 += 'a';
	parcel1 += "B";
	Parcel<char, std::string > parcel2;
	parcel2 += 'c';
	parcel2 += "D";
	Parcel<char, std::string > result = parcel1 + parcel2;
	result.print();
	return 0;
}
