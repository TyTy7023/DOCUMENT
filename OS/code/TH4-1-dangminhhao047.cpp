#include <iostream>
using namespace std;

int main()
{
    int pid[15],bt[15], n;
      float att, awt,twt = 0,tat = 0;;
    cout << "Enter the number of processes: ";
    cin >> n;

    cout << "Enter process id of all the processes: "<<endl;
    for (int i = 0; i < n; i++)
    {   
        cout<<"P";
        cin >> pid[i];
    }

  
    for (int i = 0; i < n; i++)
    {
        cout << "Enter burst time of P"<<pid[i]<<": ";
        cin >> bt[i];
    }

    int i, wt[n];
    wt[0] = 0;
    for (i = 1; i < n; i++)
    {
        wt[i] = bt[i - 1] + wt[i - 1];
    }

    cout << "Process ID\tBurst Time\tWaiting Time\tTurnaround Time" << endl;
    for (i = 0; i < n; i++)
    {
        cout << pid[i] << "\t\t" << bt[i] << "\t\t" << wt[i];
        cout << "\t\t" << bt[i] + wt[i] << endl;
        twt += wt[i];
        tat += (wt[i] + bt[i]);
    }
    awt = twt / n;
    att = tat / n;
    cout << "Avg waiting time= " << awt << endl;
    cout << "Avg turnaround time= " << att;

    return 0;
}
