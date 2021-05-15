#include <iostream>
#include <vector>
#include <string>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds);
vector<int> ConvertNum(string& _Nums);

struct Info
{
	bool Suc = false;
	int CurrentProgresses = 0;
};

void main()
{
	vector<int> progresses;
	vector<int> speeds;

	string str1 , str2;

	cin >> str1;
	progresses = ConvertNum(str1);
	cin >> str2;
	speeds = ConvertNum(str2);

	vector<int> Anser = solution(progresses, speeds);

	for (int i = 0; i < Anser.size(); i++)
	{
		cout << Anser[i] << endl;
	}
}

vector<int> ConvertNum(string& _Nums)
{
	vector<int> Num;
	vector<int> OutNums;
	const char* tempstr = _Nums.c_str();
	for (int i = 0; i < _Nums.length(); i++)
	{
		if (tempstr[i] == ',' || i == (_Nums.length() -1))
		{
			if (i == (_Nums.length() - 1))
			{
				int tempnum = int(tempstr[i] - '0');

				if (0 <= tempnum && tempnum < 10)
					Num.push_back(tempnum);
			}


			if (Num.size() != 0)
			{
				int num = 0;
				int DecNum = 1;
				for (int i = Num.size() - 1; i >= 0; --i)
				{
					num += (Num[i] * DecNum);
					DecNum *= 10;
				}
				Num.clear();
				OutNums.push_back(num);
			}
		}
		else
		{
			int tempnum = int(tempstr[i] - '0');

			if (0 <= tempnum && tempnum < 10)
				Num.push_back(tempnum);
		}
	}

	return OutNums;
}

vector<int> solution(vector<int> progresses, vector<int> speeds)
{
	vector<int> answer;

	int cursor = 0;

	while (true)
	{
		int TempCursor = cursor;

		for (int i = 0; i < progresses.size(); i++)
		{
			if (progresses[i] >= 100)
			{
				if (TempCursor == i)
				{
					++TempCursor;
				}
			}
			else
			{
				progresses[i] += speeds[i];
			}

		}



		if (TempCursor != cursor)
		{
			int Result = TempCursor - cursor;
			answer.push_back(Result);
			cursor = TempCursor;
		}
		
		if (cursor == progresses.size())
			break;
	}

	return answer;

}