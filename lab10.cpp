#include <iostream>
#include <vector>
#include <stack>
#include <utility>
using namespace std;

class ByteSequenceIterator
{
	private:
		const unsigned char *data;
	size_t size;

	public:
		ByteSequenceIterator(const unsigned char *ptr, size_t s): data(ptr), size(s) {}

	int operator* ()const
	{
		int result = 0;
		for (int i = 0; i < 3; i++)
		{
			result |= data[i] << (8 *(2 - i));
		}

		return result;
	}

	ByteSequenceIterator &operator++()
	{
		data += 3;
		return * this;
	}

	bool operator!=(const ByteSequenceIterator &other) const
	{
		return data != other.data;
	}
};

class ByteSequence
{
	private:
		const unsigned char *data;
	size_t size;

	public:
		ByteSequence(const unsigned char *ptr, size_t s): data(ptr), size(s) {}

	ByteSequenceIterator begin() const
	{
		return ByteSequenceIterator(data, size);
	}

	ByteSequenceIterator end() const
	{
		return ByteSequenceIterator(data + size, size);
	}
};

template < typename T>
	class MaxStack
	{
		private:
			std::stack<std::pair<T, T>> stack;

		public:
			void push(const T &value)
			{
				T max_val = stack.empty() ? value : std::max(value, stack.top().second);
				stack.push({ value, max_val });
			}

		void pop()
		{
			stack.pop();
		}

		T top() const
		{
			return stack.top().first;
		}

		T get_max() const
		{
			return stack.top().second;
		}

		class Iterator
		{
			private:
				typename std::stack<std::pair<T, T>> st;
			public:
				using iterator_category = std::forward_iterator_tag;
			using value_type = T;
			using difference_type = std::ptrdiff_t;
			using pointer = T *;
			using reference = T &;

			explicit Iterator(const std::stack<std::pair<T, T>> &s): st(s) {}

			Iterator &operator++()
			{
				st.pop();
				return * this;
			}

			bool operator!=(const Iterator &other) const
			{
				return !st.empty() != other.st.empty();
			}

			T operator* ()const
			{
				return st.top().first;
			}
		};

		Iterator begin()
		{
			return Iterator(stack);
		}

		Iterator end()
		{
			return Iterator(std::stack<std::pair<T, T>> ());
		}
	};

int main()
{
	unsigned char bytes[] = { 0x01, 0x23, 0x45, 0x67, 0x89, 0xAB
	};
	// Пример последовательности байтов
	size_t size = sizeof(bytes) / sizeof(bytes[0]);

	ByteSequence sequence(bytes, size);
	for (int num: sequence)
	{
		std::cout << num << std::endl;
	}

	MaxStack<int> stack;
	stack.push(5);
	stack.push(3);
	stack.push(7);
	stack.push(2);

	for (int num: stack)
	{
		std::cout << num << std::endl;
	}

	std::cout << "Max element: " << stack.get_max() << std::endl;

	stack.pop();
	std::cout << "After popping: Max element: " << stack.get_max() << std::endl;

	return 0;
}
