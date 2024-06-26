#include <iostream>
#include <stack>
#include <string>
#include <algorithm>

template <typename T>
	class Stack
	{
		private:
			std::stack<T> data_stack;
		std::stack<T> max_stack;
		public:
			void push(const T &value)
			{
				data_stack.push(value);
				if (max_stack.empty() || value >= max_stack.top())
				{
					max_stack.push(value);
				}
			}

		void pop()
		{
			if (data_stack.top() == max_stack.top())
			{
				max_stack.pop();
			}

			data_stack.pop();
		}

		T top() const
		{
			return data_stack.top();
		}

		T getMax() const
		{
			return max_stack.top();
		}

		void reverseStrings()
		{
			Stack<std::string > sStack;
			int h = 0;
			while (!data_stack.empty())
			{
				std::string str = data_stack.top();
				std::reverse(str.begin(), str.end());
				data_stack.pop();
				sStack.push(str);
				h++;
			}

			for (int i = 0; i < h; i++)
			{
				data_stack.push(sStack.top());
				sStack.pop();
			}
		}
	};

int main()
{
	Stack<int> intStack;
	intStack.push(5);
	intStack.push(3);
	intStack.push(8);
	std::cout << intStack.getMax() << std::endl;
	intStack.pop();
	std::cout << intStack.top() << std::endl;
	Stack<std::string > stringStack;
	stringStack.push("hello");
	stringStack.push("world");
	stringStack.reverseStrings();
	std::cout << stringStack.top() << std::endl;
	return 0;
}
