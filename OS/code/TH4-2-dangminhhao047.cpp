#include <iostream>
using namespace std;
int main()
{
    int i, NOP, sum = 0, count = 0, y, quant, wt = 0, tat = 0, at[10], bt[10], temp[10];
    float avg_wt, avg_tat;
    cout << "Total number of process in the system: ";
    cin >> NOP;
    y = NOP; // Assign the number of process to variable y

    // Use for loop to enter the details of the process like Arrival time and the Burst Time
    for (i = 0; i < NOP; i++)
    {
        cout << "\nEnter the Arrival and Burst time of Process[" << i + 1 << "]\n";
        cout << "Arrival time is: ";
        cin >> at[i];
        cout << "\nBurst time is: ";
        cin >> bt[i];
        temp[i] = bt[i]; // store the burst time in temp array
    }

    cout << "Enter the Time Quantum for the process: ";
    cin >> quant;

    cout << "\nProcess No\tBurst Time\tTAT\tWaiting Time\n";
    for (sum = 0, i = 0; y != 0;)
    {
        if (temp[i] <= quant && temp[i] > 0)
        {
            sum = sum + temp[i];
            temp[i] = 0;
            count = 1;
        }
        else if (temp[i] > 0)
        {
            temp[i] = temp[i] - quant;
            sum = sum + quant;
        }
        if (temp[i] == 0 && count == 1)
        {
            y--;
            cout << "P" << i + 1 << "\t\t" << bt[i] << "\t\t" << sum - at[i] << "\t" << sum - at[i] - bt[i] << "\n";
            wt = wt + sum - at[i] - bt[i];
            tat = tat + sum - at[i];
            count = 0;
        }
        if (i == NOP - 1)
        {
            i = 0;
        }
        else if (at[i + 1] <= sum)
        {
            i++;
        }
        else
        {
            i = 0;
        }
    }

    avg_wt = wt * 1.0 / NOP;
    avg_tat = tat * 1.0 / NOP;
    cout << "\nAverage Turn Around Time: " << avg_wt;
    cout << "\nAverage Waiting Time: " << avg_tat;

    return 0;
}
